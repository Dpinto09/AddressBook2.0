package com.telRan.addressbook.test;

import com.telRan.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getGroupHelper().openGroupPage();
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("HEADER1", "FOOTER1", "NAME1"));
        app.getGroupHelper().confirmNewGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
        System.out.println("Count before is: " + before + "\nCount after is: " + after);
        Assert.assertEquals(after,before+1);

        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("HEADER2", "FOOTER2", "NAME2"));
        app.getGroupHelper().confirmNewGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("HEADER3", "FOOTER3", "NAME3"));
        app.getGroupHelper().confirmNewGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

    }

    @Test
    public void testGroupCreationLong() {
        app.getGroupHelper().openGroupPage();
        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("HEADERRRRRRRRRRRRR", "FOOTERRRRRRRRRRRRR", "NAMEEEEEEEEEEEEE"));
        app.getGroupHelper().confirmNewGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

    }

    @Test
    public void testGroupCreationEmpty() {
        app.getGroupHelper().openGroupPage();
        app.getGroupHelper().initNewGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
        app.getGroupHelper().confirmNewGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

    }


}