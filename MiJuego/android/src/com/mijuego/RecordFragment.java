package com.mijuego;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecordFragment extends Fragment {

    public RecyclerView recyclerView;
    private static RecordFragment instance;

    public RecordFragment() {
        // Required empty public constructor
    }

    public static RecordFragment getInstance(){
        if(instance == null) {
            instance = new RecordFragment();
        }
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_record, container, false);
        recyclerView = v.findViewById(R.id.listaUsers);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        return v;
    }

}
