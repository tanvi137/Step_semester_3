package week_5.assignment_problems;

class Library {
    protected String libraryName = "SRM Library";
}

class ReferenceDesk extends Library {

    void showLibrary() {
        System.out.println(libraryName);
    }
}

public class ReferenceDeskSubclassReach {

    public static void main(String[] args) {
        ReferenceDesk desk = new ReferenceDesk();
        desk.showLibrary();
    }
}
