package Exceptions;

public class ChargeUtilMaxDepasseException extends Exception{
    private String message;
    public ChargeUtilMaxDepasseException(double charge){
        message = "Charge Utile Max="+charge + " est dépassée";
    }
    public String toString(){
        return message;
    }
}
