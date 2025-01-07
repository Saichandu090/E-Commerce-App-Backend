package com.chandu.e_commerce.service.serviceimpl;

import com.chandu.e_commerce.exception.CustomerNotFoundException;
import com.chandu.e_commerce.model.Customer;
import com.chandu.e_commerce.model.UserPrinciple;
import com.chandu.e_commerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Customer customer=customerRepository.findByEmail(username).orElseThrow(()->new CustomerNotFoundException("Customer not found"));
        return new UserPrinciple(customer);
    }
}
