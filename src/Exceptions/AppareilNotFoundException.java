package Exceptions;

import VoyagesAeriennes.Appareil;

public class AppareilNotFoundException extends Exception{
    public String message;
    public AppareilNotFoundException(Appareil A){
        message = "Appareil model: "+A.getCode()+" n'existe pas";
    }
    @Override
    public String toString() {
        return "AppareilNotFoundException [message=" + message + "]";
    }
}