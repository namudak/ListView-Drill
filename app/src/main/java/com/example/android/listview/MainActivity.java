package com.example.android.listview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<People> mData;
    private CustomAdapter mAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        initAdapter();

        initListView();
    }

    private void initData() {
        mData= new ArrayList<>();

        for(int i= 0; i< 50; i++) {
            mData.add(new People("Richard"+ i, "010-6288-256"+ i, R.drawable.justjava));
        }
        for(int i= 0; i< 50; i++) {
            mData.add(new People("Sunny"+ i, "010-4564-567"+ i, R.mipmap.ic_launcher));
        }
    }

    private void initAdapter() {
        mAdapter= new CustomAdapter(getApplicationContext(), mData);

    }

    private void initListView() {
        ListView mListView= (ListView)findViewById(R.id.List_view);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Position : "+ position, Toast.LENGTH_SHORT).show();

                Intent intent= new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:"+ mData.get(position).getPhoneNumber()));

                startActivity(intent);
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
}
