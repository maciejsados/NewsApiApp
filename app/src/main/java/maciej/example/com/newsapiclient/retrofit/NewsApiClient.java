package maciej.example.com.newsapiclient.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface NewsApiClient {


    @GET("/plugin/test.news")
    @Headers("X-BAASBOX-APPCODE: 1234567890")
    Call<NewsResponse> getNews();

}
