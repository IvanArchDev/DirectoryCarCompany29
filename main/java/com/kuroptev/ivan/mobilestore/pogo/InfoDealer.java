package com.kuroptev.ivan.mobilestore.pogo;


public class InfoDealer {
    private String address;
    private String city;
    private String telephoneNumberOp;
    private String telephoneNumberSr;
    private String title;
    private String webSite;
    private String logo;

    public InfoDealer(){

    }

    public InfoDealer(String address, String city, String telephoneNumberOp, String telephoneNumberSr, String title, String webSite, String logo) {
        this.address = address;
        this.city = city;
        this.telephoneNumberOp = telephoneNumberOp;
        this.telephoneNumberSr = telephoneNumberSr;
        this.title = title;
        this.webSite = webSite;
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephoneNumberOp() {
        return telephoneNumberOp;
    }

    public void setTelephoneNumberOp(String telephoneNumberOp) {
        this.telephoneNumberOp = telephoneNumberOp;
    }

    public String getTelephoneNumberSr() {
        return telephoneNumberSr;
    }

    public void setTelephoneNumberSr(String telephoneNumberSr) {
        this.telephoneNumberSr = telephoneNumberSr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
