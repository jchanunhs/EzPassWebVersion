package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RemoveVehicleControl{

    @RequestMapping(value = "/RemoveVehicleControl", method = RequestMethod.POST)
    public ModelAndView RemoveVehicle(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession(false);
        String CID = (String) session.getAttribute("CID");
        String license = request.getParameter("LicensePlateNumber");
        Vehicle vehicle = new Vehicle(CID, license);
        mv.setViewName("redirect:/RemoveVehicle");
        if (vehicle.removeVehicle()) { //attempt to remove vehicle
            redirectAttributes.addFlashAttribute("message", "Vehicle removed successfully!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Vehicle removed failed because the license plate entered is invalid!");
        }
        return mv;
    }

}
