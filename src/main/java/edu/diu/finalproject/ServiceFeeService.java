package edu.diu.finalproject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceFeeService {
	
	@Autowired
	private ServiceFeeRepository repo;
	
	public List<ServiceFee> listAll(){
		
		return (List<ServiceFee>) repo.findAll();
	}
	public void save(ServiceFee serviceFee) {
		
		repo.save(serviceFee);
	}
	
	public ServiceFee get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
