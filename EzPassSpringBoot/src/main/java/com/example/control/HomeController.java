package com.example.control;

/*
if the username is empty, that means user did not log in
if username is not empty, but CID is empty, that means  user logged in but needs to create profile
if CID is not empty, that means user logged in and profile is already created
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.example.model.Account;
import com.example.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String root(HttpServletRequest request) { 
        HttpSession session = request.getSession();
        return "root";
    }

    @RequestMapping("/faq")
    public String faq(HttpServletRequest request) { 
        HttpSession session = request.getSession();
        return "faq";
    }

    @RequestMapping("/index")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Username") == null) {  //check if user has logged in successfully
            return "index";
        } else if (session.getAttribute("Username") != null && session.getAttribute("CID") == null) { //check if user logged in but needs to create profile
            return "redirect:/CreateProfile";
        } else {
            return "redirect:/Profile";
        }
    }

    @RequestMapping(value = "/LoginControl", method = RequestMethod.POST)
    public ModelAndView Login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        String User = request.getParameter("Username");
        String PW = request.getParameter("Password");
        HttpSession session = request.getSession();
        Account Acct = new Account(User, PW);
        if (Acct.signIn() && Acct.getCustomerID() != null) { //set session attributes and redirect to user main page
            session.setAttribute("Username", User); //for change password
            session.setAttribute("CID", Acct.getCustomerID());
            mv.setViewName("redirect:/Profile");
        } else if (Acct.signIn()) {
            session.setAttribute("Username", User);
            session.setAttribute("Name", Acct.getName());
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
        if (session.getAttribute("Username") == null) {  //check if user has logged in successfully
            return "SignUp";
        } else if (session.getAttribute("Username") != null && session.getAttribute("CID") == null) { //check if user logged in but needs to create profile
            return "redirect:/CreateProfile";
        } else {
            return "redirect:/Profile";
        }
    }

    @RequestMapping(value = "/SignUpControl", method = RequestMethod.POST)
    public ModelAndView SignUpControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String Password1 = request.getParameter("Password1");
        String Name = request.getParameter("Name");
        Account acct = new Account(Username, Password, Name);
        if (acct.signUp()) {
            mv.setViewName("redirect:/index");
            redirectAttributes.addFlashAttribute("message", "Account creation was successful! Please login to your new account!");
        } else {
            mv.setViewName("redirect:/SignUp");
            redirectAttributes.addFlashAttribute("message", "Error: Username is taken. Please try another username.");
        }
        return mv;
    }

    @RequestMapping("/CreateProfile")
    public String CreateProfile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Username") == null) {  //check if user has logged in successfully
            return "redirect:/index";
        } else if (session.getAttribute("Username") != null && session.getAttribute("CID") == null) { //check if user logged in but needs to create profile
            return "CreateProfile";
        } else {
            return "redirect:/Profile";
        }
    }

    @RequestMapping(value = "/CreateProfileControl", method = RequestMethod.POST)
    public ModelAndView CreateProfileControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String UName = (String) session.getAttribute("Username");
        String Name = request.getParameter("Name");
        String Street = request.getParameter("Street");
        String City = request.getParameter("City");
        String State = request.getParameter("State");
        String Zip = request.getParameter("Zip");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");
        Customer cus = new Customer(Name, Street, City, State, Zip, Phone, Email, UName);
        mv.setViewName("redirect:/index");
        if (cus.createProfile()) { //create the profile 
            redirectAttributes.addFlashAttribute("message", "Created profile successfully! Please relog to your account!");
            session.invalidate();
        } else { //customer profile will fail if the generated customer id is taken
            redirectAttributes.addFlashAttribute("message", "Error: Created profile failed unexpectly! If this occurs multiple times please contact help desk.");
        }
        return mv;
    }

}
