package zj.com.learnokhttp.synchronization;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Post {


    public static void main(String[] args) {

        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().build();
        RequestBody mRequestBody = new FormBody.Builder().add("start", "0").add("count", "10").build();
        Request request = new Request.Builder().url("https://api.douban.com/v2/movie/top250").post(mRequestBody).build();


        Call call = mOkHttpClient.newCall(request);
        try {
            Response response = call.execute();
            String stringResponse = response.body().string();
            System.out.println("stringPostResponse ==> " + stringResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
