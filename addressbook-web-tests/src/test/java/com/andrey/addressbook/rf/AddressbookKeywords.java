package com.andrey.addressbook.rf;


import com.andrey.addressbook.appmanager.ApplicationManager;
import com.andrey.addressbook.models.GroupData;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;

public class AddressbookKeywords {

  public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

  private ApplicationManager app;

  public void initApplicationManager() throws IOException {
    app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));
    app.init();
  }

  public void stopApplicationManager() {
    app.stop();
    app = null;
  }

  public int getGroupCount() {
    app.goTo().groupPage();
    return app.group().count();
  }

  public void createGroup(String name, String header, String footer) {
    app.goTo().groupPage();
    app.group().create(new GroupData().withName(name).withHeader(header).withFooter(footer));
  }
}
