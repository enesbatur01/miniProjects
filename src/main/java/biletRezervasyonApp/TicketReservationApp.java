package biletRezervasyonApp;

import java.util.Scanner;

public class TicketReservationApp {
    public static void main(String[] args) {

        /*
Project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

    1-Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
    2- Kullanıcıdan     mesafe (KM),
                        yolcu yaşı ,
                        yolculuk tipi (Tek Yön, Gidiş-Dönüş)
                        ve koltuk no bilgilerini alınır.
             NOT: Koltuk numaraları 1-32 aralığında olmalıdır.)
                  Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
                  Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

    3-Fiyat hesaplama kuralları:
       -Mesafe başına ücret:
                  Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
       -Tekli Koltuk ücreti:
                  Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
       -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
        sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
                   i)-Çift Yön indirimi:
                               "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
                   ii)-Yaş indirimi:
                                Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
                                Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

 */

        Scanner input = new Scanner(System.in);

        //1- bilet rezervasyonunu yapacağımız bir otobüse ihtiyacımız
        Bus bus=new Bus("34 ASD 789");//"1","2",...
        //2- bilet objesini oluşturalım.
        Ticket bilet=new Ticket();
        System.out.println("Lütfen gideceğiniz mesafeyi giriniz...");
        bilet.distance= input.nextInt();
        System.out.println("Lütfen tek yönlü seyehat ise 1'e, çift yönlü seyehat ise 2'ye basınız...");
        bilet.typeNo= input.nextByte();
        System.out.println("Lütfen istediğiniz koltuk numarasını yazınız...");
        bilet.seatNo=input.next();
        System.out.println("Lütfen yaşınızı giriniz...");
        byte age = input.nextByte();

        bilet.getTotalPrice(age);
        bilet.printTicket(bus);

        //...ÇOK YAKINDA...



    }
}
