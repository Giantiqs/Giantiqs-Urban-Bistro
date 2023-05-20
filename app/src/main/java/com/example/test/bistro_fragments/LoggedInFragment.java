package com.example.test.bistro_fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.test.bistro_activities.EditProfile;
import com.example.test.bistro_activities.HistoryActivity;
import com.example.test.bistro_activities.LoginActivity;
import com.example.test.bistro_activities.QRScanner;
import com.example.test.R;
import com.example.test.bistro_classes.bistro_adaptors.UserAdapter;

public class LoggedInFragment extends Fragment {

    Button edit_profile, qr, purchase_history, logout;
    TextView username_in, firstLetterText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view_logged_in = inflater.inflate(R.layout.bistro_logged_in, container, false);

        edit_profile = view_logged_in.findViewById(R.id.edit_profile);
        qr = view_logged_in.findViewById(R.id.qr_selection);
        purchase_history = view_logged_in.findViewById(R.id.purchase_history);
        logout = view_logged_in.findViewById(R.id.logout);
        username_in = view_logged_in.findViewById(R.id.username_logged_in);
        firstLetterText = view_logged_in.findViewById(R.id.firstLetter);

        username_in.setText(UserAdapter.userNow);

        firstLetterText.setText(String.valueOf(UserAdapter.userNow.charAt(0)));

        edit_profile.setOnClickListener(view -> startActivity(new Intent(getActivity(), EditProfile.class)));

        qr.setOnClickListener(view -> startActivity(new Intent(getActivity(), QRScanner.class)));

        purchase_history.setOnClickListener(view -> startActivity(new Intent(getActivity(), HistoryActivity.class)));

        logout.setOnClickListener(view -> {

            Toast.makeText(getActivity(), "Logging out..", Toast.LENGTH_LONG).show();

            SharedPreferences sp = requireActivity().getSharedPreferences(LoginActivity.preference_name, 0);
            SharedPreferences.Editor editor = sp.edit();

            UserAdapter.userNow = "";

            editor.putBoolean("logged_in", false);
            editor.apply();

            startActivity(new Intent(getActivity(), LoginActivity.class));
        });

        return view_logged_in;
    }

}