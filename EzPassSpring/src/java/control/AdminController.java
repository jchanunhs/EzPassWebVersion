package control;

/*
If AdminID is null, admin is not logged in. //display admin login page
If AdminID is not null, admin is logged in. //display verify information page 
If AdminID is not null and AdminCIDInput is null, admin is logged in, but does not have a customer case.
If AdminID is not null and AdminCIDInput is not null, admin is logged in and has a case. //display update customer profile page
Each webpage will have restrictions based on whether the admin is logged in and is currently helping a customer.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Customer;
import model.EzTag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {

    @RequestMapping("/AdminLogin")
    public ModelAndView AdminLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") != null) {
            mv.setViewName("redirect:/Admin/UpdateCustomerProfile");
        } else if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") == null) {
            mv.setViewName("redirect:/Admin/VerifyInformation");
        } else {
            mv.setViewName("AdminLogin");
        }
        return mv;
    }

    @RequestMapping(value = "/AdminLoginControl", method = RequestMethod.POST)
    public ModelAndView AdminLoginControl(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        String AdminID = request.getParameter("AdminID");
        String Name = request.getParameter("Name");
        String Password = request.getParameter("Password");
        Admin admin = new Admin(AdminID, Name, Password);
        if (admin.login()) {
            session.setAttribute("AdminID", AdminID);
            mv.setViewName("redirect:/Admin/VerifyInformation");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Invalid Information!");
            mv.setViewName("redirect:/AdminLogin");
        }
        return mv;
    }

    @RequestMapping("/Admin/VerifyInformation")
    public ModelAndView AdminVerifyInformation(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") != null) {
            mv.setViewName("redirect:/Admin/UpdateCustomerProfile");
        } else if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") == null) {
            mv.setViewName("AdminVerify");
        } else {
            mv.setViewName("redirect:/AdminLogin");
        }
        return mv;
    }

    @RequestMapping(value = "/AdminVerificationInfoControl", method = RequestMethod.POST)
    public ModelAndView AdminVerificationInfoControl(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        String CustUsername = request.getParameter("CustUsername");
        String CID = request.getParameter("CustomerID");
        String AID = (String) session.getAttribute("AdminID");
        Admin admin = new Admin(AID);
        if (admin.VerifyCustomerInfo(CID, CustUsername)) {
            session.setAttribute("AdminCIDInput", CID);
            mv.setViewName("redirect:/Admin/UpdateCustomerProfile");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Invalid Customer Information!");
            mv.setViewName("redirect:/Admin/VerifyInformation");
        }
        return mv;
    }

    @RequestMapping("/Admin/UpdateCustomerProfile")
    public ModelAndView AdminUpdateProfile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") != null) {
            mv.setViewName("AdminUpdateProfile");
        } else if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") == null) {
            mv.setViewName("redirect:/Admin/VerifyInformation");
        } else {
            mv.setViewName("redirect:/AdminLogin");
        }
        return mv;
    }

    @RequestMapping(value = "/UpdateProfileControl", method = RequestMethod.POST)
    public ModelAndView AdminUpdateProfileControl(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        String CID = (String) session.getAttribute("AdminCIDInput");
        String Street = request.getParameter("Street");
        String City = request.getParameter("City");
        String State = request.getParameter("State");
        String Zip = request.getParameter("Zip");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");
        Customer cus = new Customer(CID);
        String prompt = "";
        if (!Street.equals("") && !City.equals("") && !State.equals("") && !Zip.equals("")) { // update address
            if (cus.updateAddress(Street, City, State, Zip)) {
                prompt += "Customer address was updated successfully! ";
            } else {
                prompt += "Customer address was not updated due to an error. ";
            }
        }

        if (!Phone.equals("")) { // update phone
            if (cus.updatePhone(Phone)) {
                prompt += "Customer phone was updated successfully! ";
            } else {
                prompt += "Customer phone was not updated due to an error. ";
            }
        }

        if (!Email.equals("")) { //  update email
            if (cus.updateEmail(Email)) {
                prompt += "Customer email was updated successfully! ";
            } else {
                prompt += "Customer email was not updated due to an error. ";
            }
        }
        mv.setViewName("redirect:/Admin/UpdateCustomerProfile");
        redirectAttributes.addFlashAttribute("message", prompt);
        return mv;
    }

    @RequestMapping("/Admin/UpdateCustomerEzTag")
    public ModelAndView AdminUpdateEzTag(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") != null) {
            mv.setViewName("AdminUpdateTag");
        } else if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") == null) {
            mv.setViewName("redirect:/Admin/VerifyInformation");
        } else {
            mv.setViewName("redirect:/AdminLogin");
        }
        return mv;
    }

    @RequestMapping(value = "/UpdateEzTagControl", method = RequestMethod.POST)
    public ModelAndView AdminUpdateEzTagControl(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        String CID = (String) session.getAttribute("AdminCIDInput");
        String OldTag = request.getParameter("OldTagCode");
        String NewTag = request.getParameter("NewTagCode");
        String NewTagType = request.getParameter("NewTagType");
        EzTag tag = new EzTag(OldTag, CID); //old tag and customer id
        if (tag.checkTag()) { //check if old tag matches customer id
            if (!NewTag.equals("") && !NewTagType.equals("")) { //if input for new tag code and tag type not empty, update both
                if (tag.updateTagCode(NewTag)) {
                    tag = new EzTag(NewTag, CID); //after updating tagcode, we need to use the new tagcode and update tag type
                    if (tag.updateTagType(NewTagType)) {
                        redirectAttributes.addFlashAttribute("message", "Tag code and tag type were updated successfully");
                    }
                } else {
                    redirectAttributes.addFlashAttribute("message", "Error: Unable to update TagCode. Please enter another TagCode.");
                }
            } else if (!NewTag.equals("") && NewTagType.equals("")) { //if input for new tagcode is not empty, but tag type is empty, update tagcode
                if (tag.updateTagCode(NewTag)) {
                    redirectAttributes.addFlashAttribute("message", "Tag code was updated successfully");
                }
            } else if (NewTag.equals("") && !NewTagType.equals("")) { //new tagcode is empty but new tag type is not empty, update tagtype
                if (tag.updateTagType(NewTagType)) {
                    redirectAttributes.addFlashAttribute("message", "Tag type was updated successfully");
                }
            }

        } else {
            redirectAttributes.addFlashAttribute("message", "Error: EzTag is invalid.");
        }
        mv.setViewName("redirect:/Admin/UpdateCustomerEzTag");
        return mv;
    }

    @RequestMapping("/Admin/DeleteAccount")
    public ModelAndView AdminDeleteAccount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") != null) {
            mv.setViewName("AdminDeleteAccount");
        } else if (session.getAttribute("AdminID") != null && session.getAttribute("AdminCIDInput") == null) {
            mv.setViewName("redirect:/Admin/VerifyInformation");
        } else {
            mv.setViewName("redirect:/AdminLogin");
        }
        return mv;
    }

    @RequestMapping(value = "/DeleteAccountControl", method = RequestMethod.POST)
    public ModelAndView AdminDeleteAccountControl(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        String CID = (String) session.getAttribute("AdminCIDInput");
        Customer cus = new Customer(CID);
        float bal = cus.getBalance();
        if (bal < 0) {
            redirectAttributes.addFlashAttribute("message", "Unable to delete account because customer has an invalid balance. Please let the customer know they must pay the negative balance before requesting for their account to be deleted.");
            mv.setViewName("redirect:/Admin/DeleteAccount");
        } else {
            if (cus.deleteCustomer()) {
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
    public ModelAndView FinishUpdates(HttpServletRequest request, RedirectAttributes redirectAttributes, ModelAndView mv) {
        HttpSession session = request.getSession();
        session.setAttribute("AdminCIDInput", null); //after finish with assisting customer, make it null.
        mv.setViewName("redirect:/Admin/VerifyInformation");
        redirectAttributes.addFlashAttribute("message", "Previous customer information is cleared.");
        return mv;
    }

}
