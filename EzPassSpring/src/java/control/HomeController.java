package control;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller

public class HomeController {
    @RequestMapping("/index") 
    public String home(){
        return "index"; 
    }
    
    @RequestMapping("/")
    public String root(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("Username")==null) { 
            return "index";
        } else {
            return "Main";
        }
    }
    
    @RequestMapping("/CreateProfile") 
    public String CreateProfile(){
        return "CreateProfile"; 
    } 
    
    @RequestMapping("/SignUp") 
    public String SignUp(){
        return "SignUp"; 
    }  
       
    @RequestMapping("/Main") 
    public String Main(){
        return "Main"; 
    } 

    @RequestMapping("/ChangePassword") 
    public String ChangePassword(){
        return "ChangePassword"; 
    } 
    
    @RequestMapping("/Recharge") 
    public String Recharge(){
        return "Recharge"; 
    } 
    
    @RequestMapping("/Vehicle") 
    public String Vehicle(){
        return "Vehicle"; 
    } 
    
    @RequestMapping("/AddVehicle") 
    public String AddVehicle(){
        return "AddVehicle"; 
    } 
    
    @RequestMapping("/RemoveVehicle") 
    public String RemoveVehicle(){
        return "RemoveVehicle"; 
    } 
    
    @RequestMapping("/EzTag") 
    public String EzTag(){
        return "EzTag"; 
    } 
    
    @RequestMapping("/AddTag") 
    public String AddEzTag(){
        return "AddTag"; 
    } 
    
    @RequestMapping("/RemoveTag") 
    public String RemoveEzTag(){
        return "RemoveTag"; 
    } 
    
    @RequestMapping("/PayTolls") 
    public String PayTolls(){
        return "PayTolls"; 
    } 
    
    @RequestMapping("/Transactions") 
    public String Transactions(){
        return "Transactions"; 
    } 
    
    @RequestMapping("/ViewDateTransactions") 
    public String ViewDateTransactions(){
        return "ViewDateTransactions"; 
    } 
    
    

    
    
}
