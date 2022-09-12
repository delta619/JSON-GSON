package hotelapp;

import com.google.gson.annotations.SerializedName;

import java.security.Key;

public class Hotel {

    @SerializedName("f")
    private String name;
    private String id;
    @SerializedName("ad")
    private String address;

    private LL ll;
    static class LL {
        public String lat;
        public String lng;
    }

    Hotel(String name, String id, String address){
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public LL getLL(){
        return this.ll;
    }

    public String getAddress(){
        return this.address;
    }

    @Override
    public String toString() {
        return String.join(",", this.id, this.name,this.address);
    }
}
