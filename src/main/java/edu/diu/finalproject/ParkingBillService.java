package edu.diu.finalproject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ParkingBillService {
	
	@Autowired
	private ParkingBillRepository repo;
	
	public List<ParkingBill> listAll(){
		
		return (List<ParkingBill>) repo.findAll();
	}
	public void save(ParkingBill parkingBill) {
		
		repo.save(parkingBill);
	}
	
	public ParkingBill get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
