package com.example.control;

import com.example.dao.EzTagDAO;
import com.example.service.EzTagService;
import com.example.model.EzTag;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EzTagController {

    @RequestMapping(value = "/eztag", method = RequestMethod.GET)
    public ModelAndView EzTag(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        if (Username != null && CustomerID != null) {  //check if user has logged in successfully and created profile
            EzTagDAO eztagdao = new EzTagService();
            List<EzTag> eztaglist = eztagdao.getAllCustomerTag(CustomerID);
            mv.addObject("eztaglist", eztaglist);
            mv.setViewName("EzTag");
        } else { //user not authenticated, redirect to index page
            mv.setViewName("redirect:/index");
        }
        return mv;
    }

    @RequestMapping(value = "/addtag", method = RequestMethod.POST)
    public ModelAndView AddEzTag(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");

        String TC = request.getParameter("TagCode");
        String TT = request.getParameter("TagType");
        EzTagDAO tagdao = new EzTagService();
        EzTag tag = new EzTag();
        tag.setCustomerID(CustomerID);
        tag.setTagCode(TC);
        tag.setTagType(TT);
        if (tagdao.addTag(tag)) { //tag added successfully
            redirectAttributes.addFlashAttribute("message", "Ez Tag was added successfully!");
        } else { //tag is taken or invalid
            redirectAttributes.addFlashAttribute("message", "Error: The Ez Tag that you entered is taken. Please try another tag code.");

        }
        mv.setViewName("redirect:/eztag#tab-2");
        return mv;
    }

    @RequestMapping(value = "/removetag", method = RequestMethod.POST)
    public ModelAndView RemoveEzTag(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");

        String TC = request.getParameter("TagCode");
        EzTagDAO eztagdao = new EzTagService();
        EzTag eztag = new EzTag();
        eztag.setTagCode(TC);
        eztag.setCustomerID(CustomerID);
        if (eztagdao.removeTag(eztag)) {//attempt to remove tag
            redirectAttributes.addFlashAttribute("message", "EzTag was removed successfully!");
        } else if (!eztagdao.checkTag(eztag)) { //check if tag code belongs to this customer
            redirectAttributes.addFlashAttribute("message", "Error: The tag code you entered is invalid");
        } else { //Remove tag fails if user already used it to pay tolls or tag is currently associated with a vehicle
            redirectAttributes.addFlashAttribute("message", "Error: Either EzTag is currently associated with a vehicle or has been used to pay tolls in the past. If you believe this is a mistake please contact help desk.");
        }

        mv.setViewName("redirect:/eztag#tab-3");
        return mv;
    }

}
