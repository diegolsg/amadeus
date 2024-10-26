package com.amadeus.horas_extras.domain.port.service;

import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.adapter.daos.repositoryImp.EmployRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployService {

    private EmployRepositoryImp employRepository;

    @Autowired
    public EmployService(EmployRepositoryImp employRepository) {
        this.employRepository = employRepository;
    }

    public Employ save(Employ employ) {
        return employRepository.save(employ);

    }

    public void delete(String document) {
        employRepository.delete(document);
    }

    public Object update(String document) {
        return null;
    }

    public List<Employ> getEmployees() {
        return employRepository.getEmployees();
    }

    public Employ getEmploy(String document) {
        return employRepository.getEmploy(document);
    }
}

