package VoyagesAeriennes;

public class Effectuer {
    private DateVol date;
    private Vol V;
    private Appareil A;
    
    public Effectuer(Vol V, Appareil A, DateVol date, double chargeUtile) {
        this.V.ajouterAppareil(A);
        this.V.ajouterDate(date);
        this.A.ajouterDate(date);
        this.A.ajouterVol(V);
        this.A.ajouterChargeUtile(chargeUtile)
        this.date.ajouterVol(V);
        this.date.ajouterAppareil(A);
    }
    public DateVol getDateVol() {
        return date;
    }
    public void setDateVol(DateVol date) {
        this.date = date;
    }
    public Vol getV() {
        return V;
    }
    public void setV(Vol v) {
        V = v;
    }
    public Appareil getA() {
        return A;
    }
    public void setA(Appareil a) {
        A = a;
    }
}
