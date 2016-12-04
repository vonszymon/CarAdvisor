package car.advisor;

/**
 * Created by Janusz on 26-11-2016.
 */
public class UserPreferences {
    private String cena;
    private String pojemnoscSilnika;
    private String bagaznik;
    private String iloscMiejsc;
    private String wymiary;
    private boolean przeznaczenieMiasto;
    private boolean przeznaczenieTeren;
    private boolean przeznaczenieTrasa;
    private boolean przeznaczenieZazdroscSasiadow;
    private boolean bogateWyposazenie;
    private boolean komfortJazdy;
    private boolean niskieKosztyEksploatacji;
    private boolean wysokieOsiagi;
    private String typSilnika;
    private boolean maDuzyZasieg;

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    public void setPojemnoscSilnika(String pojemnoscSilnika) {
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public String getBagaznik() {
        return bagaznik;
    }

    public void setBagaznik(String bagaznik) {
        this.bagaznik = bagaznik;
    }

    public String getIloscMiejsc() {
        return iloscMiejsc;
    }

    public void setIloscMiejsc(String iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }

    public String getWymiary() {
        return wymiary;
    }

    public void setWymiary(String wymiary) {
        this.wymiary = wymiary;
    }

    public boolean isPrzeznaczenieMiasto() {
        return przeznaczenieMiasto;
    }

    public void setPrzeznaczenieMiasto(boolean przeznaczenieMiasto) {
        this.przeznaczenieMiasto = przeznaczenieMiasto;
    }

    public boolean isPrzeznaczenieTeren() {
        return przeznaczenieTeren;
    }

    public void setPrzeznaczenieTeren(boolean przeznaczenieTeren) {
        this.przeznaczenieTeren = przeznaczenieTeren;
    }

    public boolean isPrzeznaczenieTrasa() {
        return przeznaczenieTrasa;
    }

    public void setPrzeznaczenieTrasa(boolean przeznaczenieTrasa) {
        this.przeznaczenieTrasa = przeznaczenieTrasa;
    }

    public boolean isPrzeznaczenieZazdroscSasiadow() {
        return przeznaczenieZazdroscSasiadow;
    }

    public void setPrzeznaczenieZazdroscSasiadow(boolean przeznaczenieZazdroscSasiadow) {
        this.przeznaczenieZazdroscSasiadow = przeznaczenieZazdroscSasiadow;
    }

    public boolean isBogateWyposazenie() {
        return bogateWyposazenie;
    }

    public void setBogateWyposazenie(boolean bogateWyposazenie) {
        this.bogateWyposazenie = bogateWyposazenie;
    }

    public boolean isKomfortJazdy() {
        return komfortJazdy;
    }

    public void setKomfortJazdy(boolean komfortJazdy) {
        this.komfortJazdy = komfortJazdy;
    }

    public boolean isNiskieKosztyEksploatacji() {
        return niskieKosztyEksploatacji;
    }

    public void setNiskieKosztyEksploatacji(boolean niskieKosztyEksploatacji) {
        this.niskieKosztyEksploatacji = niskieKosztyEksploatacji;
    }

    public boolean isWysokieOsiagi() {
        return wysokieOsiagi;
    }

    public void setWysokieOsiagi(boolean wysokieOsiagi) {
        this.wysokieOsiagi = wysokieOsiagi;
    }

    public String toString() {
        return  "Cena: " + this.cena
                + "\nPojemnosc silnika: " + this.pojemnoscSilnika
                + "\nBagaznik: " + this.bagaznik
                + "\nIlosc miejsc: " + this.iloscMiejsc
                + "\nWymiary: " + this.wymiary
                + "\nPrzeznaczenie miasto: " + String.valueOf(this.przeznaczenieMiasto)
                + "\nPrzeznaczenie teren: " + String.valueOf(this.przeznaczenieTeren)
                + "\nPrzeznaczenie trasa: " + String.valueOf(this.przeznaczenieTrasa)
                + "\nPrzeznaczenie zazdrosc sasiadow: " + String.valueOf(this.przeznaczenieZazdroscSasiadow)
                + "\nBogate wyposazenie: " + String.valueOf(this.bogateWyposazenie)
                + "\nKomfort jazdy: " + String.valueOf(this.komfortJazdy)
                + "\nNiskie koszty eksploatacji: " + String.valueOf(this.niskieKosztyEksploatacji)
                + "\nWysokie osiagi: "  + String.valueOf(this.wysokieOsiagi)
                + "\nTyp silnika: " + String.valueOf(this.typSilnika)
                + "\nMa duzy zasieg" + String.valueOf(this.maDuzyZasieg);
    }

    public boolean maDuzyZasieg() {
        return maDuzyZasieg;
    }

    public void setMaDuzyZasieg(boolean maDuzyZasieg) {
        this.maDuzyZasieg = maDuzyZasieg;
    }

    public String getTypSilnika() {
        return typSilnika;
    }

    public void setTypSilnika(String typSilnika) {
        this.typSilnika = typSilnika;
    }
}
