package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {

    public static  void main(String[] agrs){
        Assert.assertEquals(myCalc(5,5),10);
    }

    public static int myCalc(int a,int b){
        return a+b;
    }
    public static boolean myValue(){
        Assert.assertTrue(myValue());
       return true;
    }

    @Test
    public void testCalc(){
        Assert.assertThrows(ArithmeticException.class, ()->myTest());

    }
   // @Test
    public void testDeviBeZero(){
        //Assert.assertThrows(ArithmeticException.class, new Runnable()
        //{@Override
       // public void run(){myTest();}
       // });
    }
    public static int myTest(){
        return 10/0;
    }
    @Test
    public void failTest(){
        int actualResult = someFunction();
        int expectedResult = 10;
        Assert.assertEquals(actualResult,expectedResult,"my comment");
        Assert.fail("The test is fail....");
    }
    public static int someFunction(){
        return 5;
    }
}
