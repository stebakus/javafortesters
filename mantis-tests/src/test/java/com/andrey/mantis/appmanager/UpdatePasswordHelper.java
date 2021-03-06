package com.andrey.mantis.appmanager;

import com.andrey.mantis.models.UsersData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.openqa.selenium.By;

import java.util.List;

public class UpdatePasswordHelper extends HelperBase {

  public UpdatePasswordHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    click(By.cssSelector("input[value='Login']"));
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
    click(By.linkText("Manage Users"));
    List<UsersData> usersList = app.loginAndVerification().getUsersListWithoutAdmin();
    click(By.linkText((usersList.iterator().next().getUsername())));
    click(By.xpath("//input[@value='Reset Password']"));
    click(By.linkText("Proceed"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("span.bigger-110"));
  }

  public List<UsersData> getAllUsersList() {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session = sessionFactory.openSession();
    List<UsersData> result = session.createQuery("from UsersData").list();
    session.close();
    return result;
  }


  public List<UsersData> getUsersListWithoutAdmin() {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session = sessionFactory.openSession();
    //List<UsersData> result = session.createQuery("from UsersData where id!=1").list(); //exclude admin by id
    List<UsersData> result = session.createQuery("from UsersData where username != 'administrator'").list(); //exclude admin by username
    session.close();
    return result;
  }
}
