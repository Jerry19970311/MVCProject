package DAO;

public class IllegalInputExpection extends Exception{
    public IllegalInputExpection(){
        super();
    }
    public IllegalInputExpection(String message){
        super(message);
    }
}
