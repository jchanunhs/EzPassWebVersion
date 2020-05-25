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

    @RequestMapping(value = "/LoginControl", method = RequestMethod.GET)
    public ModelAndView Login(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {

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
            session.setAttribute("Name", cus.getName());
            session.setAttribute("Street", cus.getStreet());
            session.setAttribute("City", cus.getCity());
            session.setAttribute("State", cus.getState());
            session.setAttribute("Zip", cus.getZip());
            session.setAttribute("Phone", cus.getPhone());
            session.setAttribute("Email", cus.getEmail());
            session.setAttribute("Balance", cus.getBalance());
            modelAndView.setViewName("redirect:/Main");
        } else if (acct.signIn()) {
            redirectAttributes.addFlashAttribute("Username", User);
            redirectAttributes.addFlashAttribute("Name", acct.getName());
            modelAndView.setViewName("redirect:/CreateProfile");
        } else { //wrong information
            redirectAttributes.addFlashAttribute("message", "Error: Invalid Username or Password!");
            modelAndView.setViewName("redirect:/index");
        }

        return modelAndView;
    }

}
