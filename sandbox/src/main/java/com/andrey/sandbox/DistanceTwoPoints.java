package com.andrey.sandbox;

public class DistanceTwoPoints {

  public static void main(String[] args) {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(5, 5);
    double distance = p2.distance() - p1.distance();

    System.out.println("Distance between A and B = " + distance);

  }

}
