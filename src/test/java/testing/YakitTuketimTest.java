package testing;

import context.YakitTuketimContext;
import pattern.strategy.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class YakitTuketimTest {
    @Test
    public void kamyonTest() {
        YakitTuketimContext context = new YakitTuketimContext();
        context.setStrateji(new KamyonYakitStratejisi());
        assertEquals(45.0, context.tuketimiHesapla(120, 0.25), 0.001);
    }

    @Test
    public void otobusTest() {
        YakitTuketimContext context = new YakitTuketimContext();
        context.setStrateji(new OtobusYakitStratejisi());
        assertEquals(39.0, context.tuketimiHesapla(120, 0.25), 0.001);
    }

    @Test
    public void traktorTest() {
        YakitTuketimContext context = new YakitTuketimContext();
        context.setStrateji(new TraktorYakitStratejisi());
        assertEquals(36.0, context.tuketimiHesapla(120, 0.25), 0.001);
    }

    @Test
    public void motorsikletTest() {
        YakitTuketimContext context = new YakitTuketimContext();
        context.setStrateji(new MotorsikletYakitStratejisi());
        assertEquals(24.0, context.tuketimiHesapla(120, 0.25), 0.001);
    }
}
