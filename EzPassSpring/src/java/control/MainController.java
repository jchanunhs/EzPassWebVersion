package control;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Account;
import model.CreditCard;
import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

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

    @RequestMapping(value = "/ChangePasswordControl", method = RequestMethod.POST)
    public ModelAndView ChangePassword(HttpServletRequest request, RedirectAttributes redirectAttributes, ModelAndView mv) {
        HttpSession session = request.getSession(false);
        String Username = (String) session.getAttribute("Username");
        String old = request.getParameter("Old");
        String NewPass = request.getParameter("New");
        Account acct = new Account(Username, old);

        if (acct.changePassword(NewPass)) { //change password
            session.invalidate();
            redirectAttributes.addFlashAttribute("message", "Your password was changed successfully. Please relog with your new password.");
            mv.setViewName("redirect:/index");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Change password failed! Your old password is invalid. Please try again.");
            mv.setViewName("redirect:/ChangePassword");
        }
        return mv;
    }
    
    @RequestMapping("/Recharge")
    public ModelAndView Recharge(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username") == null && session.getAttribute("CID") == null) {
            mv.setViewName("redirect:/index");
        } else {
            CreditCard card = new CreditCard((String) session.getAttribute("CID"));
            ArrayList<String> CreditID_list = card.getAllTransactions("CreditID");
            ArrayList<String> CN_list = card.getAllTransactions("CardNumber");
            ArrayList<String> date_list = card.getAllTransactions("Date");
            ArrayList<String> time_list = card.getAllTransactions("Time");
            ArrayList<String> cd_amt = card.getAllTransactions("CreditAmount");
            mv.addObject("CreditID", CreditID_list);
            mv.addObject("CardNumber", CN_list);
            mv.addObject("Date", date_list);
            mv.addObject("Time", time_list);
            mv.addObject("CreditAmt", cd_amt);
            Customer cus = new Customer((String) session.getAttribute("CID"));
            cus.setData();
            mv.addObject("Balance", String.valueOf(cus.getBalance()));
            mv.setViewName("Recharge");
        }
        return mv;
    }
    
    @RequestMapping(value = "/RechargeControl", method = RequestMethod.POST)
    public ModelAndView Recharge(HttpServletRequest request, RedirectAttributes redirectAttributes, ModelAndView mv) {
        HttpSession session = request.getSession();
        String CID = (String) session.getAttribute("CID");
        String CN = request.getParameter("CardNumber");
        String NM = request.getParameter("Name");
        String EXPDate = request.getParameter("EXP");
        String CVV = request.getParameter("CVV");
        String Credit = request.getParameter("Credit");
        float Credit_FLT = Float.parseFloat(Credit);
        CreditCard card = new CreditCard(CN, NM, EXPDate, CVV, CID, Credit_FLT); // add payment information
        Customer cus = new Customer(CID); // get current balance
        cus.setData();//data set based on customer id
        float oldBal = cus.getBalance();
        float newBal = oldBal + Credit_FLT; //add the balance together
        mv.setViewName("redirect:/Recharge");
        if (cus.updateBalance(newBal) && card.addCreditCard()) {
            redirectAttributes.addFlashAttribute("message", "Recharge successfully! Your Transaction ID is " + card.getCreditID() + " and your new balance is: " + newBal);
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Recharge failed unexpectly! If this occurs multiple times, please contact help desk.");
        }

        return mv;
    }
    
    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
    public ModelAndView LogOut(HttpServletRequest request, RedirectAttributes redirectAttributes, ModelAndView mv) {
        HttpSession session = request.getSession();
        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "Account signed off successfully!");
        mv.setViewName("redirect:/index");
        return mv;
    }

}
