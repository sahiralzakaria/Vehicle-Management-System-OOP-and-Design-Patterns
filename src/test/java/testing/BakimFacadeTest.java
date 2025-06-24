package testing;

import models.Arac;
import models.Bakim;
import pattern.facade.BakimFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BakimFacadeTest {
    private BakimFacade bakimFacade;
    
    @BeforeEach
    public void setUp() {
        bakimFacade = new BakimFacade();
        
        // Önce araçları ekle
        bakimFacade.aracEkle(1, "Mercedes", "Travego", "otobus", "Yeni", 850000, "Gri");
        bakimFacade.aracEkle(2, "Yamaha", "R25", "motorsiklet", "Yeni", 120000, "Mavi");
        
        // Sonra bakımları ekle
        bakimFacade.bakimEkle(1, 1, "05/05/2025", "Motor yağı değişimi", "Planlandı");
        bakimFacade.bakimEkle(2, 1, "20/06/2025", "Fren bakımı", "Planlandı");
        bakimFacade.bakimEkle(3, 2, "01/05/2025", "Zincir değişimi", "Planlandı");
    }
    
    @Test
    public void testAracEklemeVeGetirme() {
        Arac arac = bakimFacade.getAracKatalog().aracBul(1);
        assertNotNull(arac);
        assertEquals("Mercedes", arac.getMarka());
        assertEquals("Travego", arac.getModel());
    }
    
    @Test
    public void testBakimEkleme() {
        // Yeni bir bakım ekle
        bakimFacade.bakimEkle(4, 2, "30/07/2025", "Yağ değişimi", "Planlandı");
        
        // Eklenen bakımı bul
        Bakim bakim = bakimFacade.getBakimYonetimi().bakimBul(4);
        assertNotNull(bakim);
        assertEquals(2, bakim.getAracId());
        assertEquals("Yağ değişimi", bakim.getAciklama());
        
        // Toplam bakım sayısını kontrol et
        assertEquals(4, bakimFacade.getBakimYonetimi().getTumBakimlar().size());
    }
    
    @Test
    public void testBakimDurumGuncelleme() {
        bakimFacade.bakimDurumGuncelle(1, "Tamamlandı");
        
        Bakim bakim = bakimFacade.getBakimYonetimi().bakimBul(1);
        assertEquals("Tamamlandı", bakim.getDurum());
    }
    
    @Test
    public void testAracaBagliTumBakimlar() {
        List<Bakim> arac1Bakimlar = bakimFacade.getBakimYonetimi().aracaBagliTumBakimlar(1);
        assertEquals(2, arac1Bakimlar.size());
    }
    
    @Test
    public void testTarihFormatiDonusumu() {
        // Tarih formatı dönüşümünü test et
        String tarihStr = "15/12/2025";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate tarih = LocalDate.parse(tarihStr, formatter);
        
        assertEquals(15, tarih.getDayOfMonth());
        assertEquals(12, tarih.getMonthValue());
        assertEquals(2025, tarih.getYear());
    }
    
    @Test
    public void testGecersizAracIcinBakimEkleme() {
        // Olmayan bir araç ID'si için bakım eklemeye çalış
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bakimFacade.bakimEkle(5, 999, "01/01/2026", "Test bakım", "Planlandı");
        });
        
        String expectedMessage = "Bu ID'ye sahip araç bulunamadı: 999";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
}