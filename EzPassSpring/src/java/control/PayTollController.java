package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.EzTag;
import model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PayTollController {
    
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
    
    @RequestMapping(value = "/PayTollControl", method = RequestMethod.POST)
    public ModelAndView PayToll(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        String CID = (String) session.getAttribute("CID");
        String TC = request.getParameter("TagCode");
        String TP = request.getParameter("TollPlaza");
        String TL = request.getParameter("TollLane");
        String TA = request.getParameter("TollAmount");

        int TL_INT = Integer.parseInt(TL); //Toll lane is int in database
        float TA_FLT = Float.parseFloat(TA); // Toll amount is float
        Transaction tran = new Transaction(TC, TA_FLT, TP, TL_INT, CID);
        EzTag tag = new EzTag(TC, CID); //check if tag code belongs to customer
        Customer cus = new Customer(CID);
        cus.setData();
        float oldBal = cus.getBalance();
        float newBal = oldBal - TA_FLT; //subtract old balance with charge toll amount
        mv.setViewName("redirect:/PayTolls");
        if (tag.checkTag()) {
            if (tran.recordTransaction() && cus.charge(newBal)) {
                redirectAttributes.addFlashAttribute("message", "Pay toll was successful! Your new balance is: " + newBal + ". Have a nice trip! ");
            } else { //transaction failed
                redirectAttributes.addFlashAttribute("message", "Error: Unable to process payments at this time. If this occurs multiple times please contact help desk.");
            }

        } else {//invalid tag
            redirectAttributes.addFlashAttribute("message", "Error: Pay toll failed because Tag Code was invalid!");
        }
        return mv;
    }
    
}
