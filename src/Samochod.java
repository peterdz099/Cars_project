import java.lang.Math;
class Samochod extends Thread {

    private boolean stanWlaczenia;
    private String numerRejestracyjny;
    private String model;
    private int vMax;
    private double aktPredkosc;

    private Pozycja aktualnaPozycja;
    private Pozycja nowaPozycja;
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;



    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public String getModel() {
        return model;
    }
    public Pozycja getAktPozycja() {
        return aktualnaPozycja;
    }

    public int getWaga(){
        int waga = silnik.getWaga() + skrzynia.getWaga() + skrzynia.sprzeglo.getWaga();
        return waga;
    }
    public double getAktPredkosc() {
        if(aktualnaPozycja.getX() != nowaPozycja.getX()) {
            if (aktualnaPozycja.getY() != nowaPozycja.getY()) {
                double a;
                a = this.getSilnik().getObroty() * skrzynia.getAktualnePrzelozenie() * 20 / 1000;
                if (a > this.vMax) {
                    this.aktPredkosc = vMax;
                } else {
                    this.aktPredkosc = a;
                }
            }
        }else{
            this.aktPredkosc = 0;
            this.getSilnik().setObroty(0);
        }
        return aktPredkosc;
    }

    public void wlacz() {
        this.stanWlaczenia=true;
        this.silnik.uruchom();
        this.aktPredkosc = 0.0;
    }


    public void wylacz() {
        this.stanWlaczenia=false;
        this.silnik.zatrzymaj();
    }

    public void jedzDo(Pozycja poz) {
       this.nowaPozycja=poz;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public Silnik getSilnik() {
        return silnik;
    }

    @Override
    public void run() {
        while (true) {
            aktualnaPozycja.przemiesc(getAktPredkosc(), 200, nowaPozycja);
            //pitStop();
            try {
                sleep(20);
            } catch (InterruptedException e) {
                return;
                }
            }

        }
    @Override
    public String toString() {
        return numerRejestracyjny;
    }

    public Samochod(boolean stanWlaczenia, String numerRejestracyjny, String model, int vmax) {
        this.stanWlaczenia = stanWlaczenia;
        this.numerRejestracyjny = numerRejestracyjny;
        this.model = model;
        this.aktPredkosc = 0;
        this.vMax = vmax;
        this.aktualnaPozycja = new Pozycja(0,0);
        this.nowaPozycja = new Pozycja(0,0);
        this.silnik = new Silnik("Diesel",600,10000,8000,0);
        this.skrzynia = new SkrzyniaBiegow("Manulana 6-bigowa",400,10000,0,6);
        start();
    }
    public Samochod(){
        this.stanWlaczenia = false;
        this.numerRejestracyjny = "";
        this.model = "";
        this.aktPredkosc = 0;
        this.vMax = 0;
        this.aktualnaPozycja = new Pozycja(0,0);
        this.nowaPozycja = new Pozycja(0,0);
        this.silnik = new Silnik();
        this.skrzynia = new SkrzyniaBiegow();
    }
}
