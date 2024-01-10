package search;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {

    /**
     * Finds the student with the given matriculation number in the given student array
     * @param students an array of students, sorted in nondescending order by their matriculation number
     * @param matriculationNumber the matriculation number of the wanted student
     * @return the student with the given matriculation number or null if they are not part of the array
     */
    private static Student binarySearch(Student[] students, int matriculationNumber) {
        // TODO: Implement binary search (do not change this method's signature and parameters!)
        if (students.length == 0){
            return null;
        }
        int length;
        if (students.length == 1){
            if (students[0].getMatriculationNumber() == matriculationNumber){
                return students[0];
            } else {
                return null;
            }
        } else if (students.length % 2 == 0){
            length = students.length/2 - 1;
        } else {
            length = students.length/2;
        }


        if (students[length].getMatriculationNumber() == matriculationNumber){
            return students[length];
        } else {
            Student[] studentslist = new Student[length];
            if (students[length].getMatriculationNumber() < matriculationNumber) {

                int counter = length + 1;
                Student[] rightHalf = Arrays.copyOfRange(students, length + 1, students.length);
                return binarySearch(rightHalf, matriculationNumber);

            } else {
                int counter = length;
                Student[] leftHalf = Arrays.copyOfRange(students, 0, length + 1);
                return binarySearch(leftHalf, matriculationNumber);
            }

        }
//        return null;
    }

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student(1, "Alexander Friedrich"),
                new Student(346, "Emma Watschon"),
                new Student(45669, "Marie Kurier"),
                new Student(87421, "Tom Thomson"),
                new Student(87497, "Polina Port"),
                new Student(196379, "Leo Poldina"),
                new Student(893729, "Murad Merkur"),
                new Student(2745532, "Maxim Winter"),
                new Student(12345678, "Magda Martinez"),
                new Student(98765432, "Frank Franklin"),
                new Student(987651432, "Fr2ank Franklin")

        };

        // The student array must be sorted by the matriculation number, since the binary search
        // works only for sorted data. If this not the case, use the following line to sort the array:
        //Arrays.sort(students, Comparator.comparingInt(Student::getMatriculationNumber));

        // Print the array
        // (This line of code uses Java method reference captures for brevity; it is not part of GdP)
        Arrays.stream(students).forEach(System.out::println);

        // Search for a student
        Student student = binarySearch(students, 1);

        boolean success = student != null;
        System.out.println("Found student: " + success);

        if (success) {
            System.out.println(student);
        }
    }
}
