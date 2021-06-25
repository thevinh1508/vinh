/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import FileHandler.ReadWrite;
import ValidateData.Validate;
import entity.User;
import java.util.*;

/**
 *
 * @author USE
 */
public class AccountManager_F6 {

    public Validate check = new Validate();
    Scanner sc = new Scanner(System.in);
    public static String temp = "";

    List<User> listU= ReadWrite.readFileUser();
    public User login() {
        System.out.println("---------- LOGIN ----------");
        listU.add(new User(1, "he140633", "binh1762", "111111", 1));
        String username = check.checkUsername("Username: ");
        String password = check.checkPassword("Password: ");
        for (User user : listU) {
            if (username.equals(user.getName()) && password.equals(user.getPassword())) {
                System.out.println("Login Succesfull");
                temp = username;
                return user;
            }
        }
        return null;
    }

    public void logout() {
        if (check.checkYesNo("Do you want to logout?")) {
            System.exit(0);
        }
    }

    public void changeStudentPass() {
        System.out.println("Change Student Password");
        for (User user : listU) {
            if (temp.equals(user.getName())) {
                while (true) {
                    String oldPass = check.checkPassword("Enter your old password: ");
                    if (user.getPassword().equals(oldPass)) {
                        String newPass = check.checkPassword("Enter your new password: ");
                        user.setPassword(newPass);
                        System.out.println("Change pass successfully");
                        ReadWrite.writeFileUser(listU);
                        return;
                    } else {
                        System.err.println("Your old password not true !");
                    }
                }
            }
        }
    }

    public void changUserPass() {
        System.out.println("Change User Password");
        String code = check.checkString("Enter Code:");
        for (User user : listU) {
            if ((user.getCode()).equals(code)) {
                while (true) {
                    String newPass = check.checkPassword("Enter your new password: ");
                    user.setPassword(newPass);
                    System.out.println("Change pass successfully");
                    ReadWrite.writeFileUser(listU);
                    return;
                }
            }
        }
        System.out.println("code does not exist");
    }

    public void display(List<User> list) {
        for (User e : list) {
            System.out.println(e);
        }
    }
}
