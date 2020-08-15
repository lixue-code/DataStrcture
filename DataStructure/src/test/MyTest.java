package test;

import org.junit.Test;
import utils.SparseArrayUtils;

public class MyTest {
    @Test
    public void testReadFormTxt(){
        String path = "D:\\sparseArray\\spraseArray.txt";
        int[][] ints = SparseArrayUtils.readFormTxt(path);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
