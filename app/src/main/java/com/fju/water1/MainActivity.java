package com.fju.water1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText edMonth;
    private float month;
    Boolean isNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Log.d(TAG,"onCreate");
        setSupportActionBar(toolbar);
        edMonth = findViewById(R.id.month);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money();
            }
        });
        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.type);
                text.setText(isNext ? getString(R.string.every_other_month ) : getString(R.string.monthly));
            }
        });

        //Spinner
        Spinner cities = findViewById(R.id.spinner);
        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,getResources().getStringArray(R.array.cities)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void money(){
        float money = 0;
//        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                edMonth.setText("");
//
//            }
//        };

        if(edMonth.getText().toString().length()!=0){
            month = Float.parseFloat(edMonth.getText().toString());
            if(isNext == false){

            if(month >=1&& month <=10){
                money = month * 7.35f;
            }
            if (month >= 11 && month <= 30) {
                money = month * 9.45f - 21;
            }
            if (month >= 31 && month <= 50) {
                money = month * 11.55f - 84;
            }
            if (month >= 51) {
                money = month * 12.075f - 110.25f;
            }
            }else if(isNext == true){
                if(month >=1&& month <=20){
                money = month * 7.35f;
            }
            if (month >= 21 && month <= 60) {
                money = month * 9.45f - 42;
            }
            if (month >= 61 && month <= 100) {
                money = month * 11.55f - 168;
            }
            if (month >= 101) {
                money = month * 12.075f - 220.5f;
            }
            }
            Intent intent = new Intent(this,ResultActivity.class);
            intent.putExtra(getString(R.string.extra_fee), money);
            startActivity(intent);

//            new AlertDialog.Builder(MainActivity.this)
//                    .setTitle("每月抄表费用")
//                    .setMessage("费用"+money)
//                    .setPositiveButton("OK",listener)
//                    .show();
        }
//        if(edNext.getText().toString().length()!=0){
//            next = Float.parseFloat(edNext.getText().toString());
//            if(next >=1&& next <=20){
//                money = 0;
//            }
//            if (next >= 21 && next <= 60) {
//                money = next * 9.45f - 42;
//            }
//            if (next >= 61 && next <= 100) {
//                money = next * 11.55f - 168;
//            }
//            if (next >= 101) {
//                money = next * 12.075f - 220.5f;
//            }
////            new AlertDialog.Builder(MainActivity.this)
////                    .setTitle("隔月抄表费用")
////                    .setMessage(getString(R.string.fee)+money)
////                    .setPositiveButton(getString(R.string.ok),listener )
////                    .show();
//        }
//        if(edMonth.getText().toString().length()==0&&edNext.getText().toString().length()==0){
//            new AlertDialog.Builder(this)
//                    .setTitle("错误")
//                    .setMessage("请输入数字")
//                    .setPositiveButton("OK",null)
//                    .show();
//        }
    }
}
