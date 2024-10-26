package com.amadeus.horas_extras.repository;

import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import lombok.Locked;

import java.util.List;

public interface EmployRepository {
    Employ save(Employ employ);
    void delete(String document);
    Object update(String document);
    List<Employ> getEmployees();
    Employ getEmploy(String document);
}
