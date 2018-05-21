package zj.com.learnokhttp.asynchronous;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Get {

    public static void main(String[] args) {

        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("https://api.douban.com/v2/movie/top250?start=0&count=10").build();


        Call call = mOkHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("stringGetResponse ==> onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String stringResponse = response.body().string();
                System.out.println("stringGetResponse ==> " + stringResponse);
            }
        });


    }
}
