package com.example.android.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private List<Map<String, String>> mData;
    private SimpleAdapter mAdapter;
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

        for(int i= 0; i< 100; i++) {
            Map<String, String> data= new HashMap<>();

            data.put("item", "Item "+ i);
            data.put("subitem", "Sub Item "+ i);

            mData.add(data);
        }
    }

    private void initAdapter() {
        mAdapter= new SimpleAdapter(this, mData,
                android.R.layout.simple_list_item_2,
                new String[] {"item", "subitem"},
                new int[] {android.R.id.text1, android.R.id.text2});

    }

    private void initListView() {
        ListView mListView= (ListView)findViewById(R.id.List_view);
        mListView.setAdapter(mAdapter);
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
