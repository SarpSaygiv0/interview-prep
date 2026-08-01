package com.medium.validstartingcity;

public class ValidStartingCity {


    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        for (int i = 0; i < distances.length; i++) {
            int fuelLeft = 0;
            if (getFuelLeft(distances, fuel, mpg, i, fuelLeft) >= 0)
                return i;
        }
        return -1;
    }

    private static int getFuelLeft(int[] distances, int[] fuel, int mpg, int i, int fuelLeft) {
        for (int j = i; j < distances.length; j++) {
            int distance = distances[j];
            fuelLeft += fuel[j] * mpg;
            fuelLeft -= distance;
            if (fuelLeft < 0)
                break;
        }
        return fuelLeft;
    }

    public int validStartingCityOptimal(int[] distances, int[] fuel, int mpg) {
        int fuelLeft = 0;
        int validStartingCity = 0;
        int fuelLeftAtValidStartingCity = 0;
        for (int i = 1; i < distances.length; i++) {
            fuelLeft += (fuel[i - 1] * mpg) - distances[i - 1];
            if (fuelLeft < fuelLeftAtValidStartingCity) {
                fuelLeftAtValidStartingCity = fuelLeft;
                validStartingCity = i;
            }
        }
        return validStartingCity;
    }
}
