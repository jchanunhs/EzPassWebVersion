package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EzTag;
import model.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddVehicleControl{

@RequestMapping(value = "/AddVehicleControl", method = RequestMethod.POST)
    public ModelAndView AddVehicle(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
       HttpSession session = request.getSession(false);
        String CID = (String) session.getAttribute("CID");
        String license = request.getParameter("LicensePlateNumber");
        String make = request.getParameter("Make");
        String model = request.getParameter("Model");
        String year = request.getParameter("Year");
        String color = request.getParameter("Color");
        String tagcode = request.getParameter("TagCode");
        Vehicle vehicle = new Vehicle(license, make, model, year, color, tagcode, CID);
        EzTag tag = new EzTag(tagcode, CID);
        mv.setViewName("redirect:/AddVehicle");
        if (tag.checkTag()) { //check if CID owns this tag
            if (vehicle.addVehicle()) { //attempt to add vehicle to db
                redirectAttributes.addFlashAttribute("message", "Vehicle was added successfully!");
            }
            else{ //vehicle fails to add to db
                redirectAttributes.addFlashAttribute("message", "Error: Add vehicle failed! Vehicle already exist in our database!");
            }
        }
        else{ //invalid tagcode
            redirectAttributes.addFlashAttribute("message", "Error: Add vehicle failed! Tag code is invalid!");
        }
        return mv;
    }
    
}