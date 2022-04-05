public class Sprzeglo extends Komponent {
    private boolean stanSprzegla;

    public Sprzeglo(String nazwa, int waga, int cena, boolean stanSprzegla) {
        super(nazwa,waga, cena);
        this.stanSprzegla = stanSprzegla;
    }

    public Sprzeglo(){

    }


    public void wcisnij() {
        this.stanSprzegla=true;
    }

    public void zwolnij() {
        this.stanSprzegla=false;
    }

    public boolean isStanSprzegla() {
        return stanSprzegla;
    }
}
