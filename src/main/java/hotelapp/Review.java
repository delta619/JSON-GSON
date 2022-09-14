package hotelapp;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Review implements Comparable<Review> {
    private String hotelId;
    private String reviewId;
    private double ratingOverall;
    private String title;
    private String reviewText;
    private String userNickname;
    private Date reviewSubmissionTime;

    Review(String hotelId, String reviewId, double ratingOverall, String title, String reviewText, String userNickname, Date reviewSubmissionTime){
        this.hotelId = hotelId;
        this.reviewId = reviewId;
        this.ratingOverall = ratingOverall;
        this.title = title;
        this.reviewText = reviewText;
        this.userNickname = userNickname;
        this.reviewSubmissionTime = reviewSubmissionTime;
    }

    public String getReviewId(){
        return this.reviewId;
    }

    public String getHotelId(){
        return this.hotelId;
    }

    public String[] getReviewTextWords(){
        return this.reviewText.split(" ");
    }

    public Date getReviewSubmissionTime(){
        return this.reviewSubmissionTime;
    }
    @Override
    public String toString() {
        return String.join("\n\t", "\tHotel id - "+ this.getHotelId(), "Review id -"+this.getReviewId(), "Overall Rating - "+ this.ratingOverall,"Title - " + this.title,"Review text - " + this.reviewText,"Nickname - " + userNickname,"Submission time - "+this.reviewSubmissionTime);
    }

    public String getReviewText() {
        return this.reviewText;
    }


    @Override
    public int compareTo(Review o) {
        return getReviewText().compareTo(o.getReviewText());
    }
}
