package maciej.example.com.newsapiclient.asyncTask;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import maciej.example.com.newsapiclient.retrofit.News;
import maciej.example.com.newsapiclient.retrofit.NewsService;


public class GetNewsAsyncTask extends AsyncTask<Void, Void, List<News>> {

    private final NewsService newsService;
    private final NewsDownloadedListener newsDownloadedListener;

    public GetNewsAsyncTask(NewsDownloadedListener newsDownloadedListener) {
        newsService = new NewsService();
        this.newsDownloadedListener = newsDownloadedListener;
    }



    @Override
    protected List<News> doInBackground(Void... voids) {
        try {
            return newsService.getNews();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<News> newses) {
        newsDownloadedListener.onNewsDownloaded(newses);
    }

    public interface NewsDownloadedListener {
        void onNewsDownloaded(List<News> news);
    }
}
