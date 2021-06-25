/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidateData;

import entity.Student;
import entity.User;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author USE
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    public Student getStudent(List<Student> list, String code) {
        for (Student student : list) {
            if (code.equalsIgnoreCase(student.getCode())) {
                return student;
            }
        }
        return null;
    }

    public User getUser(List<User> list, String userName) {
        for (User user : list) {
            if (userName.equalsIgnoreCase(user.getName())) {
                return user;
            }
        }
        return null;
    }

    public int CheckInt(String smg, int min, int max) {
        while (true) {
            System.out.print(smg);
            try {
                int input = Integer.parseInt(sc.nextLine().trim());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Out of range " + "{ " + min + ", " + max + "}");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must try again");
            }
        }
    }

    public double CheckDouble(String mess, double min, double max) {
        while (true) {
            System.out.print(mess);
            try {
                double input = Double.parseDouble(sc.nextLine().trim());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.err.println("Out range " + "{ " + min + ", " + max + "}");
                }
            } catch (NumberFormatException e) {
                System.err.println("You must try again");
            }
        }
    }

    public String checkString(String mess) {
        while (true) {
            System.out.print(mess);
            String str = sc.nextLine().trim();
            if (str.isEmpty()) {
                System.err.println("Can not empty!");
            } else {
                return str;
            }
        }
    }

    public String checkPassword(String message) {
        while (true) {
            System.out.print(message);
            String password = sc.nextLine().trim();

            Pattern pattern = Pattern.compile("[a-zA-Z0-9]{6,}");
            if (password.isEmpty()) {
                System.err.println("Password can not empty");
                continue;
            } else if (!pattern.matcher(password).find()) {
                System.err.println("Password must include >=6 chars, including only letters or numbers");
                continue;
            } else {
                return password;
            }
        }
    }

    public String checkUsername(String mess) {
        while (true) {
            System.out.print(mess);
            String userName = sc.nextLine().trim();
            if (userName.isEmpty()) {
                System.err.println("Username can not empty");
                continue;
            } else if (!userName.matches("^[a-zA-Z](.){4,}")) {
                System.err.println("userName has >=5 chars, unique & must start with a letter character");
                continue;
            } else {
                return userName;
            }
        }
    }

    public String checkAddUsername(String mess, List<User> list) {
        while (true) {
            boolean check = true;
            System.out.print(mess);
            String userName = sc.nextLine().trim();
            for (User user : list) {
                if (userName.equalsIgnoreCase(user.getName())) {
                    System.err.println("Username has exist !");
                    check = false;
                    break;
                }
            }
            if (check != false) {
                if (userName.isEmpty()) {
                    System.err.println("Username can not empty");
                    continue;
                } else if (!userName.matches("^[a-zA-Z](.){4,}")) {
                    System.err.println("userName has >=5 chars, unique & must start with a letter character");
                    continue;
                } else {
                    return userName;
                }
            }
        }
    }

    public boolean checkYesNo(String mess) {
        while (true) {
            System.out.print(mess);
            String choice = sc.nextLine().trim();
            if (choice.isEmpty()) {
                System.err.println("Option can't be empty");
                continue;
            } else if (choice.equalsIgnoreCase("yes")) {
                return true;
            } else if (choice.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.err.println("Please input Yes or No!");
            }
        }
    }

}
