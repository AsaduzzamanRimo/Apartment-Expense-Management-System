package edu.diu.finalproject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CommonCurrentBillService {
	
	@Autowired
	private CommonCurrentBillRepository repo;
	public List<CommonCurrentBill> listAll(){
		
		return (List<CommonCurrentBill>) repo.findAll();
	}
	public void save(CommonCurrentBill commonCurrentBill) {
		
		repo.save(commonCurrentBill);
	}
	
	public CommonCurrentBill get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
