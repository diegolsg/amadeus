package com.amadeus.horas_extras.domain.port.service;

import com.amadeus.horas_extras.adapter.daos.entity.User;
import com.amadeus.horas_extras.adapter.daos.jpa.UserRepository;


public class UserService {

//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email) .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//    }
//
//    public User saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(Integer id) {
//        userRepository.deleteById(id);
//    }
//
//    public User updateUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public List<User> index() {
//        return userRepository.findAll();
//    }
//
//    public Optional<User> findUserById(int id) {
//        return userRepository.findById(id);
//    }
//
//    public Optional<User> findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public Optional<User> findUserByName(String name) {
//        return userRepository.findByName(name);
//    }
//
//    public Optional<User> findUserByCity(String city) {
//        return userRepository.findByCity(city);
//    }
//
//    public Optional<User> findUserByRole(String role) {
//        return userRepository.findByRole(role);
//    }
}
