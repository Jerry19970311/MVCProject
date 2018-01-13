package bean;

import DAO.IllegalInputExpection;

public class Person{
    private String id;
    private String name;
    private String password;
    private int power;
    public Person(String id,String name,String password,int power) throws IllegalInputExpection {
        this.id=id;
        this.name=name;
        this.password=password;
        if((power!=0)&&(power!=1)&&(power!=2)) {
            throw new IllegalInputExpection("请输入合法的权限值");
        }else{
            this.power = power;
        }
    }

    public int getPower(){
        return power;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }
}
