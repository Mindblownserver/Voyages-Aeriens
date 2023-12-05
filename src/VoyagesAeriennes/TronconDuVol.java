package VoyagesAeriennes;

import Exceptions.ValeurNotUniqueException;

//Est-ce que j'utilise une classe differente pour décrire le Troncon du vol ou simplement met ses attributs dans la classe Vol? 
//  ajouter controle sur la date saisie, date < date d'aujourd'hui;
public class TronconDuVol implements Aviation {
    private Vol vol;
    private static int tailleC=0;
    private static String codes[];
    private String code;
    private Aeroport depart;
    private Aeroport destination;
    private DateVol date;
    private double longueur; // (en heur)
    private double carburantNecessaire; // (en litres)
    

    public TronconDuVol(double carburantNecessaire ,Aeroport depart, Aeroport destination, double longueur)throws ValeurNotUniqueException {
        /* this.vol = vol; */
        if(tailleC!=0 && existe(code))
            throw new ValeurNotUniqueException(2,depart.getCode()+"-->"+destination.getCode());
        this.code = depart.getCode()+"-->"+destination.getCode(); // a changer, incorporer depart et desnation avec le code
        this.depart = depart;
        this.destination = destination;
        /* this.date = date; */
        this.longueur = longueur;
        this.carburantNecessaire = carburantNecessaire;   
    }
    
    

    @Override
    public String toString() {
        if(this.date!= null)
            return "\n_________\nTronconDuVol "+code+": du "+ depart.getNom()+" vers "+ destination.getNom()+", de longueur "+longueur+"et necessite "+ carburantNecessaire+" littres de carburant, et depart le "+date.getDateDepart()+" vers "+date.getDateArrive(); 
        return "\n_________\nTronconDuVol "+code+": du "+ depart.getNom()+" vers "+ destination.getNom()+", de longueur "+longueur+"et necessite "+ carburantNecessaire+" littres de carburant";
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

    //methods
    public boolean existe(String code){
        int i=0;
        while(code.compareTo(codes[i])!=0 && i<tailleC)
            i++;
        return(i>=tailleC)?false:true;
    }
}
