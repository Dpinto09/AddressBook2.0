package com.telRan.addressbook;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        openGroupPage();
        selectGroup();
        initGroupModification();
        fillGroupForm("new name", "", "");
        confirmGroupModification();
        returnToGroupsPage();

    }

}
