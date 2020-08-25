package com.example.control;

import com.example.dao.EzTagDAO;
import com.example.dao.VehicleDAO;
import com.example.entity.EzTag;
import com.example.entity.Vehicle;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VehicleController {
    
    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public ModelAndView Vehicle(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        if (Username != null && CustomerID != null) {  //check if user has logged in successfully and created profile
            VehicleDAO vehicledao = new VehicleDAO();
            ArrayList<Vehicle> vehiclelist = vehicledao.getAllCustomerVehicles(CustomerID);
            mv.addObject("vehiclelist", vehiclelist);
            mv.setViewName("Vehicle");
        } else { //user not authenticated, redirect to index page
            mv.setViewName("redirect:/index");
        }
        return mv;
    }
    
    @RequestMapping(value = "/addvehicle", method = RequestMethod.POST)
    public ModelAndView AddVehicle(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");
        
        String LicensePlateNumber = request.getParameter("LicensePlateNumber");
        String Make = request.getParameter("Make");
        String Model = request.getParameter("Model");
        String Year = request.getParameter("Year");
        String Color = request.getParameter("Color");
        String TagCode = request.getParameter("TagCode");
        
        //check tag
        EzTagDAO eztagdao = new EzTagDAO();
        EzTag eztag = new EzTag();
        eztag.setCustomerID(CustomerID);
        eztag.setTagCode(TagCode);
        
        //add vehicle
        VehicleDAO vehicledao = new VehicleDAO();
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlateNumber(LicensePlateNumber);
        vehicle.setMake(Make);
        vehicle.setModel(Model);
        vehicle.setYear(Year);
        vehicle.setColor(Color);
        vehicle.setTagCode(TagCode);
        vehicle.setCustomerID(CustomerID);
        
        if (eztagdao.checkTag(eztag)) { //check if eztag belongs to user
            if (vehicledao.addVehicle(vehicle)) { //attempt to add vehicle
                redirectAttributes.addFlashAttribute("message", "Vehicle was added successfully!");
            } else { //return false if vehicle already exist
                redirectAttributes.addFlashAttribute("message", "Error: Add vehicle failed! Vehicle already exist in our database!");
            }
        } else { //invalid tagcode
            redirectAttributes.addFlashAttribute("message", "Error: Add vehicle failed! Tag code is invalid!");
        }
        mv.setViewName("redirect:/vehicle#tab-2");
        return mv;
    }
    
    @RequestMapping(value = "/removevehicle", method = RequestMethod.GET)
    public ModelAndView RemoveVehicle(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String Username = (String) session.getAttribute("Username");
        String CustomerID = (String) session.getAttribute("CustomerID");

        String LicensePlateNumber = request.getParameter("LicensePlateNumber");
        VehicleDAO vehicledao = new VehicleDAO();
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlateNumber(LicensePlateNumber);
        vehicle.setCustomerID(CustomerID);
        if (vehicledao.removeVehicle(vehicle)) {
            redirectAttributes.addFlashAttribute("message", "Vehicle was removed successfully!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Error: Something went wrong when removing vehicle. If this occurs multiple times please contact help desk.");
        }
        mv.setViewName("redirect:/vehicle#tab-1");
        return mv;
    }

}
