package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CreateProfileControl {

    @RequestMapping(value = "/CreateProfileControl", method = RequestMethod.POST)
    public ModelAndView CreateProfile(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        String UName = (String) session.getAttribute("Username");
        String Name = request.getParameter("Name");
        String Street = request.getParameter("Street");
        String City = request.getParameter("City");
        String State = request.getParameter("State");
        String Zip = request.getParameter("Zip");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");
        String Balance = request.getParameter("Balance");
        float bal = Float.parseFloat(Balance);
        Customer cus = new Customer(Name, Street, City, State, Zip, Phone, Email, bal, UName);
        mv.setViewName("redirect:/index");
        if (cus.createProfile()) { //create the profile 
            redirectAttributes.addFlashAttribute("message", "Created profile successfully! Please relog to your account!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Created profile failed unexpectly! If this occurs multiple times please contact help desk.");
        }
        return mv;
    }

}
