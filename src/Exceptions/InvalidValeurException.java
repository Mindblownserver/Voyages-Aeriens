package Exceptions;

public class InvalidValeurException extends Exception{
    private String message;
    public InvalidValeurException(int choix,double arg){
        switch (choix) {
            case 0:// CapaciteVolMax<=0
                message = "Impossible de créer une appareil ayant le nombre maximum des voyages qu'elle peut effectuer = "+arg;
                break;
            case 1:// ChargeUtilMax < ChargeUtilMin
                message="La charge utile max que tu as saisie est < "+ arg;
                break;
            case 2: // 
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
    public String toString(){
        return "[InvalidValeurException]: "+message;
    }
}
