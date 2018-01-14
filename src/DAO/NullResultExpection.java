package DAO;

public class NullResultExpection extends Exception{
    public NullResultExpection(){
        super();
    }
    public NullResultExpection(String message){
        super(message);
    }
}
