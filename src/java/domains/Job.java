/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

/**
 *
 * @author Desktop
 */
public class Job {
    
    private String title;
    private String company;
    private String country;
    private String location;
    private String source;
    private String date;
    private String snippet;
    private String url;
    private String relativeTime;
    
    private String website;
    private String industry;
    private int numberOfRatings;
    private String squareLogo;
    private double overallRating;

    public Job(String title, String company, String country, String location, String source, String date, String snippet, String url, String relativeTime) {
        this.title = title;
        this.company = company;
        this.country = country;
        this.location = location;
        this.source = source;
        this.date = date;
        this.snippet = snippet;
        this.url = url;
        this.relativeTime = relativeTime;
    }

    public void addCompanyInfo(String website, String industry, int numberOfRatings, String squareLogo, double overallRating){
        this.website = website;
        this.industry = industry;
        this.numberOfRatings = numberOfRatings;
        this.squareLogo = squareLogo;
        this.overallRating = overallRating;
    }
    
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public String getSquareLogo() {
        return squareLogo;
    }

    public void setSquareLogo(String squareLogo) {
        this.squareLogo = squareLogo;
    }

    public double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRelativeTime() {
        return relativeTime;
    }

    public void setRelativeTime(String relativeTime) {
        this.relativeTime = relativeTime;
    }
    
}
