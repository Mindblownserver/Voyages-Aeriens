package VoyagesAeriennes;

import MethodesStatiques.MethodesTableaux;

public class Vol {
    private String code;
    private Aeroport depart;
    private Aeroport destination;
    private Aeroport escales[];
    private int nombresEscales=-1;
    private int nombresEscalesMax=-1;
    private Appareil appareils[];
    private int capaciteAppareil=-1;
    private DateVol dates[];
    private int capaciteDates=-1;

    public Vol(Aeroport depart, Aeroport destination) {
        code = depart+"%20"+destination;

        this.depart = depart;
        this.destination = destination;

        this.nombresEscales++;
        this.nombresEscalesMax ++;
        this.escales= new Aeroport[this.nombresEscalesMax];
        
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
    
    public Aeroport[] getEscales() {
        return escales;
    }
    
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

    // methods
    public boolean equals(Vol V){
        return (V.code == this.code)?true:false;
    }

    public void ajouterAppareil(Appareil A){
        Appareil a[]= new Appareil[capaciteAppareil+1];
        MethodesTableaux.copierTableaux(a,appareils,capaciteAppareil);
        a[capaciteAppareil]=A;
        appareils = a;
        capaciteAppareil++;
    }

    public void supprimerAppareil(Appareil A){
        Appareil a = appareils[0];
        int i=0;
        while(!A.equals(a) && i<capaciteAppareil){
            i++;
            a = appareils[i];
        }
        if(i<capaciteAppareil){
            MethodesTableaux.decalage(appareils,i,capaciteAppareil);
            capaciteAppareil--;
        }
        else{
            return;
        }
    }

    public void ajouterDate(DateVol date){
        DateVol d[] = new DateVol[capaciteDates+1];
        MethodesTableaux.copierTableaux(d,dates,capaciteDates);
        d[capaciteDates] = date;
        dates = d;
        capaciteDates++;
    }
    public void supprimerDate(DateVol date){
        int i=0;
        DateVol d = dates[0];
        while(!d.equals(date) && i<capaciteDates){
            i++;
            d = dates[i];
        }
        if(i<capaciteDates){
            MethodesTableaux.decalage(dates,i,capaciteDates);
            capaciteDates--;
        }
        else{
            return;
        }
    }
}
