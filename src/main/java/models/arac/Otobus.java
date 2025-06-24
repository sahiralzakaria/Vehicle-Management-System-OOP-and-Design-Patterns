package models.arac;

import models.Arac;

public class Otobus extends Arac {
    public Otobus(int id, String marka, String model, String durum, double fiyat, String renk) {
        super(id, marka, model, durum, fiyat, renk);
    }
    @Override
    public String getTur() {
        return "Otobüs";
    }
}
