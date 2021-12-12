package edu.diu.finalproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommonCurrentBillRepository extends CrudRepository<CommonCurrentBill, Long>{
	
	List <CommonCurrentBill> findByCommonCurrentBillId(int commonCurrentBillId);
	
	CommonCurrentBill findById(long Id);

}
