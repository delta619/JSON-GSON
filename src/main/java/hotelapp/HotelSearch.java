package hotelapp;


import java.util.HashMap;
import java.util.Map;

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
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(arg_map);

    }


}
