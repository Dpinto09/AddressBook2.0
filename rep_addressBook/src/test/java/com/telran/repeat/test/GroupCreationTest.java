package com.telran.repeat.test;


import com.telran.repeat.model.Group;
import com.telran.repeat.provider.StaticProvider;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase {


    @Test(dataProvider = "validGroups", dataProviderClass = StaticProvider.class)

    public void testGroupCreation(Group group) {


        app.getNavigationHelper().openGroupsPage();


        int before = app.getGroupHelper().getGroupsCount();


        app.getGroupHelper().initGroupCreation();


        app.getGroupHelper().fillGroupForm(group);


        app.getGroupHelper().confirmGroupCreation();

        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupHelper().getGroupsCount();


        System.out.println("count before is: " + before + " and count after is: " + after);

        Assert.assertEquals(after, before + 1);


    }

}