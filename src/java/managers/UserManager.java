/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import domains.User;
import java.util.HashMap;

/**
 *
 * @author Sam W.
 */
public class UserManager {
    
    private HashMap<String, User> users;
    
    public UserManager(){
        users = new HashMap();
    }
    
    public User login(String email, String password){
        User user = users.get(email);
        
        if(user!=null){
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        
        return null;
    }
    
    public Boolean register(String email, String password){
        
        if(!users.containsKey(email)){
            users.put(email, new User(email,password));
            return true;
        }
        
        return false;
    }
    
}
