package edu.diu.finalproject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TotalBillService {
	
	@Autowired
	private TotalBillRepository repo;
	
public List<TotalBill> listAll(){
		
		return (List<TotalBill>) repo.findAll();
	}
	public void save(TotalBill totalBill) {
		
		repo.save(totalBill);
	}
	
	public TotalBill get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
