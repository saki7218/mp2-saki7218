package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.boggle.BoggleBoard;
import ca.ubc.ece.cpen221.mp2.boggle.BogglePlayer;
import ca.ubc.ece.cpen221.utils.In;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BogglePlayerTest {

    @Test
    public void testGetAllValidWords(){
        In in = new In(new File("datasets/dictionary-yawl.txt"));
        String[] dictionary = in.readAllStrings();
        BogglePlayer solver = new BogglePlayer(dictionary);
        char[][] b={{'T','R','N','J'},{'X','P','H','W'},{'S','Y','U','A'},{'C','L','N','F'}};
        BoggleBoard board = new BoggleBoard(b);
        Set<String> words = solver.getAllValidWords(board);
        Set<String> expectedWords=new TreeSet<>();
        expectedWords.add("AH");
        expectedWords.add("AL");
        expectedWords.add("AN");
        expectedWords.add("ANU");
        expectedWords.add("AS");
        expectedWords.add("AW");
        expectedWords.add("AX");
        expectedWords.add("FA");
        expectedWords.add("FAP");
        expectedWords.add("FAW");
        expectedWords.add("NA");
        expectedWords.add("NAW");
        expectedWords.add("NU");
        expectedWords.add("NUR");
        expectedWords.add("NY");
        expectedWords.add("NYS");
        expectedWords.add("PA");
        expectedWords.add("PH");
        expectedWords.add("PRY");
        expectedWords.add("SH");
        expectedWords.add("SUP");
        expectedWords.add("SYN");
        expectedWords.add("UH");
        expectedWords.add("UP");
        expectedWords.add("UR");
        expectedWords.add("XU");
        expectedWords.add("YA");
        expectedWords.add("YAH");
        expectedWords.add("YU");
        assertEquals(expectedWords,words);
    }
}
