package control;

/*
This controller contains all the mappings for the website directories. 
if the username is empty, that means user did not log in
if username is not empty, but CID is empty, that means  user logged in but needs to create profile
if username and CID are both not empty, that means user logged in and profile is already created
*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    
    @RequestMapping("/index") 
    public String home(){
        return "index"; 
    }
    
    @RequestMapping("/SignUp") 
    public String SignUp(){
        return "SignUp"; 
    } 
    
    @RequestMapping("/")
    public String root(HttpServletRequest request) { //first session
        HttpSession session = request.getSession();
        if (session.getAttribute("Username")==null) {  //check if user has logged in successfully
            return "redirect:/index";
        } else {
            return "Main";
        }
    }
    
    @RequestMapping("/CreateProfile") 
    public String CreateProfile(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session.getAttribute("Username")==null) {  //check if user has logged in successfully
            return "redirect:/index";
        } else {
            return "CreateProfile";
        }
    } 
    
     
       
    @RequestMapping("/Main") 
    public String Main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "Main";
        }
    } 

    @RequestMapping("/ChangePassword") 
    public String ChangePassword(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "ChangePassword";
        }
    } 
    
    @RequestMapping("/Recharge") 
    public String Recharge(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "Recharge";
        }
    } 
    
    @RequestMapping("/Vehicle") 
    public String Vehicle(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "Vehicle";
        }
    } 
    
    @RequestMapping("/AddVehicle") 
    public String AddVehicle(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "AddVehicle";
        }
    } 
    
    @RequestMapping("/RemoveVehicle") 
    public String RemoveVehicle(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "RemoveVehicle";
        }
    } 
    
    @RequestMapping("/EzTag") 
    public String EzTag(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "EzTag";
        }
    } 
    
    @RequestMapping("/AddTag") 
    public String AddEzTag(HttpServletRequest request){
       HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "AddTag";
        }
    } 
    
    @RequestMapping("/RemoveTag") 
    public String RemoveEzTag(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "RemoveTag";
        }
    } 
    
    @RequestMapping("/PayTolls") 
    public String PayTolls(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "PayTolls";
        }
    } 
    
    @RequestMapping("/Transactions") 
    public String Transactions(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "Transactions";
        } 
    } 
    
    @RequestMapping("/ViewDateTransactions") 
    public String ViewDateTransactions(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username")==null && session.getAttribute("CID")==null) {  
            return "redirect:/index";
        } else {
            return "ViewDateTransactions";
        }
    } 
    
    

    
    
}
