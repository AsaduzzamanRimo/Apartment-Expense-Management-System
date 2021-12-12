package edu.diu.finalproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long>{
	
	List <Bill> findByBillName(String billName);
	
	Bill findById(long Id);

}
