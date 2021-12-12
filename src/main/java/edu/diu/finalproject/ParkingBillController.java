package edu.diu.finalproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParkingBillController {
	
	
	@Autowired
	private ParkingBillService service;
	
	// handler methods...
				@RequestMapping("/parkingBill")
				public String viewHomePage(Model model) {
					List<ParkingBill> listParkingBill = service.listAll();
					model.addAttribute("listParkingBill" , listParkingBill);
					return "parkingBill_index";
					
					
				}
				
				@RequestMapping("/newparkingBill")
				public String showNewParkingBillPage(Model model) {
					
					ParkingBill parkingBill = new ParkingBill();
					model.addAttribute("parkingBill" , parkingBill);
					return "new_parkingBill";
					
				}
				
				@RequestMapping(value = "/saveParkingBill" , method = RequestMethod.POST)
				public String saveParkingBill(@ModelAttribute("parkingBill") ParkingBill parkingBill,Model model) {
					
					service.save(parkingBill);
					List<ParkingBill> listParkingBill = service.listAll();
					model.addAttribute("listParkingBill" , listParkingBill);
					return "redirect:/";
					
					
				}
				
				@RequestMapping(value = "/updateParkingBill" , method = RequestMethod.POST)
				public String updateBill(@ModelAttribute("ParkingBill") ParkingBill parkingBill,Model model) {
					
					ParkingBill pb = service.get(parkingBill.getParkingBillId());
					pb.setParkingBillId(parkingBill.getParkingBillId());//.setBillTime(parkingBill.getBillTime());
					service.save(pb);
					List<ParkingBill> listParkingBill = service.listAll();
					model.addAttribute("listParkingBill" , listParkingBill);
					return "redirect:/";
				}
				
				@RequestMapping("/editParkingBill/{id}")
						public ModelAndView showEditParkingBillPage(@PathVariable(name = "id") int id) {
							ModelAndView mav = new ModelAndView("edit_ParkingBill");
							ParkingBill parkingBill = service.get(id);
							mav.addObject("parkingBill", parkingBill);
							return mav;
							
							
						}
				@RequestMapping("/deleteParkingBill/{id}")
				public String deleteParkingBill(@PathVariable(name = "id") int id) {
					service.delete(id);
					return "redirect:/";

				}

}
