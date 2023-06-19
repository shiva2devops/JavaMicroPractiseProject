package com.shiva.app;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StudentOperation {
    public List<Integer> findprime(int count) {
        List<Integer> listOfPrime = new ArrayList<>(Arrays. asList(0,1));
        int x, y, flg;

        for (x = 1; x <= count; x++) {

            if (x == 1 || x == 0)
                continue;

            flg = 1;

            for (y = 2; y <= x / 2; ++y) {
                if (x % y == 0) {
                    flg = 0;
                    break;
                }
            }

            if (flg == 1)
                listOfPrime.add(x);
        }
        return listOfPrime;
    }
    public String addString(String s1,String s2){

        return s1+s2;
    }
}
