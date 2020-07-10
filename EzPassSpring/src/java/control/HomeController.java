package control;

/*
if the username is empty, that means user did not log in
if username is not empty, but CID is empty, that means  user logged in but needs to create profile
if username and CID are both not empty, that means user logged in and profile is already created
 */
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
public class HomeController {

    @RequestMapping("/")
    public String root(HttpServletRequest request) { //first session
        HttpSession session = request.getSession();
        if (session.getAttribute("Username") == null) {  //check if user has logged in successfully
            return "index";
        } else {
            return "redirect:/Main";
        }
    }

    @RequestMapping("/faq")
    public String faq(HttpServletRequest request) { //first session
        HttpSession session = request.getSession();
        return "faq";
    }

    @RequestMapping("/index")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Username") == null) {  //check if user has logged in successfully
            return "index";
        } else {
            return "redirect:/Main";
        }
    }

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

    @RequestMapping("/SignUp")
    public String SignUp(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Username") != null) {  //check if user has logged in successfully
            return "redirect:/index";
        } else {
            return "SignUp";
        }
    }

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

    @RequestMapping("/CreateProfile")
    public String CreateProfile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Username") != null && session.getAttribute("CID") == null) { //check if user logged in and created profile
            return "CreateProfile";
        } else {
            return "redirect:/index";
        }
    }

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
            session.invalidate();
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Created profile failed unexpectly! If this occurs multiple times please contact help desk.");
        }
        return mv;
    }

}
