package VoyagesAeriennes;

import java.util.Date;

import MethodesStatiques.MethodesTableaux;

public class DateVol {
    private Date dateDepart;
    private Date dateArrive;
    private Vol voles[];
    private int capaciteVoles=-1;
    private Appareil appareils[];
    private int capaciteAppareil=-1;

    public DateVol(Date dateDepart, Date dateArrive) {
        this.dateDepart = dateDepart;
        this.dateArrive = dateArrive;
        this.capaciteVoles ++;
        this.voles = new Vol[capaciteVoles];
        this.capaciteAppareil ++;
        appareils = new Appareil[capaciteAppareil];
    }

    //getters & setters
    public Date getDateDepart() {
        return dateDepart;
    }
    
    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }
    
    public Date getDateArrive() {
        return dateArrive;
    }
    
    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Vol[] getVoles() {
        return voles;
    }

    public void setVoles(Vol[] voles) {
        this.voles = voles;
    }

    public int getCapaciteVoles() {
        return capaciteVoles;
    }

    public void setCapaciteVoles(int capaciteVoles) {
        this.capaciteVoles = capaciteVoles;
    }

    public Appareil[] getAppareils() {
        return appareils;
    }

    public void setAppareils(Appareil[] appareils) {
        this.appareils = appareils;
    }

    public int getCapaciteAppareil() {
        return capaciteAppareil;
    }

    public void setCapaciteAppareil(int capaciteAppareil) {
        this.capaciteAppareil = capaciteAppareil;
    }

    //methodes
    public boolean equals(DateVol date){
        return (date.dateArrive == this.dateArrive && dateDepart == date.dateDepart)?true:false;
    }

    public void ajouterAppareil(Appareil A){
        Appareil a[] = new Appareil[capaciteAppareil+1];
        for(int i=0;i<capaciteAppareil;i++){
            a[i] = appareils[i];
        }
        appareils[capaciteAppareil]=A;
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

    public void ajouterVol(Vol V){
        Vol v[] = new Vol[capaciteVoles+1];
        for(int i=0;i<capaciteVoles;i++){
            v[i] = voles[i];
        }
        v[capaciteVoles]=V;
        voles = v;
        capaciteVoles++;
    }

    public void supprimerVol(Vol V){
        Vol v = voles[0];
        int i=0;
        while(!V.equals(v) && i<capaciteVoles){
            i++;
            v = voles[i];
        }

        if(i<capaciteVoles){
            MethodesTableaux.decalage(voles,i,capaciteVoles);
            capaciteVoles--;
        }
        else{
            return;
        }
    }
}
