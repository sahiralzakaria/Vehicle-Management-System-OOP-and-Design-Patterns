package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BakimYonetimi {
    private List<Bakim> bakimListesi;
    
    public BakimYonetimi() {
        this.bakimListesi = new ArrayList<>();
    }
    
    public void bakimEkle(int id, int aracId, LocalDate bakimTarihi, String aciklama, String durum) {
        Bakim yeniBakim = new Bakim(id, aracId, bakimTarihi, aciklama, durum);
        bakimListesi.add(yeniBakim);
    }
    
    public void bakimSil(int id) {
        bakimListesi.removeIf(bakim -> bakim.getId() == id);
    }
    
    public Bakim bakimBul(int id) {
        for (Bakim bakim : bakimListesi) {
            if (bakim.getId() == id) {
                return bakim;
            }
        }
        return null;
    }
    
    public List<Bakim> aracaBagliTumBakimlar(int aracId) {
        return bakimListesi.stream()
                .filter(bakim -> bakim.getAracId() == aracId)
                .collect(Collectors.toList());
    }
    
    public List<Bakim> getGecmisBakimlar() {
        LocalDate bugun = LocalDate.now();
        return bakimListesi.stream()
                .filter(bakim -> bakim.getBakimTarihi().isBefore(bugun))
                .collect(Collectors.toList());
    }
    
    public List<Bakim> getBakimZamaniGelenler() {
        return bakimListesi.stream()
                .filter(Bakim::bakimZamaniGeldiMi)
                .collect(Collectors.toList());
    }
    
    public List<Bakim> getTumBakimlar() {
        return bakimListesi;
    }
    
    public void bakimDurumGuncelle(int bakimId, String yeniDurum) {
        Bakim bakim = bakimBul(bakimId);
        if (bakim != null) {
            bakim.setDurum(yeniDurum);
        }
    }
}