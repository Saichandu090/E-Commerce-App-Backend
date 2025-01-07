package com.chandu.e_commerce.service.serviceimpl;

import com.chandu.e_commerce.repository.CustomerRepository;
import com.chandu.e_commerce.requestdto.CustomerRequestDTO;
import com.chandu.e_commerce.requestdto.LoginRequestDTO;
import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import com.chandu.e_commerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public JSONResponseDTO registerCustomer(CustomerRequestDTO requestDTO)
    {
        return null;
    }

    @Override
    public JSONResponseDTO loginCustomer(LoginRequestDTO loginRequestDTO)
    {
        return null;
    }
}
