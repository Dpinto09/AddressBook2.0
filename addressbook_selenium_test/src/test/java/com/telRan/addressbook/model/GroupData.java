package com.telRan.addressbook.model;

public class GroupData {
    private final String groupHeader;
    private final String groupFooter;
    private final String groupName;

    public GroupData(String groupHeader, String groupFooter, String groupName) {
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
        this.groupName = groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    public String getGroupName() {
        return groupName;
    }
}
