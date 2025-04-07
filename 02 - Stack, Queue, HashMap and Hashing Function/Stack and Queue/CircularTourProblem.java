public class CircularTourProblem {

    public static int findStartingPoint(int[] petrol, int[] distance) {
        int totalSurplus = 0, currentSurplus = 0, start = 0;

        for (int i = 0; i < petrol.length; i++) {
            totalSurplus += petrol[i] - distance[i];
            currentSurplus += petrol[i] - distance[i];

            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }

        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startPoint = findStartingPoint(petrol, distance);

        if (startPoint == -1) {
            System.out.println("Tour is not possible.");
        } else {
            System.out.println("Start at pump " + startPoint);
        }
    }
}