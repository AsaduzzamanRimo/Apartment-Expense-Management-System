package com.epam.apartmentbooking.service.impl;

import com.epam.apartmentbooking.dao.ApartmentDAO;
import com.epam.apartmentbooking.domain.Apartment;
import com.epam.apartmentbooking.domain.ApartmentCriteria;
import com.epam.apartmentbooking.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("apartmentService")
public class ApartmentServiceImpl implements ApartmentService {
    @Autowired
    @Qualifier("apartmentDAO")
    private ApartmentDAO apartmentDAO;

    @Override
    public List<Apartment> findAllAvailableApartments() {
        return apartmentDAO.findAllAvailableApartments();
    }

    @Override
    public List<Apartment> findAllApartments() {
        return apartmentDAO.findAllApartments();
    }

    @Override
    public Apartment findEntityById(Long id) {
        return apartmentDAO.findEntityById(id);
    }

    @Override
    public List<Apartment> findAllApartmentsByCriteria(ApartmentCriteria criteria) {
        return apartmentDAO.findAllApartmentsByCriteria(criteria);
    }

    @Override
    public boolean remove(Long id) {
        return apartmentDAO.remove(id);
    }

    @Override
    public boolean create(Apartment apartment) {
        return apartmentDAO.create(apartment);
    }

    @Override
    public boolean update(Apartment apartment) {
        return apartmentDAO.update(apartment);
    }
}
