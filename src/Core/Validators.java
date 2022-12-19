package Core;

import Entity.User;

import java.util.List;
import java.util.regex.Pattern;

public class Validators {public static boolean isPasswordValidator(User user) {

    if(user.getPassword().length() >= 6 ) {

        return true;
    }

    return false;
}

    public static boolean isMailValidator(User user) {

        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(user.getMail())
                .matches();


    }

    public static boolean isNameLastNameValidator(User user) {

        if(user.getFullName().length() > 2) {

            return true;
        }

        return false;
    }

    public static boolean isUsedMail(List<User> users, User user) {

        for(User userControl : users ) {

            if(userControl.getMail().equals(user.getMail())) {

                return false;
            }
        }

        return true;

    }

    public static boolean isMailConfirmation(boolean tıkla) {


        if(tıkla) {
            System.out.println("Mail onaylandı.");
            return true;
        }
        return false;


    }
}
