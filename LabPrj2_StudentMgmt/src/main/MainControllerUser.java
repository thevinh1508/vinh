/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import FileHandler.ReadWrite;
import View.InterfaceView;
import entity.Student;
import entity.User;
import java.io.FileNotFoundException;
import java.util.List;
import manage.AccountManager_F6;
import manage.GradingMarkManager;
import manage.MarkGroupByClass;
import manage.MarkManager;
import manage.StudentManager_F1;
import manage.UserManager;

/**
 *
 * @author BlackBear
 */
public class MainControllerUser {

    static StudentManager_F1 studetManage = new StudentManager_F1();
    static MarkManager manageMark = new MarkManager();
    static MarkGroupByClass groupMark = new MarkGroupByClass();
    static GradingMarkManager gradingType = new GradingMarkManager();
    static AccountManager_F6 manageAccount = new AccountManager_F6();
    static UserManager userManager = new UserManager();
    public static void AdminConttroller(List<Student> listS, List<User> listU) throws FileNotFoundException {
        while (true) {
            int option = InterfaceView.menuAdmin();
            switch (option) {
                case 1:
                    studetManage.manager(listS);
                    break;
                case 2:
                    manageMark.menu();
                    break;
                case 3:
                    groupMark.showInfoStudent(listS);
                    break;
                case 4:
                    userManager.f4Menu();
                    break;
                case 5:
                    gradingType.calPercent(listS);
                    break;
                case 6:
                    manageAccount.changUserPass();
                    break;
                case 7:
                    ReadWrite.writeFileStudent(listS);
                    ReadWrite.writeFileUser(listU);
                    System.exit(0);
                    default: return;
            }
        }
    }
}
