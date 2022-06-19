package com.cqsd.utils;

public interface SparseArray {

    //二维数组转稀疏数组
    static int[][] chessToSparse(int[][] chessArr) {
        //存储棋盘上有效棋子的个数
        int sum = 0;
        for (int[] row : chessArr) {
            for (int i : row) {
                if (i != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //将二维数据中的有效数据存入到稀疏数组中（从第二行开始存储）
        int chessRow = chessArr.length;//行：棋盘大小
        int chessCol = 0;//列：棋盘大小
        int count = 0;//记录当前是第几个非0的数据 这是个游标
        for (int i = 0; i < chessArr.length; i++) {
            int[] rows = chessArr[i];
            if (chessCol == 0) {
                //给列的长度做初始化
                chessCol = rows.length;
            }
            for (int j = 0; j < rows.length; j++) {
                int chess = rows[j];
                if (chess == 0) {
                    continue;
                }
                count++; //第一行是棋盘信息，先自增
                sparseArr[count][0] = i;
                sparseArr[count][1] = j;
                sparseArr[count][2] = chess;
            }
        }
        sparseArr[0][0] = chessRow;
        sparseArr[0][1] = chessCol;
        sparseArr[0][2] = sum;
        return sparseArr;
    }

    //稀疏数组转换二维数组
    static int[][] sparseToChess(int[][] sparceArr) {
        //创建二维数组
        int[][] chessArr = new int[sparceArr[0][0]][sparceArr[0][1]];
        for (int i = 1; i < sparceArr.length; i++) {
            int[] rows = sparceArr[i];
            chessArr[rows[0]][rows[1]] = rows[2];
        }
        return chessArr;
    }

    static void printChessArray(int[][] chessArr) {
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%-2d\t", data);
            }
        }
        System.out.println("");
    }

    class SparseArrayTest {
        public static void start() {
            new SparseArrayTest().run();
        }

        private void run() {
            int chessArr[][] = new int[11][11];
            chessArr[1][2] = 1;
            chessArr[2][3] = 2;
            System.out.println("原始数组");
            printChessArray(chessArr);
            //转化为稀疏数组
            int sparseArr[][] = chessToSparse(chessArr);
            System.out.println("二维数组转稀疏数组");
            printChessArray(sparseArr);
            //稀疏数组转换二维数组
            int chessArr2[][] = sparseToChess(sparseArr);
            System.out.println("稀疏数组转二维数组");
            printChessArray(chessArr2);
        }
    }

    class Test {
        public static void main(String[] args) {
            SparseArray.SparseArrayTest.start();
        }
    }
}


