package hotelapp;


import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

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
        // FILL IN CODE:
        // Note that you are expected to create additional classes and methods
        HashMap<String, String> arg_map =  handleCommandLineArgs(args);  // arguments handled

        inputFiles(arg_map.get("-hotels"), arg_map.get("-reviews"));
        System.out.println(arg_map);


    }
    static void inputFiles(String hotelsFilePath, String reviewsFilePath){

        FileProcessor fp = new FileProcessor();

        ArrayList hotels =  fp.parseHotels(hotelsFilePath);
        System.out.println(hotels);


    }
    static HashMap<String, String> handleCommandLineArgs(String[] args){
        HashMap<String, String> arg_map = new HashMap<>();
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
}
