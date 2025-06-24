package pattern.strategy;

public class OtobusYakitStratejisi implements AracYakitTuketimStratejisi {
    @Override
    public double tuketimiHesapla(double mesafe, double ortalamaTuketim) {
        return mesafe * ortalamaTuketim * 1.3;
    }
}
