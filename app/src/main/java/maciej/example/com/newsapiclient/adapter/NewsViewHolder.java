package maciej.example.com.newsapiclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import maciej.example.com.newsapiclient.R;



public class NewsViewHolder extends RecyclerView.ViewHolder {

    public final ImageView image;
    public final TextView title;
    public final TextView content;

    public NewsViewHolder(View view) {
        super(view);
        this.image = (ImageView) view.findViewById(R.id.image);
        this.title = (TextView) view.findViewById(R.id.title);
        this.content = (TextView) view.findViewById(R.id.content);
    }
}
