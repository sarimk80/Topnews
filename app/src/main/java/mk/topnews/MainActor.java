package mk.topnews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActor {

    private Context context;

    private List<NewsData> newsDataList;
    private Adapter adapter;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;



    public MainActor(Context context, List<NewsData> newsDataList, Adapter adapter, RecyclerView recyclerView, RequestQueue requestQueue) {
        this.context = context;
        this.newsDataList = newsDataList;
        this.adapter = adapter;
        this.recyclerView = recyclerView;
        this.requestQueue = requestQueue;
    }




    public void NewsApplication(String source1,String source2,String source3){

         String URL ="https://newsapi.org/v2/top-headlines?sources="+source1+","+source2+","+source3+"&apiKey=3209e0394c0b402cb60f1b67e490dc0a";

        requestQueue= Volley.newRequestQueue(context);


        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray=response.getJSONArray("articles");


                    for(int i=0;i<10;i++){

                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                        NewsData newsData=new NewsData(
                                jsonObject.getString("title"),
                                jsonObject.getString("author"),
                                jsonObject.getString("urlToImage")

                        );

                        newsDataList.add(newsData);
                        adapter=new Adapter(newsDataList,context);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
            requestQueue.add(jsonObjectRequest);

        }



}
