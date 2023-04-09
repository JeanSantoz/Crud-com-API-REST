package com.contratosc.crud.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.contratosc.crud.services.ProductService;
import com.contratosc.crud.shared.ProductDTO;
import com.contratosc.crud.view.model.ProductResponse;
import com.contratosc.crud.view.model.ProductRequest;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){

        List<ProductDTO> products = productService.findAll();

        //Converte a lista de 
        List<ProductResponse> responses =  products.stream()
        .map(product -> new ModelMapper().map(product, ProductResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }    


    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductResponse>> findById(@PathVariable Integer id){

        Optional<ProductDTO> productDTO = productService.findById(id);
        ProductResponse response = new ModelMapper().map(productDTO.get(), ProductResponse.class);
        return new ResponseEntity<>(Optional.of(response), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest){

        ProductDTO productDTO = new ModelMapper().map(productRequest, ProductDTO.class);
        productDTO = productService.addProduct(productDTO);
        return new ResponseEntity<>(new ModelMapper().map(productDTO, ProductResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Integer id, @RequestBody ProductRequest productRequest){

        ProductDTO productDTO = new ModelMapper().map(productRequest, ProductDTO.class); 
        productDTO = productService.updateProduct(id, productDTO);
        return new ResponseEntity<>(new ModelMapper().map(productDTO, ProductResponse.class), HttpStatus.OK);
    }

}
