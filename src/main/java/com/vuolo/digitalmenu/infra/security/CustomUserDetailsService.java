package com.vuolo.digitalmenu.infra.security;

import com.vuolo.digitalmenu.domain.entities.Restaurant;
import com.vuolo.digitalmenu.domain.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Restaurant restaurant = this.restaurantRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Restaurant not found"));
        return new org.springframework.security.core.userdetails.User(restaurant.getEmail(), restaurant.getPassword(),
                new ArrayList<>());
    }
}
