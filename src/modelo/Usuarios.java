/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author vicec
 */
public class Usuarios {

    private int user_id;
    private String user_account;
    private String user_pass;
    private int user_type;

    public Usuarios(int user_id, String user_account, String user_pass, int user_type) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_pass = user_pass;
        this.user_type = user_type;
    }

    public Usuarios() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }
    
    
    
    
    
    
}
