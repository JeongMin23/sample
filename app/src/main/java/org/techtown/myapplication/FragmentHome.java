//가게 홈 화면 프래그먼트 파일

package org.techtown.myapplication;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class FragmentHome extends Fragment {

    Cafe cafe;
    Button callButton; //전화버튼 객체

    public FragmentHome(Cafe cafe){
        this.cafe = cafe;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_home, container, false); //뷰 객체를 정의,레이아웃 파일 인플레이션->findViewById 사용 가능하게 됨.

        callButton=v.findViewById(R.id.call);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = cafe.tel;
                Intent callIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + tel));
                startActivity(callIntent);
            }
        });

        TextView addressView = v.findViewById(R.id.address);
        addressView.setText(cafe.address);

        TextView etcView = v.findViewById(R.id.etc);
        etcView.setText(cafe.etc);

        TextView linkView = v.findViewById(R.id.link);
        linkView.setText(cafe.link);
        return v;
    }


    //주소변환 함수
//    public String toAddress(double lat, double lon){
//        Geocoder geocoder = new Geocoder(getContext());
//        List<Address> list = null;
//        try {
//            list = geocoder.getFromLocation(lat, lon, 10);
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.e("test", "입출력 오류 - 서버에서 주소변환시 에러발생");
//        }
//        if (list!=null) {
//            if (list.size() == 0)
//                return "해당 주소 없음";
//            else
//                return list.get(0).toString();
//        }
//        return "오류입니다.";
//    }


}