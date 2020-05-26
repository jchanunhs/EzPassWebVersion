package control;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class AddTagControl{

  @RequestMapping(value = "/AddTagControl", method = RequestMethod.POST)
    public ModelAndView AddTag(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
     HttpSession session = request.getSession(false);
        String CID = (String) session.getAttribute("CID");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String IssueDate = formatter.format(date);
        String TC = request.getParameter("TagCode");
        String TT = request.getParameter("TagType");
        EzTag ez = new EzTag(TC, TT, IssueDate, CID);
        mv.setViewName("redirect:/AddTag");
        if (ez.addTag()) {
            redirectAttributes.addFlashAttribute("message", "Ez Tag was added successfully!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: The Ez Tag that you entered is invalid. Please try again.");
        }
        return mv;
    }
    
}
