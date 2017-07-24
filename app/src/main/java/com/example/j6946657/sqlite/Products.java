package com.example.j6946657.sqlite;


public class Products {

    private int _id;
    private String _productsName;


    public Products(String productsName) {
        this._productsName = productsName;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_productsName(String _productsName) {
        this._productsName = _productsName;
    }

    public int get_id() {
        return _id;
    }

    public String get_productsName() {
        return _productsName;
    }
}









