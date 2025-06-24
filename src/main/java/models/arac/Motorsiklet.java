package models.arac;

import models.Arac;

public class Motorsiklet extends Arac {
    public Motorsiklet(int id, String marka, String model, String durum, double fiyat, String renk) {
        super(id, marka, model, durum, fiyat, renk);
    }
    @Override
    public String getTur() {
        return "Motorsiklet";
    }
}
