import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class _23AverageGrades {
    public static class Student {
        public Student(String name, ArrayList<Double> grades) {
            this.name = name;
            this.grades = grades;
        }

        private String name;

        private ArrayList<Double> grades;

        private double average;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Double> getGrades() {
            return grades;
        }

        public void setGrades(ArrayList<Double> grades) {
            this.grades = grades;
        }

        public double getAverage() {
            double sum = 0;
            for (double grade : grades
            ) {
                sum += grade;
            }
            return sum / grades.size();
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Student> students = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] commands = br.readLine().split(" ");

            ArrayList<Double> currList = new ArrayList<>();
            for (int i = 1; i < commands.length; i++) {
                double currGrade = Double.parseDouble(commands[i]);
                currList.add(currGrade);
            }

            students.add(new Student(commands[0], currList));
        }
        students.sort(Comparator.comparing(Student::getName)
                .thenComparing(Student::getAverage));
        for (Student s : students
        ) {
            if (s.getAverage()>=5){
                System.out.printf("%s -> %.2f%n",s.getName(),s.getAverage());
            }
        }

    }
}
