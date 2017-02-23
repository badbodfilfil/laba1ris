/**
 * Created by Algoritm on 19.02.2017.
 */
import java.io.*;
import java.util.*;

public class theatreApp{

    public String album_name(String album){

        String name= new String();
        String line;
        try{
            FileReader fr = new FileReader("E:/acts.txt");
            BufferedReader in = new BufferedReader(fr);

            while ((line=in.readLine())!=null) {
                String[] str = line.split(" ");
                if (str[1].equals(album)) {
                    name=str[0]; break;
                }
                else
                    name="Information not found";
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return name;
    }


    public String name_album(String name){
        String album= new String();
        String line;
        try{
            FileReader fr = new FileReader(  "E:/acts.txt");
            BufferedReader in = new BufferedReader(fr);
            while ((line=in.readLine())!=null){
                String[] str = line.split(" ");
                if (str[0].equals(name)){
                    album=str[1]; break;
                }
                else
                    album="Information not found";
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return album;
    }
}

