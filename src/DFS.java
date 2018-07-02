import edu.princeton.cs.algs4.Graph;

public class DFS {
	
	private boolean[] marked;
    public int size;
    private boolean already_searched = false;
	
	public DFS(Graph G) {
        marked = new boolean[G.V()];
    }
	
	public void dfs_check(Graph G, int v) {
		if(!marked[v]) {
			dfs(G,v);
		}
	}
	
	// depth first search from v
    public void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                size++;
                dfs(G, w);
            }
        }
    }
    
    public boolean[] getMarked() {
    	return this.marked;
    }
    
    public int getSize() {
    	if(size == 0)return 0;
    	return this.size + 1;
    }
    
    public boolean as() {
    	return this.already_searched;
    }
    
    public void setSize(int size) {
    	this.size = size;
    }


}
