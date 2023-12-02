package Exceptions;

import VoyagesAeriennes.Aeroport;

public class InvalidTronconException extends Exception{
    private String message;
    public InvalidTronconException(Aeroport departNouveau, Aeroport ArriveAncien){
        message = "Tronçon invalide, l'aeroport d'arrive "+ArriveAncien.getNom()+" et l'aeroport "+departNouveau.getNom()+" ne sont pas identiques";
    }
    public String toString(){
        return message;
    }
}
