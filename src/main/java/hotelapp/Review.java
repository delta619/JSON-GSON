package hotelapp;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Review {
    private String hotelId;
    private String reviewId;
    private int ratingOverall;
    private String title;
    private String reviewText;
    private String userNickname;
    private String reviewSubmissionTime;

    Review(String hotelId, String reviewId, int ratingOverall, String title, String reviewText, String userNickname, String reviewSubmissionTime){
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


    @Override
    public String toString() {
        return String.join(",", this.getReviewId(), this.getHotelId(), this.title);
    }
}
