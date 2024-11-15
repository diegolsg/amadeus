package com.amadeus.horas_extras.adapter.daos.jpa;

import com.amadeus.horas_extras.adapter.daos.entity.Employ;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Optional;

public interface EmployJpaRepository extends JpaRepository<Employ,String> {
    Optional<Employ> findByDocument(String documento);

}
