package VoyagesAeriennes;

public class Partir {
    private Aeroport depart;
    private TronconDuVol troncon;
    private Vol vol;
    
    public Partir(Aeroport depart, Vol vol) {
        this.depart = depart;
        this.vol = vol;
        this.vol.setDepart(depart);
        depart.ajouterVol(vol);

    }
    public Partir(Aeroport depart, TronconDuVol troncon) {
        this.depart = depart;
        this.troncon = troncon;
        this.troncon.setDepart(depart);
    }
    
    public Aeroport getDepart() {
        return depart;
    }
    public void setDepart(Aeroport depart) {
        this.depart = depart;
    }
    public TronconDuVol getTroncon() {
        return troncon;
    }
    public void setTroncon(TronconDuVol troncon) {
        this.troncon = troncon;
    }
    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
    }
    
}
