package edu.diu.finalproject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceFeeRepository extends CrudRepository<ServiceFee, Long> {
	
	List <ServiceFee> findByServiceFeeId(int serviceFeeId);
	
	ServiceFee findById(long Id);

}
