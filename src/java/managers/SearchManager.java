/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import domains.CEO;
import domains.Company;
import domains.Job;
import domains.Review;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Sam W.
 */
public class SearchManager {
    
    private HashMap<String, Job> savedJobs;
    private HashMap<String, Company> companies;
    
    public SearchManager(){
        savedJobs = new HashMap();
        companies = new HashMap();
    }
    
    public ArrayList<Job> searchIndeed(String query, String location, int radius, int fromAge, String country, String ip, String agent, int startFrom) 
            throws MalformedURLException, IOException{
        
        query = URLEncoder.encode(query, "UTF-8");
        location = URLEncoder.encode(location, "UTF-8");
        agent = URLEncoder.encode(agent, "UTF-8");
        
        String url = "http://api.indeed.com/ads/apisearch?publisher=922281543268654&v=2&hightlight=1&format=json&"
                    + "q="+query
                    + "&l="+location
                    + "&radius="+radius
                    + "&fromage="+fromAge
                    + "&co="+country
                    + "&userip="+ip
                    + "&useragent="+agent
                    + "&start="+startFrom
                    + "&limit=10";
        
        //System.out.println("Testing in SearchManager, URL: "+url);
        
        ArrayList<Job> jobs = new ArrayList();
        
        JSONObject js = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
        
        JSONArray jsa = js.getJSONArray("results");
        
        //System.out.println("Testing in SearchNanager, JSON Length: "+jsa.length()+"\n");
        
        for(int i=0;i<jsa.length();i++){
            JSONObject temp = (JSONObject)jsa.get(i);
            
            if(temp.getBoolean("expired")==false){
                if(!savedJobs.containsKey(temp.getString("jobkey"))){
                    
                    Job newJob = new Job (
                                temp.getString("jobkey"),
                                temp.getString("jobtitle"),
                                temp.getString("country"),
                                temp.getString("formattedLocation"),
                                temp.getString("source"),
                                temp.getString("date"),
                                temp.getString("snippet"),
                                temp.getString("url"),
                                temp.getString("formattedRelativeTime"));
                    
                    if(!companies.containsKey(temp.getString("company"))){
                        Company newCompany = createCompany(temp.getString("company"), temp.getString("formattedLocation"), ip, agent);
                        companies.put(newCompany.getName(),newCompany);
                        newJob.setCompany(newCompany);
                    }else{
                        newJob.setCompany(companies.get(temp.getString("company")));
                    }
                    
                    savedJobs.put(temp.getString("jobkey"), newJob);
                    jobs.add(newJob);
                }else{
                    jobs.add(savedJobs.get(temp.getString("jobkey")));
                }
            }
        }
        
        return jobs;
    }
    
    public Company createCompany(String name, String location, String ip, String agent) throws UnsupportedEncodingException, MalformedURLException, IOException{
        Company company;
        
        String url = "http://api.glassdoor.com/api/api.htm?t.p=40246&t.k=bGUFJuNw0Vg&format=json&v=1&action=employers&ps=1"
                   + "&q="+URLEncoder.encode(name, "UTF-8")
                   + "&l="+URLEncoder.encode(location, "UTF-8")
                   + "&userip="+ip
                   + "&useragent="+agent;
        
        //System.out.println("Testing in SearchManager, Glassdoor URL: "+url);
        
        JSONArray jsa = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8"))).getJSONObject("response").getJSONArray("employers");
        
        if(jsa.length()!=0){
            JSONObject js = (JSONObject)jsa.get(0);
            
            company = new Company(
                    js.getString("name"),
                    js.getString("website"),
                    js.getString("industry"),
                    js.getInt("numberOfRatings"),
                    js.getDouble("overallRating"),
                    js.getString("ratingDescription"));
            
            if(js.getString("squareLogo").length()>0){
                company.setLogo(js.getString("squareLogo"));
            }
            
            company.addRatings(
                    js.getDouble("cultureAndValuesRating"),
                    js.getDouble("seniorLeadershipRating"),
                    js.getDouble("compensationAndBenefitsRating"),
                    js.getDouble("careerOpportunitiesRating"),
                    js.getDouble("workLifeBalanceRating"),
                    js.getDouble("recommendToFriendRating"));
            
            if(js.has("featuredReview")){
                JSONObject info = js.getJSONObject("featuredReview");
                Review review = new Review(
                    info.getString("headline"),
                    info.getString("reviewDateTime"),
                    info.getString("jobTitle"),
                    info.getBoolean("currentJob"),
                    info.getString("location"),
                    info.getDouble("overall"),
                    info.getString("pros"),
                    info.getString("cons"));
                
                company.setReview(review);
            }
            if(js.has("ceo")){
                JSONObject info = js.getJSONObject("ceo");
                CEO ceo = new CEO(
                    info.getString("name"),
                    info.getString("title"),
                    info.getInt("numberOfRatings"),
                    info.getInt("pctApprove"));
                
                if(info.has("image")){
                    ceo.setImage(info.getJSONObject("image").getString("src"));
                }
                company.setCeo(ceo);
            }
            
        }else{
            company = new Company(name);
        }
        
        //System.out.println("Testing in SearchManager, company website: "+job.getWebsite());
        
        return company;
    }
    
}
