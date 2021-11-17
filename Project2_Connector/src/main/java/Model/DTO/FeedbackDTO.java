/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DTO;



import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Do_Do
 */
public class FeedbackDTO implements Serializable{
    private int FeedBackId;
    private int UserId;
    private Date FeedBackDate;
    private String Content;
    private String Description;

    public FeedbackDTO() {
    }

    public FeedbackDTO(int FeedBackId, int UserId, Date FeedBackDate, String Content, String Description) {
        this.FeedBackId = FeedBackId;
        this.UserId = UserId;
        this.FeedBackDate = FeedBackDate;
        this.Content = Content;
        this.Description = Description;
    }

    public int getFeedBackId() {
        return FeedBackId;
    }

    public int getUserId() {
        return UserId;
    }

    public Date getFeedBackDate() {
        return FeedBackDate;
    }

    public String getContent() {
        return Content;
    }

    public String getDescription() {
        return Description;
    }

    public void setFeedBackId(int FeedBackId) {
        this.FeedBackId = FeedBackId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public void setFeedBackDate(Date FeedBackDate) {
        this.FeedBackDate = FeedBackDate;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}
