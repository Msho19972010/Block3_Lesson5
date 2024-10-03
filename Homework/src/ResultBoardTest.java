import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultBoardTest {

    @Test
    void top3() throws NoSuchElementException {
        ResultBoard resultBoard = new ResultBoard();
        resultBoard.addStudent("Eva Volt", 3.5f);
        resultBoard.addStudent("Misha Simonian", 3.5f);
        resultBoard.addStudent("Masha Mishiniova", 4.7f);
        resultBoard.addStudent("Sasha Seraya", 4.3f);


        System.out.println(resultBoard.top3());

        resultBoard.addStudent("Eva V", 3.2f);
        resultBoard.addStudent("Misha S", 3.7f);
        resultBoard.addStudent("Masha M", 4.1f);
        resultBoard.addStudent("Sasha S", 4.9f);
        System.out.println(resultBoard.top3());
    }
}