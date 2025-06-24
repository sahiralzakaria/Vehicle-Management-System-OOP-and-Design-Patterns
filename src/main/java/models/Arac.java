package models;
public abstract class Arac {
    private int id;
    private String marka;
    private String model;
    private String durum;
    private double fiyat;
    private String renk;
    public Arac(int id, String marka, String model, String durum, double fiyat, String renk) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.durum = durum;
        this.fiyat = fiyat;
        this.renk = renk;
    }
    public int getId() { return id; }
    public String getMarka() { return marka; }
    public String getModel() { return model; }
    public String getDurum() { return durum; }
    public double getFiyat() { return fiyat; }
    public String getRenk() { return renk; }

    public void setMarka(String marka) { this.marka = marka; }
    public void setModel(String model) { this.model = model; }
    public void setDurum(String durum) { this.durum = durum; }
    public void setFiyat(double fiyat) { this.fiyat = fiyat; }
    public void setRenk(String renk) { this.renk = renk; }

    public abstract String getTur();
    @Override
    public String toString() {
        return String.format("Arac [ID=%d, Marka=%s, Model=%s, Tür=%s, Durum=%s, Fiyat=%.2f, Renk=%s]",
                id, marka, model, getTur(), durum, fiyat, renk);
    }
}
