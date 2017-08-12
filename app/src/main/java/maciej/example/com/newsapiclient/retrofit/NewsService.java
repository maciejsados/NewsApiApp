package maciej.example.com.newsapiclient.retrofit;


import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class NewsService {

    private final NewsApiClient newsApiClient;

    public NewsService() {
        newsApiClient = new NewApiClientFactory().createNewsApiClient();
    }

    public List<News> getNews() throws IOException {
        Call<NewsResponse> call = newsApiClient.getNews();
        Response<NewsResponse> response = call.execute();
        return response.body().getNews();
    }
}
