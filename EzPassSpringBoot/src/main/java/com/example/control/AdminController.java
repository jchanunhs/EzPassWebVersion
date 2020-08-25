package com.example.control;

import com.example.dao.AccountDAO;
import com.example.dao.AdminDAO;
import com.example.dao.CustomerDAO;
import com.example.dao.EzTagDAO;
import com.example.entity.Account;
import com.example.entity.Admin;
import com.example.entity.Customer;
import com.example.entity.EzTag;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {

    @RequestMapping(value = "/Admin/Login", method = RequestMethod.GET)
    public ModelAndView AdminLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String AdminID = (String) session.getAttribute("AdminID");
        String CustomerID = (String) session.getAttribute("AdminCIDInput");
        if (AdminID != null && CustomerID != null) { //admin is logged on and is assisting a customer
            mv.setViewName("redirect:/Admin/UpdateCustomerProfile");
        } else if (AdminID != null && CustomerID == null) { //admin is logged on and does not have a case
            mv.setViewName("redirect:/Admin/VerifyInformation");
        } else { //admin not logged on
            mv.setViewName("AdminLogin");
        }
        return mv;
    }

    @RequestMapping(value = "/Admin/Login", method = RequestMethod.POST)
    public ModelAndView AdminLoginControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String AdminID = request.getParameter("AdminID");
        String Name = request.getParameter("Name");
        String Password = request.getParameter("Password");

        //login
        AdminDAO admindao = new AdminDAO();
        Admin admin = new Admin();
        admin.setAdminID(AdminID);
        admin.setName(Name);
        admin.setPassword(Password);

        if (admindao.login(admin)) { //admin logs in successfully
            session.setAttribute("AdminID", AdminID);
            mv.setViewName("redirect:/Admin/VerifyInformation");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Invalid login credentials.");
            mv.setViewName("redirect:/Admin/Login");
        }

        return mv;
    }

    @RequestMapping(value = "/Admin/VerifyInformation", method = RequestMethod.GET)
    public ModelAndView AdminVerify(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String AdminID = (String) session.getAttribute("AdminID");
        String CustomerID = (String) session.getAttribute("AdminCIDInput");
         if (AdminID != null && CustomerID == null) { //only show this page if admin is logged on and currently does not have a case
            mv.setViewName("AdminVerify");
        } else { //redirect because admin currently does not have permission to access this page
            mv.setViewName("redirect:/Admin/Login");
        }
        return mv;
    }

    @RequestMapping(value = "/Admin/VerifyInformation", method = RequestMethod.POST)
    public ModelAndView AdminVerifyControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = request.getParameter("Username");
        String CustomerID = request.getParameter("CustomerID");

        //AdminDAO to verify the customer's information
        AdminDAO admindao = new AdminDAO();

        //Account with CustomerID and Username
        AccountDAO accountdao = new AccountDAO();
        Account account = new Account();
        account.setUsername(Username);
        account.setCustomerID(CustomerID);

        if (admindao.VerifyCustomerInfo(account)) {
            session.setAttribute("AdminCIDInput", CustomerID);
            mv.setViewName("redirect:/Admin/UpdateCustomerProfile");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Invalid Customer Information!");
            mv.setViewName("redirect:/Admin/VerifyInformation");
        }

        return mv;
    }

    @RequestMapping(value = "/Admin/UpdateCustomerProfile", method = RequestMethod.GET)
    public ModelAndView AdminUpdateProfile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") != null) { //page is displayed only if admin is logged on and currently working with a customer
            mv.setViewName("AdminUpdateProfile");
        } else { //redirect because admin currently does not have permission to access this page
            mv.setViewName("redirect:/Admin/Login");
        }
        return mv;
    }

    @RequestMapping(value = "/Admin/UpdateCustomerProfile", method = RequestMethod.POST)
    public ModelAndView AdminUpdateProfileControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String CustomerID = (String) session.getAttribute("AdminCIDInput");
        String NewStreet = request.getParameter("Street");
        String NewCity = request.getParameter("City");
        String NewState = request.getParameter("State");
        String NewZip = request.getParameter("Zip");
        String NewPhone = request.getParameter("Phone");
        String NewEmail = request.getParameter("Email");

        CustomerDAO customerdao = new CustomerDAO();
        Customer customer = new Customer();
        customer.setCustomerID(CustomerID);

        String prompt = "";
        if (!NewStreet.equals("") && !NewCity.equals("") && !NewState.equals("") && !NewZip.equals("")) { // update address
            if (customerdao.updateAddress(customer, NewStreet, NewCity, NewState, NewZip)) {
                prompt += "Customer address was updated successfully! ";
            } else {
                prompt += "Customer address was not updated due to an error. ";
            }
        }

        if (!NewPhone.equals("")) { // update phone
            if (customerdao.updatePhone(customer, NewPhone)) {
                prompt += "Customer phone was updated successfully! ";
            } else {
                prompt += "Customer phone was not updated due to an error. ";
            }
        }

        if (!NewEmail.equals("")) { //  update email
            if (customerdao.updateEmail(customer, NewEmail)) {
                prompt += "Customer email was updated successfully! ";
            } else {
                prompt += "Customer email was not updated due to an error. ";
            }
        }
        mv.setViewName("redirect:/Admin/UpdateCustomerProfile");
        redirectAttributes.addFlashAttribute("message", prompt);
        return mv;
    }

    @RequestMapping(value = "/Admin/UpdateCustomerEzTag", method = RequestMethod.GET)
    public ModelAndView AdminUpdateEzTag(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") != null) { //page is displayed only if admin is logged on and currently working with a customer
            mv.setViewName("AdminUpdateTag");
        } else { //redirect because admin currently does not have permission to access this page
            mv.setViewName("redirect:/Admin/Login");
        }
        return mv;
    }

    @RequestMapping(value = "/Admin/UpdateCustomerEzTag", method = RequestMethod.POST)
    public ModelAndView AdminUpdateEzTagControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String CustomerID = (String) session.getAttribute("AdminCIDInput");
        String TagCode = request.getParameter("TagCode");
        String NewTagType = request.getParameter("NewTagType");

        //check tag
        AdminDAO admindao = new AdminDAO();

        EzTagDAO eztagdao = new EzTagDAO();
        EzTag eztag = new EzTag();
        eztag.setCustomerID(CustomerID);
        eztag.setTagCode(TagCode);

        if (admindao.checkCustomerTag(eztag)) { //tag belongs to customer
            if (eztagdao.updateTagType(eztag, NewTagType)) {
                redirectAttributes.addFlashAttribute("message", "Tag type was updated successfully");
            }
        } else { //invalid tag
            redirectAttributes.addFlashAttribute("message", "Error: Invalid tag code.");
        }

        mv.setViewName("redirect:/Admin/UpdateCustomerEzTag");
        return mv;
    }

    @RequestMapping(value = "/Admin/DeleteAccount", method = RequestMethod.GET)
    public ModelAndView AdminDeleteAccount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") != null) { //page is displayed only if admin is logged on and currently working with a customer
            mv.setViewName("AdminDeleteAccount");
        } else { //redirect because admin currently does not have permission to access this page
            mv.setViewName("redirect:/Admin/Login");
        }
        return mv;
    }

    @RequestMapping(value = "/Admin/DeleteAccount", method = RequestMethod.POST)
    public ModelAndView AdminDeleteAccountControl(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String CustomerID = (String) session.getAttribute("AdminCIDInput");

        CustomerDAO customerdao = new CustomerDAO();
        Customer customer = customerdao.getCustomerInformation(CustomerID);

        float balance = customer.getBalance();
        if (balance < 0) { //balance must not be negative to delete account
            redirectAttributes.addFlashAttribute("message", "Unable to delete account because customer has an negative balance. Please let the customer know they must pay the negative balance before requesting for their account to be deleted.");
            mv.setViewName("redirect:/Admin/DeleteAccount");
        } else {
            if (customerdao.deleteCustomer(customer)) {
                session.setAttribute("AdminCIDInput", null); //after finish with assisting customer, make it null.
                redirectAttributes.addFlashAttribute("message", "Account Deleted Successfully! Please let the customer know that the leftover funds will be delivered via mail.");
                mv.setViewName("redirect:/Admin/VerifyInformation");
            } else {
                redirectAttributes.addFlashAttribute("message", "Unable to delete account, please contact the database admin to resolve this issue.");
                mv.setViewName("redirect:/Admin/DeleteAccount");
            }
        }

        return mv;
    }

    @RequestMapping(value = "/Admin/Finish", method = RequestMethod.GET)
    public ModelAndView FinishUpdates(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        session.setAttribute("AdminCIDInput", null); //after finish with assisting customer, make it null.
        mv.setViewName("redirect:/Admin/VerifyInformation");
        redirectAttributes.addFlashAttribute("message", "Previous customer information is cleared.");
        return mv;
    }

}
