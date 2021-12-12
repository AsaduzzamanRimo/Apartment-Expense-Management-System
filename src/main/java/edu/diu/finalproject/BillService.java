package edu.diu.finalproject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class BillService {
	
	@Autowired
	private BillRepository repo;
	
	public List<Bill> listAll(){
		
		return (List<Bill>) repo.findAll();
	}
	public void save(Bill bill) {
		
		repo.save(bill);
	}
	
	public Bill get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
