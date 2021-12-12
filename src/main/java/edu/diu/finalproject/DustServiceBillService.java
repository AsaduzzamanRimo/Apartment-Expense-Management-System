package edu.diu.finalproject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DustServiceBillService {
	
	@Autowired
	private DustServiceBillRepository repo;
	
	public List<DustServiceBill> listAll(){
		
		return (List<DustServiceBill>) repo.findAll();
	}
	public void save(DustServiceBill dustServiceBill) {
		
		repo.save(dustServiceBill);
	}
	
	public DustServiceBill get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
