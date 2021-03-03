//메뉴 화면 프래그먼트 파일

package org.techtown.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentMenu extends Fragment {


    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_menu, container, false); //뷰 객체를 정의,레이아웃 파일 인플레이션->findViewById 사용 가능하게 됨

        recyclerView = v.findViewById(R.id.recyclerView); //리사이클러뷰 객체


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        MenuItemAdapter adapter = new MenuItemAdapter(); //메뉴아이템 어댑터 객체

        adapter.addItem(new MenuItem("아메리카노","4,000원"));
        adapter.addItem(new MenuItem("카페라떼","4,500원"));
        adapter.addItem(new MenuItem("ㄱ","5,000원"));
        adapter.addItem(new MenuItem("ㄴ","5,000원"));
        adapter.addItem(new MenuItem("ㄷ","5,000원"));
        adapter.addItem(new MenuItem("ㄹ","5,000원"));
        adapter.addItem(new MenuItem("ㅁ","5,000원"));
        adapter.addItem(new MenuItem("ㅂ","5,000원"));
        adapter.addItem(new MenuItem("ㅅ","5,000원"));
        adapter.addItem(new MenuItem("ㅇ","5,000원"));


        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onItemClick(MenuItemAdapter.ViewHolder holder, View view, int position) {
                MenuItem item = adapter.getItem(position);
                Toast.makeText(getActivity(),"아이템 선택됨: " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}