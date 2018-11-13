package com.telRan.addressbook.test;

import com.telRan.addressbook.dataProvider.GroupsProvider;
import com.telRan.addressbook.model.GroupData;
import javafx.scene.Group;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test(dataProvider = "validGroups", dataProviderClass = GroupsProvider.class)
    public void testGroupCreation(GroupData groupData) {
        app.getGroupHelper().openGroupPage();
        int before = app.getGroupHelper().getGroupsCount();

        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().confirmNewGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupHelper().getGroupsCount();
        System.out.println("Count before is: " + before + "\nCount after is: " + after);
        Assert.assertEquals(after, before + 1);

        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().confirmNewGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().confirmNewGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

    }

  /*  @Test (dataProvider = "validGroups")
    public void testGroupCreationLong(String groupName, String groupHeader, String groupFooter) {
        app.getGroupHelper().openGroupPage();
        app.getGroupHelper().initNewGroupCreation();
        GroupData groupData = new GroupData().withGroupFooter(groupFooter).withGroupHeader(groupHeader).withGroupName(groupName);
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().confirmNewGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

    }

    @Test
    public void testGroupCreationEmpty(String groupName, String groupHeader, String groupFooter) {
        app.getGroupHelper().openGroupPage();
        app.getGroupHelper().initNewGroupCreation();
        GroupData groupData = new GroupData().withGroupFooter(groupFooter).withGroupHeader(groupHeader).withGroupName(groupName);
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().confirmNewGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

    }
*/

}