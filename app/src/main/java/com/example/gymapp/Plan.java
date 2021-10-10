package com.example.gymapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Plan implements Parcelable {
    private GymTraining training;
    private int minute;
    private String day;
    private boolean isAccomplished;

    public Plan(GymTraining training, int minute, String day, boolean isAccomplished) {
        this.training = training;
        this.minute = minute;
        this.day = day;
        this.isAccomplished = isAccomplished;
    }

    protected Plan(Parcel in) {
        training = in.readParcelable(GymTraining.class.getClassLoader());
        minute = in.readInt();
        day = in.readString();
        isAccomplished = in.readByte() != 0;
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    public Plan() {

    }

    public GymTraining getTraining() {
        return training;
    }

    public void setTraining(GymTraining training) {
        this.training = training;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(boolean accomplished) {
        isAccomplished = accomplished;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "training=" + training +
                ", minute=" + minute +
                ", day='" + day + '\'' +
                ", isAccomplished=" + isAccomplished +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(training, flags);
        dest.writeInt(minute);
        dest.writeString(day);
        dest.writeByte((byte) (isAccomplished ? 1 : 0));
    }
}
