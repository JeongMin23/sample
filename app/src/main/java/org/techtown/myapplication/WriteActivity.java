package org.techtown.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteActivity extends AppCompatActivity {
    EditText review;
    RatingBar star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        review = findViewById(R.id.text_review);
        star = findViewById(R.id.star_review);

        Button cancel = findViewById(R.id.cancel_review);
        Button save = findViewById(R.id.save_review);

        //취소
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //경고창 띄우기
                AlertDialog.Builder builder = new AlertDialog.Builder(WriteActivity.this);
                builder.setTitle("리뷰 작성 종료");
                builder.setMessage("리뷰 작성을 종료하시겠습니까?");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("아니오", null);
                builder.create().show();

            }
        });

        //저장
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //저장하기
                String text = review.getText().toString();
                float rating = star.getRating();
                long now = System.currentTimeMillis();
                Date mDate = new Date(now);
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                String getTime = simpleDate.format(mDate);

                Intent intent = new Intent();
                intent.putExtra("text", text);
                intent.putExtra("rating", rating);
                intent.putExtra("date", getTime);

                //이전 화면으로 돌아갈때 줄 값 설정
                //응답코드 -> RESULT_OK:성공, RESULT_CANCEL: 실패
                setResult(RESULT_OK, intent);

                Toast.makeText(getApplicationContext(), "리뷰가 저장되었습니다.", Toast.LENGTH_LONG).show();
                //창닫기
                finish();
            }
        });
    }
}
