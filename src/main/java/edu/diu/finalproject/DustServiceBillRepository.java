package edu.diu.finalproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DustServiceBillRepository extends CrudRepository<DustServiceBill, Long> {
	
	List <DustServiceBill> findByDustServiceBillId(int dustServiceBillId);
	
	DustServiceBill findById(long Id);

}
