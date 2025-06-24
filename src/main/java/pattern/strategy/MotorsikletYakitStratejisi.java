package pattern.strategy;

public class MotorsikletYakitStratejisi implements AracYakitTuketimStratejisi {
    @Override
    public double tuketimiHesapla(double mesafe, double ortalamaTuketim) {
        return mesafe * ortalamaTuketim * 0.8;
    }
}
