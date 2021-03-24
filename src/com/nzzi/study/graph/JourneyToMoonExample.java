package com.nzzi.study.graph;

import com.nzzi.study.graph.domain.Graph2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JourneyToMoonExample {

    public void run() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));
        Scanner scanner = new Scanner(new File("input"));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    private long journeyToMoon(int n, int[][] astronaut) {
        long result;
        Graph2 graph = Graph2.of(n, astronaut);

        result = graph.dfs();
        System.out.println(result);
        return result;
    }
}
