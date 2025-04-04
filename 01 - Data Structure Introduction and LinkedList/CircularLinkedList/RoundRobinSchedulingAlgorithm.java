public class RoundRobinSchedulingAlgorithm {
    Node last;
    int totalWaitingTime = 0;
    int totalTurnAroundTime = 0;
    int totalProcesses = 0;

    class Node {
        String processID;
        int burstTime;
        int priority;
        int remainingTime;
        int waitingTime;
        int turnAroundTime;
        Node next;

        Node(String processID, int burstTime, int priority) {
            this.processID = processID;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.waitingTime = 0;
            this.turnAroundTime = 0;
            next = null;
        }
    }

    RoundRobinSchedulingAlgorithm() {
        last = null;
    }

    public void addProcess(String processID, int burstTime, int priority) {
        Node newNode = new Node(processID, burstTime, priority);
        if (last == null) {
            newNode.next = newNode;
            last = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        totalProcesses++;
    }

    public void removeProcess(String processID) {
        Node temp = last.next;
        if (last == null) {
            throw new NullPointerException("Empty List");
        }
        if (last == last.next && last.next.processID.equalsIgnoreCase(processID)) {
            last = null;
            return;
        }
        if (last.next.processID.equalsIgnoreCase(processID)) {
            last.next = temp.next;
            return;
        }
        while (temp.next != last.next) {
            if (temp.next.processID.equalsIgnoreCase(processID)) {
                if (temp.next == last) {
                    last = temp;
                }
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    public void display() {
        if (last == null) {
            System.out.println("No processes to display.");
            return;
        }
        Node temp = last.next;
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime +
                    ", Priority: " + temp.priority + ", Waiting Time: " + temp.waitingTime +
                    ", Turnaround Time: " + temp.turnAroundTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    public void simulationOfRoundRobinAlgorithm(int timeQuantum) {
        if (last == null) {
            throw new NullPointerException("No processes to schedule");
        }

        Node temp = last.next;
        int currentTime = 0;

        System.out.println("Starting Round-Robin Scheduling with Time Quantum: " + timeQuantum);

        while (last != null) {
            if (temp.remainingTime <= timeQuantum) {
                currentTime += temp.remainingTime;
                System.out.println("Executing Process: " + temp.processID + " | Burst Time: " + temp.remainingTime + " Completed");

                temp.turnAroundTime = currentTime;
                temp.waitingTime = currentTime - temp.burstTime;
                totalTurnAroundTime += temp.turnAroundTime;
                totalWaitingTime += temp.waitingTime;

                String completedID = temp.processID;
                temp = temp.next;
                removeProcess(completedID);
            } else {
                System.out.println("Executing Process: " + temp.processID + " | Remaining Burst Time: " + (temp.remainingTime - timeQuantum));
                temp.remainingTime -= timeQuantum;
                currentTime += timeQuantum;
                temp = temp.next;
            }
            System.out.println("-------------------------------------------------");
        }

        System.out.println("All processes completed.");
    }

    public void displayAverageTimes() {
        if (totalProcesses == 0) {
            System.out.println("No processes executed.");
            return;
        }
        double averageWaitingTime = (double) totalWaitingTime / totalProcesses;
        double averageTurnAroundTime = (double) totalTurnAroundTime / totalProcesses;

        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turnaround Time: " + averageTurnAroundTime);
    }
}

class Process {
    public static void main(String[] args) {
        RoundRobinSchedulingAlgorithm robinSchedulingAlgorithm = new RoundRobinSchedulingAlgorithm();
        robinSchedulingAlgorithm.addProcess("Process01", 5, 1);
        robinSchedulingAlgorithm.addProcess("Process02", 2, 2);
        robinSchedulingAlgorithm.addProcess("Process03", 7, 3);
        robinSchedulingAlgorithm.display();
        robinSchedulingAlgorithm.simulationOfRoundRobinAlgorithm(4);
        robinSchedulingAlgorithm.displayAverageTimes();
    }
}