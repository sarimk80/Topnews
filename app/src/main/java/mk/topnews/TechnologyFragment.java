package mk.topnews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TechnologyFragment extends Fragment {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<NewsData> newsDataList;

    private RequestQueue requestQueue;

    MainActor mainActor;


    public TechnologyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_technology, container, false);

        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        newsDataList=new ArrayList<>();

        mainActor=new MainActor(getContext(),newsDataList,adapter,recyclerView,requestQueue);

        mainActor.NewsApplication("crypto-coins-news","engadget","hacker-news");

        return view;
    }

}
