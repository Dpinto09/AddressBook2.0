package com.telRan.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getGroupHelper().openGroupPage();
        if (!app.isPresent()) {
            app.createGroup();
        }

    }

    @Test
    public void testsGroupDeletionFirst() {

        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupHelper().getGroupsCount();

        Assert.assertEquals(after, before - 1);


    }

    @Test
    public void testsGroupDeletionLast() {

        int before = app.getGroupHelper().getGroupsCount();
        app.selectByIndex(before - 1);
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before - 1);



    }


}
