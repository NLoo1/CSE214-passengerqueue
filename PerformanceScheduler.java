/*
PerformanceScheduler
Main program that runs based off of PerformanceNode and PerformanceList.

Takes user input and creates a "performance schedule".
 */

import java.util.Scanner;

public class PerformanceScheduler {

    public static void main(String[] args) throws Exception {

        Boolean quit = false;
        Scanner input;
        String userInput;

        PerformanceList schedule = new PerformanceList();

        System.out.println("Welcome to Performance Scheduler");

        while(!quit){
            System.out.println("Choose an option: ");
            System.out.println("A: Add performance");
//            System.out.println("B: Move current node backward");
            System.out.println("C: Display current node");
            System.out.println("D: Display all nodes");
//            System.out.println("F: Move current node forward");
//            System.out.println("I: Insert after current node");
            System.out.println("J: Jump to position ");
            System.out.println("R: Remove current node");
            System.out.println("Q: Exit");

            input = new Scanner(System.in);
            userInput = input.nextLine().toLowerCase();

            String performanceName;
            String leadPerformer;
            int totalParticipants;
            int performanceDuration;
            int startTime;
            int position;

            switch(userInput){
                case "a": // Add to end

                    // Get perf name
                    System.out.println("Add" + '\n' + "Name of performance?");

                    input = new Scanner(System.in);
                    performanceName = input.nextLine();

                    // Get lead perf
                    System.out.println("Name of lead performer: ");
                    input = new Scanner(System.in);
                    leadPerformer = input.nextLine();

                    // Get total participants
                    System.out.println("Total participants?");
                    input = new Scanner(System.in);
                    totalParticipants = input.nextInt();

                    // Get duration
                    System.out.println("Duration of performance?");
                    input = new Scanner(System.in);
                    performanceDuration = input.nextInt();

                    // Get start time
                    System.out.println("Start time:");
                    input = new Scanner(System.in);
                    startTime = input.nextInt();

                    schedule.addToEnd(new PerformanceNode(performanceName, leadPerformer, totalParticipants, performanceDuration, startTime));
                    schedule.setHead(schedule.mergeSort(schedule.getHead()));
                    break;
//                case "b": // Move current node backward
//                    try{
//                        if(schedule.moveCursorBackward()) System.out.println("Moved cursor backwards.");
//                    }
//                    catch(Exception e){
//                        System.out.println("Cannot move backwards");
//                    }
                case "c": // Display current node
                    schedule.displayCurrentPerformance();
                    break;
                case "d": // Display all nodes
                    schedule.displayAllNodes();
                    break;
//                case "f": // Move current node forward
//                    try{
//                        if(schedule.moveCursorForward()) System.out.println("Moved cursor forwards.");
//                    }
//                    catch(Exception e){
//                        System.out.println("Cannot move forward");
//                    }
//                    break;
//                case "i": // Insert after current node
//
//                    System.out.println("Add to end" + '\n' + "Name of performance?");
//
//                    input = new Scanner(System.in);
//                    performanceName = input.nextLine();
//
//                    // Get lead perf
//                    System.out.println("Name of lead performer: ");
//                    input = new Scanner(System.in);
//                    leadPerformer = input.nextLine();
//
//                    // Get total participants
//                    System.out.println("Total participants?");
//                    input = new Scanner(System.in);
//                    totalParticipants = input.nextInt();
//
//                    // Get duration
//                    System.out.println("Duration of performance?");
//                    input = new Scanner(System.in);
//                    performanceDuration = input.nextInt();
//
//                    // Get start time
//                    System.out.println("Start time:");
//                    input = new Scanner(System.in);
//                    startTime = input.nextInt();
//
//                    schedule.addAfterCurrent(new PerformanceNode(performanceName, leadPerformer, totalParticipants, performanceDuration, startTime));
//                    schedule.setHead(schedule.mergeSort(schedule.getHead()));
//                    break;
                case "j": // Jump to position
                    System.out.println("Position?");

                    input = new Scanner(System.in);
                    position = input.nextInt();

                    if(schedule.jumpToPosition(position)) System.out.println("Jumped to position " + position + ".");
                    else System.out.println("Could not jump to position " + position + ".");

                    break;
                case "r": // Remove current node
                    if(schedule.removeCurrentNode()) {
                        System.out.println("Removed");
                        schedule.setHead(schedule.mergeSort(schedule.getHead()));
                    }
                    else System.out.println("Could not remove or was only node");

                    break;
                case "q":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }


        }

    }
}
