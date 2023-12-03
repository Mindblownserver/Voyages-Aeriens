package VoyagesAeriennes;

import Exceptions.AppareilNotFoundException;
import Exceptions.InvalidTronconException;
import MethodesStatiques.MethodesUniverselles;

// verifier l'unicité des clés primaires
public class Vol implements Aviation{
    private String code;
    private Aeroport depart;
    private Aeroport destination;
    private String typeVol;
    private TronconDuVol troncons[];
    private int capaciteTroncon=-1;
    private Appareil appareils[];
    private int capaciteAppareil=-1;
    private DateVol dates[];
    private int capaciteDates=-1;
    private double chargeUtile;

    public Vol(Aeroport depart, Aeroport destination,String typeVol,double chargeUtil) {
        code = depart.getCode()+"%20"+destination.getCode();
        this.typeVol = typeVol;
        this.chargeUtile = chargeUtil;

        this.depart = depart;
        this.destination = destination;
        
        //this.nombresEscalesMax ++;
        /* this.nombresEscales++;
        this.escales= new Aeroport[/* this.nombresEscalesMax 0];*/
        capaciteTroncon++;
        troncons = new TronconDuVol[capaciteTroncon];
        
        this.capaciteAppareil ++;
        appareils = new Appareil[capaciteAppareil];
        
        this.capaciteDates++;
        dates = new DateVol[capaciteDates];
    }
    


    public Appareil[] getAppareils() {
        return appareils;
    }

    public void setAppareils(Appareil[] appareils) {
        this.appareils = appareils;
    }
    
    public DateVol[] getDates() {
        return dates;
    }
    
    public void setDates(DateVol[] dates) {
        this.dates = dates;
    }
    
    public int getCapaciteDates() {
        return capaciteDates;
    }
    
    public void setCapaciteDates(int capaciteDates) {
        this.capaciteDates = capaciteDates;
    }
    
    public Aeroport getDepart() {
        return depart;
    }
    
    public void setDepart(Aeroport depart) {
        this.depart = depart;
    }
    
    public Aeroport getDestination() {
        return destination;
    }
    
    public void setDestination(Aeroport destination) {
        this.destination = destination;
    }
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public int getCapaciteAppareil() {
        return capaciteAppareil;
    }
    
    public void setCapaciteAppareil(int capaciteAppareil) {
        this.capaciteAppareil = capaciteAppareil;
    }
    
    public double getChargeUtile() {
        return chargeUtile;
    }
    
    public void setChargeUtile(double chargeUtile) {
        this.chargeUtile = chargeUtile;
    }
    
    public String getTypeVol() {
        return typeVol;
    }

    public void setTypeVol(String typeVol) {
        this.typeVol = typeVol;
    }

    public TronconDuVol[] getTroncons() {
        return troncons;
    }

    public void setTroncons(TronconDuVol[] troncons) {
        this.troncons = troncons;
    }

    public int getCapaciteTroncon() {
        return capaciteTroncon;
    }

    public void setCapaciteTroncon(int capaciteTroncon) {
        this.capaciteTroncon = capaciteTroncon;
    }
    
    
    // methods
    public boolean existe(DateVol date){
        int i=0;
        while(i<capaciteDates && !dates[i].equals(date))
            i++;
        return (i<capaciteDates)?true:false;
    }

    public boolean existe(Appareil appareil){
        int i=0;
        while(i<capaciteAppareil && !appareils[i].equals(appareil))
            i++;
        return (i<capaciteDates)?true:false;
    }

    public double getLongueurTotale(){
        double s=0;
        for(TronconDuVol tr: troncons)
            s+= tr.getLongueur();
        return s;
    }
    public void afficheDateDuVol(){
        System.out.println("Date de depart: "+dates[0].getDateDepart() + "\nDate d'arrive: "+dates[dates.length-1].getDateArrive());
    }
    
    public boolean equals(Vol V){
        return (V.code == this.code)?true:false;
    }
    
    public void ajouterAppareil(Appareil A){
        Appareil a[]= new Appareil[capaciteAppareil+1];
        MethodesUniverselles.copierTableaux(a,appareils,capaciteAppareil);
        a[capaciteAppareil]=A;
        appareils = a;
        capaciteAppareil++;
    }
    
    public void supprimerAppareil(Appareil A)throws AppareilNotFoundException{
        Appareil a = appareils[0];
        int i=0;
        while(!A.equals(a) && i<capaciteAppareil){
            i++;
            a = appareils[i];
        }
        if(i<capaciteAppareil){
            MethodesUniverselles.decalage(appareils,i,capaciteAppareil);
            capaciteAppareil--;
        }
        else{
            throw new AppareilNotFoundException(A);
        }
    }
    
    public void ajouterDate(DateVol date){
        DateVol d[] = new DateVol[capaciteDates+1];
        MethodesUniverselles.copierTableaux(d,dates,capaciteDates);
        d[capaciteDates] = date;
        dates = d;
        capaciteDates++;
    }
    
    public void supprimerDate(DateVol date){
        int i=0;
        DateVol d = dates[i];
        while(!d.equals(date) && i<capaciteDates){
            i++;
            d = dates[i];
        }
        if(i<capaciteDates){
            MethodesUniverselles.decalage(dates,i,capaciteDates);
            capaciteDates--;
        }
        else{
            return;
        }
    }
    
    public void supprimerTroncon(TronconDuVol t){
        int i=0;
        TronconDuVol tr = troncons[i];
        while(!t.equals(tr) && i<capaciteTroncon){
            i++;
            tr = troncons[i];
        }
        
    }
    
    public void ajouterTroncon(TronconDuVol t){
        TronconDuVol tr[]= new TronconDuVol[capaciteTroncon+1];
        MethodesUniverselles.copierTableaux(tr, troncons, capaciteTroncon);
        tr[capaciteTroncon] = t;
        troncons = tr;
        capaciteTroncon++;
    }
    
    public boolean tronconValide(TronconDuVol t)throws InvalidTronconException{
        TronconDuVol tronconPrec= troncons[capaciteTroncon-1];
        if(!t.getDepart().equals(tronconPrec.getDestination()) || /* TronconDuVol precedant doit avoir une date inferieure ou égale au nouveau troncon */ tronconPrec.getDate().getDateArrive().compareTo(t.getDate().getDateDepart())>0)
            throw new InvalidTronconException(t.getDepart(), troncons[capaciteTroncon-1].getDestination());
        return true;
    }

}
/* 
public Aeroport[] getEscales() {
    return escales;
} */
/* 
public void setEscales(Aeroport[] escales) {
    this.escales = escales;
}

public int getNombresEscales() {
    return nombresEscales;
}

public void setNombresEscales(int nombresEscales) {
    this.nombresEscales = nombresEscales;
}

public int getNombresEscalesMax() {
    return nombresEscalesMax;
}

public void setNombresEscalesMax(int nombresEscalesMax) {
    this.nombresEscalesMax = nombresEscalesMax;
}
*/