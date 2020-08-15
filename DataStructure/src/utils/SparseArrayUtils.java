package utils;

import java.io.*;

public class SparseArrayUtils {

    //将稀疏数组写入到文件中
    public static void  writeToTxt(int[][] sparseArray,String path)  {
        //创建文件夹
        File file = new File(path);




        FileWriter fileWriter = null;
        try {
            //true 表示可以追加不覆盖原有的数据
            fileWriter  = new FileWriter(file);
            //遍历稀疏数组
            for (int i = 0; i <sparseArray.length ; i++) {
                fileWriter.write(sparseArray[i][0]+" ");
                fileWriter.write(sparseArray[i][1]+" ");
                fileWriter.write(sparseArray[i][2]+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //关闭流
        if(fileWriter!=null){
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    //从文件中读取稀疏数组
    public static int[][] readFormTxt(String path){
        File file = new File(path);
        //创建一个稀疏数组
        int[][] sparseArray;
        BufferedReader bufferedReader = null;
        int temp = 0;//稀疏数组的行数


        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.readLine()!=null){
                temp++;
            }
            System.out.println("temp:"+temp);
            //创建稀疏数组
            sparseArray = new int[temp][3];


            bufferedReader.close();//刷新流缓存

            bufferedReader = new BufferedReader(new FileReader(file));

            String str;
            int row = 0;
            int clo = 0;

            while ((str=bufferedReader.readLine())!=null){
                String[] split = str.split(" ");

                for (String s : split) {
                    sparseArray[row][clo] = Integer.parseInt(s);
                    clo++;
                }
                clo=0;
                row++;

            }


            return sparseArray;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    return null;

    }
}
