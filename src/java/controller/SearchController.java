/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import managers.SearchManager;
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
public class SearchController {
    
    private SearchManager searchManager;
    
    @RequestMapping(value="/search", method = RequestMethod.POST)
    public ModelAndView doSearch(@RequestParam(value = "query") String query,
                                 @RequestParam(value = "location") String location,
                                 @RequestParam(value ="days") int days,
                                 @RequestParam(value ="radius") int radius,
                                 HttpServletRequest request,
                                 HttpSession session){
        
        ModelAndView mv = new ModelAndView("results");
        
        String ip = request.getHeader("X-Forwarded-For");
        
        if(ip==null){
            ip = request.getRemoteAddr();
        }
        
        String agent = request.getHeader("User-Agent");
        
        session.setAttribute("parameters", query+"#"+location+"#"+days+"#"+radius+"#"+ip+"#"+agent+"#"+0);
        
        try {
            mv.addObject("jobs", searchManager.searchIndeed(query,location,radius,days,"us",ip,agent,0));
        } catch (IOException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mv.addObject("canPrev", false);
        return mv;
    }
    
    @RequestMapping(value="/next", method = RequestMethod.GET)
    public ModelAndView nextPage(HttpSession session){
        
        ModelAndView mv = new ModelAndView("results");
        String s = (String) session.getAttribute("parameters");
        //System.out.println("SearchController TEST 64 "+s);
        String[] param = s.split("#");
        
        //System.out.println("SearchController TEST 66: "+param[6]);
        
        int days = Integer.parseInt(param[2]);
;       int radius = Integer.parseInt(param[3]);
        int startFrom = Integer.parseInt(param[6])+10;
               
        try {
            mv.addObject("jobs", searchManager.searchIndeed(param[0],param[1],days,radius,"us",param[4],param[5],startFrom));
        } catch (IOException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("parameters", param[0]+"#"+param[1]+"#"+param[2]+"#"+param[3]+"#"+param[4]+"#"+param[5]+"#"+startFrom);
        
        mv.addObject("canPrev", true);
        return mv;
    }
    
    @RequestMapping(value="/prev", method = RequestMethod.GET)
    public ModelAndView prevPage(HttpSession session){
        ModelAndView mv = new ModelAndView("results");
        String s = (String) session.getAttribute("parameters");
        String[] param = s.split("#");
        //System.out.println("Testing SearchController 91: "+param[6]);
        int days = Integer.parseInt(param[2]);
        int radius = Integer.parseInt(param[3]);
        int startFrom = Integer.parseInt(param[6])-10;
        //System.out.println("Testing SearchController 95: "+startFrom);       
        try {
            mv.addObject("jobs", searchManager.searchIndeed(param[0],param[1],days,radius,"us",param[4],param[5],startFrom));
        } catch (IOException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("parameters", param[0]+"#"+param[1]+"#"+param[2]+"#"+param[3]+"#"+param[4]+"#"+param[5]+"#"+startFrom);
        
        if(startFrom-10<0){
            mv.addObject("canPrev", false);
        }else{
            mv.addObject("canPrev", true);
        }
        return mv;
    }
    
    public SearchManager getSearchManager() {
        return searchManager;
    }

    public void setSearchManager(SearchManager searchManager) {
        this.searchManager = searchManager;
    }
    
}
