package com.chandu.e_commerce.controller;

import com.chandu.e_commerce.responsedto.JSONResponseDTO;
import com.chandu.e_commerce.requestdto.ProductRequestDTO;
import com.chandu.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<JSONResponseDTO> addProduct(@RequestBody ProductRequestDTO productRequestDTO)
    {
        JSONResponseDTO responseDTO=productService.addProduct(productRequestDTO);
        return  new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<JSONResponseDTO> getProduct(@PathVariable Long id)
    {
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<JSONResponseDTO> getAllProducts()
    {
        return new ResponseEntity<>(productService.findAllProducts(),HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<JSONResponseDTO> updateProduct(@PathVariable Long id,@RequestBody ProductRequestDTO requestDTO)
    {
        return new ResponseEntity<>(productService.updateProduct(id,requestDTO),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<JSONResponseDTO> deleteProduct(@PathVariable Long id)
    {
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.ACCEPTED);
    }
}
