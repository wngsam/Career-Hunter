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
import managers.SearchManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Desktop
 */

@Controller
public class SearchController {
    
    private SearchManager searchManager;
    
    @RequestMapping(value="/search", method = RequestMethod.POST)
    public ModelAndView doSearch(@RequestParam(value = "query") String query,
                                 @RequestParam(value = "location") String location,
                                 @RequestParam(value ="days") int days,
                                 @RequestParam(value ="radius") int radius,
                                 HttpServletRequest request){
        
        ModelAndView mv = new ModelAndView("results");
        
        String ip = request.getHeader("X-Forwarded-For");
        
        if(ip==null){
            ip = request.getRemoteAddr();
        }
        
        String agent = request.getHeader("User-Agent");
        
        try {
            mv.addObject("jobs", searchManager.searchIndeed(query,location,radius,days,"us",ip,agent));
        } catch (IOException ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
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
