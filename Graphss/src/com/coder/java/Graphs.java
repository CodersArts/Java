package com.coder.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graphs {
	private static final int INFINITE = 999;
	private static Scanner scanner = new Scanner(System.in);

	public static int[][] checkGraph(int[][] adjacency_matrix, int number_no_nodes) {
		int source;

		try {
			adjacency_matrix = new int[number_no_nodes + 1][number_no_nodes + 1];
			System.out.println("Enter the adjacency matrix");
			for (int i = 1; i <= number_no_nodes; i++)
				for (int j = 1; j <= number_no_nodes; j++)
					adjacency_matrix[i][j] = scanner.nextInt();

			for (int i = 1; i <= number_no_nodes; i++) {
				for (int j = 1; j <= number_no_nodes; j++) {
					if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0) {
						adjacency_matrix[j][i] = 1;
					}
				}
			}

			System.out.println("Enter the source for the graph");
			source = scanner.nextInt();

			IsConnected undirectedConnectivity = new IsConnected();
			undirectedConnectivity.bfs(adjacency_matrix, source);

		} catch (InputMismatchException inputMismatch) {
			System.out.println("Wrong Input Format");
		}

		return adjacency_matrix;
	}

	public static int[][] minSpanningTree(int[][] adjacency_matrix, int number_no_nodes) {

		try {

			adjacency_matrix = new int[number_no_nodes + 1][number_no_nodes + 1];

			System.out.println("Enter the Weighted Matrix for the graph");
			for (int i = 1; i <= number_no_nodes; i++) {
				for (int j = 1; j <= number_no_nodes; j++) {
					adjacency_matrix[i][j] = scanner.nextInt();
					if (i == j) {
						adjacency_matrix[i][j] = 0;
						continue;
					}
					if (adjacency_matrix[i][j] == 0) {
						adjacency_matrix[i][j] = INFINITE;
					}
				}
			}

			MST mst = new MST(number_no_nodes);
			mst.primsAlgorithm(adjacency_matrix);
			mst.printMST();

		} catch (InputMismatchException inputMismatch) {
			System.out.println("Wrong Input Format");
		}

		return adjacency_matrix;
	}

	public static int[][] shortestPath(int[][] adjacency_matrix, int number_no_nodes) {
		int source = 0;

		try {
			System.out.println("Enter the number of vertices");
			number_no_nodes = scanner.nextInt();
			adjacency_matrix = new int[number_no_nodes + 1][number_no_nodes + 1];

			System.out.println("Enter the Weighted Matrix for the graph");
			for (int i = 1; i <= number_no_nodes; i++) {
				for (int j = 1; j <= number_no_nodes; j++) {
					adjacency_matrix[i][j] = scanner.nextInt();
					if (i == j) {
						adjacency_matrix[i][j] = 0;
						continue;
					}
					if (adjacency_matrix[i][j] == 0) {
						adjacency_matrix[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			System.out.println("Enter the source ");
			source = scanner.nextInt();
			ShortestPath dijkstrasQueue = new ShortestPath(number_no_nodes);
			dijkstrasQueue.dijkstra_algorithm(adjacency_matrix, source);

			System.out.println("The Shorted Path to all nodes are ");
			for (int i = 1; i <= dijkstrasQueue.distances.length - 1; i++) {
				System.out.println(source + " to " + i + " is " + dijkstrasQueue.distances[i]);
			}
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Wrong Input Format");
		}

		return adjacency_matrix;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		int choice;
		int wish;
		int number_no_nodes = 0;
		int adjacency_matrix[][] = new int[10][10];

		System.out.println(" Enter graphFileName");
		String graphFileName = scanner.next();
		int i, j, x = 0, y = 0;
		String line;

		try {
			Scanner sc = new Scanner(new BufferedReader(new FileReader(graphFileName)));
			line = sc.nextLine().trim();
			while (line.length() > 0) // file reading
			{
				String[] values = line.split("\\s+");
				
				if (values.length ==  1) {
					number_no_nodes = Integer.parseInt(values[0]);
					System.out.println("number_no_nodes :" + number_no_nodes);
				} else {
					
					for (String str : values) {
						int str_int = Integer.parseInt(str);
						adjacency_matrix[x][y] = str_int;
						System.out.print(adjacency_matrix[x][y] + " ");
					}
					y = y + 1;
					System.out.println();
				}
				x = x + 1;
				line = sc.nextLine().trim();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	

		do {
			System.out.println(" Enter Choices");
			System.out.println("1) Is Connected ");
			System.out.println("2) Minimum Spanning Tree ");
			System.out.println("3) Shortest Path");
			System.out.println("4) Quit");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				adjacency_matrix = checkGraph(adjacency_matrix, number_no_nodes);
				break;

			case 2:
				adjacency_matrix = minSpanningTree(adjacency_matrix, number_no_nodes);
				break;
			case 3:
				adjacency_matrix = shortestPath(adjacency_matrix, number_no_nodes);
				break;

			case 4:
				System.exit(0);
				break;

			}

			System.out.println(" Do you want to continue(1/0)?");
			wish = scanner.nextInt();

		} while (wish == 1);

	}

}
