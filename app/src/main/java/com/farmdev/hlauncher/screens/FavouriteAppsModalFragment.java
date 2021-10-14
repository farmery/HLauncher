package com.farmdev.hlauncher.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.farmdev.hlauncher.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

class FavouriteAppsModalFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.favourite_apps_modal,
                container, false);

        return v;
    }
}
