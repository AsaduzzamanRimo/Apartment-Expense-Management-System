package edu.diu.finalproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class TransactionController {
	
	
	@Autowired
	private TransactionService service;
	
	// handler methods...
			@RequestMapping("/transaction")
			public String viewHomePage(Model model) {
				List<Transaction> listTransaction = service.listAll();
				model.addAttribute("listTransaction" , listTransaction);
				return "transaction_index";
				
				
			}
			
			@RequestMapping("/newTransaction")
			public String showNewTransactionPage(Model model) {
				
				Transaction transaction = new Transaction();
				model.addAttribute("transaction" , transaction);
				return "new_transaction";
				
			}
			
			@RequestMapping(value = "/saveTransaction" , method = RequestMethod.POST)
			public String saveTransaction(@ModelAttribute("transaction") Transaction transaction,Model model) {
				
				service.save(transaction);
				List<Transaction> listTransaction = service.listAll();
				model.addAttribute("listTransaction" , listTransaction);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateTransaction" , method = RequestMethod.POST)
			public String updateTransaction(@ModelAttribute("transaction") Transaction transaction,Model model) {
				
				Transaction t = service.get(transaction.gettId());
				t.settTime(transaction.gettTime());
				service.save(t);
				List<Transaction> listTransaction = service.listAll();
				model.addAttribute("listTransaction" , listTransaction);
				return "redirect:/";
			}
			
			@RequestMapping("/editTransaction/{id}")
					public ModelAndView showEditTransactionPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_transaction");
						Transaction transaction = service.get(id);
						mav.addObject("transaction", transaction);
						return mav;
						
						
					}
			@RequestMapping("/deleteTransaction/{id}")
			public String deleteTransaction(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";

			}

}
