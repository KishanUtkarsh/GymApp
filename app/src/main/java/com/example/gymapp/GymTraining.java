package com.example.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

public class GymTraining implements Parcelable {
    private int id;
    private String name;
    private String srtdesc;
    private String longdesc;
    private String imageUrl;

    public GymTraining(int id, String name, String srtdesc, String longdesc, String imageUrl) {
        this.id = id;
        this.name = name;
        this.srtdesc = srtdesc;
        this.longdesc = longdesc;
        this.imageUrl = imageUrl;
    }

    public GymTraining() {

    }

    protected GymTraining(Parcel in) {
        id = in.readInt();
        name = in.readString();
        srtdesc = in.readString();
        longdesc = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<GymTraining> CREATOR = new Creator<GymTraining>() {
        @Override
        public GymTraining createFromParcel(Parcel in) {
            return new GymTraining(in);
        }

        @Override
        public GymTraining[] newArray(int size) {
            return new GymTraining[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrtdesc() {
        return srtdesc;
    }

    public void setSrtdesc(String srtdesc) {
        this.srtdesc = srtdesc;
    }

    public String getLongdesc() {
        return longdesc;
    }

    public void setLongdesc(String longdesc) {
        this.longdesc = longdesc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "GymTraining{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", srtdesc='" + srtdesc + '\'' +
                ", longdesc='" + longdesc + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(srtdesc);
        dest.writeString(longdesc);
        dest.writeString(imageUrl);
    }
}
