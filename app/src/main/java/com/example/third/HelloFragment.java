package com.example.third;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.third.databinding.FragmentHelloBinding;

public class HelloFragment extends Fragment {
    FragmentManager fragmentManager;
    FragmentHelloBinding binding;
    MainActivity mainActivity;
    private final String TAG = "resultText";

    public HelloFragment(){
        super(R.layout.fragment_hello);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getParentFragmentManager();
        // Мы получаем данные с именем обратно
        fragmentManager.setFragmentResultListener("ccc", this, (requestKey, result) -> {
            String results = result.getString(TAG);
            binding.textView.setText(results);
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHelloBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Мы ввели наше имя и передаем текст
        binding.buttonGotovo.setOnClickListener(view1 -> {
            Bundle result = new Bundle();
            result.putString(TAG, binding.editTextTextPersonName.getText().toString());
            fragmentManager.setFragmentResult("ppp", result);
            mainActivity.changeFragment(view1);
        });
    }
}