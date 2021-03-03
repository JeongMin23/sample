package org.techtown.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.ViewHolder> implements OnCafeClickListener{
    ArrayList<Cafe> cafeArrayList = new ArrayList<Cafe>();
    OnCafeClickListener listener; //클릭했을 때

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.cafe_list, parent, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cafe item = cafeArrayList.get(position);
        holder.setItem(item);

    }

    @Override
    public int getItemCount() {
        return cafeArrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView; //카페 이름 받아오기 위한 변수
        //TextView textView2; //가격 받아오기 위한 변수

        public ViewHolder(View itemView, final OnCafeClickListener listener){
            super(itemView);

            textView = itemView.findViewById(R.id.ctextView); //cafe_list 레이아웃 파일의 텍스트뷰
            //textView2 = itemView.findViewById(R.id.textView2); //위랑 동일

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener!=null)
                        listener.onItemClick(ViewHolder.this, view, position);
                }
            });
        }

        public void setItem(Cafe item){
            textView.setText(item.getName());
            //textView2.setText(item.getPrice());
        }
    }

    public void addItem(Cafe item){
        cafeArrayList.add(item);
    }

    public Cafe getItem(int position){
        return cafeArrayList.get(position);
    }

    public ArrayList<Cafe> getCafeHashMap() {
        return cafeArrayList;
    }

    public void setCafeHashMap(ArrayList<Cafe> cafeArrayList) {
        this.cafeArrayList = cafeArrayList;
    }
    public void setOnItemClickListener(OnCafeClickListener listener){
        this.listener = listener;
    }

    public void onItemClick(ViewHolder holder, View view, int position){
        if(listener != null){
            listener.onItemClick(holder,view,position);
        }
    }
}
