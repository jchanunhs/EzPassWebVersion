package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginControl {

    @RequestMapping(value = "/LoginControl", method = RequestMethod.POST)
    public ModelAndView Login(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {

        String User = request.getParameter("Username");
        String PW = request.getParameter("Password");
        HttpSession session = request.getSession();
        Account acct = new Account(User, PW);
        Customer cus = new Customer();
        if (acct.signIn() && cus.checkExist(User)) { //set session attributes and redirect to user main page
            cus = new Customer(acct.getCustomerID());
            cus.setData();
            session.setAttribute("Username", User); //for change password
            session.setAttribute("CID", cus.getCustomerID());
            mv.setViewName("redirect:/Main");
        } else if (acct.signIn()) {
            session.setAttribute("Username", User);
            session.setAttribute("Name", acct.getName());
            mv.setViewName("redirect:/CreateProfile");
        } else { //wrong information
            redirectAttributes.addFlashAttribute("message", "Error: Invalid Username or Password!");
            mv.setViewName("redirect:/index");
        }

        return mv;
    }

}
