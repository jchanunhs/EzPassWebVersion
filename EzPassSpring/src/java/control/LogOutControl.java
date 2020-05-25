package control;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class LogOutControl extends HttpServlet {

    @RequestMapping(value = "/LogOutControl", method = RequestMethod.GET)
   public String LogOut(HttpServletRequest request,RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        session.invalidate();
        redirectAttributes.addFlashAttribute("message","Account signed off successfully!");
        return "redirect:/index";
    }
    


}
