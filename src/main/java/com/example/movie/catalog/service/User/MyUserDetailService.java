//package com.example.movie.catalog.service.User;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
////        return new MyUserDetails(s);
//        Optional<User> user = userRepository.findByUserName(s);
//
//        user.orElseThrow(()-> new UsernameNotFoundException("no such user: " + s));
//
//        return user.map(MyUserDetails::new).get();
//    }
//}
