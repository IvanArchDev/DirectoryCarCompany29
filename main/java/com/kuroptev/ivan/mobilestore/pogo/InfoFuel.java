package com.kuroptev.ivan.mobilestore.pogo;


public class InfoFuel {

    private String title;
    private String typeStation;
    private String price;
    private String logoStation;

    public InfoFuel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeStation() {
        return typeStation;
    }

    public void setTypeStation(String typeStation) {
        this.typeStation = typeStation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLogoStation() {return logoStation; }

    public void setLogoStation(String logo){ this.logoStation = logo; }
}
