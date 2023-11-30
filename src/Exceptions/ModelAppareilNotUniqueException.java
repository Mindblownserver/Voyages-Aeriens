package Exceptions;

public class ModelAppareilNotUniqueException extends Exception{
    public String message;
    public ModelAppareilNotUniqueException(String model){
        this.message = "Le model "+model+" n'est pas unique!";
    }
    public String toString(){
        return message;
    }
}
