package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EzTag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EzTagController {

    @RequestMapping("/EzTag")
    public ModelAndView EzTag(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username") == null && session.getAttribute("CID") == null) {
            mv.setViewName("redirect:/index");
        } else {
            mv.setViewName("EzTag");
            EzTag ez = new EzTag((String) session.getAttribute("CID"));
            mv.addObject("ez_list", ez.getTags());
        }
        return mv;
    }

    @RequestMapping(value = "/AddTagControl", method = RequestMethod.POST)
    public ModelAndView AddTag(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        String CID = (String) session.getAttribute("CID");
        String TC = request.getParameter("TagCode");
        String TT = request.getParameter("TagType");
        EzTag ez = new EzTag(TC, TT, CID);
        mv.setViewName("redirect:/EzTag#tab-2");
        if (ez.addTag()) {
            redirectAttributes.addFlashAttribute("message", "Ez Tag was added successfully!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: The Ez Tag that you entered is invalid. Please try again.");
        }
        return mv;
    }

    @RequestMapping(value = "/RemoveTagControl", method = RequestMethod.POST)
    public ModelAndView RemoveTag(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        String CID = (String) session.getAttribute("CID");
        String TC = request.getParameter("TagCode");
        EzTag ez = new EzTag(TC, CID);
        mv.setViewName("redirect:/EzTag#tab-3");
        if (ez.removeTag()) {
            redirectAttributes.addFlashAttribute("message", "EzTag was removed successfully!");
        } //if fails to add tag, we try to figure out why it happened
        else if (!ez.checkTag()) {
            redirectAttributes.addFlashAttribute("message", "Error: The tag code you entered is invalid");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Either EzTag is currently associated with a vehicle or has been used to pay tolls in the past. If you believe this is a mistake please contact help desk.");
        }
        return mv;
    }

}
