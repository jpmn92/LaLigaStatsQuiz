package com.laligastatsquiz.laligastatsquiz.beans;

import com.google.gson.annotations.SerializedName;

public class FootballPhoto {
    @SerializedName("001")
    FootballPhotoSize photo;

    public FootballPhotoSize getPhoto() {
        return photo;
    }

    public void setPhoto(FootballPhotoSize photo) {
        this.photo = photo;
    }
}
