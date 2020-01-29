package com.company;

import com.company.Model.entity.DairyEnt;
import com.company.Model.service.DairyServ;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choose;
        String name,product,expire,name2,product2,expire2;
        long number,number2,number3;
        System.out.println("\t\tMihan");
        System.out.println("\n1.Insert Dairy\n2.Update Dairy\n3.Delete Dairy\n4.Show Dairies");
        choose = input.nextInt();
        switch (choose){

            case 1:{
                try {
                    System.out.println("__________________________\nINSERTING");
                    System.out.print("Number:");
                    number = input.nextLong();
                    System.out.print("Name:");
                    name = input.next();
                    System.out.print("Product:");
                    product = input.next();
                    System.out.print("Expire:");
                    expire = input.next();
                    DairyServ.getInstance().save(new DairyEnt().setNum(number).setName(name).setProduct(product).setExpire(expire));
                    System.out.println("\n\tSaved Successfully");
                } catch (Exception e) {
                    System.out.println("Fail to save!"+e.getMessage());
                }
                break;
            }

            case 2:{
                try {
                    System.out.println("__________________________\nUPDATING");
                    System.out.print("Number(previous one):");
                    number2 = input.nextLong();
                    System.out.print("Name(new one):");
                    name2 = input.next();
                    System.out.print("Product(new one):");
                    product2 = input.next();
                    System.out.print("Expire(previous one):");
                    expire2 = input.next();
                    DairyServ.getInstance().save(new DairyEnt().setNum(number2).setName(name2).setProduct(product2).setExpire(expire2));
                    System.out.println("\n\tEdited Successfully");
                } catch (Exception e) {
                    System.out.println("Fail to edit!"+e.getMessage());
                }
                break;
            }

            case 3:{
                try {
                    System.out.println("__________________________\nDELETING");
                    System.out.print("Number:");
                    number3 = input.nextLong();
                    DairyServ.getInstance().remove(number3);
                    System.out.println("\n\tDeleted Successfully");
                } catch (Exception e) {
                    System.out.println("Fail to delete!"+e.getMessage());
                }
                break;
            }

            case 4:{
                try {
                    System.out.println("__________________________\nInventory of Dairies");
                    List<DairyEnt> dairyList = DairyServ.getInstance().report();
                    for(DairyEnt dairyEnt : dairyList){
                        System.out.println(dairyEnt.getNum());
                        System.out.println(dairyEnt.getName());
                        System.out.println(dairyEnt.getProduct());
                        System.out.println(dairyEnt.getExpire());
                    }
                } catch (Exception e) {
                    System.out.println("Fail to Show!"+e.getMessage());
                }
                break;
            }
        }
    }
}
