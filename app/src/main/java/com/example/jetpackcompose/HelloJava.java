package com.example.jetpackcompose;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class HelloJava extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String name = "HelloName";
        Button button = new Button(this);
        button.setOnClickListener(view -> System.out.println("Hello" + name));
        Predicate<Integer> atLeast5 = x -> x > 5;
        BinaryOperator<Long> addLong = (x, y) -> x + y;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            BinaryOperator<Long> addLong2 = Long::sum;
        }
    }
}
