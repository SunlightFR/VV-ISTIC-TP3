package test.java.fr.istic.vv;

import main.java.fr.istic.vv.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @BeforeAll
    public static void setup(){

    }

    @org.junit.Test
    public void testEmptyString(){
        assertTrue(StringUtils.isBalanced(""));
    }

    @Test
    public void testOddLengthString(){
        assertFalse(StringUtils.isBalanced("{"));
        assertFalse(StringUtils.isBalanced("[][()"));
    }

    @Test
    public void testSimpleString(){
        assertTrue(StringUtils.isBalanced("[]"));
    }

    @Test
    public void testNestedSequencesSameCharacters(){
        assertTrue(StringUtils.isBalanced("[[]]"));
    }
    @Test
    public void testNestedSequencesDifferentCharacters(){
        assertTrue(StringUtils.isBalanced("[()]"));
    }


    @Test
    public void testSuccessiveSequencesSameCharacters(){
        assertTrue(StringUtils.isBalanced("[][]"));
    }

    @Test
    public void testSuccessiveSequencesDifferentCharacters(){
        assertTrue(StringUtils.isBalanced("[]()"));
    }

    @Test
    public void testSuccessiveAndNestedSequencesSameCharacters(){
        assertTrue(StringUtils.isBalanced("[[][]][]"));
    }

    @Test
    public void testSuccessiveAndNestedSequencesDifferentCharacters(){
        assertTrue(StringUtils.isBalanced("[(){}]()"));
    }

    @Test
    public void testNoSuccessiveMatchingCharacters(){
        assertFalse(StringUtils.isBalanced("[[))"));
    }
}