package hotelapp;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
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

        HashMap<String, Boolean> stopWords = getStopWords();

        for (String key: reviewMap.keySet()){
            Review currReview = reviewMap.get(key);
            for (String word: currReview.getReviewTextWords()){
                if(stopWords.containsKey(word)){
                    continue;
                }
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
        if(!hotelReviewMap.containsKey(hotelId)){
            System.out.println("No Reviews for hotelID - "+hotelId);
            return;
        }
        ArrayList<Review> reviews = hotelReviewMap.get(hotelId);
        reviews.sort((r1, r2)-> r2.getReviewSubmissionTime().compareTo(r1.getReviewSubmissionTime()));
            for(Review review: reviews){
                System.out.println(review);
                System.out.println("**********************");
            }
    }

    public static HashMap<String, Boolean> getStopWords(){
        HashMap<String, Boolean> m = new HashMap<>();
         String WORD_FILE = "input/stop_words.txt";
        try {
            File file = new File(WORD_FILE);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (String word : line.split("\\s")) {
                    if (!word.isEmpty())
                        m.put(word, true);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return m;
    }
    public void findWords(String word){
        if(!word_to_reviews.containsKey(word)){
            System.out.println("No reviews found with word "+word);
            return;
        }

        for(Review review: word_to_reviews.get(word)){
            System.out.println(review);
            System.out.println("\tWord count of "+word+" - "+Helper.countWords(review.getReviewText(), word));
            System.out.println("*****************");
        }
    }

}