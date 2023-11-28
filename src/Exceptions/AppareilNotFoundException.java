package Exceptions;

import VoyagesAeriennes.Appareil;

public class AppareilNotFoundException extends Exception{
    public String message;
    public AppareilNotFoundException(Appareil A){
        message = "Appareil model: "+A.getModel()+" n'existe pas";
    }
}
