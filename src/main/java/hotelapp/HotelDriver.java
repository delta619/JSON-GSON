package hotelapp;

import java.util.HashMap;

public class HotelDriver {
    private HashMap<String, Hotel> hotelMap = new HashMap<>();
    HotelDriver(Hotel[] hotels){
        this.setHotels(hotels);
    }

    public void setHotels(Hotel[] hotels){

        for(Hotel hotel: hotels){
            this.hotelMap.put(hotel.getId(), hotel);
        }
    }

    public void findHotelId(String hotelId){
        Hotel hotel = this.hotelMap.get(hotelId);
        if(hotel == null){
            System.out.println("No Hotel found with id : "+hotelId);
            return;
        }
        System.out.println("The hotel details are:\n");
        System.out.println(hotel.getName());
        System.out.println(hotel);
    }
    public void findReviews(String hotelId){

    }

    public void findWord(String word){

    }
}
