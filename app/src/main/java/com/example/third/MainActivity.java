package com.example.third;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment hello_fragment, confirm_fragment;
    FragmentManager fragmentManager;
    // Подгружаем фрагменты в активность
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello_fragment = new HelloFragment();
        confirm_fragment = new ConfirmFragment();

        // Загружаем фрагмент в контейнер
        if (savedInstanceState == null){
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setReorderingAllowed(true).add(R.id.fragment_container_view, HelloFragment.class, null).commit();
        }
    }

    public void changeFragment(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // по кнопке выбираем в какой фрагмент из какого хотим перейти
        if (view.getId() == R.id.button_gotovo1) {
            if (hello_fragment.isVisible())
                return;
            fragmentTransaction.replace(R.id.fragment_container_view, hello_fragment);
        }
        else if (view.getId() == R.id.button_gotovo) {
            if (confirm_fragment.isVisible())
                return;
            fragmentTransaction.replace(R.id.fragment_container_view, confirm_fragment);
        }

        fragmentTransaction.commit();
    }
}