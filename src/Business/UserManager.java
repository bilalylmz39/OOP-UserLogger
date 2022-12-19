package Business;

import Core.GoogleUserInfoService;
import Core.Validators;
import DataAccess.UserDaoWithInformations;
import Entity.User;

import java.util.Scanner;

public class UserManager implements UserService {

    UserDaoWithInformations userDaoWithInformations;
    GoogleUserInfoService googleUserInfoService;


    public UserManager(UserDaoWithInformations userDaoWithInformations, GoogleUserInfoService googleUserInfoService) {

        this.userDaoWithInformations = userDaoWithInformations;
        this.googleUserInfoService = googleUserInfoService;

    }


    @Override
    public void add(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------Kullanıcı ekleme sayfası sayfası-----");
        System.out.print("E-mail : ");
        String mail = input.next();
        System.out.print("Şifre : ");
        String password = input.next();

        if (!Validators.isUsedMail(userDaoWithInformations.getAll(), user)) {

            System.out.println("Girmiş olduğunuz mail kullanımda lütfen farklı bir mail adresi girin.");


        } else if (!Validators.isPasswordValidator(user) && !Validators.isMailValidator(user) &&
                !Validators.isNameLastNameValidator(user)) {
            System.out.println("Şifreniz en az 6 karakterden oluşmalıdır.\nMail adresiniz mail formatında olmalıdır.\nAdınız ve Soyadınız en az 2 karkaterden oluşmalıdır.");

        } else if (!Validators.isPasswordValidator(user) && !Validators.isMailValidator(user)) {
            System.out.println("Şifreniz en az 6 karakterden oluşmalıdır.\nMail adresiniz mail formatında giriniz.");
        } else if (!Validators.isPasswordValidator(user) && !Validators.isNameLastNameValidator(user)) {
            System.out.println("Şifreniz en az 6 karakterden oluşmalıdır.\nAdınız ve Soyadınız en az 2 karkaterden oluşmalıdır.");
        } else if (!Validators.isMailValidator(user) && !Validators.isNameLastNameValidator(user)) {
            System.out.println("Mail adresiniz mail formatında giriniz.\nAdınız ve Soyadınız en az 2 karkaterden oluşmalıdır.");
        } else if (!Validators.isMailValidator(user)) {
            System.out.println("Mail adresiniz mail formatında giriniz.");
        } else if (!Validators.isPasswordValidator(user)) {
            System.out.println("Şifreniz en az 6 karakterden oluşmalıdır.");
        } else if (!Validators.isNameLastNameValidator(user)) {
            System.out.println("Adınız ve Soyadınız en az 2 karakterden oluşmalıdır.");
        } else {


            if (Validators.isMailConfirmation(true)) {
                System.out.println(user.getFullName() + " tebrikler başarıyla kayıt oluşturuldu.");
                userDaoWithInformations.add(user);

            } else {
                System.out.println("Mail adresinize bir mail gönderdik maili doğrulayın lütfen.");
            }

        }
    }

    @Override
    public void delete(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public User getUser(int id) {
        return null;
        // TODO Auto-generated method stub

    }

    @Override
    public void getAll() {

        for (User user : userDaoWithInformations.getAll()) {

            System.out.println("Id : " + user.getId());
            System.out.println("Ad Soyad : " + user.getFullName());
            System.out.println("E-mail : " + user.getMail());
            System.out.println();
        }
    }


    Scanner input = new Scanner(System.in);

    @Override
    public void login() {
        System.out.println("--------Giriş sayfası-----");
        System.out.print("E-mail : ");
        String mail = input.next();
        System.out.print("Şifre : ");
        String password = input.next();

        if (!mail.isEmpty() && !password.isEmpty()) {

            for (User userControl : userDaoWithInformations.getAll()) {
                if (mail.equals(userControl.getMail()) && password.equals(userControl.getPassword())) {
                    System.out.println("Giriş yapıldı.");
                    return;
                }

            }
            System.out.println("Bilgiler uyuşmamaktadır.");

        } else {
            System.out.println("Mail alanı ve şifre alanı boş geçilemez.");
        }

    }


    @Override
    public void registerWithGoogle(GoogleUserInfoService info) {
        User user = new User();
        user.setId(info.getUserInfo().getId());
        user.setFullName(info.getUserInfo().getFullName());
        user.setMail(info.getUserInfo().getMail());
        user.setPassword(info.getUserInfo().getPassword());
        if (!Validators.isUsedMail(userDaoWithInformations.getAll(), user)) {

            System.out.println("Girmiş olduğunuz mail kullanımda lütfen farklı bir mail adresi girin.");


        } else {
            if (Validators.isMailConfirmation(true)) {
                System.out.println(user.getFullName() + " tebrikler google hesabımız ile başarıyla kayıt oluşturuldu.");
                userDaoWithInformations.add(user);

            } else {
                System.out.println("Mail adresinize bir mail gönderdik maili doğrulayın lütfen.");
            }


        }
    }
}

