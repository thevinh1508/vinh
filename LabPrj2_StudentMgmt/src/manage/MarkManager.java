/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import FileHandler.ReadWrite;
import ValidateData.Validate;
import entity.Student;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USE
 */
public class MarkManager {

    private Validate check = new Validate();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        List<Student> lstS = ReadWrite.readFileStudent();
        while (true) {
            System.out.println("1. Add Mark\n"
                    + "2. Update Mark\n"
                    + "3. Delete Student\n"
                    + "4. Save and Return\n"
                    + "5. Exit");
            int option = check.CheckInt("Enter your choice: ", 1, 5);
            switch (option) {
                case 1:
                    addMark(lstS);
                    break;
                case 2:
                    updateMark(lstS);
                    break;
                case 3:
                    deleteMark(lstS);
                    break;
                case 4:
                    return;
                default:
                    System.exit(0);
            }
        }
    }

    public void addMark(List<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println("Add Mark");
        String code = check.checkString("Enter code: ");
        for (Student student : list) {
            if (student.getCode().equals(code)) {
                double mark = check.CheckDouble("Enter mark:", 0, 10);
                student.setMark(mark);
                return;
            }
        }
        System.out.println("Student not exist!");
    }

    public void updateMark(List<Student> list) {

        System.out.println("Update Mark");
        while (true) {
            int ID = check.CheckInt("Enter ID:", 1, Integer.MAX_VALUE);
            for (Student student : list) {
                if (student.getId() == ID) {
                    student.setMark(check.CheckDouble("Enter new mark: ", 0, 10));
                    System.out.println("Update mark successfully");
                    return;
                }
            }
            System.out.println("ID does not exist");
        }
    }

    public void deleteMark(List<Student> list) {
        System.out.println("Delete Mark");
        while (true) {
            int ID = check.CheckInt("Enter ID:", 1, Integer.MAX_VALUE);
            for (int i = 0; i < list.size(); i++) {
                Student e = list.get(i);
                if (e.getId() == ID) {
                    e.setMark(0);
                    System.out.println("Mark has been setted to 0");
                    return;
                }
            }
            System.out.println("ID does not exist");
        }

    }
}
