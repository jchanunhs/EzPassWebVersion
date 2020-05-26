package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ChangePasswordControl{

    @RequestMapping(value = "/ChangePasswordControl", method = RequestMethod.POST)
    public ModelAndView ChangePassword(HttpServletRequest request, RedirectAttributes redirectAttributes, ModelAndView mv) {
        HttpSession session = request.getSession(false);
        String Username = (String) session.getAttribute("Username");
        String old = request.getParameter("Old");
        String NewPass = request.getParameter("New");
        Account acct = new Account(Username, old);
        
        if (acct.changePassword(NewPass)) { //change password
            session.invalidate();
            redirectAttributes.addFlashAttribute("message", "Your password was changed successfully. Please relog with your new password.");
            mv.setViewName("redirect:/index");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Change password failed! Your old password is invalid. Please try again.");
            mv.setViewName("redirect:/ChangePassword");
        }
        return mv;
    }
}
