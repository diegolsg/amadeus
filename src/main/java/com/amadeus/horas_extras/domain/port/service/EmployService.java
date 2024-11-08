package com.amadeus.horas_extras.domain.port.service;


import com.amadeus.horas_extras.adapter.daos.repositoryImp.EmployRepositoryImp;
import com.amadeus.horas_extras.domain.model.EmployModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployService {
    private EmployRepositoryImp repository;

    @Autowired
    public EmployService(EmployRepositoryImp repository) {
        this.repository = repository;
    }

    public List<EmployModel> getEmployes() {
        return repository.getEmployes();
    }

    public EmployModel saveEmploy(EmployModel Employ) {
        return repository.saveEmploy(Employ);
    }

    public EmployModel updateEmploy(EmployModel employModel) {
        return repository.updateEmploy(employModel);
    }

    public void deleteEmploy(String document) {
        repository.deleteEmploy(document);
    }

    public Optional<EmployModel> findByDocument(String document) {
        return repository.findByDocument(document);
    }
}
