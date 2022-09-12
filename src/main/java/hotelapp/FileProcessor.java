package hotelapp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    public Review[] parseReviews(String reviewsFilePath){

        return null;
    }
}
