package com.yangsanhe.library.entity;

public class Library {
    private Integer liraryId;

    private String libraryname;

    private String curator;

    private String phone;

    private String address;

    private String mailbox;

    private String website;

    private String buildingtime;

    private String briefintroduction;

    public Integer getLiraryId() {
        return liraryId;
    }

    public void setLiraryId(Integer liraryId) {
        this.liraryId = liraryId;
    }

    public String getLibraryname() {
        return libraryname;
    }

    public void setLibraryname(String libraryname) {
        this.libraryname = libraryname == null ? null : libraryname.trim();
    }

    public String getCurator() {
        return curator;
    }

    public void setCurator(String curator) {
        this.curator = curator == null ? null : curator.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox == null ? null : mailbox.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getBuildingtime() {
        return buildingtime;
    }

    public void setBuildingtime(String buildingtime) {
        this.buildingtime = buildingtime == null ? null : buildingtime.trim();
    }

    public String getBriefintroduction() {
        return briefintroduction;
    }

    public void setBriefintroduction(String briefintroduction) {
        this.briefintroduction = briefintroduction == null ? null : briefintroduction.trim();
    }
}