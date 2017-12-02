package com.example.anuja.ddtrial4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.service.dreams.DreamService;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by anuja on 9/22/2017.
 */

public class mainclass extends DreamService {

    TextView hourh,minh,sech,date,month, batterypercentage,digiclock,hourleft,dateup,datebelow,bighour,bigmin,bigdate,bigmon;
    Handler handler;
    Runnable runnable;
    ImageView secondhand;
    public void onAttachedToWindow(){
        //TimeChange12();
        setFullscreen(true);

        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String type=sp.getString("listkey","analogval");

        if(Objects.equals(type, "analogval")){
            setContentView(R.layout.mainlayout);
        } if(Objects.equals(type,"analogdigitalval")){

            setContentView(R.layout.listitem);
            digiclock=(TextView)findViewById(R.id.digiclocktext);
            settime1();

        } if(Objects.equals(type,"digitalanalogval")){
            setContentView(R.layout.digital2);

            hourleft=(TextView)findViewById(R.id.digitxthour);
            dateup=(TextView)findViewById(R.id.txtdate1);
            datebelow=(TextView)findViewById(R.id.txtdate2);
            settime2();

        } if(Objects.equals(type,"digitalval")){
            setContentView(R.layout.layoutfile);

            batterypercentage=(TextView)findViewById(R.id.batryper);
            hourh=(TextView)findViewById(R.id.txthour);
            minh=(TextView)findViewById(R.id.txtmin);
            sech=(TextView)findViewById(R.id.txtsec);
            date=(TextView)findViewById(R.id.txtdate);
            month=(TextView)findViewById(R.id.txtmnth);
            this.registerReceiver(this.mbroadcastreceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            settime3();

        }if(Objects.equals(type, "analogval2")){
            setContentView(R.layout.analog2);
        }if(Objects.equals(type,"analogval3")){
            setContentView(R.layout.analog3);
        }if(Objects.equals(type,"bigdigital")){
            setContentView(R.layout.digitalbig);

            bighour=(TextView)findViewById(R.id.hourdigitalbig);
            bigmin=(TextView)findViewById(R.id.mindigitalbig);
            bigdate=(TextView)findViewById(R.id.datedigitalbig);
            bigmon=(TextView)findViewById(R.id.mondigitalbig);
            settime4();
        }

    }




    private BroadcastReceiver mbroadcastreceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);

            batterypercentage.setText(String.valueOf(level)+"%");
        }
    };

    private  void settime1(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,1000);
                try{
                    Date d=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("mm",Locale.ENGLISH);
                    String currentDateTimeString = sdf.format(d);
                    digiclock.setText(currentDateTimeString);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable,0);
    }
    private  void settime2(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,1000);
                try{
                    Date d=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("hh");
                    SimpleDateFormat sdfmnth=new SimpleDateFormat("MM");
                    SimpleDateFormat sdfdate=new SimpleDateFormat("d");
                    String currentDateTimeString = sdf.format(d);
                    String currentmnth=sdfmnth.format(d);
                    String currentdate=sdfdate.format(d);
                    hourleft.setText(currentDateTimeString);
                    dateup.setText(currentdate);
                    datebelow.setText(currentmnth);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable,0);
    }
    private  void settime3(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,1000);
                try{
                    Date d=new Date();
                    SimpleDateFormat sdf1=new SimpleDateFormat("hh",Locale.ENGLISH);
                    SimpleDateFormat sdf2=new SimpleDateFormat("mm",Locale.ENGLISH);
                    SimpleDateFormat sdf3=new SimpleDateFormat("ss",Locale.ENGLISH);
                    SimpleDateFormat sdf4=new SimpleDateFormat("d",Locale.ENGLISH);
                    SimpleDateFormat sdf5=new SimpleDateFormat("MM",Locale.ENGLISH);
                    String DateTimeString1 = sdf1.format(d);
                    String DateTimeString2 = sdf2.format(d);
                    String DateTimeString3 = sdf3.format(d);
                    String DateTimeString4 = sdf4.format(d);
                    String DateTimeString5 = sdf5.format(d);

                    hourh.setText(DateTimeString1);
                    minh.setText(DateTimeString2);
                    sech.setText(DateTimeString3);
                    date.setText(DateTimeString4);
                    month.setText(DateTimeString5);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable,0);
    }
    private void settime4() {
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,1000);
                try{
                    Date d=new Date();
                    SimpleDateFormat sdf1=new SimpleDateFormat("hh",Locale.ENGLISH);
                    SimpleDateFormat sdf2=new SimpleDateFormat("mm",Locale.ENGLISH);
                    SimpleDateFormat sdf4=new SimpleDateFormat("d",Locale.ENGLISH);
                    SimpleDateFormat sdf5=new SimpleDateFormat("MM",Locale.ENGLISH);
                    String DateTimeString1 = sdf1.format(d);
                    String DateTimeString2 = sdf2.format(d);
                    String DateTimeString4 = sdf4.format(d);
                    String DateTimeString5 = sdf5.format(d);

                    bighour.setText(DateTimeString1);
                    bigmin.setText(DateTimeString2);
                    bigdate.setText(DateTimeString4);
                    bigmon.setText(DateTimeString5);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable,0);
    }

}
