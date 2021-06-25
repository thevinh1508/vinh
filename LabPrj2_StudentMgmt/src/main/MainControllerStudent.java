/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import View.InterfaceView;
import entity.Student;
import entity.User;
import java.util.List;
import manage.AccountManager_F6;

/**
 *
 * @author BlackBear
 */
public class MainControllerStudent {

    static AccountManager_F6 manageAccount = new AccountManager_F6();

    public static void studentController(List<Student> listS, List<User> listU) {
        while (true) {
            int option = InterfaceView.menuWorker();
            switch (option) {
                case 1:
                    break;
                case 2:
                    manageAccount.changeStudentPass();
                    break;
                case 3:
                    System.exit(0);
                    default: return;
            }
        }
    }
}
