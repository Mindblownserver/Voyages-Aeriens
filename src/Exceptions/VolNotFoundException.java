package Exceptions;

import VoyagesAeriennes.Vol;

public class VolNotFoundException extends Exception{
    public String message;
    public VolNotFoundException(Vol V){
        message = "Vol du code: "+V.getCode()+" n'existe pas";
    }
}
