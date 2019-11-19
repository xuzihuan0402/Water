package com.fju.water1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        float money = getIntent().getFloatExtra("FEE",-1);
        Log.d("ResultActivity",money+"");
        TextView feeView = findViewById(R.id.fee);
        int n = (int)(money + 0.5f);  //四舍五入整数
        float m = (int)((money+0.05f)*10);
        DecimalFormat df = new DecimalFormat("###0.0");
        df.setRoundingMode(RoundingMode.HALF_UP);
        feeView.setText(df.format(money) + "");
    }
}
