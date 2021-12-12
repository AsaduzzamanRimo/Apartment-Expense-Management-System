package edu.diu.finalproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiftBillRepository extends CrudRepository<LiftBill, Long> {
	
	List <LiftBill> findByLiftBillId(int liftBillId);
	LiftBill findById(long Id);

}
