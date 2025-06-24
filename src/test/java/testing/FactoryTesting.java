package testing;

import models.Arac;
import pattern.factory.AracFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryTesting {
    @Test
    public void testAracFactory() {
        Arac arac = AracFactory.createArac(1, "Toyota", "Travego", "otobus", "Yeni", 2500000, "Beyaz");
        assertNotNull(arac);
        assertEquals("Toyota", arac.getMarka());
        assertEquals("Travego", arac.getModel());
        assertEquals("Otobüs", arac.getTur());
        assertEquals(2500000, arac.getFiyat(), 0.001);
    }
}
