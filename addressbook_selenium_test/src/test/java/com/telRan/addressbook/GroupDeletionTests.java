package com.telRan.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testsGroupDeletion() {

        openGroupPage();
        selectGroup();
        deleteGroup();
        returnToGroupsPage();
    }

}
