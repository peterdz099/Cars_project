class Silnik extends Komponent {
    private int maxObroty;
    private int obroty;
    private boolean stanSilnika;

    public Silnik(String nazwa, int waga, int cena, int maxObroty, int obroty) {
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = obroty;
    }

    public void setObroty(int obroty) {
        this.obroty = obroty;
    }

    public Silnik(){
    }

    public int getObroty() {
        return obroty;
    }

    public void uruchom() {
        this.stanSilnika = true;
    }

    public void zatrzymaj() {
        this.stanSilnika = false;
        this.obroty = 0;
    }

    public void zwiekszObroty() {
        if( (stanSilnika ==true) && (obroty+ 200 <= this.maxObroty)) {
            this.obroty += 200;
        }
    }

    public void zmniejszObroty(){
        if((stanSilnika == true) && (obroty - 200 >= 0)){
            this.obroty -= 200;
        }
    }


}
