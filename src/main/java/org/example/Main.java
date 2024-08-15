package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.SellerDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1 FINDBYID ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println();
        System.out.println("=== TEST 2 FINDBYDEPARTMENT ===");
        List<Seller> sellerList = sellerDao.findByDepartment(new Department(2, null));
        for (Seller seller1 : sellerList) {

            System.out.println(seller1);

        }

    }
}