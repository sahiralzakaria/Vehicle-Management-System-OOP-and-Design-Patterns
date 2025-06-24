package pattern.facade;

import models.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class BakimFacade {
    private BakimYonetimi bakimYonetimi;
    private BakimTarihKontrol tarihKontrol;
    private AracKatalog aracKatalog;
    
    public BakimFacade() {
        this.bakimYonetimi = new BakimYonetimi();
        this.tarihKontrol = new BakimTarihKontrol();
        this.aracKatalog = new AracKatalog();
    }
    
    
    public void bakimEkle(int bakimId, int aracId, String tarihStr, String aciklama, String durum) {
        // Tarih formatını kontrol et
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate bakimTarihi = LocalDate.parse(tarihStr, formatter);
        
        // Araç mevcut mu kontrol et
        Arac arac = aracKatalog.aracBul(aracId);
        if (arac == null) {
            throw new IllegalArgumentException("Bu ID'ye sahip araç bulunamadı: " + aracId);
        }
        
        bakimYonetimi.bakimEkle(bakimId, aracId, bakimTarihi, aciklama, durum);
        System.out.println("Bakım kaydı başarıyla eklendi: " + aracId + " ID'li araç için " + tarihStr + " tarihinde");
    }
    
 
    public void aracBakimlariniListele(int aracId) {
        Arac arac = aracKatalog.aracBul(aracId);
        if (arac == null) {
            System.out.println("Bu ID'ye sahip araç bulunamadı: " + aracId);
            return;
        }
        
        List<Bakim> bakimlar = bakimYonetimi.aracaBagliTumBakimlar(aracId);
        
        System.out.println("Araç Bilgisi: " + arac);
        System.out.println("Bakım Kayıtları: ");
        
        if (bakimlar.isEmpty()) {
            System.out.println("Bu araç için bakım kaydı bulunmamaktadır.");
        } else {
            for (Bakim bakim : bakimlar) {
                System.out.println(bakim);
                if (bakim.bakimZamaniGeldiMi()) {
                    System.out.println("  --> UYARI: Bakım zamanı geldi!");
                }
            }
        }
    }
    
   
    public void bakimZamaniGelenleriBildir() {
        List<Bakim> zamanıGelenBakimlar = bakimYonetimi.getBakimZamaniGelenler();
        
        System.out.println("--- Bakım Zamanı Gelen Araçlar ---");
        if (zamanıGelenBakimlar.isEmpty()) {
            System.out.println("Bakım zamanı gelen araç bulunmamaktadır.");
        } else {
            for (Bakim bakim : zamanıGelenBakimlar) {
                Arac arac = aracKatalog.aracBul(bakim.getAracId());
                if (arac != null) {
                    System.out.println("UYARI: " + arac.getMarka() + " " + arac.getModel() + 
                            " için (" + bakim.getBakimTarihi() + ") tarihli bakım zamanı geldi!");
                    System.out.println("Bakım detayı: " + bakim.getAciklama());
                }
            }
        }
    }
    
    
    public void bakimDurumGuncelle(int bakimId, String yeniDurum) {
        Bakim bakim = bakimYonetimi.bakimBul(bakimId);
        if (bakim == null) {
            System.out.println("Bu ID'ye sahip bakım kaydı bulunamadı: " + bakimId);
            return;
        }
        
        bakimYonetimi.bakimDurumGuncelle(bakimId, yeniDurum);
        System.out.println("Bakım durumu güncellendi: " + bakimId + " -> " + yeniDurum);
    }
    
    
    public void tumBakimlariListele() {
        List<Bakim> tumBakimlar = bakimYonetimi.getTumBakimlar();
        
        System.out.println("--- Tüm Bakım Kayıtları ---");
        if (tumBakimlar.isEmpty()) {
            System.out.println("Sistemde bakım kaydı bulunmamaktadır.");
        } else {
            for (Bakim bakim : tumBakimlar) {
                Arac arac = aracKatalog.aracBul(bakim.getAracId());
                System.out.print(bakim);
                if (arac != null) {
                    System.out.println(" - Araç: " + arac.getMarka() + " " + arac.getModel());
                } else {
                    System.out.println(" - Araç bilgisi bulunamadı.");
                }
                
                if (bakim.bakimZamaniGeldiMi()) {
                    System.out.println("  --> UYARI: Bakım zamanı geldi!");
                }
            }
        }
    }
    
   
    public void bakimSil(int bakimId) {
        Bakim bakim = bakimYonetimi.bakimBul(bakimId);
        if (bakim == null) {
            System.out.println("Bu ID'ye sahip bakım kaydı bulunamadı: " + bakimId);
            return;
        }
        
        bakimYonetimi.bakimSil(bakimId);
        System.out.println("Bakım kaydı silindi: " + bakimId);
    }
    
    // AracKatalog yönetimi için eklenen metodlar
    public void aracEkle(int id, String marka, String model, String tur, String durum, double fiyat, String renk) {
        aracKatalog.aracEkle(id, marka, model, tur, durum, fiyat, renk);
    }
    
    public AracKatalog getAracKatalog() {
        return aracKatalog;
    }
    
    public BakimYonetimi getBakimYonetimi() {
        return bakimYonetimi;
    }
}