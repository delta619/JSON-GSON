package hotelapp;

public class Hotel {

    private String name;
    private int id;
    private double lat;
    private double lon;
    private String address;

    Hotel(String name, int id, double lat, double lon, String address){
        this.name = name;
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }

}
