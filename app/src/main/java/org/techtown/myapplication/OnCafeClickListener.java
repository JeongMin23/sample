package org.techtown.myapplication;

import android.view.View;

interface OnCafeClickListener {
    public void onItemClick(CafeAdapter.ViewHolder holder, View view, int position);
}
