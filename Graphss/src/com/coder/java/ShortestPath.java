package com.coder.java;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
public class ShortestPath {
	

	    public static int distances[];
	    private Queue<Integer> queue;
	    private Set<Integer> settled;
	    private int number_of_nodes;
	    private int adjacencyMatrix[][];
	 
	    public ShortestPath(int number_of_nodes)
	    {
	        this.number_of_nodes = number_of_nodes;
	        distances = new int[number_of_nodes + 1];
	        settled = new HashSet<Integer>();
	        queue = new LinkedList<Integer>();
	        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
	    }
	 
	    public void dijkstra_algorithm(int adjacency_matrix[][], int source)
	    {
	        int evaluationNode;
	        for (int i = 1; i <= number_of_nodes; i++)
	            for (int j = 1; j <= number_of_nodes; j++)
	                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
	 
	        for (int i = 1; i <= number_of_nodes; i++)
	        {
	            distances[i] = Integer.MAX_VALUE;
	        }
	 
	        queue.add(source);
	        distances[source] = 0;
	 
	        while (!queue.isEmpty())
	        {
	            evaluationNode = getNodeWithMinimumDistanceFromQueue();
	            settled.add(evaluationNode);
	            evaluateNeighbours(evaluationNode);
	        }
	    }
	 
	    private int getNodeWithMinimumDistanceFromQueue()
	    {
	        int min ;
	        int node = 0;
	        Iterator<Integer> iterator = queue.iterator();
	        node = iterator.next();
	        min = distances[node];
	 
	        for (int i = 1; i <= distances.length; i++)
	        {
	            if (queue.contains(i))
	            {
	                if (distances[i] <= min)
	                {
	                    min = distances[i];
	                    node = i;			
	                }
	            }
	        }
	        queue.remove(node);
	        return node;
	    }
	 
	    private void evaluateNeighbours(int evaluationNode)
	    {
	        int edgeDistance = -1;
	        int newDistance = -1;
	 
	        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)
	        {
	            if (!settled.contains(destinationNode))
	            {
	                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
	                {
	                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
	                    newDistance = distances[evaluationNode] + edgeDistance;
	                    if (newDistance < distances[destinationNode])
	                    {
	                        distances[destinationNode] = newDistance;
	                    }
	                    queue.add(destinationNode);
	                }
	            }
	        }
	    }
}
	 
	    
