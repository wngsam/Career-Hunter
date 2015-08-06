/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import domains.Job;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Desktop
 */
public class SearchManager {
    
    public ArrayList<Job> searchIndeed(String query, String location, int radius, int fromAge, String country, String ip, String agent) 
            throws MalformedURLException, IOException{
        
        query = URLEncoder.encode(query, "UTF-8");
        location = URLEncoder.encode(location, "UTF-8");
        agent = URLEncoder.encode(agent, "UTF-8");
        
        String url = "http://api.indeed.com/ads/apisearch?publisher=922281543268654&v=2&hightlight=1&latlong=1&format=json&"
                    + "q="+query
                    + "&l="+location
                    + "&radius="+radius
                    + "&fromage="+fromAge
                    + "&co="+country
                    + "&userip="+ip
                    + "&useragent="+agent;
        
        //System.out.println("Testing in SearchManager, URL: "+url);
        
        ArrayList<Job> jobs = new ArrayList();
        
        JSONObject js = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
        
        JSONArray jsa = js.getJSONArray("results");
        
        //System.out.println("Testing in SearchNanager, JSON Length: "+jsa.length()+"\n");
        
        for(int i=0;i<jsa.length();i++){
            JSONObject temp = (JSONObject)jsa.get(i);
            
            if(temp.getBoolean("expired")==false){
                
                jobs.add(addCompanyInfo(new Job(temp.getString("jobtitle"),
                                 temp.getString("company"),
                                 temp.getString("country"),
                                 temp.getString("formattedLocation"),
                                 temp.getString("source"),
                                 temp.getString("date"),
                                 temp.getString("snippet"),
                                 temp.getString("url"),
                                 temp.getString("formattedRelativeTime")) , ip, agent));
                
            }
        }
        
        return jobs;
    }
    
    public Job addCompanyInfo(Job job, String ip, String agent) throws UnsupportedEncodingException, MalformedURLException, IOException{
        
        String url = "http://api.glassdoor.com/api/api.htm?t.p=40246&t.k=bGUFJuNw0Vg&format=json&v=1&action=employers&ps=1"
                   + "&q="+URLEncoder.encode(job.getCompany(), "UTF-8")
                   + "&l="+URLEncoder.encode(job.getLocation(), "UTF-8")
                   + "&userip="+ip
                   + "&useragent="+agent;
        System.out.println("Testing in SearchManager, Glassdoor URL: "+url);
        
        JSONArray jsa = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8"))).getJSONObject("response").getJSONArray("employers");
        
        if(jsa.length()!=0){
            JSONObject js = (JSONObject)jsa.get(0);
            job.addCompanyInfo(js.getString("website"),js.getString("industry"),js.getInt("numberOfRatings"),js.getString("squareLogo"),js.getDouble("overallRating"));
        }
        
        System.out.println("Testing in SearchManager, company website: "+job.getWebsite());
        
        return job;
    }
    
}
