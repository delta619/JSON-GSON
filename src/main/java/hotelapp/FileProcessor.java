package hotelapp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

public class FileProcessor {


    public Hotel[] parseHotels(String filepath){

        Gson gson = new Gson();
        String hotelsFilePath = new File(filepath).getAbsolutePath();

        try (FileReader br = new FileReader(hotelsFilePath)) {
            JsonParser parser = new JsonParser();
            JsonObject jo = (JsonObject) parser.parse(br);
            JsonArray jsonArr = jo.getAsJsonArray("sr");
            Hotel[] hotels = gson.fromJson(jsonArr, Hotel[].class);

        return hotels;

        } catch (IOException e) {
            System.out.println("Could not read the file:" + e);

        }

     return null;
    }

    private static ArrayList<Review> reviews = new ArrayList<>();
    public static void reviewInsert(String path){
        Gson gson = new Gson();
        String hotelsFilePath = new File(path).getAbsolutePath();

        try (FileReader br = new FileReader(hotelsFilePath)) {
            JsonParser parser = new JsonParser();
            JsonObject jo = (JsonObject) parser.parse(br);
            JsonArray jsonArr = jo.getAsJsonObject("reviewDetails").getAsJsonObject("reviewCollection").getAsJsonArray("review");
            Review[] revs = gson.fromJson(jsonArr, Review[].class);
            for (Review rev: revs){
                reviews.add(rev);
            }


        } catch (IOException e) {
            System.out.println("Could not read the file:" + e);

        }

    }

    public static void findReviewFiles(String directory) {
        Path p = Paths.get(directory);
        try (DirectoryStream<Path> pathsInDir = Files.newDirectoryStream(p)) {
            for (Path path : pathsInDir) {

                if(Files.isDirectory(path)){
                    findReviewFiles(path.toString());
                }
                if (path.toString().endsWith(".json")){
                    reviewInsert(path.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Can not open directory: " + directory);
        }
    }
    public void parseReviews(String reviewPath){
        findReviewFiles(reviewPath);
        ReviewDriver.insertReviews(reviews);
    }


}
