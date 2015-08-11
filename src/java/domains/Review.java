/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

/**
 *
 * @author Sam W.
 */
public class Review {
    
    private String headline;
    private String time;
    private String jobTitle;
    private boolean currentJob;
    private String location;
    private double overall;
    private String pros;
    private String cons;

    public Review(String headline, String time, String jobTitle, boolean currentJob, String location, double overall, String pros, String cons) {
        this.headline = headline;
        this.time = time;
        this.jobTitle = jobTitle;
        this.currentJob = currentJob;
        this.location = location;
        this.overall = overall;
        this.pros = pros;
        this.cons = cons;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(boolean currentJob) {
        this.currentJob = currentJob;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }
    
}
