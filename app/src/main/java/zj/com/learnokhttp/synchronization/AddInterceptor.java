package zj.com.learnokhttp.synchronization;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AddInterceptor {

    public static void main(String[] args) {

        /*************************************************核心代码***********************************************/
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                String url = request.url().toString();

                System.out.println("Interceptor url == " + url);

                return chain.proceed(request);
            }
        };

        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).addNetworkInterceptor(interceptor).build();
        /*************************************************核心代码***********************************************/
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
