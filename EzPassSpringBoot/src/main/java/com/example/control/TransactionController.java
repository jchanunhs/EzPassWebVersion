package com.example.control;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.example.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionController {

    @RequestMapping("/Transactions")
    public ModelAndView Transactions(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        //check if user has logged in successfully AND created profile
        if (session.getAttribute("Username") == null) {  //check if user has logged in successfully
            mv.setViewName("redirect:/index");
        } else if (session.getAttribute("Username") != null && session.getAttribute("CID") == null) { //check if user logged in but needs to create profile
            mv.setViewName("redirect:/CreateProfile");
        } else {
            Transaction tran = new Transaction((String) session.getAttribute("CID"));
            ArrayList<String> TID_list = tran.getAllTransactions("TransactionID");
            ArrayList<String> TC_list = tran.getAllTransactions("TagCode");
            ArrayList<String> TD_list = tran.getAllTransactions("TransactionDate");
            ArrayList<String> TT_list = tran.getAllTransactions("TransactionTime");
            ArrayList<String> TP_list = tran.getAllTransactions("TollPlaza");
            ArrayList<String> TLN_list = tran.getAllTransactions("TollLaneNumber");
            ArrayList<String> TA_list = tran.getAllTransactions("TollAmount");
            mv.addObject("TID", TID_list);
            mv.addObject("TC", TC_list);
            mv.addObject("TD", TD_list);
            mv.addObject("TT", TT_list);
            mv.addObject("TP", TP_list);
            mv.addObject("TLN", TLN_list);
            mv.addObject("TA", TA_list);
            mv.setViewName("Transactions");
        }
        return mv;
    }

    @RequestMapping(value = "/ViewTransactionDates", method = RequestMethod.POST)
    public ModelAndView ViewTransactionDate(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String before = request.getParameter("before");
        String after = request.getParameter("after");
        Transaction tran = new Transaction((String) session.getAttribute("CID"));
        mv.setViewName("Transactions");
        if (before.equals("") && after.equals("")) {
            ArrayList<String> TID_list = tran.getAllTransactions("TransactionID");
            ArrayList<String> TC_list = tran.getAllTransactions("TagCode");
            ArrayList<String> TD_list = tran.getAllTransactions("TransactionDate");
            ArrayList<String> TT_list = tran.getAllTransactions("TransactionTime");
            ArrayList<String> TP_list = tran.getAllTransactions("TollPlaza");
            ArrayList<String> TLN_list = tran.getAllTransactions("TollLaneNumber");
            ArrayList<String> TA_list = tran.getAllTransactions("TollAmount");
            mv.addObject("TID", TID_list);
            mv.addObject("TC", TC_list);
            mv.addObject("TD", TD_list);
            mv.addObject("TT", TT_list);
            mv.addObject("TP", TP_list);
            mv.addObject("TLN", TLN_list);
            mv.addObject("TA", TA_list);
        } else {
            ArrayList<String> TID_list = tran.getTransactions(before, after, "TransactionID");
            ArrayList<String> TC_list = tran.getTransactions(before, after, "TagCode");
            ArrayList<String> TD_list = tran.getTransactions(before, after, "TransactionDate");
            ArrayList<String> TT_list = tran.getTransactions(before, after, "TransactionTime");
            ArrayList<String> TP_list = tran.getTransactions(before, after, "TollPlaza");
            ArrayList<String> TLN_list = tran.getTransactions(before, after, "TollLaneNumber");
            ArrayList<String> TA_list = tran.getTransactions(before, after, "TollAmount");
            mv.addObject("TID", TID_list);
            mv.addObject("TC", TC_list);
            mv.addObject("TD", TD_list);
            mv.addObject("TT", TT_list);
            mv.addObject("TP", TP_list);
            mv.addObject("TLN", TLN_list);
            mv.addObject("TA", TA_list);
        }
        return mv;
    }

}
