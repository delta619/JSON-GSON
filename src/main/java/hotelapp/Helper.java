package hotelapp;

public class Helper {

    public static int countWords(String line, String checkWord){
        int cnt = 0;
        for(String word: line.split(" ")){
            if(word == checkWord){
                cnt++;
            }
        }
        return cnt;
    };
}


