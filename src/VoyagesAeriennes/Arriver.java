package VoyagesAeriennes;

import Exceptions.InvalidValeurException;

public class Arriver {
    private Vol V;
    private Aeroport Arrive;
    private TronconDuVol tr;

    public Arriver(Vol V, Aeroport Arrive) throws InvalidValeurException{
        this.V = V;
        this.Arrive = Arrive;
        if(!Arrive.getCode().equals(V.getDestination().getCode()))
            throw new InvalidValeurException(0,Arrive.getNom(),V.getDepart().getNom());
        Arrive.ajouterVolArrive(V);
    }
    public Vol getV() {
        return V;
    }
    public void setV(Vol v) {
        V = v;
    }
    public Aeroport getArrive() {
        return Arrive;
    }
    public void setArrive(Aeroport arrive) {
        Arrive = arrive;
    }
    public TronconDuVol getTr() {
        return tr;
    }
    public void setTr(TronconDuVol tr) {
        this.tr = tr;
    }
    
}
