import java.util.ArrayList;

import edu.princeton.cs.algs4.Graph;



public class JourneyMoon {
	
	public static void main(String [] args) {
		int n = journeyToMoon(4,8, new int [][] {{5,3}, {0,1}
		,{2,3}, {0,4}});
		System.out.println(n);
	}
		
	static Graph createGraph(int [][] astro, int p, int n) {
		Graph g = new Graph(n);
		for(int i = 0; i < p; i++) {
//			System.out.println(astro[i][0]);
//			System.out.println(astro[i][1]);;
			g.addEdge(astro[i][0], astro[i][1]);
		}
		return g;
	}
	
	
	 // Complete the journeyToMoon function below.
    static int journeyToMoon(int p, int n, int[][] astronaut) {
    	Graph g = createGraph(astronaut, p, n);
    	
    	System.out.println(g);
    	
    	ArrayList<Integer> set_sizes = new ArrayList<Integer>();
		DFS search = new DFS(g);

	   	for(int i = 0; i < g.V(); i++) {
    		search.dfs_check(g, i);
    		int size = search.getSize();
    		if(size > 0 && !search.as())set_sizes.add(size);
    		search.setSize(0);
	    }
	   	
	   	System.out.println(set_sizes);
	   	
	   	
	   	int sum = 0, result = 0;
	   	for(int i = 0; i < set_sizes.size(); i++) {
	   		result += sum*set_sizes.get(i);
	   		sum += set_sizes.get(i);
	   	}
    	return result;
    }

}
