package VoyagesAeriennes;

public class Contenir {
    private Vol vol;
    private TronconDuVol troncon;
    public Contenir(Vol v,TronconDuVol t){
        troncon.setVol(v);
        vol.ajouterTroncon(t);
    }
}
