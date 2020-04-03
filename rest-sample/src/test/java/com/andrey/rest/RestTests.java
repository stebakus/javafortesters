package com.andrey.rest;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase {

  @Test
  public void testCreateIssue() throws IOException {
    skipIfNotFixed(1); // Bug status - Open
    //skipIfNotFixed(608); // Bug status - Closed
    //skipIfNotFixed(768); // Bug status - Resolved
    //skipIfNotFixed(1); // Bug status - Deleted

    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
    assertEquals(newIssues.size(), oldIssues.size() + 1);
    oldIssues.add(newIssue.withId(issueId).withStatus("Open")); //20 bugs per page are shown
    assertEquals(newIssues, oldIssues);
  }

}
