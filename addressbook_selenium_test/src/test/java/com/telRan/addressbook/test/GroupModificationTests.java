package com.telRan.addressbook.test;

import com.telRan.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getGroupHelper().openGroupPage();
        if (!app.isPresent()) {
            app.createGroup();
        }

    }

    @Test
    public void testGroupModification() {

        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("", "", "new name"));
        app.getGroupHelper().confirmGroupModification();
        app.getGroupHelper().returnToGroupsPage();

    }

}
