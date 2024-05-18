package TalianskeZadanie2023;

public class Vespa {

    private static class Uzol {
        int hodnota;
        Uzol dalsi;
    }

    private Uzol prvy = null;

    public void pridajNaZaciatok(int hodnota) {
        Uzol pridavany = new Uzol();
        pridavany.hodnota = hodnota;
        pridavany.dalsi = prvy;
        prvy = pridavany;
    }

    @Override
    public String toString() {
        String vysledok = "[";
        Uzol aktualny = prvy;
        while (aktualny != null) {
            if (aktualny != prvy)
                vysledok += ", ";

            vysledok += aktualny.hodnota;
            aktualny = aktualny.dalsi;
        }
        return vysledok + "]";
    }

    public void pridajVespu(int rocnik) {

        Uzol aktualny = prvy;
        boolean bolaVlozena = false;
        if (aktualny.hodnota > rocnik) {
            Uzol novy = new Uzol();
            novy.hodnota = rocnik;
            novy.dalsi = aktualny;
            prvy = novy;
            bolaVlozena = true;
        }

        while (aktualny.dalsi != null) {
            if(bolaVlozena){
                return;
            }
            if (aktualny.dalsi.hodnota > rocnik && aktualny.hodnota < rocnik) {
                Uzol novy = new Uzol();
                novy.hodnota = rocnik;
                novy.dalsi = aktualny.dalsi;
                aktualny.dalsi = novy;
                bolaVlozena = true;
            }
            aktualny = aktualny.dalsi;
        }
        Uzol novy = new Uzol();
        novy.hodnota = rocnik;
        aktualny.dalsi = novy;
    }

    public static void main(String[] args) {
        Vespa v = new Vespa();
        v.pridajNaZaciatok(1993);
        v.pridajNaZaciatok(1992);
        v.pridajNaZaciatok(1990);
        v.pridajNaZaciatok(1830);
        v.pridajNaZaciatok(1810);
        v.pridajNaZaciatok(1800);
        v.pridajVespu(1994);
    }
}
