package pattern.factory;
import models.arac.Motorsiklet;
import models.arac.Otobus;
import models.arac.Traktor;
import models.arac.Kamyon;
import models.*;
public class AracFactory {
    public static Arac createArac(int id, String marka, String model, String tur,
                                   String durum, double fiyat, String renk) {

        switch (tur.toLowerCase()) {
            case "otobus":
                return new Otobus(id, marka, model, durum, fiyat, renk);
            case "motorsiklet":
                return new Motorsiklet(id, marka, model, durum, fiyat, renk);
            case "traktor":
                return new Traktor(id, marka, model, durum, fiyat, renk);
            case "kamyon":
                return new Kamyon(id, marka, model, durum, fiyat, renk);
            default:
                throw new IllegalArgumentException("Geçersiz araç türü: " + tur);
        }
    }
}
