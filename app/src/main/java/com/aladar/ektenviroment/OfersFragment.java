package com.aladar.ektenviroment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.List;

import static android.widget.Toast.makeText;

//import static com.aladar.ektenviroment.RetrofitClient.getRetrofitInstance;

public class OfersFragment extends Fragment {

    public  MyAdapter myAdapter;
    public RecyclerView myRecyclerView;
    View view;
    GetData service;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //return inflater.inflate(R.layout.fragment_ofers,container,false);

        view =  inflater.inflate(R.layout.fragment_ofers,container,false);


        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

        Call<List<RetroUsers>> call = service.getAllUsers();

        call.enqueue(new Callback<List<RetroUsers>>() {
            @Override
            public void onResponse(Call<List<RetroUsers>> call, Response<List<RetroUsers>> response) {
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroUsers>> call, Throwable t) {
                Toast.makeText(getContext(),"No furulo",Toast.LENGTH_SHORT).show();

            }
        });


        return  view;

    }

    private void loadDataList(List<RetroUsers> usersList) {

//Get a reference to the RecyclerView//

        myRecyclerView = view.findViewById(R.id.myRecyclerview);
        myAdapter = new MyAdapter(usersList);

//Use a LinearLayoutManager with default vertical orientation//

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        myRecyclerView.setLayoutManager(layoutManager);

//Set the Adapter to the RecyclerView//

        myRecyclerView.setAdapter(myAdapter);
    }

}
