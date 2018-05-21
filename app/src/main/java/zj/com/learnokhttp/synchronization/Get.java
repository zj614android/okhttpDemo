package zj.com.learnokhttp.synchronization;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Get {

    public static void main(String[] args) {

        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("https://api.douban.com/v2/movie/top250?start=0&count=10").build();


        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
            String stringResponse = response.body().string();
            System.out.println("stringGetResponse ==> " + stringResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
