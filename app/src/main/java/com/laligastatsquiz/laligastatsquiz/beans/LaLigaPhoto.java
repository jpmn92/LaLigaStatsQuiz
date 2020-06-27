package com.laligastatsquiz.laligastatsquiz.beans;

import com.google.gson.annotations.SerializedName;

public class LaLigaPhoto {
    @SerializedName("001")
    LaLigaPhotoSize photo;

    public LaLigaPhotoSize getPhoto() {
        return photo;
    }

    public void setPhoto(LaLigaPhotoSize photo) {
        this.photo = photo;
    }
}
