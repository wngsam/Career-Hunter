/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

import java.util.ArrayList;

/**
 *
 * @author Sam W.
 */
public class User {
    
    private String email;
    private String password;
    private ArrayList<JobMin> savedJobs;
    
    public User(String email, String password){
        this.email=email;
        this.password=password;
        savedJobs = new ArrayList();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
