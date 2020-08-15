package sparseArray;

import org.junit.Test;

public class MainTest {
    @Test
    public void test(){
        int chassArray[][] = new int[11][11];
        chassArray[0][4] = 1;
        chassArray[1][3] = 2;
        chassArray[3][3] = 2;

        int sum = 0;//记录有效数的个数

        //遍历原始数组，获取有效元素个数sum ,用于初始化稀疏数组
        for (int[] ints : chassArray) {

            for (int anInt : ints) {
                if(anInt!=0){
                  sum++;
                }
                System.out.print(anInt+"\t");
            }
            System.out.println("\n");
        }
        
        //初始化一个稀疏数组
        //sum表示稀疏数组的有效元素的行数
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int  count = 0;
        //赋值
        //遍历原始数组，获取有效元素的个数
        //生成稀疏数组
        for (int i = 0; i <chassArray.length ; i++) {
            for (int j = 0; j <chassArray[i].length ; j++) {
                if(chassArray[i][j]!=0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chassArray[i][j];
                }
            }
        }


        //输出稀疏数组
        System.out.println("稀疏数组");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }

        //恢复原始数组
        //创建原始数组
        int row = sparseArray[0][0];
        int clo = sparseArray[0][1];
        int[][] chassArray2 = new int[row][clo];

        //遍历稀疏数组给原始数组赋值
        for (int i = 1; i <sparseArray.length ; i++) {
            chassArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //遍历原始数组输出原始数组
        for (int[] ints : chassArray) {

            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println("\n");
        }

    }



    
    
    
}
