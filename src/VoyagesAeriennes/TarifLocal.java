package VoyagesAeriennes;

import java.util.Date;

public class TarifLocal implements Aviation{
    private Date date;
    private String code;
    private double valeur; // en dollars par kilo
    public TarifLocal(Date date,double valeur){
        this.code = "dans la date " + date + ", la valeur est" + valeur + " dollars/littre du carburant";
        this.date = date;
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "TarifLocal: dans la date " + date + ", la valeur est" + valeur + " dollars/littre du carburant";
    }
    public String getCode(){
        return code;
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
