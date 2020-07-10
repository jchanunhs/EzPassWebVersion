package control;

/*
This controller contains all the mappings for the website directories. 
if the username is empty, that means user did not log in
if username is not empty, but CID is empty, that means  user logged in but needs to create profile
if username and CID are both not empty, that means user logged in and profile is already created
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.EzTag;
import model.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Username") == null) {  //check if user has logged in successfully
            return "index";
        } else {
            return "redirect:/Main";
        }
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

    @RequestMapping("/CreateProfile")
    public String CreateProfile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Username") != null && session.getAttribute("CID") == null) { //check if user logged in and created profile
            return "CreateProfile";
        } else {
            return "redirect:/index";
        }
    }

    @RequestMapping("/Main")
    public ModelAndView Main(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username") == null && session.getAttribute("CID") == null) {
            mv.setViewName("redirect:/index");
        } else {
            Customer cus = new Customer((String) session.getAttribute("CID"));
            cus.setData();
            mv.addObject("Name", cus.getName());
            mv.addObject("Street", cus.getStreet());
            mv.addObject("City", cus.getCity());
            mv.addObject("State", cus.getState());
            mv.addObject("Zip", cus.getZip());
            mv.addObject("Phone", cus.getPhone());
            mv.addObject("Email", cus.getEmail());
            mv.addObject("Balance", String.valueOf(cus.getBalance()));
            mv.setViewName("Main");
        }
        return mv;
    }

    @RequestMapping("/ChangePassword")
    public String ChangePassword(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username") == null && session.getAttribute("CID") == null) {
            return "redirect:/index";
        } else {
            return "ChangePassword";
        }
    }

    @RequestMapping("/Vehicle")
    public ModelAndView Vehicle(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username") == null && session.getAttribute("CID") == null) {
            mv.setViewName("redirect:/index");
        } else {
            mv.setViewName("Vehicle");
            Vehicle vehicle = new Vehicle((String) session.getAttribute("CID"));
            mv.addObject("vehicle_list", vehicle.getVehicles());
        }
        return mv;
    }

    @RequestMapping("/EzTag")
    public ModelAndView EzTag(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username") == null && session.getAttribute("CID") == null) {
            mv.setViewName("redirect:/index");
        } else {
            mv.setViewName("EzTag");
            EzTag ez = new EzTag((String) session.getAttribute("CID"));
            mv.addObject("ez_list", ez.getTags());
        }
        return mv;
    }

    @RequestMapping("/PayTolls")
    public String PayTolls(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username") == null && session.getAttribute("CID") == null) {
            return "redirect:/index";
        } else {
            return "PayTolls";
        }
    }

}
