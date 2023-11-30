package VoyagesAeriennes;

public class Arriver {
    private Vol V;
    private Aeroport Arrive;
    private TronconDuVol tr;

    public Arriver(Vol V, Aeroport Arrive){
        this.V = V;
        V.setDestination(Arrive);
        this.Arrive = Arrive;
        Arrive.ajouterVolArrive(V);
    }
    public Arriver(TronconDuVol tr, Aeroport Arrive){
        tr.setDestination(Arrive);
        this.tr = tr;
        this.Arrive = Arrive;
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
