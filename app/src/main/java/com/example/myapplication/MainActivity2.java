package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    private int[] btnId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        tv1.setOnClickListener(onClickListener);
        tv2.setOnClickListener(onClickListener);
        tv3.setOnClickListener(onClickListener);

        btnId = new int[]{tv1.getId(), tv2.getId(), tv3.getId()};

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onClickCommon(view);
        }
    };

    private void onClickCommon(View view){
        switch (view.getId()){
            case R.id.tv1:
            case R.id.tv2:
            case R.id.tv3:{
                setBtnColor(view.getId());
                break;
            }
        }
    }

    private void setBtnColor(int viewId){

        int index = 0;
        switch (viewId){
            case R.id.tv1:{
                index = 0;

                if(!Arrays.asList(btnId).contains(viewId)){
                    tv1.setBackgroundColor(Color.parseColor("#996449"));
                    tv1.setTextColor(Color.parseColor("#ffffff"));

                }else{
                    tv1.setBackgroundColor(Color.parseColor("#ffffff"));
                    tv1.setTextColor(Color.parseColor("#757575"));
                }
                break;
            }
            case R.id.tv2:{
                index = 1;

                if(!Arrays.asList(btnId).contains(viewId)){
                    tv2.setBackgroundColor(Color.parseColor("#996449"));
                    tv2.setTextColor(Color.parseColor("#ffffff"));

                }else{
                    tv2.setBackgroundColor(Color.parseColor("#ffffff"));
                    tv2.setTextColor(Color.parseColor("#757575"));
                }
                break;
            }
            case R.id.tv3:{
                index = 2;
                if(!Arrays.asList(btnId).contains(viewId)){ // true
                    tv3.setBackgroundColor(Color.parseColor("#996449"));
                    tv3.setTextColor(Color.parseColor("#ffffff"));

                }else{ // false
                    tv3.setBackgroundColor(Color.parseColor("#ffffff"));
                    tv3.setTextColor(Color.parseColor("#757575"));
                }
                break;
            }
        }

        if(!Arrays.asList(btnId).contains(viewId)){
            btnId[index] = viewId;
        }else{
            for(int i = index; i < btnId.length-1; i++){
                btnId[i] = btnId[i+1];
            }
        }





    }




}