package Exceptions;

import VoyagesAeriennes.Appareil;

public class CapaciteVolMaxDepasseException extends Exception{
    private String message;
    public CapaciteVolMaxDepasseException(Appareil app){
        message = "la capacite maximale d'une vol de l'appareil " + app.getModel() + " est atteinte";
    }
    public String toString(){
        return message;
    }
}
