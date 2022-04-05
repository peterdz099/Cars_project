public class SkrzyniaBiegow extends Komponent {
    private int aktualnyBieg;
    private int iloscBiegow;
    private double aktualnePrzelozenie;

    Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, int waga, int cena, int aktualnyBieg, int iloscBiegow) {
        super(nazwa, waga, cena);
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;
        this.aktualnePrzelozenie = aktualnePrzelozenie;
        this.sprzeglo =  new Sprzeglo("Standardowe sprzeglo",100,500,false);
    }
    public SkrzyniaBiegow(){
        sprzeglo = new Sprzeglo();
    }

    public void setIloscBiegow(int iloscBiegow) {
        this.iloscBiegow = iloscBiegow;
    }

    public int getAktualnyBieg() {
        return aktualnyBieg;
    }


    public double getAktualnePrzelozenie() {
        switch (aktualnyBieg){
            case 1:
                this.aktualnePrzelozenie = 1.2;
                break;
            case 2:
                this.aktualnePrzelozenie = 1.5;
                break;
            case 3:
                this.aktualnePrzelozenie = 1.8;
                break;
            case 4:
                this.aktualnePrzelozenie = 2.1;
                break;
            case 5:
                this.aktualnePrzelozenie = 2.4;
                break;
            case 6:
                this.aktualnePrzelozenie = 2.8;
                break;
        }
        return aktualnePrzelozenie;
    }


    public void zwiekszBieg(){
        if((sprzeglo.isStanSprzegla() == true) && (this.aktualnyBieg < this.iloscBiegow)) {
            this.aktualnyBieg = aktualnyBieg + 1;
            sprzeglo.zwolnij();
        }
    }

    public void zmniejszBieg() {
        if (sprzeglo.isStanSprzegla() == true && (this.aktualnyBieg >= 1)) {
            this.aktualnyBieg = aktualnyBieg - 1;
            sprzeglo.zwolnij();
        }
    }
}
