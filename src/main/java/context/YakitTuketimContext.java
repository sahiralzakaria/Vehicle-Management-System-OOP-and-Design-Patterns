package context;

import pattern.strategy.AracYakitTuketimStratejisi;

public class YakitTuketimContext {
    private AracYakitTuketimStratejisi strateji;

    public void setStrateji(AracYakitTuketimStratejisi strateji) {
        this.strateji = strateji;
    }

    public double tuketimiHesapla(double mesafe, double ortalamaTuketim) {
        return strateji.tuketimiHesapla(mesafe, ortalamaTuketim);
    }
}
