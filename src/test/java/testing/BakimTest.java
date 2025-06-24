package testing;

import models.Bakim;
import models.BakimYonetimi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BakimTest {
    private BakimYonetimi bakimYonetimi;
    
    @BeforeEach
    public void setUp() {
        bakimYonetimi = new BakimYonetimi();
        // Bugünden bir gün önce
        LocalDate dun = LocalDate.now().minusDays(1);
        // Bugünden 10 gün sonra
        LocalDate onGunSonra = LocalDate.now().plusDays(10);
        
        bakimYonetimi.bakimEkle(1, 1, dun, "Motor yağı değişimi", "Planlandı");
        bakimYonetimi.bakimEkle(2, 1, onGunSonra, "Fren bakımı", "Planlandı");
        bakimYonetimi.bakimEkle(3, 2, LocalDate.now(), "Zincir değişimi", "Planlandı"); // Tam bugün
    }
    
    @Test
    public void testBakimEkle() {
        LocalDate yirmiGunSonra = LocalDate.now().plusDays(20);
        bakimYonetimi.bakimEkle(4, 3, yirmiGunSonra, "Genel bakım", "Planlandı");
        
        Bakim yeniBakim = bakimYonetimi.bakimBul(4);
        assertNotNull(yeniBakim);
        assertEquals(3, yeniBakim.getAracId());
        assertEquals(4, bakimYonetimi.getTumBakimlar().size());
    }
    
    @Test
    public void testBakimSil() {
        bakimYonetimi.bakimSil(1);
        assertNull(bakimYonetimi.bakimBul(1));
        assertEquals(2, bakimYonetimi.getTumBakimlar().size());
    }
    
    @Test
    public void testBakimDurumGuncelle() {
        bakimYonetimi.bakimDurumGuncelle(1, "Tamamlandı");
        Bakim guncellenenBakim = bakimYonetimi.bakimBul(1);
        assertEquals("Tamamlandı", guncellenenBakim.getDurum());
    }
    
    @Test
    public void testBakimZamaniGeldi() {
        Bakim gecmisBakim = bakimYonetimi.bakimBul(1); // Dünkü bakım
        Bakim bugunkuBakim = bakimYonetimi.bakimBul(3); // Bugünkü bakım
        Bakim gelecekBakim = bakimYonetimi.bakimBul(2); // 10 gün sonraki bakım
        
        assertTrue(gecmisBakim.bakimZamaniGeldiMi(), "Geçmiş tarihli bakımın zamanı gelmiş olmalı");
        assertTrue(bugunkuBakim.bakimZamaniGeldiMi(), "Bugünkü bakımın zamanı gelmiş olmalı");
        assertFalse(gelecekBakim.bakimZamaniGeldiMi(), "Gelecek tarihli bakımın zamanı henüz gelmemiş olmalı");
    }
    
    @Test
    public void testBakimZamaniGelenlerListesi() {
        List<Bakim> gelenler = bakimYonetimi.getBakimZamaniGelenler();
        assertEquals(2, gelenler.size(), "Zamanı gelen 2 bakım olmalı (dün ve bugün)");
    }
    
    @Test
    public void testAracaBagliTumBakimlar() {
        List<Bakim> arac1Bakimlar = bakimYonetimi.aracaBagliTumBakimlar(1);
        assertEquals(2, arac1Bakimlar.size(), "Araç 1'e ait 2 bakım kaydı olmalı");
        
        List<Bakim> arac3Bakimlar = bakimYonetimi.aracaBagliTumBakimlar(3);
        assertEquals(0, arac3Bakimlar.size(), "Araç 3'e ait bakım kaydı olmamalı");
    }
}