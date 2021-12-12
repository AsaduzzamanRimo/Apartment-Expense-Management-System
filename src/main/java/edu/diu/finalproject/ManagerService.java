package edu.diu.finalproject;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ManagerService {
	
	@Autowired
	private ManagerRepository repo;
	public List<Manager> listAll(){
		
		return (List<Manager>) repo.findAll();
	}
	public void save(Manager manager) {
		
		repo.save(manager);
	}
	
	public Manager get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
