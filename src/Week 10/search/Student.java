package search;

public class Student {

    private final int matriculationNumber;
    private final String name;

    public Student(int matriculationNumber, String name) {
        this.matriculationNumber = matriculationNumber;
        this.name = name;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + this.matriculationNumber + "] " + this.name;
    }
}
