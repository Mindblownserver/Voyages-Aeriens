package VoyagesAeriennes;
import java.util.Date;

public class TarifLocal {
    private Date date;
    private double valeur; // en dollars par kilo
    
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
