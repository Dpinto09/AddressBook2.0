package com.telRan.addressbook.test;

import com.telRan.addressbook.dataProvider.StaticProvider;
import com.telRan.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getGroupHelper().openGroupPage();
        if (!app.isGroupPresent()) {
            app.createGroup();
        }

    }

    @Test (dataProvider = "validGroups", dataProviderClass = StaticProvider.class)
    public void testGroupModification(GroupData groupData) {

        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(groupData);
        app.getGroupHelper().confirmGroupModification();
        app.getGroupHelper().returnToGroupsPage();

    }

}
