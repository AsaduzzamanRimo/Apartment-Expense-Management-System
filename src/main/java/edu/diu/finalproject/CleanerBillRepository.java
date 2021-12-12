package edu.diu.finalproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleanerBillRepository extends CrudRepository<CleanerBill, Long>  {
	
	List <CleanerBill> findByCleanerBillId(int cleanerBillId);
	
	CleanerBill findById(long Id);

}
