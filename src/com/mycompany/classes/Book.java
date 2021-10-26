package com.mycompany.classes;

public class Book {

    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAuthorNames() {
        String authNames = "";
        if (authors == null || authors.length < 1) {
            return "";
        }
        authNames = authors[0].getName();
        for (int i = 1; i < authors.length; i++) {
            authNames += ", " + authors[i].getName();
        }
        return authNames;
    }

    @Override
    public String toString() {
        String result;
        result = "Book[name=" + name + ",authors={";
        if (authors == null || authors.length < 1) {
            result += "}";
        }
        else {
            result += "Author[name=" + authors[0].getName() + ",email=" + authors[0].getEmail() + ",gender=" + authors[0].getGender() + "]";
            for (int i = 1; i < authors.length; i++) {
                result += ",Author[name=" + authors[i].getName() + ",email=" + authors[i].getEmail() + ",gender=" + authors[i].getGender() + "]";
            }
            result+="}";
        }
        result+=",price=" + price + ",qty=" + qty + "]";
        return result;
    }
}
