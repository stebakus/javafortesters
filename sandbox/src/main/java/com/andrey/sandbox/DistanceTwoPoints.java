package com.andrey.sandbox;

public class DistanceTwoPoints {

  public static void main(String[] args) {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(5, 5);

    double distance = Math.sqrt((p2.distance1() - p1.distance1()) * (p2.distance1() - p1.distance1()) + ((p2.distance2() - p1.distance2()) * (p2.distance2() - p1.distance2())));

    System.out.println("Distance between A and B = " + distance);

  }

}
