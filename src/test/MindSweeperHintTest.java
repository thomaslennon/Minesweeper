import ie.lennon.minesweeper.MindSweeper;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MindSweeperHintTest {

    @Test
    public void Given1by1GameWhen1MineThenMine(){
        String[][] minefield = {{"*"}};
        String[][] expected = {{"*"}};

        String result[][] = MindSweeper.hint(minefield);
        assertTrue(compareArrays(expected, result));
    }


    @Test
    public void given2x2FieldWith2MinesThenHints(){
        String[][] minefield = {{"*", "."},
                                {".", "*"}};
        String[][] expected = {{"*", "2"},
                                {"2", "*"}};

        String result[][] = MindSweeper.hint(minefield);
        assertTrue(compareArrays(expected, result));
    }

    @Test
    public void twoByTwoGameScenario2(){
        String[][] minefield = {{".", "*"},
                {"*", "."}};
        String[][] expected = {{"2", "*"},
                {"*", "2"}};

        String result[][] = MindSweeper.hint(minefield);
        assertTrue(compareArrays(expected, result));
    }

    @Test
    public void twoByTwoGameScenario3(){
        String[][] minefield = {{".", "*"},
                {".", "."}};
        String[][] expected = {{"1", "*"},
                {"1", "1"}};

        String result[][] = MindSweeper.hint(minefield);
        assertTrue(compareArrays(expected, result));
    }


    @Test
    public void givenSetsOfDataThenCheckHints(){

        String[][] minefield = {{"*", ".", ".", "."},
                {".", ".", ".", "."},
                {".", "*", ".", "."},
                {".", ".", ".", "."}};

        String [][] expected = {{"*", "1", "0", "0"},
                {"2", "2", "1", "0"},
                {"1", "*", "1", "0"},
                {"1", "1", "1", "0"}};

        String result[][] = MindSweeper.hint(minefield);

        assertTrue(compareArrays(expected, result));

    }

    private boolean compareArrays(String expected[][], String actual[][]){
        for( int i = 0; i < expected.length; i++){
            if(!Arrays.deepEquals(expected[i], actual[i]))
                return false;
        }
        return true;
    }


}
