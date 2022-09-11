package hotelapp;

import java.time.LocalDate;

public class Review {
    private int hotelId;
    private String reviewId;
    private double ratingOverall;
    private String title;
    private String reviewText;
    private String userNickname;
    private LocalDate postDate;

    Review(int hotelId, String reviewId, double ratingOverall, String title, String reviewText, String userNickname, LocalDate postDate){
        this.hotelId = hotelId;
        this.reviewId = reviewId;
        this.ratingOverall = ratingOverall;
        this.title = title;
        this.reviewText = reviewText;
        this.userNickname = userNickname;
        this.postDate = postDate;
    }

}
