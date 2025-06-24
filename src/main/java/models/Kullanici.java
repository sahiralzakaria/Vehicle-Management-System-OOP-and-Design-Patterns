package models;

/**
 * Sistem kullanıcılarını temsil eden model sınıfı.
 */
public class Kullanici {
    private int id;
    private String kullaniciAdi;
    private String sifre;
    private String rol;

    public Kullanici(int id, String kullaniciAdi, String sifre, String rol) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.rol = rol;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getKullaniciAdi() { return kullaniciAdi; }
    public void setKullaniciAdi(String kullaniciAdi) { this.kullaniciAdi = kullaniciAdi; }

    public String getSifre() { return sifre; }
    public void setSifre(String sifre) { this.sifre = sifre; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    @Override
    public String toString() {
        return String.format("Kullanici [ID=%d, Ad=%s, Rol=%s]", id, kullaniciAdi, rol);
    }
}