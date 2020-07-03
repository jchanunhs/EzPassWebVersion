package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignUpControl {

    @RequestMapping(value = "/SignUpControl", method = RequestMethod.POST)
    public ModelAndView SignUp(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String Password1 = request.getParameter("Password1");
        String Name = request.getParameter("Name");
        Account acct = new Account(Username, Password, Password1, Name);
        if (acct.signUp()) {
            mv.setViewName("redirect:/index");
            redirectAttributes.addFlashAttribute("message", "Account creation was successful! Please login to your new account!");
        } else if (acct.UsernameTaken()) {
            mv.setViewName("redirect:/SignUp");
            redirectAttributes.addFlashAttribute("message", "Error: Username is taken. Please try another username.");
        } else {
            mv.setViewName("redirect:/SignUp");
            redirectAttributes.addFlashAttribute("message", "Error: Signup failed unexpectedly. If this occurs multiple times please contact help desk.");
        }
        return mv;
    }

}
