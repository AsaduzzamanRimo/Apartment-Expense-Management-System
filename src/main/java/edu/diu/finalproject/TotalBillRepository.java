package edu.diu.finalproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalBillRepository extends CrudRepository<TotalBill, Long> {
	
	List <TotalBill> findByBillNumber(int billNumber);
	TotalBill findById(long Id);


}
