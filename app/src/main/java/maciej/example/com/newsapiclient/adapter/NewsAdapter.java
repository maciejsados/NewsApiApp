package maciej.example.com.newsapiclient.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import maciej.example.com.newsapiclient.R;
import maciej.example.com.newsapiclient.retrofit.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private final Context context;
    private final List<News> news;
    private final LayoutInflater layoutInflater;

    public NewsAdapter(Context context, List<News> news) {
        this.context = context;
        this.news = news;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.news_item_view, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News news = this.news.get(position);

        holder.title.setText(news.getTitle());
        holder.content.setText(news.getContent());

        Picasso.with(context)
                .load(news.getImageUrl())
                .fit()
                .centerCrop()
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}
