package Testbase;

import Pages.HomePage;
import Pages.StackoverflowPage;


public class PageInitializer extends BaseClass {
    public static HomePage home;
    public static StackoverflowPage stackoverflowPage;


    public static void initializePageObjects() {
        home = new HomePage();
        stackoverflowPage = new StackoverflowPage();
    }
}
