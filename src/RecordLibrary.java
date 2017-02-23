import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo Z on 18.02.2017.
 */
public class RecordLibrary {
    HashMap<String, String> albums=new HashMap<>();
    public RecordLibrary(){
        String line;
        try{
            FileReader fr = new FileReader("E:/albums.txt");
            BufferedReader in = new BufferedReader(fr);
            while ((line=in.readLine())!=null) {
                String[] str = line.split(" ");
                albums.put(str[0],str[1]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public String searchByAlbum(String album) throws IOException {
        for(Map.Entry<String,String> pair: albums.entrySet()){
            if(pair.getValue().equals(album)){
                return pair.getKey();
            }
        }
        return "Album is not exist!";
    }
    public String searchBySinger(String singer) throws IOException {
        for(Map.Entry<String,String> pair: albums.entrySet()){
            if(pair.getKey().equals(singer)){
                return pair.getValue();
            }
        }
        return "Singer is not exist!";
    }
}
