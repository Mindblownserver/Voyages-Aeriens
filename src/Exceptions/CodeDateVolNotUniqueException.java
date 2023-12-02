package Exceptions;

public class CodeDateVolNotUniqueException extends Exception {
    public String message;
    public CodeDateVolNotUniqueException(String d){
        message = "La date "+d+" n'est pas unique";
    }
    public String toString(){
        return message;
    }
}
