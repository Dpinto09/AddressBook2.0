package com.telRan.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        openGroupPage();
        initNewGroupCreation();
        fillGroupForm("NAME", "HEADER", "FOOTER");
        confirmNewGroupCreation();
        returnToGroupsPage();

    }


    @Test
    public void testGroupCreationLong() {
        openGroupPage();
        initNewGroupCreation();
        fillGroupForm("NAMEEEEEEEEEEEEE", "HEADERRRRRRRRRRRRR", "FOOTERRRRRRRRRRRRR");
        confirmNewGroupCreation();
        returnToGroupsPage();

    }

    @Test
    public void testGroupCreationEmpty() {
        openGroupPage();
        initNewGroupCreation();
        fillGroupForm("", "", "");
        confirmNewGroupCreation();
        returnToGroupsPage();

    }


}