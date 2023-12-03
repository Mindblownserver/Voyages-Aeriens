package VoyagesAeriennes;

import java.util.Date;

public class TarifLocal {
    private Date date;
    private double valeur; // en dollars par kilo
    public TarifLocal(Date date,double valeur){
        this.date = date;
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "dans la date " + date + ", la valeur=" + valeur + " dollars/littre du carburant";
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public double getValeur() {
        return valeur;
    }
    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    
}
