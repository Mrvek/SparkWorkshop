package Domain;

import java.util.ArrayList;

public class FactoryAssignments {
    private static ArrayList<Assignment> assignmentArrayList = new ArrayList<>();


    public ArrayList<Assignment> getAssignmentArrayList() {
        return assignmentArrayList;
    }

    public void setAssignmentArrayList(ArrayList<Assignment> assignmentArrayList) {
        FactoryAssignments.assignmentArrayList = assignmentArrayList;
    }
}
