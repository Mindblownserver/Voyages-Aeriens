package VoyagesAeriennes;

public class Effectuer {
    private DateVol date;
    private Vol V;
    private Appareil A;
    
    public Effectuer(Vol V, Appareil A, DateVol date, double chargeUtile) {
        this.V = V;
        this.A = A;
        this.date = date;
        this.V.ajouterAppareil(A);
        this.V.ajouterDate(date);
        if(this.A.chargeUtileValide(chargeUtile)) this.V.setChargeUtile(chargeUtile);
        this.A.ajouterDate(date);
        this.A.ajouterVol(V);
        this.date.ajouterVol(V);
        this.date.ajouterAppareil(A);
        //this.A.ajouterChargeUtile(chargeUtile);
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
