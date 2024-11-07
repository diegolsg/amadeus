package com.amadeus.horas_extras.domain.port.repository;


import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import com.amadeus.horas_extras.domain.model.EmployModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployRepository {

    List<EmployModel> getEmployes();

    EmployModel saveEmploy(EmployModel Employ);

    EmployModel updateEmploy(EmployModel Employ);

    void deleteEmploy(Long id);

    Optional<EmployModel> findByDocument(String documento);
}

