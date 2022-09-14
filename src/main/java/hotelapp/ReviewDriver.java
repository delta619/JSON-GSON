package hotelapp;

import com.sun.source.tree.Tree;

import java.util.*;

public class ReviewDriver {
    private static HashMap<String, ArrayList<Review>>hotelReviewMap = new HashMap<>();
    private static HashMap<String, Review>reviewMap = new HashMap<>();
    private static HashMap<String, TreeSet<Review>> word_to_reviews = new HashMap<>();

    ReviewDriver(){
        setUpWords();
    }
    public static void insertReviews(ArrayList<Review> reviews){
        for (Review review : reviews) {
            reviewMap.put(review.getReviewId(), review);

            if (!hotelReviewMap.containsKey(review.getHotelId())) {
                hotelReviewMap.put(review.getHotelId(), new ArrayList<>());
            }
            hotelReviewMap.get(review.getHotelId()).add(review);
        }

    }
    public static void setUpWords(){


        for (String key: reviewMap.keySet()){
            Review currReview = reviewMap.get(key);
            for (String word: currReview.getReviewTextWords()){
                if(!word_to_reviews.containsKey(word)){
                    TreeSet<Review> emptyReviewsTree = new TreeSet<Review>(new Comparator<Review>() {
                        public int compare(Review r1, Review r2)
                                {
                                    if(Helper.countWords(r1.getReviewText(), word) == Helper.countWords(r2.getReviewText(), word)){
                                        return r2.getReviewSubmissionTime().compareTo(r1.getReviewSubmissionTime());
                                    }
                                    return Helper.countWords(r2.getReviewText(), word) - Helper.countWords(r1.getReviewText(), word);
                                }
                            });
                    word_to_reviews.put(word, emptyReviewsTree);
                }
                    word_to_reviews.get(word).add(currReview);
            }
        }
    }
    public void findReviewsByHotelId(String hotelId){
        ArrayList<Review> reviews = hotelReviewMap.get(hotelId);
        reviews.sort((r1, r2)-> r2.getReviewSubmissionTime().compareTo(r1.getReviewSubmissionTime()));
            for(Review review: reviews){
                System.out.println(review);
                System.out.println("**********************");
            }
    }

    public void findWords(String word){


        for(Review review: word_to_reviews.get(word)){
            System.out.println(review);
            System.out.println("\tWord count of "+word+" - "+Helper.countWords(review.getReviewText(), word));
            System.out.println("*****************");
        }
    }

}