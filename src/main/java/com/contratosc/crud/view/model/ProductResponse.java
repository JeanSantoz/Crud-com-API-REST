package com.contratosc.crud.view.model;

public class ProductResponse {

    // #region Atributos
    private Integer id;
    private String name;
    //private String description;
    private Double price;
    private Integer quantity;
    // #endregion

    // #region Constructors
    public ProductResponse() {}

    public ProductResponse(Integer id, String name, Double price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    // #endregion

    // #region Getters e Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
    // #endregion
    
}