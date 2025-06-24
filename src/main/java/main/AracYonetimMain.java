package main;

//import models.*;
//import pattern.factory.AracFactory;
//import pattern.facade.BakimFacade;
import context.YakitTuketimContext;
import pattern.strategy.*;

public class AracYonetimMain {
    public static void main(String[] args) {
        
          /*      
        System.out.println("Araç Yönetim Sistemi Başlatılıyor...");

        // Factory kullanımı - araçların oluşturulması
        Arac otobus = AracFactory.createArac(1, "Mercedes", "Travego", "otobus", "Yeni", 850000, "Gri");
        Arac motorsiklet = AracFactory.createArac(2, "Yamaha", "R25", "motorsiklet", "Yeni", 120000, "Mavi");
        Arac traktor = AracFactory.createArac(3, "John Deere", "5050D", "traktor", "Yeni", 300000, "Yeşil");
        Arac kamyon = AracFactory.createArac(4, "Ford", "Cargo", "kamyon", "Kullanılmış", 450000, "Beyaz");

        System.out.println("Oluşturulan araçlar:");
        System.out.println(otobus);
        System.out.println(motorsiklet);
        System.out.println(traktor);
        System.out.println(kamyon);

        // Facade kullanımı - bakım işlemlerinin yönetimi
        BakimFacade bakimFacade = new BakimFacade();
        
        // Araçları kataloga ekle
        bakimFacade.aracEkle(1, "Mercedes", "Travego", "otobus", "Yeni", 850000, "Gri");
        bakimFacade.aracEkle(2, "Yamaha", "R25", "motorsiklet", "Yeni", 120000, "Mavi");
        bakimFacade.aracEkle(3, "John Deere", "5050D", "traktor", "Yeni", 300000, "Yeşil");
        bakimFacade.aracEkle(4, "Ford", "Cargo", "kamyon", "Kullanılmış", 450000, "Beyaz");
        
        System.out.println("\n--- Bakım Takip Sistemi Demo ---");
        
        // Bakım kayıtları ekleme
        System.out.println("\nBakım kayıtları ekleniyor...");
        bakimFacade.bakimEkle(1, 1, "08/05/2025", "Motor yağı değişimi", "Planlandı");
        bakimFacade.bakimEkle(2, 1, "15/07/2025", "Fren bakımı", "Planlandı");
        bakimFacade.bakimEkle(3, 2, "01/05/2025", "Zincir değişimi", "Planlandı"); // Bakım zamanı gelmiş!
        bakimFacade.bakimEkle(4, 3, "25/06/2025", "Genel bakım", "Planlandı");
        
        // Tüm bakımları listele
        System.out.println("\nTüm bakım kayıtları:");
        bakimFacade.tumBakimlariListele();
        
        // Belirli bir aracın bakımlarını listele
        System.out.println("\nMercedes Travego için bakım kayıtları:");
        bakimFacade.aracBakimlariniListele(1);
        
        // Bakım zamanı gelenleri bildir
        System.out.println("\nBakım zamanı gelen araçlar kontrol ediliyor...");
        bakimFacade.bakimZamaniGelenleriBildir();
        
        // Bakım durumunu güncelle  
        System.out.println("\nBakım durumu güncelleniyor...");
        bakimFacade.bakimDurumGuncelle(3, "Tamamlandı");
        
        // Güncellenmiş bakımları listele
        System.out.println("\nGüncelleme sonrası bakım kayıtları:");
        bakimFacade.tumBakimlariListele();
        
        Kullanici admin = new Kullanici(1, "admin", "sifre123", "Yönetici");
        System.out.println("\nGiriş yapan kullanıcı: " + admin.getKullaniciAdi());
   */
          
        YakitTuketimContext context = new YakitTuketimContext();

        double mesafe = 120; // kilometre
        double ortalamaTuketim = 0.25; // litre/km

        context.setStrateji(new KamyonYakitStratejisi());
        System.out.println("Kamyon Tüketimi: " + context.tuketimiHesapla(mesafe, ortalamaTuketim));

        context.setStrateji(new OtobusYakitStratejisi());
        System.out.println("Otobüs Tüketimi: " + context.tuketimiHesapla(mesafe, ortalamaTuketim));

        context.setStrateji(new TraktorYakitStratejisi());
        System.out.println("Traktör Tüketimi: " + context.tuketimiHesapla(mesafe, ortalamaTuketim));

        context.setStrateji(new MotorsikletYakitStratejisi());
        System.out.println("Motorsiklet Tüketimi: " + context.tuketimiHesapla(mesafe, ortalamaTuketim));
        
        
    }
    
    
    
}