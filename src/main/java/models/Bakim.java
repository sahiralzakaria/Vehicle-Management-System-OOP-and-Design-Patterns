package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bakim {
    private int id;
    private int aracId;
    private LocalDate bakimTarihi;
    private String aciklama;
    private String durum;
    
    public Bakim(int id, int aracId, LocalDate bakimTarihi, String aciklama, String durum) {
        this.id = id;
        this.aracId = aracId;
        this.bakimTarihi = bakimTarihi;
        this.aciklama = aciklama;
        this.durum = durum;
    }
    
    public int getId() { return id; }
    public int getAracId() { return aracId; }
    public LocalDate getBakimTarihi() { return bakimTarihi; }
    public String getAciklama() { return aciklama; }
    public String getDurum() { return durum; }
    
    public void setDurum(String durum) { this.durum = durum; }
    public void setBakimTarihi(LocalDate bakimTarihi) { this.bakimTarihi = bakimTarihi; }
    public void setAciklama(String aciklama) { this.aciklama = aciklama; }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Bakım [ID=%d, AraçID=%d, Tarih=%s, Açıklama=%s, Durum=%s]", 
                id, aracId, bakimTarihi.format(formatter), aciklama, durum);
    }
    
    public boolean bakimZamaniGeldiMi() {
        LocalDate bugun = LocalDate.now();
        return !bugun.isBefore(bakimTarihi); // Bugün bakım tarihinde veya sonrasındaysa true döner
    }
}
