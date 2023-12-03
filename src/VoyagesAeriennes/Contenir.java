package VoyagesAeriennes;

import Exceptions.DateVolNotFoundException;
import Exceptions.InvalidTronconException;

public class Contenir {
    private Vol vol;
    private TronconDuVol troncon;
    private DateVol date;
    public Contenir(Vol v,TronconDuVol t, DateVol date)throws InvalidTronconException, DateVolNotFoundException{
        this.vol =v;
        this.troncon =t;
        this.date = date;
        if(!this.vol.existe(date))
            throw new DateVolNotFoundException(date);
        troncon.setVol(this.vol);
        troncon.setDate(date);

        if(this.vol.tronconValide(t))
            this.vol.ajouterTroncon(t);
        
    }
    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
    }
    public TronconDuVol getTroncon() {
        return troncon;
    }
    public void setTroncon(TronconDuVol troncon) {
        this.troncon = troncon;
    }
    public DateVol getDate() {
        return date;
    }
    public void setDate(DateVol date) {
        this.date = date;
    }   
}
