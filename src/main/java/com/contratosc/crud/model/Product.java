package com.contratosc.crud.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    
    //#region Atributos 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name, description;
    private Double price;
    private Integer quantity;
    //#endregion

    //#region Constructors
    public Product() {}

    public String getName() {
        return name;
    }
    //#endregion

    //#region Getters e Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    //#endregion

    
    

}
