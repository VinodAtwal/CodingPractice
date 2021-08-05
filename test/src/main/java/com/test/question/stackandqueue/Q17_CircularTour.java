package com.test.question.stackandqueue;

public class Q17_CircularTour {

    public static int circularTour(int[] petrol, int[] distance) {
        int startIndex = 0;
        int remPetrol = 0;
        int index = startIndex;
        while (startIndex < petrol.length) {
            remPetrol = remPetrol + petrol[index] - distance[index];
            index = (index + 1) % petrol.length;
            if (remPetrol < 0) {
                if (index <= startIndex) {
                    return -1;
                }
                startIndex = index;
                remPetrol = 0;
            } else {
                if (index == startIndex) {
                    return startIndex;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] petrol = {6, 7, 3, 1};
        int[] distance = {5, 3, 5, 4};
        System.out.println(circularTour(petrol, distance));
    }
}
