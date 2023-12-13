/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
class K
 {
    static int v = 5;
    static int[] parent = new int[v];
    static int INF = Integer.MAX_VALUE;

    static int find(int i) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    static void union(int i, int j) {
        int a = find(i);
        int b = find(j);
        parent[a] = b;
    }

    static void kruskal(int[][] cost) {
        int minCost = 0;
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
        int edgeCount = 0;
        while (edgeCount < v - 1) {
            int min = INF;
            int a = -1, b = -1;
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (find(i) != find(j) && cost[i][j] < min) {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }
            if (a != -1 && b != -1) {
                System.out.println("Edge " + a + " - " + b + " : Cost = " + min);
                union(a, b);
                minCost += min;
                edgeCount++;
            } else {
                break;
            }
        }
        System.out.println("Minimum Cost of the Spanning Tree: " + minCost);
        
    }

    public static void main(String[] args) {
        int[][] cost = {
            {INF, 2, INF, 6, INF},
            {2, INF, 3, 8, 5},
            {INF, 3, INF, INF, 7},
            {6, 8, INF, INF, 9},
            {INF, 5, 7, 9, INF}
        };
        kruskal(cost);
    }
}
