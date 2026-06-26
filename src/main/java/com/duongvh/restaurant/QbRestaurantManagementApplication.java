package com.duongvh.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.duongvh.restaurant")
public class QbRestaurantManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(QbRestaurantManagementApplication.class, args);
    }

}
