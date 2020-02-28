package com.andrey.addressbook.tests;

import com.andrey.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupModificaitonTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
<<<<<<< HEAD
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup();
=======
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
>>>>>>> 9b14024b929cf5ee3d80236d3280f5787ffcb199
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
<<<<<<< HEAD
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);








=======
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
>>>>>>> 9b14024b929cf5ee3d80236d3280f5787ffcb199
  }

}
