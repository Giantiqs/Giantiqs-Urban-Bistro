package com.example.test.bistro_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.test.bistro_activities.ContactUs;
import com.example.test.bistro_activities.FaqsActivity;
import com.example.test.R;

public class HelpFragment extends Fragment {

    Button contactUs, faqs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view_help = inflater.inflate(R.layout.bistro_help, container, false);

        contactUs = view_help.findViewById(R.id.contactUs);
        faqs = view_help.findViewById(R.id.faq);

        contactUs.setOnClickListener(view -> startActivity(new Intent(getActivity(), ContactUs.class)));

        faqs.setOnClickListener(view -> startActivity(new Intent(getActivity(), FaqsActivity.class)));

        return view_help;
    }

}