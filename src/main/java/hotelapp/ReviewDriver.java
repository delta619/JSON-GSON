package hotelapp;

import java.util.ArrayList;
import java.util.HashMap;

public class ReviewDriver {
    private static HashMap<String, ArrayList<Review>>reviewMap = new HashMap<>();

    public static void insertReviews(ArrayList<Review> reviews){

        for (Review review : reviews) {
            if (!reviewMap.containsKey(review.getHotelId())) {
                reviewMap.put(review.getHotelId(), new ArrayList<>());
            }
            reviewMap.get(review.getHotelId()).add(review);
        }

    }

    public void findReviewsByHotelId(String hotelId){
        ArrayList<Review> reviews = reviewMap.get(hotelId);
            for(Review review: reviews){
                System.out.println(review);
            }
    }


}
