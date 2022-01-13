package com.codegym;

public class ProductManagement {
    private Product[] products = new Product[0];

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void displayAllProduct() {
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + "\t" + products[i]);
        }
    }

    public void addNewProduct(int index, Product newProduct) {
        Product[] newProducts = new Product[this.products.length + 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < index) {
                newProducts[i] = this.products[i];
            } else if (i == index) {
                newProducts[i] = newProduct;
            } else {
                newProducts[i] = this.products[i - 1];
            }
        }
        this.products = newProducts;
    }

    public void updateProduct(int index, Product newProduct) {
        this.products[index] = newProduct;
    }

    public void removeProduct(int index) {
        Product[] newProducts = new Product[this.products.length - 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < index) {
                newProducts[i] = this.products[i];
            } else {
                newProducts[i] = this.products[i + 1];
            }
        }
        this.products = newProducts;
    }
}
