package zj.com.learnokhttp.synchronization;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddHeader {

    public static void main(String[] args) {

        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().build();
        RequestBody mRequestBody = new FormBody.Builder().add("start", "0").add("count", "10").build();
        Request request = new Request.Builder().url("https://api.douban.com/v2/movie/top250").header("token", "logintoken").post(mRequestBody).build();

        System.out.println("reqstring ==> " +  request.headers().toString() + "__________" +request.header("token").toString());

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
