package com.example.java_labor_beadando.securityrole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByName(username)
                .orElseThrow(()->new UsernameNotFoundException("A "+username+" felhasználó nem létezik"));
        return new org.springframework.security.core.userdetails.User(user.getNév(),user.getJelszó(),getAuthorities(user));
    }
    private static Collection<? extends GrantedAuthority> getAuthorities(User user){
        String[] userRoles=user.getRoles().stream().map((role)->role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities= AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
}
