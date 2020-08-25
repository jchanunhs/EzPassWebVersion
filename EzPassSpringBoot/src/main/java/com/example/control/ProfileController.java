package com.example.control;

import com.example.dao.AccountDAO;
import com.example.dao.CreditCardDAO;
import com.example.dao.CustomerDAO;
import com.example.entity.Account;
import com.example.entity.CreditCard;
import com.example.entity.Customer;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfileController {

    @RequestMapping(value = "/recharge", method = RequestMethod.GET)
    public ModelAndView Recharge(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        if (Username != null && CustomerID != null) {  //check if user has logged in successfully and created profile
            CustomerDAO customerdao = new CustomerDAO(); //get current balance
            Customer customer = customerdao.getCustomerInformation(CustomerID);
            CreditCardDAO creditcarddao = new CreditCardDAO(); //get recharge transaction
            ArrayList<CreditCard> creditcardlist = creditcarddao.getAllTransactions(CustomerID);
            mv.addObject("creditcardlist", creditcardlist);
            mv.addObject("customer", customer);
            mv.setViewName("Recharge");
        } else { //user not authenticated, redirect to index page
            mv.setViewName("redirect:/index");
        }
        return mv;
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public ModelAndView RechargeControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");

        String CardNumber = request.getParameter("CardNumber");
        String Name = request.getParameter("Name");
        String ExpirationDate = request.getParameter("EXP");
        String CVV = request.getParameter("CVV");
        String Credit = request.getParameter("Credit");
        float CreditAmount = Float.parseFloat(Credit);
        //get customer current balance
        CustomerDAO customerdao = new CustomerDAO();
        Customer customer = customerdao.getCustomerInformation(CustomerID);
        float OldBalance = customer.getBalance(); //get old balance and add credit amount to it
        float NewBalance = OldBalance + CreditAmount;
        //add transaction
        CreditCardDAO creditcarddao = new CreditCardDAO();
        CreditCard creditcard = new CreditCard();
        creditcard.setCardNumber(CardNumber);
        creditcard.setName(Name);
        creditcard.setExpirationDate(ExpirationDate);
        creditcard.setCVV(CVV);
        creditcard.setCustomerID(CustomerID);
        creditcard.setCreditAmount(CreditAmount);

        if (customerdao.updateBalance(customer, NewBalance)) {
            String transactionresult = creditcarddao.addCreditCardTransaction(creditcard); //create credit transaction.
            redirectAttributes.addFlashAttribute("message", "Recharge successful! Your Transaction ID is " + transactionresult + " and your new balance is: " + NewBalance);
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Recharge failed unexpectly! If this occurs multiple times, please contact help desk.");
        }

        mv.setViewName("redirect:/recharge");
        return mv;
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
    public ModelAndView ChangePassword(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        if (Username != null && CustomerID != null) {  //check if user has logged in successfully and created profile
            mv.setViewName("ChangePassword");
        } else { //user not authenticated, redirect to index page
            mv.setViewName("redirect:/index");
        }
        return mv;
    }
    
    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public ModelAndView ChangePasswordControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        
        String OldPassword = request.getParameter("OldPassword");
        String NewPassword = request.getParameter("NewPassword");
        AccountDAO accountdao = new AccountDAO();
        Account account = new Account();
        account.setUsername(Username);
        account.setPassword(OldPassword);
        if (accountdao.updatePassword(account, NewPassword)) {
            session.invalidate();
            redirectAttributes.addFlashAttribute("message", "Your password was changed successfully. Please relog with your new password.");
            mv.setViewName("redirect:/index");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Change password failed! Your old password is invalid. Please try again.");
            mv.setViewName("redirect:/changepassword");
        }
        
        return mv;
    }

}
