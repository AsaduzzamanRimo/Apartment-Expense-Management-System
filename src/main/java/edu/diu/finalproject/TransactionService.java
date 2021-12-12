package edu.diu.finalproject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransactionService {
	
	@Autowired
	private TransactionRepository repo;
public List<Transaction> listAll(){
		
		return (List<Transaction>) repo.findAll();
	}
	public void save(Transaction transaction) {
		
		repo.save(transaction);
	}
	
	public Transaction get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
