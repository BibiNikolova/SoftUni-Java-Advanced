package examPreparation.type03.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {

        if (students.contains(student)) {
            return "Student is already in the examPreparation.type03.university";
        } else if (this.capacity > students.size()) {
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
        return "No seats in the examPreparation.type03.university";
    }

    public Student getStudent(String firstName, String lastName) {
        return students.stream().filter(s -> s.getFirstName().equals(firstName)
                && s.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    public String dismissStudent(Student student) {
        return this.students.remove(student)
                ? String.format("Removed student %s %s", student.getFirstName(), student.getLastName())
                : "Student not found";
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        this.students.forEach(s -> sb.append("==Student: First Name = ").append(s.getFirstName())
                .append(", Last Name = ").append(s.getLastName())
                .append(", Best Subject = ").append(s.getBestSubject()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}

