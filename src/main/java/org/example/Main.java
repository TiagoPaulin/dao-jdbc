package org.example;

import org.example.model.dao.DaoFactory;
import org.example.model.dao.SellerDao;
import org.example.model.entities.Department;
import org.example.model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println();
        System.out.println("=== TEST 2: findByDepartment ===");
        List<Seller> sellerList = sellerDao.findByDepartment(new Department(2, null));
        for (Seller seller1 : sellerList) {

            System.out.println(seller1);

        }

        System.out.println();
        System.out.println("=== TEST 3: findAll ===");
        sellerList = sellerDao.findAll();
        for (Seller seller1 : sellerList) {

            System.out.println(seller1);

        }

        System.out.println();
        System.out.println("=== TEST 4: insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(2, null));
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new Id = " + newSeller.getId());


        System.out.println();
        System.out.println("=== TEST 5: update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println();
        System.out.println("=== TEST 6: delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();



    }
}