package com.example.control;

import com.example.dao.AccountDAO;
import com.example.dao.CustomerDAO;
import com.example.entity.Account;
import com.example.entity.Customer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String root(HttpServletRequest request) { //display homepage
        HttpSession session = request.getSession();
        return "root";
    }

    @RequestMapping("/faq")
    public String faq(HttpServletRequest request) { //display faq page
        HttpSession session = request.getSession();
        return "faq";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        if (Username != null && CustomerID != null) {  //check if user has logged in successfully and created profile
            CustomerDAO customerdao = new CustomerDAO();
            Customer customer = customerdao.getCustomerInformation(CustomerID);
            mv.addObject("customer", customer);
            mv.setViewName("Profile");
        } else if (Username != null && CustomerID == null) { //check if user logged in but needs to create profile
            mv.setViewName("redirect:/createprofile");
        } else { //user not logged in, show index page (login sceeen)
            mv.setViewName("index"); 
        }
        return mv;
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ModelAndView LoginControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        AccountDAO accountdao = new AccountDAO();
        Account account = accountdao.getAccountInformation(Username, Password);

        if (account.getUsername() != null && account.getPassword() != null && account.getCustomerID() != null) { 
            CustomerDAO customerdao = new CustomerDAO();
            Customer customer = customerdao.getCustomerInformation(account.getCustomerID()); //get customer information from customer id
            //save username for change password. save customerid to access customer information
            session.setAttribute("Username", Username);
            session.setAttribute("CustomerID", customer.getCustomerID());
            mv.setViewName("redirect:/index");
        } else if (account.getUsername() != null && account.getPassword() != null && account.getCustomerID() == null) { //profile not created
            session.setAttribute("Username", Username);
            mv.setViewName("redirect:/createprofile");
        } else { //login failed
            redirectAttributes.addFlashAttribute("message", "Error: Invalid Username and/or Password. Please try again.");
            mv.setViewName("redirect:/index");
        }
        return mv;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView SignUp(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        if (Username != null && CustomerID != null) {  
            mv.setViewName("redirect:/index");
        } else if (Username != null && CustomerID == null) { 
            mv.setViewName("redirect:/createprofile");
        } else { //only show sign up page if user is not logged on
            mv.setViewName("SignUp");
        }
        return mv;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView SignUpControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        AccountDAO accountdao = new AccountDAO();
        Account account = new Account();
        account.setUsername(Username);
        account.setPassword(Password);

        if (accountdao.signUp(account)) { //create account
            redirectAttributes.addFlashAttribute("message", "Account created successfully! Please login to your new account!");
            mv.setViewName("redirect:/index");
        } else { //account creation failed
            redirectAttributes.addFlashAttribute("message", "Error: Username is taken. Please try another username.");
            mv.setViewName("redirect:/signup");
        }
        return mv;
    }

    @RequestMapping(value = "/createprofile", method = RequestMethod.GET)
    public ModelAndView CreateProfile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        if (session.getAttribute("Username") != null && session.getAttribute("CustomerID") == null) { //check if user logged in but needs to create profile
            mv.setViewName("CreateProfile");
        } else {// if not need to create profile, redirect to index page
            mv.setViewName("redirect:/index");
        }
        return mv;
    }

    @RequestMapping(value = "/createprofile", method = RequestMethod.POST)
    public ModelAndView CreateProfileControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String Name = request.getParameter("Name");
        String Street = request.getParameter("Street");
        String City = request.getParameter("City");
        String State = request.getParameter("State");
        String Zip = request.getParameter("Zip");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");
        CustomerDAO customerdao = new CustomerDAO();
        Customer customer = new Customer();
        customer.setName(Name);
        customer.setStreet(Street);
        customer.setCity(City);
        customer.setState(State);
        customer.setZip(Zip);
        customer.setPhone(Phone);
        customer.setEmail(Email);

        if (customerdao.createProfile(customer, Username)) {
            redirectAttributes.addFlashAttribute("message", "Profile created successfully! Please relog to your account!");
            session.invalidate();
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Created profile failed unexpectly! If this occurs multiple times please contact help desk.");
        }
        mv.setViewName("redirect:/index");
        return mv;
    }

    

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView LogOut(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("AdminID") != null) { //check if it's admin logging out
            mv.setViewName("redirect:/Admin/Login");
        } else {
            mv.setViewName("redirect:/index");
        }
        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "Account signed off successfully!");
        return mv;
    }

}
