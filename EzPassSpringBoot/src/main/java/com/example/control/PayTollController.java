package com.example.control;

import com.example.dao.CustomerDAO;
import com.example.dao.EzTagDAO;
import com.example.dao.TransactionDAO;
import com.example.dao.VehicleDAO;
import com.example.service.CustomerService;
import com.example.service.EzTagService;
import com.example.service.TransactionService;
import com.example.service.VehicleService;
import com.example.model.Customer;
import com.example.model.EzTag;
import com.example.model.Transaction;
import com.example.model.Vehicle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PayTollController {

    @RequestMapping(value = "/paytoll", method = RequestMethod.GET)
    public ModelAndView PayToll(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        if (Username != null && CustomerID != null) {  //check if user has logged in successfully and created profile
            mv.setViewName("PayTolls");
        } else { //user not authenticated, redirect to index page
            mv.setViewName("redirect:/index");
        }
        return mv;
    }

    @RequestMapping(value = "/paytoll", method = RequestMethod.POST)
    public ModelAndView PayTollControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");

        String LicensePlateNumber = request.getParameter("LicensePlateNumber");
        String TagCode = request.getParameter("TagCode");
        String TollPlaza = request.getParameter("TollPlaza");
        String TollLane = request.getParameter("TollLane");
        String TollAmt = request.getParameter("TollAmount");
        float TollAmount = Float.parseFloat(TollAmt);
        int TollLaneNumber = Integer.parseInt(TollLane);

        //process customer balance
        CustomerDAO customerdao = new CustomerService();
        Customer customer = customerdao.getCustomerInformation(CustomerID);
        float OldBalance = customer.getBalance(); //get current balance from customer
        float NewBalance = OldBalance - TollAmount;

        //check if tag belongs to customer
        EzTagDAO eztagdao = new EzTagService();
        EzTag eztag = new EzTag();
        eztag.setCustomerID(CustomerID);
        eztag.setTagCode(TagCode);

        //check if vehicle belongs both to the customer and tagcode
        VehicleDAO vehicledao = new VehicleService();
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlateNumber(LicensePlateNumber);
        vehicle.setTagCode(TagCode);
        vehicle.setCustomerID(CustomerID);

        //record transaction
        TransactionDAO transactiondao = new TransactionService();
        Transaction transaction = new Transaction();
        transaction.setTagCode(TagCode);
        transaction.setTollAmount(TollAmount);
        transaction.setTollPlaza(TollPlaza);
        transaction.setTollLaneNumber(TollLaneNumber);
        transaction.setCustomerID(CustomerID);

        if (eztagdao.checkTag(eztag)) { //check if tag code belongs to customer
            if (vehicledao.checkVehicle(vehicle)) { // check if vehicle belongs to tag code
                if (customerdao.updateBalance(customer, NewBalance)) { //invalidate session after pay toll success
                    String transactionresult = transactiondao.recordTransaction(transaction); //create transaction
                    session.invalidate();
                    redirectAttributes.addFlashAttribute("message", "Pay toll was successful! Your Transaction ID is " + transactionresult + " and your new balance is: " + NewBalance + ". Have a nice trip!");
                    mv.setViewName("redirect:/index");
                } else { //update balance failed
                    redirectAttributes.addFlashAttribute("message", "Error: Unable to process payments at this time. If this occurs multiple times please contact help desk.");
                    mv.setViewName("redirect:/paytoll");
                }
            } else { //vehicle and tag code dont match
                redirectAttributes.addFlashAttribute("message", "Error: The Tag Code is registered to your account, but this vehicle is not associated with this tag code.");
                mv.setViewName("redirect:/paytoll");
            }
        } else {//invalid tag
            redirectAttributes.addFlashAttribute("message", "Error: Pay toll failed because Tag Code was invalid!");
            mv.setViewName("redirect:/paytoll");
        }
        return mv;
    }

}

