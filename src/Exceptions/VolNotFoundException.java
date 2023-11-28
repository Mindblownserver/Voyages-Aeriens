package Exceptions;

import VoyagesAeriennes.Vol;

public class VolNotFoundException extends Exception{
    public String message;
    public VolNotFoundException(Vol A){
        message = "Vol du code: "+A.getModel()+" n'existe pas";
    }
}
