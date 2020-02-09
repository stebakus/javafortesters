package com.andrey.sandbox;

import com.andrey.sandbox.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void distance() {
    Point AB = new Point(1,1,5,5);
    //assert AB.distance() == 0;
    Assert.assertEquals(AB.distance(), 5.656854249492381);
  }

}
