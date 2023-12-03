package Exceptions;

public class ValeurNotUniqueException extends Exception{
    private String message;
    public ValeurNotUniqueException(int choix, String arg){
        switch (choix) {
            case 0:// appareil n'est pas unique
                this.message = "Le model "+arg+" n'est pas unique!";
                break;
            case 1:// DateVol n'est pas unique
                message = "La date "+arg+" n'est pas unique";
                break;
            case 2:
                message = "La tronçon "+ arg+" n'est pas unique";
                break;
            default:
                break;
        }
    }
    public String toString(){
        return "[ValeurNotUniqueException]: "+message;
    }
}
