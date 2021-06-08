package com.testframework.pages;

public interface Page {
     void waitForCurrentUrl(String url);
     void goToPage(String url);
     String waitForPageTitle(String title);

}
