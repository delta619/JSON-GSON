package hotelapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** The main class for project 1.
 * The main function should take the following 4 command line arguments:
 * -hotels hotelFile -reviews reviewsDirectory
 *
 * and read general information about the hotels from the hotelFile (a JSON file)
 * and read hotel reviews from the json files in reviewsDirectory.
 * The data should be loaded into data structures that allow efficient search.
 * See the pdf description for details.
 *
 * You are expected to add other classes and methods to this project.
 */
public class HotelSearch {


    public static void main(String[] args) {

        Map<String, String> arg_map =  handleCommandLineArgs(args);  // arguments handled

        FileProcessor fp = new FileProcessor();
        Hotel[] hotels = fp.parseHotels(arg_map.get("-hotels"));
        HotelHandler hotelHandler = new HotelHandler(hotels);
        ArrayList<Review> reviews = fp.parseReviews(arg_map.get("-reviews"));
        ReviewHandler reviewHandler = new ReviewHandler(reviews);

        processUserQueries(hotelHandler, reviewHandler);

    }


    static Map<String, String> handleCommandLineArgs(String[] args){
        Map<String, String> arg_map = new HashMap<>();
        try {
            for (int i = 0; i < args.length; i += 2) {
                if (args[i].startsWith("-")) {
                    arg_map.put(args[i], args[i + 1]);
                }
            }
            if(arg_map.get("-hotels") ==null || arg_map.get("-reviews")==null){
                throw new Exception("Some error occurred") ;
            }
        }catch (Exception e){
            System.out.println("Invalid arguments, please try again.");
        }
        return arg_map;
    }

    public static void processUserQueries(HotelHandler hotelHandler, ReviewHandler reviewHandler){
        try{
            Scanner sc = new Scanner(System.in);
            do{
                System.out.println("\nPlease enter any of the below instructions.\nfind <hotelID>, findReviews <hotelID>, findWord <word>  or press Q to quit.");
                String[] instruction = sc.nextLine().split(" ");
                if(instruction.length == 2){
                    switch (instruction[0]){
                        case "f":
                            System.out.println(hotelHandler.findHotelId(instruction[1]));
                            break;
                        case "r":
                            reviewHandler.findReviewsByHotelId(instruction[1]);
                            break;
                        case "w":
                            reviewHandler.findWords(instruction[1]);
                            break;
                        default:
                            System.out.println("Please enter a valid instruction.");
                    }
                }else {
                    if(instruction.length == 1 && instruction[0].toLowerCase().equals("q")){
                        System.out.println("Good bye.");
                        return;
                    }
                    System.out.println("Please enter a valid instruction.");
                }
            }while(true);
        } catch (Exception e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

}
