import Business.UserManager;
import Business.UserService;
import Core.GoogleUserInfoAdapter;
import Core.Validators;
import DataAccess.UserDao;
import DataAccess.UserDaoWithInformations;
import Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {


        User user1 = new User(1,"Yusuf Bilal Yilmaz","yusufbilaly29@gmail.com","1234");



        UserManager userManager = new UserManager(new UserDaoWithInformations(), new GoogleUserInfoAdapter());

        userManager.registerWithGoogle(new GoogleUserInfoAdapter());

        System.out.println();


        System.out.println();


        System.out.println("-------------------------------------------");



        System.out.println();
        userManager.getAll();
        userManager.login();



    }
}