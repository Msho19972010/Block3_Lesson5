import java.util.*;
import java.util.NoSuchElementException;

public class ResultBoard {
    StudentComparator comparator = new StudentComparator();
    TreeSet<Student> studentsDataBase = new TreeSet<>(comparator);
    List<String> topThreeStudents = new ArrayList<>(3);


    void addStudent(String nameAndSurname, Float score) throws EmptyFieldException {
        Student student = new Student(nameAndSurname, score);

        try {
            studentsDataBase.add(student);
        } catch (NullPointerException e) {
            throw new EmptyFieldException("In the field Name or Score, we have the value null, we can't add values like this in our database.");
        }
    }

    List<String> top3 () throws NoSuchElementException {

        if(studentsDataBase.isEmpty()) {
            throw new NoSuchElementException("The database is empty");
        }

        topThreeStudents.clear();


        if(studentsDataBase.size() == 1) {
            topThreeStudents.add(studentsDataBase.stream().toList().get(0).nameAndSurname());

        } else if(studentsDataBase.size() == 2) {
            topThreeStudents.add(studentsDataBase.stream().toList().get(1).nameAndSurname());
            topThreeStudents.add(studentsDataBase.stream().toList().get(0).nameAndSurname());

        } else if(studentsDataBase.size() == 3) {
            topThreeStudents.add(studentsDataBase.stream().toList().get(2).nameAndSurname());
            topThreeStudents.add(studentsDataBase.stream().toList().get(1).nameAndSurname());
            topThreeStudents.add(studentsDataBase.stream().toList().get(0).nameAndSurname());

        } else {
            for(int i = studentsDataBase.size() - 1; i > studentsDataBase.size() - 4; i --) {
                topThreeStudents.add(studentsDataBase.stream().toList().get(i).nameAndSurname());

            }
        }


        return topThreeStudents;
    }

    public static void main (String[] args) {
        ResultBoard resultBoard = new ResultBoard();
        resultBoard.addStudent("Eva Volt", 3.5f);
        resultBoard.addStudent("Misha Simonian", 3.5f);
        resultBoard.addStudent("Misha Simonian", 3.5f);
        resultBoard.addStudent("Misha Simonian", 3.5f);
        resultBoard.addStudent("Masha Mishiniova", 4.7f);
        resultBoard.addStudent("Sasha Seraya", 4.3f);
        resultBoard.addStudent("Dasha Chernaia", 3.7f);
        resultBoard.addStudent("Natasha Pereviznik", 2.5f);
        resultBoard.addStudent("Misha Simonian", 4.9f);
        resultBoard.addStudent("Hass Benz", 3.0f);
        resultBoard.addStudent(null, null);
        System.out.println(resultBoard.top3());
    }

    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            int scoreCompare = student1.score().compareTo(student2.score());

            if (scoreCompare != 0) {
                return scoreCompare;
            }
            return student1.nameAndSurname().compareTo(student2.nameAndSurname());

        }

        }
}
