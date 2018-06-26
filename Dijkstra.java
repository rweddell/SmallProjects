/*
Rob Weddell
Dijkstra's Algorithm
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex>{
	String name;
	int distance;
	Vertex (String name, int distance){
		this.name = name;
		this.distance = distance;
	}
	public int compareTo(Vertex other){
		if(this.distance < other.distance) return -1;
		if(this.distance > other.distance) return 1;
		else return 0;
	}
	@Override
	public String toString(){
		return (name + " " + distance);
	}
}

class EdgeList {
	String name;
	List<Vertex> neighbors;
	
	EdgeList(String name){
		this.name = name;
		neighbors = new ArrayList<>();
	}
	public void addNeighbor(Vertex neighbor){
		neighbors.add(neighbor);
	}
	@Override
	public String toString(){
		String edges = this.name + ": ";
		for (Vertex vert : neighbors){
			edges = edges + vert.name + " - " + vert.distance + ";  ";
		}
		return edges;
	}
}

class DijkstraObj{
	Map<String, EdgeList> adjList;
	
	/*  Step 3  */
	PriorityQueue<Vertex> minHeap = new PriorityQueue<Vertex>();;
	List<Vertex> graph;
	Map<String, String> childOf = new HashMap<String, String>();
	Map<String, Integer> shortestPath = new HashMap<String, Integer>();
	
	@SuppressWarnings("unchecked")
	DijkstraObj(HashMap<String, EdgeList> adjList, List<Vertex> graph){
		this.adjList = adjList;
		this.graph = graph;
		
		/*  Step 1  */
		for (String vertex: adjList.keySet()){
			childOf.put( vertex, null);
			
			/*  Step 2  */
			if(vertex.equals("A"))
				shortestPath.put( vertex, 0);
			else
				shortestPath.put( vertex, Integer.MAX_VALUE);
		}
		
		/*  Step 4  */
		for(Vertex v : graph){
			minHeap.add(v);
		}
		/*Checking the formation of the priority queue */
		//System.out.println("This is the priority queue on formation: \n" + minHeap.toString());
	}
	
	public void findShortestPaths( ){
		Vertex parent;
		
		/*  Step 5  */
		while(minHeap.size() > 0){
			parent = minHeap.poll();
			
			/*adjList contains a list of lists of edges, even though the edges are 
			of type Vertex but they contain the weight of the line between two points */
			EdgeList parentEdges = adjList.get(parent.name);		
			if(parentEdges != null){
				for (Vertex edge : parentEdges.neighbors){
					if(shortestPath.get(edge.name) != null){
						if( (shortestPath.get(parent.name) + edge.distance) < shortestPath.get(edge.name)){
							minHeap.remove(edge);
							shortestPath.replace(edge.name, shortestPath.get(parent.name) + edge.distance);
							childOf.replace(edge.name, parent.name);
							minHeap.add(new Vertex(edge.name, shortestPath.get(edge.name)));
						}
					}
				}
			}
		}
	}
	public String parentageToString(){
		return (childOf.toString());
	}
	public String shortestPathToString(){
		return (shortestPath.toString());
	}
}

public class Dijkstra {
	
	static void putWeightedEdge (HashMap<String, EdgeList> adjList, String begin, String end, int weight){
		EdgeList edgeList;
		if (!adjList.containsKey(begin)){
			edgeList = new EdgeList(begin);
			edgeList.addNeighbor(new Vertex(end, weight));
			adjList.put(begin, edgeList);
		}
		else {
			edgeList = adjList.get(begin);	
			edgeList.addNeighbor(new Vertex(end,weight));
		} 
		if (!adjList.containsKey(end)){
			edgeList = new EdgeList(end);
			adjList.put(end, edgeList);
		} 
	}

    public static void main(String[] args) {
		
        String fileName = "notFound";
		HashMap<String, EdgeList> adjList = new HashMap<String, EdgeList>();
		String line = null;
		String[] star;
		int numNodes;
		List<String> vertStr = new ArrayList<>();
		List<Vertex> vertices = new ArrayList<>();
		DijkstraObj dob;
		
        if(args.length > 0){
            fileName = args[0];
        }
        if (fileName.equals("notFound")){
            System.out.println("You need to run this program with an existing file as an argument.");
        }
        else {
            try{
                BufferedReader bure = new BufferedReader(new FileReader(new File(fileName)));
                line = bure.readLine();
                numNodes = Integer.parseInt(line);
                while ((line = bure.readLine()) != null){
                    star = line.split(" ");
					putWeightedEdge(adjList, star[0], star[1], Integer.parseInt(star[2]));
                    if(!vertStr.contains(star[0])){
						vertStr.add(star[0]);
					}
					if(!vertStr.contains(star[1])){
						vertStr.add(star[1]);
					}	
                }		
				for(String str : vertStr){
					if(str.equals("A"))
						vertices.add(new Vertex(str, 0));
					else
					vertices.add(new Vertex(str, Integer.MAX_VALUE));
				}
				
				/*Checks the adjacency list for errors*/
				/* EdgeList edgy;
				for (String str : adjList.keySet()){
					edgy = adjList.get(str);
					System.out.println(edgy.toString());
				}  */
            }catch (Exception exc){
                exc.printStackTrace();
            }
			try{
				dob = new DijkstraObj(adjList, vertices);
				dob.findShortestPaths();
				
				/*   Step 6   */
				/*Can use these lines to check results*/
				//System.out.println(dob.shortestPathToString());		
				//System.out.println(dob.parentageToString());
				
				/*This block formats the results into the output specified in the assignment*/
				String pathway = "";
				String parent = "B";
				while(parent != null){
					pathway = parent + " " + pathway ;
					parent = dob.childOf.get(parent);
				}
				System.out.println();
				System.out.println(dob.shortestPath.get("B"));
				System.out.println(pathway);
				
			}catch (Exception exc){
				exc.printStackTrace();
			}
        }
    }
}
