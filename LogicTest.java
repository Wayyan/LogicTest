package com.devduo.androidcodetest;

import java.util.Scanner;

public class LogicTest {


    static int[] xOrder = {0, 1, 0, -1};
    static int[] yOrder = {-1, 0, 1, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int floorSize = 4;

        int[][] floorArr = new int[floorSize][floorSize];
        boolean[][] visited = new boolean[floorSize][floorSize];

//accept input
        for (int i = 0; i < floorSize; i++) {
            for (int j = 0; j < floorSize; j++) {
                floorArr[i][j] = sc.nextInt();

            }
        }


        //find solution
        int partitions = 0;

        for (int i = 0; i < floorSize; i++) {
            for (int j = 0; j < floorSize; j++) {

                if (floorArr[i][j] == 1 && !visited[i][j]) {

                    dfs(floorArr, visited, floorSize, i, j);
                    partitions++;
                }
            }
        }

        System.out.println("Partitions: " + partitions);

        sc.close();
    }

    //solved using dfs
    static void dfs(int[][] data, boolean[][] visited, int size, int x, int y) {

        if (isSafe(data, visited, x, y)) {

            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int newX = x + xOrder[i], newY = y + yOrder[i];

                dfs(data, visited, size, newX, newY);
            }

        }
    }


    // check it  is safe to go or not
    static boolean isSafe(int[][] data, boolean[][] visited, int x, int y) {
        return (x >= 0 && x < data.length && y >= 0 && y < data.length && data[x][y] == 1 && !visited[x][y]);
    }
}
