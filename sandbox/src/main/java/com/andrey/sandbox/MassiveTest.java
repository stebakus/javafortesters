package com.andrey.sandbox;

import java.util.Arrays;
import java.util.Scanner;

public class MassiveTest {

  public static void main(String[] args) throws Exception {

    int a = 2;
    int b = 5;
    int c = 19;
    int d = -5;

    int[] numbers = new int[] {a, b, c, d};
    Arrays.sort(numbers);
    System.out.println(numbers[3]);


  }
}

