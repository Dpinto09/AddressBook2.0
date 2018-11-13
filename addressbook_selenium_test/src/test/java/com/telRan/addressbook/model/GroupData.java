package com.telRan.addressbook.model;

public class GroupData {
    private String groupHeader;
    private String groupFooter;
    private String groupName;

    public GroupData withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupData withGroupFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
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

    @Override
    public String toString() {
        return "GroupData{" +
                "groupHeader='" + groupHeader + '\'' +
                ", groupFooter='" + groupFooter + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
