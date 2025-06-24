package testing;

import models.Arac;
import models.AracKatalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AracKatalogTest {
    private AracKatalog katalog;
    @BeforeEach
    public void setUp() {
        katalog = new AracKatalog();
        katalog.aracEkle(1, "Mercedes", "Travego", "otobus", "Yeni", 2500000, "Beyaz");
        katalog.aracEkle(2, "Ford", "F-Max", "kamyon", "Kullanılmış", 1800000, "Siyah");
    }
    @Test
    public void testAracEkle() {
        katalog.aracEkle(3, "John Deere", "5065E", "traktor", "Yeni", 800000, "Yeşil");
        Arac yeniArac = katalog.aracBul(3);
        assertNotNull(yeniArac);
        assertEquals(3, yeniArac.getId());
        assertEquals(3, katalog.getTumAraclar().size());
    }
    @Test
    public void testAracSil() {
        katalog.aracSil(1);
        assertNull(katalog.aracBul(1));
        assertEquals(1, katalog.getTumAraclar().size());
    }
    @Test
    public void testAracGuncelle() {
        katalog.aracSil(1);
        katalog.aracEkle(1, "Mercedes", "Travego", "otobus", "Yeni", 2700000, "Beyaz");
        Arac guncelArac = katalog.aracBul(1);
        assertNotNull(guncelArac);
        assertEquals(2700000, guncelArac.getFiyat(), 0.001);
    }
    @Test
    public void testAracGetir() {
        Arac arac = katalog.aracBul(2);
        assertNotNull(arac);
        assertEquals("Ford", arac.getMarka());
    }
}
