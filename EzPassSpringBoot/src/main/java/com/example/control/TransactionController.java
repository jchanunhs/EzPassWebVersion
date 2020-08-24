package com.example.control;

import com.example.dao.TransactionDAO;
import com.example.entity.Transaction;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionController {
    
    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public ModelAndView Transaction(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        if (Username != null && CustomerID != null) {  //check if user has logged in successfully and created profile
            TransactionDAO transactiondao = new TransactionDAO();
            ArrayList<Transaction> transactionlist = transactiondao.getAllTransactions(CustomerID);
            mv.addObject("transactionlist", transactionlist);
            mv.setViewName("Transactions");
        } else if (Username != null && CustomerID == null) { //check if user logged in but needs to create profile
            mv.setViewName("redirect:/createprofile");
        } else { //user not logged in, show index page (login sceeen)
            mv.setViewName("redirect:/index");
        }
        return mv;
    }
    
    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public ModelAndView TransactionControl(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        
        String before = request.getParameter("before");
        String after = request.getParameter("after");
        if (before.isEmpty() || after.isEmpty()) {
            mv.setViewName("redirect:/transaction");
        } else {
            //get transactions based on date
            TransactionDAO transactiondao = new TransactionDAO();
            ArrayList<Transaction> transactionlist = transactiondao.getTransactions(CustomerID, before, after);
            mv.addObject("transactionlist", transactionlist);
            mv.setViewName("Transactions");
        }
        
        return mv;
    }
    
}
