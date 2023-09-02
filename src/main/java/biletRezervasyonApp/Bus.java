package biletRezervasyonApp;
import java.util.ArrayList;
import java.util.List;

public class Bus {


    //2-plaka ve koltuk no şuan boş

    public String numberPlate;//plaka

    public List<String> seats=new ArrayList<>();//koltuklar

    //3-otobusü oluştrurken plaka ve koltuk nolar set edildin.
    public Bus(String plaka){
        this.numberPlate=plaka;
        for (int i = 1; i <33 ; i++) {
            // this.seats.add(String.valueOf(i));//int değer girildiğinde int olarak yazmasını istiyoruz.
            // seats listesine eklemek için
            this.seats.add(i+"");//yukarıda ile aynı işi yapıyor,string value yerine yaptık.
        }
    }}