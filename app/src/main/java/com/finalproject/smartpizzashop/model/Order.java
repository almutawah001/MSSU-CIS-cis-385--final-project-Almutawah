package com.finalproject.smartpizzashop.model;
public class Order {
   private   String customerName;

   private String address;

   private   String servings;

   private   String  pizzaName;

   private   String   extraToppings;
    private String  crust;

    public Order() {
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public void setExtraToppings(String extraToppings) {
        this.extraToppings = extraToppings;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getServings() {
        return servings;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getExtraToppings() {
        return extraToppings;
    }

    public String getCrust() {
        return crust;
    }

    public String getSize() {
        return size;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public Order(String customerName, String address, String servings, String pizzaName, String extraToppings, String crust, String size, String ingredients, String contactNumber, String price, int id) {
        this.customerName = customerName;
        this.address = address;
        this.servings = servings;
        this.pizzaName = pizzaName;
        this.extraToppings = extraToppings;
        this.crust = crust;
        this.size = size;
        this.ingredients = ingredients;
        this.contactNumber = contactNumber;
        this.price = price;
        this.id = id;
    }

    String size;


    String ingredients;
    String contactNumber;
    String   price;
    int id;

}