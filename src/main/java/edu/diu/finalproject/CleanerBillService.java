package edu.diu.finalproject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CleanerBillService {
	
	@Autowired
	private CleanerBillRepository repo;
	
	public List<CleanerBill> listAll(){
		
		return (List<CleanerBill>) repo.findAll();
	}
	public void save(CleanerBill cleanerBill) {
		
		repo.save(cleanerBill);
	}
	
	public CleanerBill get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
