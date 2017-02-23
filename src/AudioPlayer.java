import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.rpc.ServiceException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Lenovo Z on 18.02.2017.
 */
public class AudioPlayer {
    public static void main(String[] args) throws ServiceException, MalformedURLException {
        String endpoint = "http://localhost:8082/axis/RecordLibrary.jws";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));
        System.out.println("1 - enter the singer");
        System.out.println("2 - enter the album");
        System.out.println("3 - exit");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            line = in.readLine();
            while (!line.equals("3")) {
                if (line.equals("3")) break;
                if (line.equals("1")) {
                    String singer = in.readLine();
                    Object[] param1 = new Object[]{singer};
                    String response = (String) call.invoke("searchBySinger", param1);
                    System.out.println("SINGER:" + singer + "\n" + "ALBUM:" + response);
                    if (line.equals("2")) {
                        String album = in.readLine();
                        Object[] param2 = new Object[]{album};
                        String response1 = (String) call.invoke("searchByAlbum", param2);
                        System.out.println("SINGER:" + response1 + "\n" + "ALBUM:" + album);
                    }
                    System.out.println("1 - enter the singer");
                    System.out.println("2 - enter the album");
                    System.out.println("3 - exit");
                    line = in.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}