package api;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DbPush {

    public static void main(String[] args) throws IOException{
        push("CVE-Example", "Testseitiger Zugriff", "420");
    }

    public static void push(String cve, String msg, String time) throws IOException{
        OkHttpClient client = new OkHttpClient();

    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, "{\n\t\"cve\": \""+cve+"\",\n\t\"msg\": \""+msg+"\",\n\t\"time\":\""+time+"\"\n}");
    Request request = new Request.Builder()
    .url("http://localhost:3000/api/users?=")
    .post(body)
    .addHeader("Content-Type", "application/json")
    .addHeader("User-Agent", "insomnia/2023.5.8")
    .build();

    Response response = client.newCall(request).execute();
    }
}
