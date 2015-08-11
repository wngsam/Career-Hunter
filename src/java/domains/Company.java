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
public class Company {
    
    private String name;
    private String logo;
    private String url;
    private String industry;
    private int totalRatings;
    private double overallRating;
    
    private double culturalRating;
    private double leadershipRating;
    private double benefitsRating;
    private double careerRating;
    private double balanceRating;
    private double recommendRating;
    
    private String ratingDescription;
    
    private Review review;
    
    private CEO ceo;

    public Company(String name){
        this.name = name;
    }
    
    public Company(String name, String url, String industry, int totalRatings, double overallRating, String ratingDescription) {
        this.name = name;
        this.logo = "assets//img//unavailable.jpg";
        this.url = url;
        this.industry = industry;
        this.totalRatings = totalRatings;
        this.overallRating = overallRating;
        this.ratingDescription = ratingDescription;
    }

    public void addRatings(double culturalRating, double leadershipRating, double benefitsRating, double careerRating, double balanceRating, double recommendRating) {
        this.culturalRating = culturalRating;
        this.leadershipRating = leadershipRating;
        this.benefitsRating = benefitsRating;
        this.careerRating = careerRating;
        this.balanceRating = balanceRating;
        this.recommendRating = recommendRating;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }

    public double getCulturalRating() {
        return culturalRating;
    }

    public void setCulturalRating(double culturalRating) {
        this.culturalRating = culturalRating;
    }

    public double getLeadershipRating() {
        return leadershipRating;
    }

    public void setLeadershipRating(double leadershipRating) {
        this.leadershipRating = leadershipRating;
    }

    public double getBenefitsRating() {
        return benefitsRating;
    }

    public void setBenefitsRating(double benefitsRating) {
        this.benefitsRating = benefitsRating;
    }

    public double getCareerRating() {
        return careerRating;
    }

    public void setCareerRating(double careerRating) {
        this.careerRating = careerRating;
    }

    public double getBalanceRating() {
        return balanceRating;
    }

    public void setBalanceRating(double balanceRating) {
        this.balanceRating = balanceRating;
    }

    public double getRecommendRating() {
        return recommendRating;
    }

    public void setRecommendRating(double recommendRating) {
        this.recommendRating = recommendRating;
    }

    public String getRatingDescription() {
        return ratingDescription;
    }

    public void setRatingDescription(String ratingDescription) {
        this.ratingDescription = ratingDescription;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public CEO getCeo() {
        return ceo;
    }

    public void setCeo(CEO ceo) {
        this.ceo = ceo;
    }
    
}
