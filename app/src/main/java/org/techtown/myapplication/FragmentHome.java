//가게 홈 화면 프래그먼트 파일

package org.techtown.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

public class FragmentHome extends Fragment {

    Button button; //버튼 객체

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_home, container, false); //뷰 객체를 정의,레이아웃 파일 인플레이션->findViewById 사용 가능하게 됨.

        button=v.findViewById(R.id.call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = "010-0000-0000";
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + num));
                startActivity(myIntent);
            }
        });

        return v;
    }


}