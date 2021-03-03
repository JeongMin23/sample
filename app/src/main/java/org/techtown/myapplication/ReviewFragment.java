package org.techtown.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.myapplication.MapActivity;
import org.techtown.myapplication.R;
import org.techtown.myapplication.Review;
import org.techtown.myapplication.ReviewAdapter;
import org.techtown.myapplication.WriteActivity;

public class ReviewFragment extends Fragment {
    public static final int REQUEST_CODE_WRITE = 101;

    RecyclerView recyclerView;
    ReviewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_review, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ReviewAdapter();
        recyclerView.setAdapter(adapter);

        Button button = root.findViewById(R.id.write_review);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WriteActivity.class);

                startActivityForResult(intent, REQUEST_CODE_WRITE);
            }
        });
        return root;
    }

    //리뷰 저장
        @Override
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            //전달받은 요청코드가 보낸 요청코드와 동일할 때
            if (requestCode == REQUEST_CODE_WRITE) {
                //전달받은 응답코드 확인
                if (resultCode == Activity.RESULT_OK) {
                    //여기서 data는 Intent
                    String text = data.getStringExtra("text");//키로 값 알아냄
                    float rating = data.getFloatExtra("rating", 0);
                    String when = data.getStringExtra("date");

                    adapter.addItem(new Review(text, rating, when));
                    recyclerView.setAdapter(adapter);
                }
            }

    }
}