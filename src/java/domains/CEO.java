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
public class CEO {
    
    private String name;
    private String title;
    private int numOfRatings;
    private int approval;
    private String image;

    public CEO(String name, String title, int numOfRatings, int approval) {
        this.name = name;
        this.title = title;
        this.numOfRatings = numOfRatings;
        this.approval = approval;
        image = "assets//img//unavailable.jpg";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfRatings() {
        return numOfRatings;
    }

    public void setNumOfRatings(int numOfRatings) {
        this.numOfRatings = numOfRatings;
    }

    public int getApproval() {
        return approval;
    }

    public void setApproval(int approval) {
        this.approval = approval;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
