package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BakimTarihKontrol {
    
    public void bakimTarihKontrol(List<Bakim> bakimListesi) {
        LocalDate bugun = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Bakım Tarih Kontrol Raporu - " + bugun.format(formatter));
        System.out.println("----------------------------------------");
        
        for (Bakim bakim : bakimListesi) {
            if (bakim.bakimZamaniGeldiMi()) {
                System.out.println("UYARI: Bakım zamanı geldi veya geçti! - " + bakim);
            }
        }
    }
    
    public boolean bakimTarihiGectiMi(Bakim bakim) {
        LocalDate bugun = LocalDate.now();
        return bugun.isAfter(bakim.getBakimTarihi());
    }
    
    public int gunFarki(Bakim bakim) {
        LocalDate bugun = LocalDate.now();
        long gunFarki = java.time.temporal.ChronoUnit.DAYS.between(bugun, bakim.getBakimTarihi());
        return (int) gunFarki;
    }
}