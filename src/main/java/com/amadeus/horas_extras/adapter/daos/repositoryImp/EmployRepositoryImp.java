package com.amadeus.horas_extras.adapter.daos.repositoryImp;

import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.adapter.daos.jpa.EmployJpaRepository;
import com.amadeus.horas_extras.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployRepositoryImp implements EmployRepository {

    private EmployJpaRepository employJpaRepository;

    @Autowired
    public EmployRepositoryImp(EmployJpaRepository employJpaRepository) {
        this.employJpaRepository = employJpaRepository;
    }

    @Override
    public Employ save(Employ employ) {
        return employJpaRepository.save(employ);

    }

    @Override
    public void delete(String document) {
        Employ employ = employJpaRepository.findByDocument(document);
        if (employ != null) {
            employJpaRepository.delete(employ);
        }
    }

    @Override
    public Object update(String document) {
        return null;
    }

    @Override
    public List<Employ> getEmployees() {
        return employJpaRepository.findAll();
    }

    @Override
    public Employ getEmploy(String document) {
        return employJpaRepository.findByDocument(document);
    }
}
