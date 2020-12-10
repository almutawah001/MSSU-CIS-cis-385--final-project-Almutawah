package com.finalproject.smartpizzashop.model;

public class Pizza{
    private String title;

   private   String servings;

    private String total_time;



    private String   toppings;
    private String  crust;

   private String size;


   private String ingredients;
  private  String topping;
  private   String   price;
   private int id;


    public void setServings(String servings) {
        this.servings = servings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pizza(String title, String ingredients, String price , String serving, String topping, String size, String crust , String time  ) {

        this.title = title;

        this.servings = serving;

        this.total_time = time;


        this.ingredients = ingredients;


        this.topping = topping;
        this.crust = crust;
        this.size = size;


        this.price = price;
    }

    public Pizza() {

    }


    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getServings() {
        return servings;
    }


    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }



    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }




    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}