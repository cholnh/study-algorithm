package com.nzzi.study.graph;

import com.nzzi.study.graph.domain.Graph;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoadAndLibrariesExample {

    public void run() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));
        Scanner scanner = new Scanner(new File("input"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            System.out.println("[도서관 비용 : " + c_lib + "] [도로 비용 : " + c_road + "]");
            long result = roadsAndLibraries(n, c_lib, c_road, cities);
            System.out.println("RESULT ["+qItr+"] : "+result+"\n");

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

    private long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        Graph graph = Graph.of(n, c_lib, c_road, cities);

        return graph.dfs((next, isRoot) -> {
            // when visit
            return (long) next.getValue().getCost(isRoot);
        });
    }
}
