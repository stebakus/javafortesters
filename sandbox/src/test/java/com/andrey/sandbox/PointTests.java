package com.andrey.sandbox;

import com.andrey.sandbox.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void distance() {
    Point p1 = new Point(1,1);
    Point p2 = new Point(5,5);
    //assert AB.distance() == 0;
    Assert.assertEquals(p1.distance(p2), 5.656854249492381);
  }

}
