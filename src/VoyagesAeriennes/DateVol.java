package VoyagesAeriennes;

import java.util.Date;

import Exceptions.AppareilNotFoundException;
import Exceptions.ValeurNotUniqueException;
import Exceptions.VolNotFoundException;
import MethodesStatiques.MethodesUniverselles;

public class DateVol implements Aviation{
    private String code;
    private static String codes[];// le dateDepart et dateArrive sont des clés primaires
    private static int tailleC=0;
    private Date dateDepart;
    private Date dateArrive;
    private Vol voles[];
    private int capaciteVoles=-1;
    private Appareil appareils[];
    private int capaciteAppareil=-1;

    public DateVol(Date dateDepart, Date dateArrive)throws ValeurNotUniqueException {
        this.code = dateDepart+"-"+dateArrive;
        if(tailleC!=0 && existe(code))
            throw new ValeurNotUniqueException(1,dateDepart+"-"+dateArrive);
        ajouterElement(dateDepart+"-"+dateArrive);
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
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    public static void ajouterElement(String code){
        String c[] = new String[tailleC+1];
        MethodesUniverselles.copierTableaux(c,codes,tailleC);
        c[tailleC] = code;
        codes = c;
        tailleC++;
    }

    public static boolean existe(String date){
        int i=0;
        while(date.compareTo(codes[i])!=0 && i<tailleC)
            i++;
        return(i>=tailleC)?false:true;
    }

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

    public void ajouterVol(Vol V){
        Vol v[] = new Vol[capaciteVoles+1];
        MethodesUniverselles.copierTableaux(v, voles, capaciteVoles);
        v[capaciteVoles]=V;
        voles = v;
        capaciteVoles++;
    }

    public void supprimerVol(Vol V)throws VolNotFoundException{
        Vol v = voles[0];
        int i=0;
        while(!V.equals(v) && i<capaciteVoles){
            i++;
            v = voles[i];
        }

        if(i<capaciteVoles){
            MethodesUniverselles.decalage(voles,i,capaciteVoles);
            capaciteVoles--;
        }
        else{
            throw new VolNotFoundException(V);
        }
    }
}
