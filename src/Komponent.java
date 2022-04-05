public class Komponent {
    private String nazwa;
    private int waga;
    private int cena;

    public Komponent(String nazwa, int waga, int cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }
    public Komponent(){

    }


    public String getNazwa() {
        return nazwa;
    }

    public int getWaga() {
        return waga;
    }

    public int getCena() {
        return cena;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public void setWaga(int waga) {
        this.waga = waga;
    }

}
