package com.amadeus.horas_extras.adapter.daos.repositoryImp;

import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.adapter.daos.jpa.EmployJpaRepository;
import com.amadeus.horas_extras.adapter.daos.mapper.EmployMappers;
import com.amadeus.horas_extras.domain.model.EmployModel;

import com.amadeus.horas_extras.domain.port.repository.EmployRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployRepositoryImp implements EmployRepository {
    private EmployMappers mappers;
    private EmployJpaRepository employJpa;

    @Autowired
    public EmployRepositoryImp(EmployMappers mappers, EmployJpaRepository employJpa) {
        this.mappers = mappers;
        this.employJpa = employJpa;
    }

    @Override
    public List<EmployModel> getEmployes() {
        List<Employ> EmployEntities = employJpa.findAll();
        return EmployEntities.stream()
                .map(mappers::fromEmploy)
                .collect(Collectors.toList());
    }

    @Override
    public EmployModel saveEmploy(EmployModel Employ) {
        Employ EmployEntity = mappers.toEmployModels(Employ);
        Employ savedEntity = employJpa.save(EmployEntity);
        return mappers.fromEmploy(savedEntity);
    }

    @Override
    public EmployModel updateEmploy(EmployModel employModel) {
        if (employModel == null) {
            throw new IllegalArgumentException("Employee model cannot be null");
        }

        String document = employModel.getDocument();
        if (!employJpa.findByDocument(document).isPresent()) {
            throw new EntityNotFoundException("Employee not found with document: " + document);
        }

        Employ employEntity = mappers.toEmployModels(employModel);
        Employ updatedEntity = employJpa.save(employEntity);
        return mappers.fromEmploy(updatedEntity);
    }


    @Override
    public void deleteEmploy(String document) {
        Employ findByDocument = employJpa.findByDocument(document)
                .orElseThrow(() -> new EntityNotFoundException("Employ not found with id: " + document));
        employJpa.delete(findByDocument);
    }


    @Override
    public Optional<EmployModel> findByDocument(String document) {
        if (document == null || document.trim().isEmpty()) {
            throw new IllegalArgumentException("Document number cannot be null or empty");
        }

        return employJpa.findByDocument(document)
                .map(mappers::fromEmploy);
    }
}

