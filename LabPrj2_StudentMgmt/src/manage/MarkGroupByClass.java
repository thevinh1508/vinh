/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import entity.Student;
import FileHandler.ReadWrite;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class MarkGroupByClass {

    Scanner sc = new Scanner(System.in);

    public void showInfoStudent(List<Student> list) {
       
        String con = "";
        do{
            boolean flag = false;
            System.out.println("Input Student className: ");
            String className = sc.nextLine();

            for (int i = 0; i < list.size(); i++) {

                if (className.equals(list.get(i).getClassName())) {

                    System.out.println("StudentID: " + list.get(i).getId() + " | Student Code: " + list.get(i).getCode() + " | Student Name: " + list.get(i).getName());

                    flag = true;
                }

            }

            if (!flag) {
                System.out.println("Class not Found!!");
            }
            System.out.println("Do you want to continue? Y/N: ");
             con = sc.nextLine();
            
        }while(con.toLowerCase().equals("y"));

    }
}
