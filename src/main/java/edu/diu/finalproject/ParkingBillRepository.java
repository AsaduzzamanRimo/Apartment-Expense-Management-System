package edu.diu.finalproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingBillRepository extends CrudRepository<ParkingBill, Long> {
	
	List <ParkingBill> findByParkingBillId(int parkingBillId);
	
	ParkingBill findById(long Id);

}
