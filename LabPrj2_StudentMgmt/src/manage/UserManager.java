/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 aaaaaaaaaa
 */
package manage;

import ValidateData.Validate;
import FileHandler.ReadWrite;
import entity.Student;
import entity.User;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USE
 */
public class UserManager {

    Validate check = new Validate();
    Scanner sc = new Scanner(System.in);

    ReadWrite rw = new ReadWrite();

    ArrayList<User> listUser = ReadWrite.readFileUser();

    public void f4Menu() throws FileNotFoundException {
        while (true) {
            switch (View.InterfaceView.menuManageUser()) {
                case 1:
                    System.out.println("ID\tCode\tName\tPasssword\tType");
                    display();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    changePassword();
                    break;
                case 5:
                    removeUser();
                    break;
                default:
                    rw.writeFileUser(listUser);
                    return;
            }
        }
    }

    public void display() throws FileNotFoundException {
        for (User e : listUser) {
            if (e.getRole() == 0) {
                System.out.println(e);
            }

        }
    }

    public void addUser() throws FileNotFoundException {
        List<Student> listStudent = ReadWrite.readFileStudent();

        System.out.println("Add User!!");
        int id;
        int size = listUser.size();
        if (listUser.isEmpty()) {
            id = 1;
        } else {
            id = listUser.get(size - 1).getId() + 1;
        }

        String code = check.checkString("Enter user Code : ");

        Student student = check.getStudent(listStudent, code);

        if (student == null) {
            System.out.println("not match with student code");
            return;
        }
        String name = check.checkUsername("Enter user name: ");
        User user = check.getUser(listUser, name);

        if (user != null) {
            System.out.println("Dubplicate UserName");
        } else {
            String password = check.checkPassword("Enter password: ");
            User u = new User(id, code, name, password, 0);
            listUser.add(u);
            System.out.println("Add new User successfully");
        }

    }

    public void removeUser() {

        System.out.println("Remove User!!");
        int id = check.CheckInt("Enter ID:", 0, Integer.MAX_VALUE);

        for (User user : listUser) {
            if (user.getId() == id) {
                System.out.print("Do you Want Remove this User? (Y or N)");
                String option = sc.nextLine();
                if (option.equalsIgnoreCase("y")) {
                    listUser.remove(user);
                    System.out.println("Remove successfully");
                    return;
                } else {
                    System.out.println("Not Remove this User!");
                    return;
                }
            }
        }
        System.out.println("Code does not exist");
    }

    public void updateUser() {
        List<Student> listStudent = new ArrayList<>();
        rw.readFileStudent();

        System.out.println("Update User!!");
        int id = check.CheckInt("Enter ID:", 0, Integer.MAX_VALUE);
        for (User user : listUser) {
            if (user.getId() == id) {
                String code = check.checkString("Enter Code: ");
                int index = getIndexStudent(listStudent, user.getCode());

                user.setCode(code);
                listStudent.get(index).setCode(code);
                rw.writeFileStudent(listStudent);
                System.out.println("Update Code successfully");
                return;
            }
        }
        System.out.println("code does not exist");
    }

    public int getIndexStudent(List<Student> listStudent, String code) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public void changePassword() {
        System.out.println("Change Password User!!");

        while (true) {
            String password = check.checkPassword("Enter new Password: ");
            String repassword = check.checkPassword("Enter repassword: ");

            if (password.equals(repassword)) {
                break;
            } else {
                System.out.println("rePassword must equal with new Password");
            }
        }

        System.out.println("Change Password Successfull!");

    }

}
