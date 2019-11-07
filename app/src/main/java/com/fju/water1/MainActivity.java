package com.fju.water1;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edNext;
    private EditText edMonth;
    private float month;
    private float next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edMonth = findViewById(R.id.month);
        edNext = findViewById(R.id.next);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    public void money(View view){


        float money = 0;
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                edMonth.setText("");
                edNext.setText("");

            }
        };

        if(edMonth.getText().toString().length()!=0){
            month = Float.parseFloat(edMonth.getText().toString());
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
                money = month * (12.075f) - 110.25f;
            }
            String message = Float.toString(money);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表费用")
                    .setMessage("费用"+message)
                    .setPositiveButton("OK",listener)
                    .show();
        }
        if(edNext.getText().toString().length()!=0){
            next = Float.parseFloat(edNext.getText().toString());
            if(next >=1&& next <=20){
                money = 0;
            }
            if (next >= 21 && next <= 60) {
                money = next * 9.45f - 42;
            }
            if (next >= 61 && next <= 100) {
                money = month * 11.55f - 168;
            }
            if (next >= 101) {
                money = month * (12.075f) - 220.5f;
            }
            String message = Float.toString(money);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("隔月抄表费用")
                    .setMessage("费用"+message)
                    .setPositiveButton("OK",listener )
                    .show();
        }
        if(edMonth.getText().toString().length()==0&&edNext.getText().toString().length()==0){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("错误")
                    .setMessage("请输入数字")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
}
