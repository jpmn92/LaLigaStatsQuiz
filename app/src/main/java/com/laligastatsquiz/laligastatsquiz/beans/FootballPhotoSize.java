package com.laligastatsquiz.laligastatsquiz.beans;

import com.google.gson.annotations.SerializedName;

public class FootballPhotoSize {
    @SerializedName("128x139")
    String small;
    @SerializedName("256x278")
    String medium;
    @SerializedName("1024x1113")
    String big;
    @SerializedName("2048x2225")
    String extraBig;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getExtraBig() {
        return extraBig;
    }

    public void setExtraBig(String extraBig) {
        this.extraBig = extraBig;
    }
}
