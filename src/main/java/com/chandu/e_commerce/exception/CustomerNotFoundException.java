package com.chandu.e_commerce.exception;

public class CustomerNotFoundException extends RuntimeException
{
  public CustomerNotFoundException(String message)
  {
    super(message);
  }
}
