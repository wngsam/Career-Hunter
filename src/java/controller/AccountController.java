/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domains.User;
import javax.servlet.http.HttpSession;
import managers.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam W.
 */

@Controller
public class AccountController {
    
    private UserManager userManager;
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password){
        
        ModelAndView mv = new ModelAndView("index");
        
        if(userManager.register(email, password)){
            mv.addObject("register", true);
        }else{
            mv.addObject("register", false);
        }
        
        return mv;
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "email") String email,
                              @RequestParam(value = "password") String password,
                              HttpSession session){
        
        ModelAndView mv = new ModelAndView("index");
        
        User user = userManager.login(email, password);
        
        if(user!=null){
            session.setAttribute("currentUser", user);
        }else{
            mv.addObject("login", false);
        }
        
        return mv;
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session){
        
        session.removeAttribute("currentUser");
        
        return new ModelAndView("index");
    }
    
    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
}
