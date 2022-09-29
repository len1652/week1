package com.ndphuc.dp.week2;

public class information {
    String name;
    String birth;
    String avatar;
    String about;

    public information(String name, String birth, String avatar, String about) {

        this.name = name;
        this.birth = birth;
        this.avatar = avatar;
        this.about = about;
    }

    public information() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
