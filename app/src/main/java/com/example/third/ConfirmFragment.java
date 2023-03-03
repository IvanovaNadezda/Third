package com.example.third;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.third.databinding.FragmentConfirmBinding;
import com.example.third.databinding.FragmentConfirmBinding;

public class ConfirmFragment extends Fragment {
    private static String TAG = "tag";
    FragmentManager fragmentManager;
    FragmentConfirmBinding binding;
    com.example.third.MainActivity mainActivity;
    public ConfirmFragment(){
        super(R.layout.fragment_confirm);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (com.example.third.MainActivity) context;
        Log.d(TAG, "onAttach");
        Toast toast = Toast.makeText(getContext(), "onAttach", Toast.LENGTH_LONG );
        toast.show();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getParentFragmentManager();
        Toast toast = Toast.makeText(getContext(), "onCreate", Toast.LENGTH_LONG );
        toast.show();
        Log.d(TAG, "onCreate");
        // Принятие имени

        fragmentManager.setFragmentResultListener("change to RepositoryFragment", this, (requestKey, result) -> {
            String results = result.getString("resultText");
            binding.textView5ForName.setText("Ваше имя: " + results);
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentConfirmBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");
        Toast toast = Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_LONG );
        toast.show();
        // Передача имени обратно
        binding.buttonGotovo1.setOnClickListener(view1 -> {
            Bundle result = new Bundle();
            result.putString("resultText", binding.textView5ForName.getText().toString());
            fragmentManager.setFragmentResult("change to HubFragment", result);
            mainActivity.changeFragment(view1);
        });
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "onViewStateRestored");
        Toast toast = Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_LONG );
        toast.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        Toast toast = Toast.makeText(getContext(), "onStart", Toast.LENGTH_LONG );
        toast.show();

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        Toast toast = Toast.makeText(getContext(), "onResume", Toast.LENGTH_LONG );
        toast.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        Toast toast = Toast.makeText(getContext(), "onPause", Toast.LENGTH_LONG );
        toast.show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        Toast toast = Toast.makeText(getContext(), "onStop", Toast.LENGTH_LONG );
        toast.show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        Toast toast = Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_LONG );
        toast.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
        Toast toast = Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_LONG );
        toast.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        Toast toast = Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_LONG );
        toast.show();
    }
}