package com.example.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.example.model.Customer;
import com.example.model.EzTag;
import com.example.model.Transaction;
import com.example.model.Vehicle;
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
        if (session.getAttribute("Username") == null) {  //check if user has logged in successfully
            return "index";
        } else if (session.getAttribute("Username") != null && session.getAttribute("CID") == null) { //check if user logged in but needs to create profile
            return "redirect:/CreateProfile";
        } else {
            return "PayTolls";
        }
    }

    @RequestMapping(value = "/PayTollControl", method = RequestMethod.POST)
    public ModelAndView PayTollControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String CID = (String) session.getAttribute("CID");
        String LP = request.getParameter("LicensePlateNumber");
        String TC = request.getParameter("TagCode");
        String TP = request.getParameter("TollPlaza");
        String TL = request.getParameter("TollLane");
        String TA = request.getParameter("TollAmount");

        int TL_INT = Integer.parseInt(TL); //Toll lane is int in database
        float TA_FLT = Float.parseFloat(TA); // Toll amount is float
        Transaction trans = new Transaction(TC, TA_FLT, TP, TL_INT, CID);
        EzTag tag = new EzTag(TC, CID); //check if tag code belongs to customer
        Vehicle vehicle = new Vehicle(LP, TC, CID); //check if vehicle matches tag code
        Customer cus = new Customer(CID);
        float oldBal = cus.getBalance();
        float newBal = oldBal - TA_FLT; //subtract old balance with charge toll amount
        mv.setViewName("redirect:/PayTolls");

        if (tag.checkTag()) { //check if tag matches customer id
            if (vehicle.checkVehicle()) { //check if vehicle belongs to tag code
                if (trans.recordTransaction()) { //record transaction first
                    if (cus.updateBalance(newBal)) {
                        redirectAttributes.addFlashAttribute("message", "Pay toll was successful! Your Transaction ID is " + trans.getTransactionID() + " and your new balance is " + newBal + ". Have a nice trip! ");
                    }
                } else { //record transaction will fail if generated transaction id is taken
                    redirectAttributes.addFlashAttribute("message", "Error: Unable to process payments at this time. If this occurs multiple times please contact help desk.");
                }
            } else {//vehicle and tag code dont match
                redirectAttributes.addFlashAttribute("message", "Error: The Tag Code is registered to your account, but this vehicle is not associated with this tag code.");
            }

        } else {//invalid tag
            redirectAttributes.addFlashAttribute("message", "Error: Pay toll failed because Tag Code was invalid!");
        }
        return mv;
    }

}
