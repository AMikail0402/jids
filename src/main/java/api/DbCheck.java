package api;

import java.io.IOException;
import java.net.ConnectException;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DbCheck {
 

    public static boolean isAvailable() throws IOException{
        OkHttpClient client = new OkHttpClient();
      
        Request request = new Request.Builder()
        .url("http://localhost:3000/api")
        .get()
        .addHeader("Content-Type", "application/json")
        .addHeader("User-Agent", "insomnia/2023.5.8")
        .build();

          try {
            Response response = client.newCall(request).execute();
            if(response.code() == 200){
                System.out.println("Datenbankanbindung funktioniert !");
                return true;
            }
            else{
                System.out.println("Datenbankanbindung funktioniert nicht !");
                return false;
            }
        } catch (ConnectException e) {
            System.out.println("Datenbankanbindung funktioniert nicht !");
            return false;
        }
        
    }
}
