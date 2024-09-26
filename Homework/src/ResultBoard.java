import java.util.*;

public class ResultBoard {
    TreeMap<Float, String> studentsDataBase = new TreeMap<>();
    List<String> topThreeStudents = new ArrayList<>(3);

    void addStudent(String name, Float score) {
        studentsDataBase.put(score, name);

        System.out.println(studentsDataBase);
    }

    List<String> top3 () {

        Object[] scores = studentsDataBase.keySet().stream().sorted().toArray();

        for(int i = scores.length - 1; i > scores.length - 4; i--) {

            for(Float student : studentsDataBase.keySet()) {
                String studentName = studentsDataBase.get(student);
                if( student.equals(scores[i])) {
                    topThreeStudents.add(studentName);
                }
            }
        }


        return topThreeStudents;
    }

    public static void main (String[] args) {
        ResultBoard resultBoard = new ResultBoard();
        resultBoard.addStudent("Misha", 3.5f);
        resultBoard.addStudent("Masha", 4.7f);
        resultBoard.addStudent("Sasha", 4.3f);
        resultBoard.addStudent("Dasha", 3.7f);
        resultBoard.addStudent("Natasha", 2.5f);
        resultBoard.addStudent("Vasia", 4.9f);
        resultBoard.addStudent("Hass", 3.0f);

        System.out.println(resultBoard.top3());
    }

}
