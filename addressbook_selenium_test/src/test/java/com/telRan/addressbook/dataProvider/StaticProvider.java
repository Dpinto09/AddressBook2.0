package com.telRan.addressbook.dataProvider;

import com.telRan.addressbook.model.ContactData;
import com.telRan.addressbook.model.GroupData;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaticProvider {
    @DataProvider
    public static Iterator<Object[]> validContact() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = br.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData().setFirstName(split[0]).setLastName(split[1]).setAddress(split[2]).setEmail(split[3]).setPhoneMobile(split[4])});
            line = br.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {

        List<Object[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = br.readLine();
        while (line != null) {
            String[]split = line.split(";");
            list.add(new Object[]{new GroupData().withGroupName(split[0]).withGroupHeader(split[1]).withGroupFooter(split[2])});
            line = br.readLine();
        }

        return list.iterator();
    }
}

