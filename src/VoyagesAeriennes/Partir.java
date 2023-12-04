package VoyagesAeriennes;

import Exceptions.InvalidValeurException;

public class Partir {
    private Aeroport depart;
    private TronconDuVol troncon;
    private Vol vol;
    
    public Partir(Aeroport depart, Vol vol)throws InvalidValeurException {
        this.depart = depart;
        this.vol = vol;
        if(!depart.getCode().equals(vol.getDepart().getCode()))
            throw new InvalidValeurException(0,depart.getNom(),vol.getDepart().getNom());
        depart.ajouterVolDeparts(vol);

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
