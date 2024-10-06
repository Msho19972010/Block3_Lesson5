import java.util.*;
import java.util.NoSuchElementException;

public class ResultBoard {
    StudentComparator comparator = new StudentComparator();
    TreeSet<Student> studentsDataBase = new TreeSet<>(comparator);
    List<String> topThreeStudents = new ArrayList<>(3);


    void addStudent(String nameAndSurname, Float score) {
        Student student = new Student(nameAndSurname, score);

        studentsDataBase.add(student);
    }

    List<String> top3 () throws NoSuchElementException {

        if(studentsDataBase.isEmpty()) {
            throw new NoSuchElementException("The database is empty");
        }

        topThreeStudents.clear();

        Student theBestStudent = studentsDataBase.last();

        if(studentsDataBase.size() == 1) {
            topThreeStudents.add(studentsDataBase.first().nameAndSurname());

        } else if(studentsDataBase.size() == 2) {
            topThreeStudents.add(studentsDataBase.last().nameAndSurname());
            topThreeStudents.add(studentsDataBase.first().nameAndSurname());

        } else if(studentsDataBase.size() == 3) {
            topThreeStudents.add(theBestStudent.nameAndSurname());
            topThreeStudents.add(studentsDataBase.lower(theBestStudent).nameAndSurname());
            topThreeStudents.add(studentsDataBase.first().nameAndSurname());

        } else {
            for(int i = 0; i < 3; i++) {
                topThreeStudents.add(theBestStudent.nameAndSurname());
                theBestStudent = studentsDataBase.lower(theBestStudent);
            }
        }


        return topThreeStudents;
    }

    public static void main (String[] args) {
        ResultBoard resultBoard = new ResultBoard();
        resultBoard.addStudent("Eva Volt", 3.5f);
        resultBoard.addStudent("Misha Simonian`", 3.5f);
        resultBoard.addStudent("Masha Mishiniova", 4.7f);
        resultBoard.addStudent("Sasha Seraya", 4.3f);
        resultBoard.addStudent("Dasha Chernaia", 3.7f);
        resultBoard.addStudent("Natasha Pereviznik", 2.5f);
        resultBoard.addStudent("Misha Simonian", 4.9f);
        resultBoard.addStudent("Hass Benz", 3.0f);

        System.out.println(resultBoard.top3());
    }

    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            int scoreCompare;
            if(!Objects.equals(student1.score(), student2.score())) {
                if(Objects.equals(student1.score(), student2.score())) {
                    scoreCompare = 0;
                } else if (student2.score() > student1.score()) {
                    scoreCompare = 1;
                } else {
                    scoreCompare = -1;
                }
            } else {
                if(Objects.equals(student1.nameAndSurname(), student2.nameAndSurname())) {
                    scoreCompare = 0;
                } else if (student1.nameAndSurname().length() > student2.nameAndSurname().length()) {
                    scoreCompare = 1;
                } else {
                    scoreCompare = -1;
                }
            }
            return scoreCompare;
        }
    }

}
