package com.example.gymapp;

import android.util.Log;

import java.util.ArrayList;

public class Utils {
    private static final String TAG = "Utils";

    private static ArrayList<GymTraining> alltrainings;
    private static ArrayList<Plan> usersPlans;

    public Utils(){

    }
    public static void initlizeAll(){
        Log.d(TAG, "initlizeAll: called");

        if(alltrainings == null){
            alltrainings = new ArrayList<>();

        }

        if(usersPlans == null){
            usersPlans = new ArrayList<>();

        }

        GymTraining squat = new GymTraining();
        squat.setName("Squat");
        squat.setSrtdesc("short des for squat");
        squat.setLongdesc("A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up. During the descent of a squat, the hip and knee joints flex while the ankle joint dorsiflexes; conversely the hip and knee joints extend and the ankle joint plantarflexes when standing up. ");
        squat.setImageUrl("https://cdn.pixabay.com/photo/2018/12/26/08/52/barbell-3895455_1280.jpg");

        alltrainings.add(squat);

        GymTraining pushup = new GymTraining();
        pushup.setName("Push Up");
        pushup.setSrtdesc("short des for Push up");
        pushup.setLongdesc("A push-up (sometimes called a press-up in British English) is a common calisthenics exercise beginning from the prone position. By raising and lowering the body using the arms, push-ups exercise the pectoral muscles, triceps, and anterior deltoids, with ancillary benefits to the rest of the deltoids, serratus anterior, coracobrachialis and the midsection as a whole. ");
        pushup.setImageUrl("https://cdn.pixabay.com/photo/2016/02/16/19/28/burpee-1203906_1280.jpg");

        alltrainings.add(pushup);

        GymTraining chestfly = new GymTraining();
        chestfly.setName("Chest Fly");
        chestfly.setSrtdesc("short des for chest fly");
        chestfly.setLongdesc("The chest fly or pectoral fly (abbreviated to pec fly) primarily works the pectoralis major muscles to move the arms horizontally forward. If medially (internally) rotated, it is assisted in this by the anterior (front) head of the deltoideus in transverse flexion. If laterally (externally) rotated, the contribution of the deltoid is lessened and the pec major is strongly emphasized as the transverse adductor.");
        chestfly.setImageUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/form-check-10-1554408283.png");

        alltrainings.add(chestfly);

        GymTraining legpress = new GymTraining();
        legpress.setName("Leg Press");
        legpress.setSrtdesc("short des for legpress");
        legpress.setLongdesc("The leg press is a compound weight training exercise in which the individual pushes a weight or resistance away from them using their legs. The term leg press machine refers to the apparatus used to perform this exercise.");
        legpress.setImageUrl("https://cdn.pixabay.com/photo/2015/07/02/10/26/training-828760_1280.jpg");

        alltrainings.add(legpress);

    }

    public static ArrayList<GymTraining> getAlltrainings() {
        return alltrainings;
    }

    public static void setAlltrainings(ArrayList<GymTraining> alltrainings) {
        Utils.alltrainings = alltrainings;
    }

    public static ArrayList<Plan> getUsersPlans() {
        return usersPlans;
    }

    public static void setUsersPlans(ArrayList<Plan> usersPlans) {
        Utils.usersPlans = usersPlans;
    }
    public static boolean addToUserPlan(Plan plan){
        Log.d(TAG, "addToUserPlan: started");

        return usersPlans.add(plan);
    }

    public static boolean removeUserPlan(Plan plan){
        Log.d(TAG, "removeUserPlan: started");

        return usersPlans.remove(plan);
    }
}
