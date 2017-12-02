package com.example.anuja.ddtrial4;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView img1,img2,img3,img4;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.butn);
        btn.setOnClickListener(this);
        /*img1=(ImageView)findViewById(R.id.image1);
        img2=(ImageView)findViewById(R.id.image2);
        img3=(ImageView)findViewById(R.id.image3);
        img4=(ImageView)findViewById(R.id.image4);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);*/

    }

    public void onClick(View v){
        Intent intent=new Intent(Settings.ACTION_DREAM_SETTINGS);
        startActivity(intent);
    }
    /*public void onClick(View v){
        switch (v.getId()){
            case R.id.image1:

                Toast.makeText(MainActivity.this, "image1 clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.image2:
                Toast.makeText(MainActivity.this, "image2 clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.image3:
                Toast.makeText(MainActivity.this, "image3 clicked", Toast.LENGTH_LONG).show();
                break;
            case R.id.image4:
                Toast.makeText(MainActivity.this, "image4 clicked", Toast.LENGTH_LONG).show();
                break;

        }
    }*/


}
