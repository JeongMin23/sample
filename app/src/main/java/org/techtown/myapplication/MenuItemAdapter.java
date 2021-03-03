//메뉴아이템 어댑터

package org.techtown.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.ViewHolder> implements OnMenuItemClickListener{
    ArrayList<MenuItem> items = new ArrayList<MenuItem>();
    OnMenuItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) { //뷰홀더가 새로 만들어질 때 호출->뷰 객체 생성

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.menuitem_item, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) { //뷰홀더가 재사용될 때 호출->뷰 객체는 기존 것을 사용하고 데이터만 교체
        MenuItem item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() { //어댑터에서 관리하는 아이템의 개수 반환
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView; //이름 받아오기 위한 변수
        TextView textView2; //가격 받아오기 위한 변수

        public ViewHolder(View itemView, final OnMenuItemClickListener listener){
            super(itemView);

            textView = itemView.findViewById(R.id.textView); //menuitem_item 레이아웃 파일의 텍스트뷰
            textView2 = itemView.findViewById(R.id.textView2); //위랑 동일

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(MenuItem item){
            textView.setText(item.getName());
            textView2.setText(item.getPrice());
        }
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public void setItems(ArrayList<MenuItem> items){
        this.items = items;
    }

    public MenuItem getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, MenuItem item){
        items.set(position,item);
    }

    public void setOnItemClickListener(OnMenuItemClickListener listener){
        this.listener = listener;
    }

    public void onItemClick(ViewHolder holder, View view, int position){
        if(listener != null){
            listener.onItemClick(holder,view,position);
        }
    }
}
