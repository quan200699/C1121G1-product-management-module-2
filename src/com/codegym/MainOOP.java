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
public class MainOOP {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1; //Để nhập lựa chọn của người dùng
        ProductManagement productManagement = new ProductManagement();
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("---Danh sách sản phẩm---");
                    productManagement.displayAllProduct();
                    break;
                }
                case 2: {
                    System.out.println("---Thêm mới sản phẩm---");
                    System.out.println("Nhập vị tí muốn thêm sản phẩm");
                    int index = scanner.nextInt();
                    Product product = inputProduct();
                    productManagement.addNewProduct(index, product);
                    break;
                }
                case 3: {
                    System.out.println("---Cập nhật thông tin sản phẩm---");
                    System.out.println("Nhập vị tí muốn thêm sản phẩm");
                    int index = scanner.nextInt();
                    Product product = inputProduct();
                    productManagement.updateProduct(index, product);
                    break;
                }
                case 4: {
                    System.out.println("---Xóa sản phẩm---");
                    System.out.println("Nhập vị tí muốn thêm sản phẩm");
                    int index = scanner.nextInt();
                    productManagement.removeProduct(index);
                    break;
                }
            }
        } while (choice != 0);
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
