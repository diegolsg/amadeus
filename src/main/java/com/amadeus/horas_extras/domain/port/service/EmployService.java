package com.amadeus.horas_extras.domain.port.service;


import com.amadeus.horas_extras.adapter.daos.entity.OurUsers;
import com.amadeus.horas_extras.adapter.daos.repositoryImp.EmployRepositoryImp;
import com.amadeus.horas_extras.domain.model.EmployModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployService implements UserDetailsService {

    private final EmployRepositoryImp repository;

    @Autowired
    public EmployService(EmployRepositoryImp repository) {
        this.repository = repository;
    }

    public List<EmployModel> getEmployes() {
        return repository.getEmployes();
    }

    public EmployModel saveEmploy(EmployModel employ) {
        return repository.saveEmploy(employ);
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

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
// Cambia "findByDocument" a "findByEmail" si el email es el identificador único
        Optional<EmployModel> userOptional = repository.findByDocument(username);
        return (UserDetails) userOptional.orElseThrow(() -> newUsernameNotFoundException("User not found"));
    }

    private RuntimeException newUsernameNotFoundException(String userNotFound) {
        return null;
    }
}
