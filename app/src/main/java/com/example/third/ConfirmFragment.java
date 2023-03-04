package com.example.third;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.third.databinding.FragmentConfirmBinding;

public class ConfirmFragment extends Fragment {
    private static String TAG = "tag";
    private static String TAG1 = "resultText";
    FragmentManager fragmentManager;
    FragmentConfirmBinding binding;
    MainActivity mainActivity;
    public ConfirmFragment(){
        super(R.layout.fragment_confirm);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
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

        // Мы получаем наше имя из другого фрагмента
        fragmentManager.setFragmentResultListener("ppp", this, (requestKey, result) -> {
            String results = result.getString(TAG1);
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
        // Мы передаем имя обратно в первый фрагмент
        binding.buttonGotovo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Bundle result = new Bundle();
                result.putString(TAG1, binding.textView5ForName.getText().toString());
                fragmentManager.setFragmentResult("ccc", result);
                mainActivity.changeFragment(view1);
            }
        });
    }

}