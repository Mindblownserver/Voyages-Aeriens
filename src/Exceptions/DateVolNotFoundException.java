package Exceptions;

import VoyagesAeriennes.DateVol;
import VoyagesAeriennes.Vol;

public class DateVolNotFoundException extends Exception {
    public String message;
    public DateVolNotFoundException(DateVol DV){
        message = "Il n'y a pas du vol dans les dates: "+DV.getDateArrive()+" et "+DV.getDateDepart()+ " n'existe pas";
    }
    public String toString(){
        return message;
    }
}
