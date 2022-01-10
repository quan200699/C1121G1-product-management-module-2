package com.codegym;

import java.util.Scanner;

/*
Làm theo dạng menu
---MENU QUẢN LÝ SẢN PHẨM---
1. Hiển thị danh sách sản phẩm
2. Thêm sản phẩm
3. Cập nhật sản phẩm mới
4. Xóa sản phẩm
5. Sắp xếp danh sách sản phẩm theo tên
6. Tìm kiếm
0. Thoát
Mời bạn nhập lựa chọn
...
* */
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1; //Để nhập lựa chọn của người dùng
        Product[] products = new Product[2];
        products[0] = new Product(1, "IPhone 13 Pro Max", 3500000, "New");
        products[1] = new Product(2, "IPhone 13 Pro", 3000000, "New");
        do {
            menu();
            System.out.println("Mời bạn nhập lựa chọn");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("---Danh sách sản phẩm---");
                    if (products.length == 0) {
                        System.out.println("Không có sản phẩm nào");
                    } else {
                        displayAllProduct(products);
                    }
                    break;
                }
                case 2: {
                    System.out.println("---Thêm sản phẩm---");
                    System.out.println("Nhập vị trí bạn muốn thêm:");
                    int index = scanner.nextInt();
                    if (index < 0 || index > products.length) {
                        System.out.println("Vị trí nhập vào không hợp lệ!");
                    } else {
                        Product newProduct = inputProduct();
                        products = addNewProduct(products, index, newProduct);
                    }
                    break;
                }
                case 3: {
                    System.out.println("---Cập nhật sản phẩm---");
                    System.out.println("Nhập vị trí cần chỉnh sửa:");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= products.length) {
                        System.out.println("Vị trí không hợp lệ!");
                    } else {
                        Product newProduct = inputProduct();
                        products[index] = newProduct;
                    }
                    break;
                }
                case 4: {
                    System.out.println("---Xóa sản phẩm---");
                    System.out.println("Nhập vị trí cần xóa:");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= products.length) {
                        System.out.println("Vị trí không hợp lệ!");
                    } else {
                        Product[] newProducts = new Product[products.length - 1];
                        for (int i = 0; i < newProducts.length; i++) {
                            if (i < index) {
                                newProducts[i] = products[i];
                            } else {
                                newProducts[i] = products[i + 1];
                            }
                        }
                        products = newProducts;
                    }
                    break;
                }
                case 5: {
                    System.out.println("---Sắp xếp sản phẩm theo tên---");
                    sortProductList(products);
                    break;
                }
                case 6: {
                    System.out.println("---Tìm kiếm sản phẩm theo tên---");
                    scanner.nextLine();
                    System.out.println("Nhập tên sản phẩm cần tìm:");
                    String name = scanner.nextLine();
                    int index = findProduct(products, name);
                    if (index == -1) {
                        System.out.println("Không tìm thấy");
                    } else {
                        System.out.println("Thông tin sản phẩm cần tìm là: " + products[index]);
                    }
                    break;
                }
                default: {
                    System.out.println("Số nhập vào phải trong khoảng 0 -> 6");
                    break;
                }
            }
        } while (choice != 0);
    }

    public static int findProduct(Product[] products, String name) {
        int index = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void sortProductList(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products.length; j++) {
                if (products[i].getName().compareTo(products[j].getName()) > 0) {//>0 có nghĩa là product[i] đang lớn hơn products[j]
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
    }

    public static Product[] addNewProduct(Product[] products, int index, Product newProduct) {
        Product[] newProducts = new Product[products.length + 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < index) {
                newProducts[i] = products[i];
            } else if (i == index) {
                newProducts[i] = newProduct;
            } else {
                newProducts[i] = products[i - 1];
            }
        }
        return newProducts;
    }

    public static Product inputProduct() {//Nhập thông tin sản phẩm
        System.out.println("Nhập thông tin của sản phẩm");
        System.out.println("Nhập mã sản phẩm:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập mô tả sản phẩm");
        String description = scanner.nextLine();
        return new Product(id, name, price, description);
    }

    public static void displayAllProduct(Product[] products) { //Hiển thị danh sách sản phẩm
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + "\t" + products[i]);
        }
    }

    public static void menu() {
        System.out.println("---MENU QUẢN LÝ SẢN PHẨM---");
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Sắp xếp danh sách sản phẩm");
        System.out.println("6. Tìm kiếm sản phẩm theo tên");
        System.out.println("0. Thoát chương trình");
    }
}
