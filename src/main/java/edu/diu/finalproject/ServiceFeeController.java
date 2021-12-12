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
public class ServiceFeeController {
	
	@Autowired
	private ServiceFeeService service;
	
	// handler methods...
				@RequestMapping("/serviceFee")
				public String viewHomePage(Model model) {
					List<ServiceFee> listServiceFee = service.listAll();
					model.addAttribute("listServiceFee" , listServiceFee);
					return "serviceFee_index";
					
					
				}
				
				@RequestMapping("/newserviceFee")
				public String showNewCommonCurrentBillPage(Model model) {
					
					ServiceFee serviceFee = new ServiceFee();
					model.addAttribute("serviceFee" , serviceFee);
					return "new_serviceFee";
					
				}
				
				@RequestMapping(value = "/saveServiceFee" , method = RequestMethod.POST)
				public String saveServiceFee(@ModelAttribute("serviceFee") ServiceFee serviceFee,Model model) {
					
					service.save(serviceFee);
					List<ServiceFee> listServiceFee = service.listAll();
					model.addAttribute("listServiceFee" , listServiceFee);
					return "redirect:/";
					
					
				}
				
				@RequestMapping(value = "/updateServiceFee" , method = RequestMethod.POST)
				public String updateBill(@ModelAttribute("ServiceFee") ServiceFee serviceFee,Model model) {
					
					ServiceFee sf = service.get(serviceFee.getServiceFeeId());
					sf.setServiceFeeId(serviceFee.getServiceFeeId());//.setBillTime(serviceFee.getBillTime());
					service.save(sf);
					List<ServiceFee> listServiceFee = service.listAll();
					model.addAttribute("listServiceFee" , listServiceFee);
					return "redirect:/";
				}
				
				@RequestMapping("/editServiceFee/{id}")
						public ModelAndView showEditServiceFeePage(@PathVariable(name = "id") int id) {
							ModelAndView mav = new ModelAndView("edit_ServiceFee");
							ServiceFee serviceFee = service.get(id);
							mav.addObject("serviceFee", serviceFee);
							return mav;
							
							
						}
				@RequestMapping("/deleteServiceFee/{id}")
				public String deleteServiceFee(@PathVariable(name = "id") int id) {
					service.delete(id);
					return "redirect:/";

				}

}
