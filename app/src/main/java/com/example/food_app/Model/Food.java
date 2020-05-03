package com.example.food_app.Model;

public class Food {
    private String name;
    private String image;
    private String price;
    private String veg;
    private String category;

    public Food() {
    }

    public Food(String name, String image, String price, String veg,String category) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.veg = veg;
        this.category=category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVeg() {
        return veg;
    }

    public void setVeg(String veg) {
        this.veg = veg;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



}

