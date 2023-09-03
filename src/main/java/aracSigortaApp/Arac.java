package aracSigortaApp;

import java.util.Scanner;

public class Arac {
    public String carType ="";
    public byte busSeat=0;
    public byte triffPeriod ;

    public int prim ;

    public boolean isAgain=false;

    public byte checkNum;

    public void trifCheck(){

        System.out.println("Lütfen dönem seçiniz \n1.dönem :Haziran 2023               2.dönem:Aralık 2023");
        Scanner input = new Scanner(System.in);
        triffPeriod= input.nextByte();
        if (triffPeriod <1||triffPeriod>2 ) {
            System.out.println("Hatalı giriş yaptınız...");
            this.isAgain=true;
        }else {
            this.isAgain=false;
        }
    }


    public void primLoan (){
        isAgain=false;
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen taşıt tipini giriniz... \nOtomobil\nKamyon\nOtobüs\nMotosiklet");
        carType= input.next().toLowerCase();

        switch (carType){
            case "otomobil" : this.prim=triffPeriod==1?2000:2500;
                System.out.println("Prim borcunuz : "+prim); break;
            case "kamyon" : this.prim=triffPeriod==1?3000:3500;
                System.out.println("Prim borcunuz : "+prim);break;
            case "otobüs" : countBusPrim();
            break;
            case "motosiklet" : this.prim=triffPeriod==1?1500:1750;
                System.out.println("Prim borcunuz : "+prim);break;
            default:
                System.out.println("Hatalı giriş yaptınız...");  isAgain=true; break;

        }
        System.out.println("Menüye dönmek için 1 tuşuna basın \nÇıkış yapmak için 2 tuşuna basın");
        checkNum= input.nextByte();
        if (checkNum==1){
            isAgain=true;
        } else if (checkNum==2) {
            isAgain=false;

        }


    }
    public void countBusPrim(){
        isAgain=false;
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen Otobüs tipini seçiniz");
        System.out.println("1. 18-30 Koltuk arası ");
        System.out.println("2. 31 Koltuk ve üzeri ");
        busSeat= input.nextByte();

        switch (busSeat){
            case 1 : this.prim=triffPeriod==1?4000:4500;
                System.out.println("Prim borcunuz : "+prim);break;
            case 2 : this.prim=triffPeriod==1?5000:5500;
                System.out.println("Prim borcunuz : "+prim);break;
            default:
                System.out.println("Geçersiz giriş yaptınız....");  isAgain=true; break;
        }

    }
}
