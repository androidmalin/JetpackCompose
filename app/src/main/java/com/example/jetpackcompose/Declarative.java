package com.example.jetpackcompose;

import android.os.Build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Declarative {

    static List<Integer> getDoubleList(List<Integer> originList) {
        List<Integer> doubleList = new ArrayList<>();
        for (int i = 0; i < originList.size(); i++) {
            doubleList.add(originList.get(i) * 2);
        }
        return doubleList;
    }


    static List<Integer> getDoubleListDeclarative(List<Integer> originArray) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return originArray.stream()
                    .filter(Objects::nonNull)
                    .map(n -> n * 2)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, null);
        List<Integer> doubleList = getDoubleList(list);
        for (int num : doubleList) {
            System.out.println(num);
        }
        System.out.println("====");
        List<Integer> doubleList2 = getDoubleListDeclarative(list);
        for (int num : doubleList2) {
            System.out.println(num);
        }
    }
}
