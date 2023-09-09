package loginPage;

import java.util.Scanner;

public class LoginPageApp /*

Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

         menü: kullanıcıya işlem seçimi için menü gösterilir.

         üye olma(register): kullanıcıdan ad-soyad, email ve şifre bilgileri alınız.
                             email ve şifre birer listede tutulur.
                             aynı email kabul edilmez.

         giriş(login): email ve şifre girilir.
                       email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
                       email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

         email validation: boşluk içermemeli
                         : @ içermeli
                         : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                         : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

         password validation: boşluk içermemeli
                            : en az 6 karakter olmalı
                            : en az bir tane küçük harf içermeli
                            : en az bir tane büyük harf içermeli
                            : en az bir tane rakam içermeli
                            : en az bir tane sembol içermeli
 */{




    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        UserService service= new UserService();
        byte select;
        do {
            System.out.println("=== ENESBATUR ===\n1) Üye ol\n2)Giriş yap\n0) Çıkış");
            select= input.nextByte();

            switch (select){
                case 1 :  service.register();  break;
                case 2 :  service.login(); break;
                case 3 :
                    System.out.println("İyi günler dileriz..."); break;
                default:
                    System.out.println("Lütfen geçerli bir işlem seçiniz...");
            }


        }while(select!=0);


    }
}
