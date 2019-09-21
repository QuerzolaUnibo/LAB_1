package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.R.drawable;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ListView myList;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myList = (ListView) findViewById(R.id.listView);

        List<ListItem> items = new ArrayList<>();
        Intent intent = getIntent();

        if (intent.getBooleanExtra("flag", true)){

            items.add(new ListItem("Jack", R.drawable.ic_3d_rotation_black_48dp,"Mathematics, Chemistry"));
            items.add(new ListItem("Jane", R.drawable.ic_announcement_black_48dp,"Physics, Informatics"));
            items.add(new ListItem("Bob", R.drawable.ic_alarm_black_48dp,"Mathematics, Informatics"));
            items.add(new ListItem("Clara", R.drawable.ic_account_box_black_48dp,"Geography, Chemistry"));
            items.add(new ListItem("Sam", R.drawable.ic_accessibility_black_48dp,"Mathematics, Physics"));

        }else{

            items.add(new ListItem("Mathematics", R.drawable.ic_3d_rotation_black_48dp,"Mathematics is the study of topics suchas quantity, structure, space and change."));
            items.add(new ListItem("Physics", R.drawable.ic_announcement_black_48dp,"Physics is the natural science that involves the study of matter and its motion through space and time, along with related concepts such as energy and force."));
            items.add(new ListItem("Chemistry", R.drawable.ic_alarm_black_48dp,"Chemistry is a branch of physical science that studies the composition, structure, properties and change of matter."));
            items.add(new ListItem("Informatics", R.drawable.ic_account_box_black_48dp,"Informatics is the science of information and computer information systems."));
            items.add(new ListItem("Geography", R.drawable.ic_accessibility_black_48dp,"Geography is a field of science devoted to the study of the lands, the features, the inhabitants and the phenomena of Earth."));

        }

        adapter = new ListAdapter(this, items);
        myList.setAdapter(adapter);

    }
}
