package zj.com.learnokhttp.asynchronous;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
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
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("stringPostResponse ==> onFailure" + "");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String stringResponse = response.body().string();
                System.out.println("stringPostResponse ==> " + stringResponse);
            }
        });


        //文件上传
        //        OkHttpClient okHttpClient=new OkHttpClient();
        //        File file = new File(Environment.getExternalStorageDirectory(), "test.txt");
        //        RequestBody body = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        //        RequestBody requestBody = new MultipartBody.Builder()
        //                .setType(MultipartBody.FORM)
        //                .addPart(Header对象,body)
        ////.addFormDataPart("XXX","XXX",body)
        //                .build();
        //        Request request = new Request.Builder()
        //                .url("XXXX")
        //                .post(requestBody)
        //                .build();
        //
        //        Call call = okHttpClient.newCall(request);
        //        call.enqueue(new Callback(){ });
    }
}
