package com.telRan.addressbook.manager;

import com.telRan.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public int getGroupsCount() {

        return wd.findElements(By.name("selected[]")).size();

    }

    public void returnToGroupsPage() {
        click(By.cssSelector("i a"));

    }

    public void confirmNewGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getGroupHeader());
        type(By.name("group_footer"), groupData.getGroupFooter());


    }

    public void initNewGroupCreation() {
        click(By.name("new"));
    }

    public void openGroupPage() {
        click(By.xpath("//a[@href='group.php']"));
    }

    public void confirmGroupModification() {

        click(By.name("update"));
    }

    public void initGroupModification() {

        click(By.name("edit"));
    }

    public void selectGroup() {

        click(By.name("selected[]"));
    }

    public void deleteGroup() {

        click(By.name("delete"));
    }
}
