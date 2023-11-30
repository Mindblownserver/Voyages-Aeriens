package VoyagesAeriennes;

//Est-ce que j'utilise une classe differente pour décrire le Troncon du vol ou simplement met ses attributs dans la classe Vol? 

public class TronconDuVol {
    private Vol vol;
    private String code;
    private Aeroport depart;
    private Aeroport destination;
    private DateVol date;
    private double longueur; // (en heur)
    private double carburantNecessaire; // (en litres)
    

    public TronconDuVol(Vol vol, String code,double carburantNecessaire ,Aeroport depart, Aeroport destination, DateVol date, double longueur) {
        this.vol = vol;
        this.code = depart.getCode()+"%20"+destination.getCode(); // a changer, incorporer depart et desnation avec le code
        this.depart = depart;
        this.destination = destination;
        this.date = date;
        this.longueur = longueur;
        this.carburantNecessaire = carburantNecessaire;   
    }

    
    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Aeroport getDepart() {
        return depart;
    }
    public void setDepart(Aeroport depart) {
        this.depart = depart;
    }
    public Aeroport getDestination() {
        return destination;
    }
    public void setDestination(Aeroport destination) {
        this.destination = destination;
    }
    public DateVol getDate() {
        return date;
    }
    public void setDate(DateVol date) {
        this.date = date;
    }
    public double getLongueur() {
        return longueur;
    }
    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }
    // methods
    public boolean equals(TronconDuVol t){
        return (depart.getCode() == t.depart.getCode() && destination.getCode() == destination.getCode() && date.equals(t.date))? true:false;
    }


    public double getCarburantNecessaire() {
        return carburantNecessaire;
    }


    public void setCarburantNecessaire(double carburantNecessaire) {
        this.carburantNecessaire = carburantNecessaire;
    }

}
