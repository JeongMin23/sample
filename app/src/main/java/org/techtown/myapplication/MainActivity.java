//메인 소스파일

package org.techtown.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MAP = 102;
    public static final int REQUEST_CODE_CAFE = 201;

    RecyclerView recyclerView;
    HashMap<Integer, Cafe> hm = new HashMap<Integer,Cafe>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //지도보기
        Button map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);

                startActivityForResult(intent, REQUEST_CODE_MAP);
            }
        });

        openData();
        recyclerView=findViewById(R.id.recyclerView_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        CafeAdapter adapter = new CafeAdapter();

        Iterator<Map.Entry<Integer, Cafe>> iter = hm.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Integer,Cafe> entry = iter.next();
            adapter.addItem(entry.getValue());
        }
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnCafeClickListener() {
            @Override
            public void onItemClick(CafeAdapter.ViewHolder holder, View view, int position) {
                Cafe item = adapter.getItem(position);

                Intent intent = new Intent(getApplicationContext(), CafeActivity.class);
                intent.putExtra("cafe", item);

                startActivityForResult(intent, REQUEST_CODE_CAFE);
            }
        } );
    }

    public void openData(){
        InputStream input = getResources().openRawResource(R.raw.cafe);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(input,"EUC-KR"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        while (true){
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(line==null)
                break;
            String arr[] = line.split(";");
            int id = Integer.parseInt(arr[0]);

            Cafe cafe = new Cafe(id, arr[1],arr[2],arr[3], arr[4],arr[5]);
            hm.put(id,cafe);
        }
    }
}