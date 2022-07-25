package com.example.emergencyservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;

public class Blood extends AppCompatActivity {
    ListView listView;
    String[] bloodDonar;
    String[] phoneNumber;
    String[] bloodGroup;
    CustomAdapter adapter;
    int[] boy = {R.drawable.boy, R.drawable.boy, R.drawable.boy, R.drawable.boy,
            R.drawable.boy, R.drawable.boy, R.drawable.boy, R.drawable.boy, R.drawable.boy, R.drawable.boy,
            R.drawable.boy, R.drawable.boy
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);

        this.setTitle("Blood");

        bloodDonar = getResources().getStringArray(R.array.blood_donar);
        phoneNumber = getResources().getStringArray(R.array.phoneNumber);
        bloodGroup = getResources().getStringArray(R.array.blood_group);
        listView = findViewById(R.id.listViewId);
        CustomAdapter adapter = new CustomAdapter(this, bloodDonar, boy, phoneNumber, bloodGroup);
        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);

        MenuItem menuItem = menu.findItem(R.id.searchViewId);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query)
            {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


}

