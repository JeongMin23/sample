//음료 클릭했을 때 동작을 위한 인터페이스 파일

package org.techtown.myapplication;

import android.view.View;

public interface OnMenuItemClickListener {
    public void onItemClick(MenuItemAdapter.ViewHolder holder, View view, int position);
}
