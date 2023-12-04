package VoyagesAeriennes;

import Exceptions.*;

public class Effectuer {
    private DateVol date;
    private Vol V;
    private Appareil A;
    
    public Effectuer(Vol V, Appareil A, DateVol date) throws ChargeUtilMaxDepasseException, CapaciteVolMaxDepasseException, InvalidValeurException{
        this.V = V;
        this.A = A;
        this.date = date;
        this.V.ajouterAppareil(A);
        if(!this.V.existe(date))
            this.V.ajouterDate(date);
        if(this.A.chargeUtileValide(V.getChargeUtile())) this.V.setChargeUtile(V.getChargeUtile());
        if(this.A.getVolParDate(date)>=this.A.getCapaciteVolesMax()) // à réviser
            throw new CapaciteVolMaxDepasseException(A);
        // ajouter les dates >= date d'aujourd'hui
        
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
