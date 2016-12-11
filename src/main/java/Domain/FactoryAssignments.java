package Domain;

import java.util.ArrayList;

public class FactoryAssignments {
    private static ArrayList<Assignment> assignmentArrayList = new ArrayList<>();


    public static ArrayList<Assignment> getAssignmentArrayList() {
        return assignmentArrayList;
    }

    public static void setAssignmentArrayList(ArrayList<Assignment> assignmentArrayList) {
        FactoryAssignments.assignmentArrayList = assignmentArrayList;
    }
}
