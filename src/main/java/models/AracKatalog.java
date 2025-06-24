package models;
import pattern.factory.AracFactory;
import java.util.ArrayList;
import java.util.List;
public class AracKatalog {
    private List<Arac> aracListesi;
    public AracKatalog() {
        this.aracListesi = new ArrayList<>();
    }
    public void aracEkle(int id, String marka, String model, String tur, String durum, double fiyat, String renk) {
        Arac yeniArac = AracFactory.createArac(id, marka, model, tur, durum, fiyat, renk);
        aracListesi.add(yeniArac);
    }
    public void aracSil(int id) {
        aracListesi.removeIf(arac -> arac.getId() == id);
    }
    public Arac aracBul(int id) {
        for (Arac arac : aracListesi) {
            if (arac.getId() == id) {
                return arac;
            }
        }
        return null;
    }
    public List<Arac> getTumAraclar() {
        return aracListesi;
    }
    public void listele() {
        if (aracListesi.isEmpty()) {
            System.out.println("Katalogda hiç araç yok.");
        } else {
            for (Arac arac : aracListesi) {
                System.out.println(arac);
            }
        }
    }
}
