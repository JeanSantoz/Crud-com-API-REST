package com.contratosc.crud.services;

//#region imports
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contratosc.crud.model.Product;
import com.contratosc.crud.repository.ProductRepository;
import com.contratosc.crud.shared.ProductDTO;
//#endregion

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public List<ProductDTO> findAll(){
        List<Product>  products = productRepository.findAll();

        return products.stream()
        .map(product -> new ModelMapper().map(product, ProductDTO.class))
        .collect(Collectors.toList());
    }

    public Optional<ProductDTO> findById(Integer id){

        //Busca Produto pelo ID
        Optional<Product> product = productRepository.findById(id);

        //Exception Caso o produto não exista

        // Converte o Product em ProductDTO
        ProductDTO productDTO = new ModelMapper().map(product.get(), ProductDTO.class);

        //Retorna Optional de ProductDTO
        return Optional.of(productDTO);
    }

    public ProductDTO addProduct(ProductDTO productDTO){

        productDTO.setId(null);

        Product product = new ModelMapper().map(productDTO, Product.class);

        product = productRepository.save(product);

        productDTO.setId(product.getId());

        return productDTO;
    }

    public void deleteProduct(Integer id){

        Optional<Product> product = productRepository.findById(id);

        if(product.isEmpty()){
            System.out.println("Produto não encontrado");
        }
        else{
            productRepository.deleteById(id);
        }

        
    }

    public ProductDTO updateProduct(Integer id, ProductDTO productDTO){

        productDTO.setId(id);

        Product product = new ModelMapper().map(productDTO, Product.class);
        productRepository.save(product);

        return productDTO;
    }

}