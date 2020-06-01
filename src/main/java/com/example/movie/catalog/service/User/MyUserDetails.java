//package com.example.movie.catalog.service.User;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class MyUserDetails implements UserDetails {
//    private String userName;
//    private boolean active;
//    private String password;
//    private List<GrantedAuthority> authorities;
//
//
//
//    public MyUserDetails(String userName) {
//        this.userName = userName;
//    }
//
//    public MyUserDetails(User user) {
//        this.userName = user.getUserName();
//        this.active = user.isActive();
//        this.password = user.getPassword();
//        this.authorities = Arrays.stream(user.getRoles().split(","))
//                            .map(SimpleGrantedAuthority::new )
//                            .collect(Collectors.toList());
//    }
//
//    public MyUserDetails() {
//
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return active;
//    }
//}
