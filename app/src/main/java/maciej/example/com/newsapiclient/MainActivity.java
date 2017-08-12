package maciej.example.com.newsapiclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import maciej.example.com.newsapiclient.adapter.NewsAdapter;
import maciej.example.com.newsapiclient.asyncTask.GetNewsAsyncTask;
import maciej.example.com.newsapiclient.retrofit.News;

public class MainActivity extends AppCompatActivity implements GetNewsAsyncTask.NewsDownloadedListener{


    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_news);

        new GetNewsAsyncTask(this).execute();
    }

    @Override
    public void onNewsDownloaded(List<News> news) {
        if (news == null) {
            Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Downloaded: " + news.size(), Toast.LENGTH_SHORT).show();

        NewsAdapter adapter = new NewsAdapter(this, news);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
