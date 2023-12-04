package Exceptions;
import java.util.Date;

public class InvalidValeurException extends Exception{
    private String message;
    public InvalidValeurException(int choix,String code,double arg){
        switch (choix) {
            case 0:// CapaciteVolMax<=0
                message = "Impossible de créer l'appareil "+code+" car le nombre maximum des voyages qu'elle peut effectuer = "+arg;
                break;
            case 1:// ChargeUtilMax < ChargeUtilMin
                message="La charge utile max de l'appareil "+code+" est < "+ arg;
                break;
            default:
                break;
        }
        
    }
    public InvalidValeurException(int choix){
        switch (choix) {
            case 0:// DateVol invalide
                message="La date du vol choisie est < aujourd'hui";
                break;
            default:
                break;
        }
        
    }
    public InvalidValeurException(int choix, Date depart, Date arrive){
        switch (choix) {
            case 0:// DateVol depart > arrive invalide
                message="La date de depart "+ depart+" est > date d'arrive "+ arrive;
                break;
            case 1:
                message = "La date d'arrive"+depart+" est > date d'arrive "+arrive;
            default:
                break;
        }
        
    }
    public InvalidValeurException(int choix, String depart, String arrive){
        switch (choix) {
            case 0:// DateVol depart > arrive invalide
                message="L'aeroport: "+ depart+" n'est pas l'aeroport de depart: "+ arrive;
                break;
            case 1:
                message="L'aeroport: "+ depart+" n'est pas l'aeroport d'arrivé: "+ arrive;
                break;
            default:
                break;
        }
        
    }
    public String toString(){
        return "[InvalidValeurException]: "+message;
    }
}
