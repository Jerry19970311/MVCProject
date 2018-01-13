package handler;

public class LoginErrorExpection extends Exception{
    public LoginErrorExpection(String str){
        super(str);
    }
    public LoginErrorExpection(){}
}
