package com.aladar.ektenviroment;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class ScanFragment extends Fragment {

    public static TextView urlTV;
    Button scanBTN;

    //public static  TextView urlTV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View view =  inflater.inflate(R.layout.fragment_scan,container,false);
        urlTV = (TextView)view.findViewById(R.id.urlRES);
       Button scanBTN = (Button)view.findViewById(R.id.ScanBTN);
        scanBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),ScanAct.class));
            }
        });


        return view;
    }
}
