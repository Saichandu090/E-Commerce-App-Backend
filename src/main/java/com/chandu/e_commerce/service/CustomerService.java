package com.chandu.e_commerce.service;

import com.chandu.e_commerce.requestdto.CustomerRequestDTO;
import com.chandu.e_commerce.requestdto.LoginRequestDTO;
import com.chandu.e_commerce.responsedto.JSONResponseDTO;

public interface CustomerService
{
    JSONResponseDTO registerCustomer(CustomerRequestDTO requestDTO);

    JSONResponseDTO loginCustomer(LoginRequestDTO loginRequestDTO);
}
