package com.coder.java;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsConnected {
                          
	    private Queue<Integer> queue;
	 
	    public IsConnected()
	    {
	        queue = new LinkedList<Integer>();
	    }
	 
	    public void bfs(int adjacency_matrix[][], int source)
	    {
	        int number_of_nodes = adjacency_matrix[source].length - 1;
	 
	        int[] visited = new int[number_of_nodes + 1];
	        int i, element;
	        visited[source] = 1;
	        queue.add(source);
	        while (!queue.isEmpty())
	        {
	            element = queue.remove();
	            i = element;
	            while (i <= number_of_nodes)
	            {
	                if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
	                {
	                    queue.add(i);
	                    visited[i] = 1;
	                }
	                i++;
	            }
	        }  
	        boolean connected = false; 
	 
	        for (int vertex = 1; vertex <= number_of_nodes; vertex++)
	        {
	            if (visited[vertex] == 1)
	            {
	                connected = true;
	            } else
	            {
	                connected = false;
	                break;
	            }
	        }
	 
	        if (connected)
	        {
	            System.out.println("The graph is connected");
	        } else
	        {
	            System.out.println("The graph is disconnected");
	        }
	    }
	 
}
	


