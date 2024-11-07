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
    private EmployJpaRepository EmployJpa;

    @Autowired
    public EmployRepositoryImp(EmployMappers mappers, EmployJpaRepository employJpa) {
        this.mappers = mappers;
        EmployJpa = employJpa;
    }

    @Override
    public List<EmployModel> getEmployes() {
        List<Employ> EmployEntities = EmployJpa.findAll();
        return EmployEntities.stream()
                .map(mappers::fromEmploy)
                .collect(Collectors.toList());
    }

    @Override
    public EmployModel saveEmploy(EmployModel Employ) {
        Employ EmployEntity = mappers.toEmployModels(Employ);
        Employ savedEntity = EmployJpa.save(EmployEntity);
        return mappers.fromEmploy(savedEntity);
    }

    @Override
    public EmployModel updateEmploy(EmployModel Employ) {
//        if (EmployJpa.findByDocument((long) Employ.getDocument())) {
//            Employ EmployEntity = mappers.toEmployModels(Employ);
//            Employ updatedEntity = EmployJpa.save(EmployEntity);
//            return mappers.fromEmploy(updatedEntity);
//        }
//        throw new EntityNotFoundException("Employ not found with id: " + Employ.getDocument());
  }

    @Override
    public void deleteEmploy(Long document) {
        if (EmployJpa.existsById(document)) {
            EmployJpa.deleteById(document);
        } else {
            throw new EntityNotFoundException("Employ not found with id: " + document);
        }
    }

    @Override
    public Optional<EmployModel> findByDocument(String document) {
        return EmployJpa.findByDocument(())
                .map(mappers::fromEmploy)
                .orElseThrow(() -> new EntityNotFoundException("Employ not found with id: " + document));
    }
}

//    @Override
//    public List<EmployModel> getEmployes() {
//        return List.of();
//    }
//
//    @Override
//    public EmployModel saveEmploy(EmployModel Employ) {
//        return null;
//    }
//
//    @Override
//    public EmployModel updateEmploy(EmployModel Employ) {
//        return null;
//    }
//
//    @Override
//    public EmployModel getEmployById(Long document) {
//        return null;
//    }
//
//    @Override
//    public void deleteEmploy(Long document) {
//
//    }


