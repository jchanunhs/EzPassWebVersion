package com.example.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.example.model.EzTag;
import com.example.model.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VehicleController {

    @RequestMapping("/Vehicle")
    public ModelAndView Vehicle(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        if (session.getAttribute("Username") == null) {  //check if user has logged in successfully
            mv.setViewName("redirect:/index");
        } else if (session.getAttribute("Username") != null && session.getAttribute("CID") == null) { //check if user logged in but needs to create profile
            mv.setViewName("redirect:/CreateProfile");
        } else {
            mv.setViewName("Vehicle");
            Vehicle vehicle = new Vehicle((String) session.getAttribute("CID"));
            mv.addObject("vehicle_list", vehicle.getVehicles());
        }
        return mv;
    }

    @RequestMapping(value = "/AddVehicleControl", method = RequestMethod.POST)
    public ModelAndView AddVehicle(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String CID = (String) session.getAttribute("CID");
        String license = request.getParameter("LicensePlateNumber");
        String make = request.getParameter("Make");
        String model = request.getParameter("Model");
        String year = request.getParameter("Year");
        String color = request.getParameter("Color");
        String tagcode = request.getParameter("TagCode");
        Vehicle vehicle = new Vehicle(license, make, model, year, color, tagcode, CID);
        EzTag tag = new EzTag(tagcode, CID);
        mv.setViewName("redirect:/Vehicle#tab-2");
        if (tag.checkTag()) { //check if CID owns this tag
            if (vehicle.addVehicle()) { //attempt to add vehicle to db
                redirectAttributes.addFlashAttribute("message", "Vehicle was added successfully!");
            } else { //vehicle fails to add to db
                redirectAttributes.addFlashAttribute("message", "Error: Add vehicle failed! Vehicle already exist in our database!");
            }
        } else { //invalid tagcode
            redirectAttributes.addFlashAttribute("message", "Error: Add vehicle failed! Tag code is invalid!");
        }
        return mv;
    }

    @RequestMapping(value = "/RemoveVehicleControl", method = RequestMethod.POST)
    public ModelAndView RemoveVehicle(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String CID = (String) session.getAttribute("CID");
        String license = request.getParameter("LicensePlateNumber");
        Vehicle vehicle = new Vehicle(license, CID);
        mv.setViewName("redirect:/Vehicle#tab-3");
        if (vehicle.removeVehicle()) { //attempt to remove vehicle
            redirectAttributes.addFlashAttribute("message", "Vehicle removed successfully!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Vehicle removed failed because the license plate entered is invalid!");
        }
        return mv;
    }

}
