package edu.diu.finalproject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class LiftBillService {
	
	@Autowired
	private LiftBillRepository repo;
	
	public List<LiftBill> listAll(){
		
		return (List<LiftBill>) repo.findAll();
	}
	public void save(LiftBill liftBill) {
		
		repo.save(liftBill);
	}
	
	public LiftBill get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
