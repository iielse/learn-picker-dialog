package com.example.android.pickerdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.android.dialog.picker.DataPickerDialog;
import com.example.android.dialog.picker.DatePickerDialog;
import com.example.android.dialog.picker.RegionPickerDialog;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogDate();
            }
        });

        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogRegion();
            }
        });
    }

    private final void showDialog() {
        DataPickerDialog.Builder builder = new DataPickerDialog.Builder(this);
        List<String> data = Arrays.asList(new String[]{"a", "b", "c", "d", "e", "f", "g", "h"});

        DataPickerDialog dialog = builder.setUnit("单位").setData(data).setSelection(1).setTitle("标题")
                .setOnDataSelectedListener(new DataPickerDialog.OnDataSelectedListener() {
                    @Override
                    public void onDataSelected(String itemValue) {
                        Toast.makeText(getApplicationContext(), itemValue, Toast.LENGTH_SHORT).show();
                    }
                }).create();

        dialog.show();
    }

    private final void showDialogDate() {
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(this);

        DatePickerDialog dialog = builder.setOnDateSelectedListener(new DatePickerDialog.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int[] dates) {
                Toast.makeText(getApplicationContext(), dates[0] + "#" + dates[1] + "#" + dates[2], Toast.LENGTH_SHORT).show();
            }
        }).create();

        dialog.show();
    }

    private final void showDialogRegion() {
        RegionPickerDialog.Builder builder = new RegionPickerDialog.Builder(this);

        RegionPickerDialog dialog = builder.setOnRegionSelectedListener(new RegionPickerDialog.OnRegionSelectedListener() {
            @Override
            public void onRegionSelected(String[] cityAndArea) {
                Toast.makeText(getApplicationContext(), cityAndArea[0] + "#" + cityAndArea[1], Toast.LENGTH_SHORT).show();
            }
        }).create();

        dialog.show();
    }

}
