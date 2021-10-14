package com.farmdev.hlauncher.screens.allapps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.farmdev.hlauncher.R;
import com.farmdev.hlauncher.models.AppInfo;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AllAppsFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AppListAdapter appListAdapter;
    TextView dateTimeDisplay;
    TextView dayDisplay;
    Calendar calendar;
    String dateFormat;
    String dayFormat;
    String date;
    ArrayList<AppInfo> appList;

    void getAppList(Context c){
        appList = new ArrayList<>();
        PackageManager pm = c.getPackageManager();
        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> allApps = pm.queryIntentActivities(i, 0);
        for (ResolveInfo ri : allApps
        ) {
            AppInfo appInfo = new AppInfo();
            appInfo.setIcon(ri.loadIcon(pm));
            appInfo.setLabel(ri.loadLabel(pm).toString());
            appInfo.setPackageName(ri.activityInfo.packageName);
            appList.add(appInfo);
        }

        Log.d("TAG", "getAppList: list loaded");
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.all_apps_fragment, container, false);

        getAppList(requireContext());

        recyclerView = viewGroup.findViewById(R.id.app_list);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        appListAdapter = new AppListAdapter(appList, getContext());

        //get current datetime
        calendar = Calendar.getInstance();
        dateTimeDisplay = viewGroup.findViewById(R.id.date);
        dayDisplay = viewGroup.findViewById(R.id.day);
        dateFormat = new SimpleDateFormat("d MMM, yyyy").format(calendar.getTime());
        dayFormat = new SimpleDateFormat("EEEE").format(calendar.getTime());

        //set time to time view
        dayDisplay.setText(dayFormat + ", ");
        dateTimeDisplay.setText(dateFormat);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(appListAdapter);
        recyclerView.setHasFixedSize(false);

        return viewGroup;
    }
}
