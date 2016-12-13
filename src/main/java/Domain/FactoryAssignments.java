package Domain;

import java.util.ArrayList;

public class FactoryAssignments {
    private static ArrayList<Assignment> assignmentArrayList = new ArrayList<>();


    public ArrayList<Assignment> getAssignmentArrayList() {
        return assignmentArrayList;
    }

    public void createAssignment(String title, String description) {
        Assignment a = new Assignment(title, description);
        assignmentArrayList.add(a);
    }
}
