/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import ValidateData.Validate;
import entity.Student;
import FileHandler.ReadWrite;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USE
 */
public class StudentManager_F1 {

    Validate check = new Validate();
    Scanner sc = new Scanner(System.in);

    public void manager(List<Student> list) {
        while (true) {
            System.out.println("----------------------------------");
            switch (View.InterfaceView.menuManageStudent()) {
                case 1:
                    display(list);
                    break;
                case 2:
                    addStudent(list);
                    break;
                case 3:
                    updateStudent(list);
                    break;
                case 4:
                    deleteStudent(list);
                    break;
                case 5:
                    saveStudent(list);
                    return;
                default:
                    System.exit(0);
            }
        }
    }

    public void display(List<Student> list) {
        int size = list.size();
        if (size > 0) {
            for (Student e : list) {
                System.out.println(e);
            }
        } else {
            System.out.println("Number student : 0 student ");
        }
        System.out.println("----------------------------------");
    }

    public void addStudent(List<Student> list) {
        int id;
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.get(list.size() - 1).getId() + 1;
        }
        System.out.println("Add Student!!");
        String code = check.checkString("Enter code: ");
        String name = check.checkString("Enter Name: ");
        String className = check.checkString("Enter className: ");
        double mark = check.CheckDouble("Enter mark: ", 0, 10);
        list.add(new Student(id, code, name, className, mark));
        System.out.println("Add new student successfully");
        System.out.println("----------------------------------");
    }

    public void deleteStudent(List<Student> list) {
        int size = list.size();
        if (size > 0) {
            System.out.println("Remove Student!!");
            int id = check.CheckInt("Enter ID:", 1, size);
            System.out.println(list.get(id - 1));
            String comf = check.checkString("Press y to delete - another character to return");
            if (comf.equalsIgnoreCase("y")) {
                for (Student e : list) {
                    if (e.getId() == id) {
                        list.remove(id - 1);
                        if (size != 1) {
                            resetID(id - 1, list);
                        }
                        System.out.println("Remove successfully");
                        return;
                    }
                }
            }
        } else {
            System.out.println("0 student - Can't remove student!");
        }
        System.out.println("----------------------------------");
    }

    public void updateStudent(List<Student> list) {

        int size = list.size();
        if (size > 0) {
            System.out.println("Update Student");
            int id = check.CheckInt("Enter ID:", 1, size);
            for (Student e : list) {
                if (e.getId() == id) {
                    String code = check.checkString("Enter new code: ");
                    String name = check.checkString("Enter new Name: ");
                    String className = check.checkString("Enter new ClassName: ");
                    double mark = check.CheckDouble("Enter new mark: ", 0, 10);

                    e.setCode(code);
                    e.setMark(mark);
                    e.setClassName(className);
                    e.setName(name);
                    System.out.println("Update student successfully");
                    return;
                }
            }
        } else {
            System.out.println("0 student - Can't update student!");
        }
        System.out.println("----------------------------------");
    }

    public void saveStudent(List<Student> list) {
        ReadWrite a = new ReadWrite();
        a.writeFileStudent(list);
    }

    public void resetID(int n, List<Student> list) {
        for (int i = n; i < list.size(); i++) {
            Student e = list.get(i);
            e.setId(i + 1);
        }
    }
}
