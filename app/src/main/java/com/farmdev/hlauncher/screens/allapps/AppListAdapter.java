package com.farmdev.hlauncher.screens.allapps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.farmdev.hlauncher.R;
import com.farmdev.hlauncher.models.AppInfo;

import java.util.ArrayList;
import java.util.List;

class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppListViewHolder> {
    ArrayList<AppInfo> appList;

    public AppListAdapter(ArrayList<AppInfo> appList, Context c) {
            this.appList = appList;
    }

    @NonNull

    @Override
    public AppListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item, parent, false);
        return new AppListViewHolder(v, appList);
    }

    @Override
    public void onBindViewHolder(@NonNull AppListAdapter.AppListViewHolder holder, int position) {
        holder.icon.setImageDrawable(appList.get(position).getIcon());
        holder.label.setText(appList.get(position).getLabel());
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public static class AppListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView label;
        ImageView icon;
        ArrayList<AppInfo> appList;

        public AppListViewHolder(@NonNull View itemView, ArrayList<AppInfo> list) {
            super(itemView);
            label = itemView.findViewById(R.id.app_label);
            icon = itemView.findViewById(R.id.app_icon);
            appList = list;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent launchAppIntent = view.getContext().getPackageManager().getLaunchIntentForPackage(appList.get(getAdapterPosition()).getPackageName());
            view.getContext().startActivity(launchAppIntent);
        }
    }
}
