package com.telran.homework.model;

import java.io.File;

public class MishpaHug {

    private File photoProfile;
    private File photoEvent;

    public File getPhotoProfile() {
        return photoProfile;
    }

    public MishpaHug setPhotoProfile(File photoProfile) {
        this.photoProfile = photoProfile;
        return  this;
    }

    public File getPhotoEvent() {
        return photoEvent;
    }

    public MishpaHug setPhotoEvent(File photoEvent) {
        this.photoEvent = photoEvent;
        return this;
    }
}
