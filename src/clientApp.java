/**
 * Created by Algoritm on 19.02.2017.
 */
import org.apache.axis.client.Service;
import org.apache.axis.client.Call;
import javax.xml.rpc.ServiceException;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class clientApp {
    public static final String findName="1";
    public static final String findDate="2";
    public static final String exit="3";
    private static final String MESSAGE  = "The play: %s. Time of play : %s";
    public static void main(String[] args) throws ServiceException, MalformedURLException {
        String endpoint = "http://localhost:8082/axis/theatreApp.jws";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));
        System.out.println("1 - Enter name of play");
        System.out.println("2 - Enter the date of play");
        System.out.println("3 - Exit");

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = in.readLine();

            while (!exit.equals(line)) {
                if (exit.equals(line)) break;
                if (findName.equals(line)) {
                    String name = in.readLine();
                    Object[] param1 = new Object[]{name};
                    String response = (String) call.invoke("name_album", param1);
                    System.out.println(String.format(MESSAGE, name, response));
                }
                if (findDate.equals(line)) {
                    String date = in.readLine();
                    Object[] param2 = new Object[]{date};
                    String response = (String) call.invoke("album_name", param2);
                    System.out.println(String.format(MESSAGE, response, date));
                };
                System.out.println("1 -Enter name of play");
                System.out.println("2 - Enter the date of play");
                System.out.println("3 - Exit");
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}