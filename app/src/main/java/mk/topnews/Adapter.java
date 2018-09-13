package mk.topnews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private List<NewsData> news_list;
    private Context context;


    public Adapter(List<NewsData> news_list, Context context) {
        this.news_list = news_list;
        this.context = context;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {

        NewsData newsData = news_list.get(position);

        holder.news_Title.setText(newsData.getTitle());
        holder.news_Author.setText(newsData.getAuthor());

        Picasso.with(context).load(newsData.getImageId()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return news_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ImageView imageView;
        public TextView news_Title;
        public TextView news_Author;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image);
            news_Title = (TextView) itemView.findViewById(R.id.Title);
            news_Author = (TextView) itemView.findViewById(R.id.Author);
        }
    }
}
