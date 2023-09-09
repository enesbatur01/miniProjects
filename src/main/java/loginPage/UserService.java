package loginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String> emails=new ArrayList<>();
    List<String> passwords=new ArrayList<>();
    //List<User> users=new ArrayList<>();-->practice


    //2-ad-soyad,email,şifre alıp->listeye kaydedelim
    public void register() {
        Scanner inp=new Scanner(System.in);
        System.out.println("Ad-Soyad giriniz: ");
        String name=inp.nextLine();

        //email geçersizse tekrar girilmeli
        String email;
        boolean isValid;
        boolean isExistEmail;
        do {
            System.out.println("Email giriniz :");
            email=inp.nextLine().trim();
            isValid=validateEmail(email);///asd@gmail.com
            isExistEmail=this.emails.contains(email);
            if (isExistEmail){
                System.out.println("Bu email ile kayıtlı kullanıcı zaten var");
                isValid=false;
            }
        }while (!isValid);

        //passsword oluşturma...
        String password;
        boolean isValidPassword;
        do {
            System.out.println("Şifrenizi oluşturunuz : ");
            password=inp.nextLine().trim();

            isValidPassword=validatePassword(password);

        }while (!isValidPassword);

        //user oluşturalım
        User user=new User(name,email,password);

        //userın bilgilerini listeye ekleyelim

        this.emails.add(user.email);
        this.passwords.add(user.password);

        System.out.println("Tebrikler, kayıt işlemi başarıyla gerçekleşti.\nEmail ve şifrenizi kullanarak sisteme giriş yapabilirsiniz.");


    }
    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("Email giriniz : ");
        String email=input.nextLine().trim();



        boolean isExistEmail=this.emails.contains(email);
        if (isExistEmail){
            System.out.println("Şifrenizi giriniz : ");
            String psw = input.nextLine().trim();

            int index = this.emails.indexOf(email);
            boolean isWrong = false;
            do {


            if (this.passwords.get(index).equals(psw)){
                System.out.println("Sisteme giriş yapıldı...");
            } else System.out.println("Mail ve şifre uyuşmuyor...");
        }while (isWrong);


        } else {
            System.out.println("Sisteme kayıtlı kullanıcı bulunamadı...");
        }


    }




    //ÖDEVV:validateEmail ve validatePassword
    private boolean validateEmail(String email){

        boolean isSpace = !email.isBlank();
        boolean isSymbol = email.contains("@");
        boolean isEnd = email.endsWith("@gmail.com") || email.endsWith("@yahoo.com") || email.endsWith("@hotmail.com");
        int indexSymbol = email.indexOf("@");
        boolean isCheck = email.substring(0,indexSymbol).replaceAll("[a-zA-Z-._0-9]","").length() == 0 ;
        boolean isValid=isSpace &&isSymbol&&isEnd&&isCheck;
        if (isValid){

        } else if (!isSpace) {
            System.out.println("Lütfen şifrenizde boşluk kullanmayın...");

        } else if (!isSymbol) {
            System.out.println("Lütfen @ işaretini giriniz...");

        } else if (!isEnd) {
            System.out.println("Geçersiz mail uzantısı...");

        } else if (!isCheck) {
            System.out.println("Lütfen geçersiz bir işaret kullanmayınız...");

        }
        return isValid;

    }

    private boolean validatePassword(String password){
        boolean isSpace = !password.contains(" ");
        boolean isSize = password.length()>5;
        boolean isLower = password.replaceAll("[^a-z]","").length() > 0 ;
        boolean isUpper= password.replaceAll("[^A-Z]","").length() >0;
        boolean isDigit = password.replaceAll("[^0-9]","").length() >0;
        boolean isSymbol = password.replaceAll("[^-._]","").length() >0;

        boolean isValid = isSpace&&isSize&&isLower&&isUpper&&isDigit&&isSymbol;

        if (!isSpace){
            System.out.println("Lütfen boşluk bırakmayınız...");
        } else if (!isSize) {
            System.out.println("Lütfen minimum 6 karakter giriniz...");
        } else if (!isLower) {
            System.out.println("Şifrenizde en az 1 tane küçük harf olmalı...");
        } else if (!isUpper) {
            System.out.println("Şifrenizde en az 1 tane büyük harf olmalı...");
        } else if (!isDigit) {
            System.out.println("Şifrenizde en az 1 tane rakam olmalı...");
        } else if (!isSymbol) {
            System.out.println("Şifrenizde en az 1 tane sembol olmalı...");
        }


        return isValid;


    }

}