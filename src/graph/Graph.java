package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图 邻接表数据结构
 * @Author: dj
 * @Date: 2019/11/1 0:09
 * @Version 1.0
 */
public class Graph {
    //顶点数量
    private int V;
    //边数量
    private int E;
    //邻接表
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        //
        adj = (Bag<Integer>[]) new Bag[V];
        //
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(int V, int E, List<String> list) {
        //初始化图
        this(V);
        for (int i = 0; i < E; i++) {
            String vw = list.get(i);
            String[] split = vw.split("-");
            //读取第一个顶点
            int v = Integer.valueOf(split[0]);
            //读取第二个顶点
            int w = Integer.valueOf(split[1]);
            //添加一条连接它们的边
            addEdge(v,w);
        }
    }

    /**
     * 向图中添加一条边v-w
     * @param v
     * @param w
     */
    private void addEdge(int v, int w) {
        //将w添加到v的链表中
        adj[v].add(w);
        //将v添加到w的链表中
        adj[w].add(v);
        E++;
    }


    /**
     * 和v相邻的所有顶点
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int getE() {
        return E;
    }

    public int getV() {
        return V;
    }

    /**
     * 对象字符串
     * @return
     */
    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int i = 0; i < V; i++) {
            s += i + ": ";
            for (int j : this.adj(i)) {
                s += j + " ";
            }
            s += "\n";
        }
        return s;
    }


    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("0-5");list.add("4-3");
        list.add("0-1");list.add("9-12");
        list.add("6-4");list.add("5-4");
        list.add("0-2");list.add("11-12");
        list.add("9-10");list.add("0-6");
        list.add("7-8");list.add("9-11");list.add("5-3");
        Graph graph = new Graph(13, 13, list);
        System.out.println(graph.toString());
    }
}
