package model;

public class Usuario {
    private int user_id;
    private String name;
    private String email;
    private int edad;

    public Usuario(String name, String email, int edad) {
        this.name = name;
        this.email = email;
        this.edad = edad;
    }

    public Usuario(int user_id, String name, String email, int edad){
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.edad = edad;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public int getEdad(){
        return edad;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    //Sobrecarga de constructor setter y getter
    public int getUser_id(){
        return user_id;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }
}
