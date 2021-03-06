package ee.ttu.algoritmid.erdos;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

public class AL05 {
    public  Graph graph = new Graph();

    //enne oli private
    private class Graph {
        private Map<String, List<String>> graph = new HashMap<>();
        private Map<String, Integer> erdosNumbers = new HashMap<>();


        private void addDirectedEdge(String one, String other) {
            if (!graph.containsKey(one)) {
                List<String> edges = new ArrayList<>();
                edges.add(other);
                graph.put(one, edges);
            } else if (!graph.get(one).contains(other)) {
                graph.get(one).add(other);
            }
        }

        /**
         * Add undirected edge to the graph.
         *
         * @param one   one element of the edge
         * @param other the other element of edge
         */
        public void addEdge(String one, String other) {
            addDirectedEdge(one, other);
            addDirectedEdge(other, one);
            if (!erdosNumbers.containsKey(one)) {
                erdosNumbers.put(one, -1);
            }
            if (!erdosNumbers.containsKey(other)) {
                erdosNumbers.put(other, -1);
            }
        }

        /**
         * Return the graph.
         *
         * @return the internal graph structure.
         */
        public Map<String, List<String>> getGraph() {
            return graph;
        }

        /**
         * Perform breadth first search.
         *
         * @param goal the goal vertex to find
         * @return the Erdos number of goal or -1 if there is no chain of coauthors leading from Erdös to goal.
         * Note that search should always start from "Paul Erdös" whose Erdös number is 0.
         */
        public Integer breadthFirstSearch(String goal) {
            Queue<String> queue = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();
            final String paul = "Paul Erdös";
            String current = paul;

            queue.add(paul);
            erdosNumbers.put(paul, 0);

            if (goal.equals(paul)) {
                return erdosNumbers.get(paul);
            }
            while (!queue.isEmpty()) {
                queue.remove();
                visited.add(current);
                List<String> collaborators = graph.get(current);
                for (String collaborator : collaborators
                ) {
                    if (erdosNumbers.get(collaborator) == -1 ) {
                        if (!visited.contains(collaborator)) {
                            queue.add(collaborator);
                            erdosNumbers.put(collaborator, erdosNumbers.get(current) + 1);
                        }
                    }

                }
                if (!queue.isEmpty()) {
                    current = queue.element();
                }
                if (current.equals(goal)) {
                    return erdosNumbers.get(goal);
                }
            }
            //  }
            return -1;
        }
    }


    /**
     * Use buildGraphAndFindErdosNumber to build a graph using the Graph class and then use its breadthFirstSearch to
     * return the Erdos number.
     *
     * @param coauthors the list of people who have coauthored scientific papers as pairs
     *                  (e.g., [["Juhan", "Jaan"], ["Juhan", "Siiri"]] means that "Juhan" has published with "Jaan" and "Siiri")
     * @param scientist the name of the scientist whose Erdös number needs to be determined or -1 if it can`t be done
     * @return the Erdos number of the scientist
     */
    public Integer buildGraphAndFindErdosNumber(List<SimpleEntry<String, String>> coauthors,
                                                       String scientist) {
        for (SimpleEntry<String, String> pair : coauthors
        ) {
            graph.addEdge(pair.getKey(), pair.getValue());
        }

        return graph.breadthFirstSearch(scientist);
    }

    public static void main(String[] args) {
        SimpleEntry<String, String> a = new AbstractMap.SimpleEntry<>("Pets", "Paul Erdös");
        SimpleEntry<String, String> b = new AbstractMap.SimpleEntry<>("Kadri", "Paul Erdös");
        SimpleEntry<String, String> c = new AbstractMap.SimpleEntry<>("Ants1", "Paul Erdös");
        SimpleEntry<String, String> d = new AbstractMap.SimpleEntry<>("Ants1", "Pets");
        SimpleEntry<String, String> e = new AbstractMap.SimpleEntry<>("Tõnu", "Pets");
        SimpleEntry<String, String> f = new AbstractMap.SimpleEntry<>("Mihkel", "Kadri");
        SimpleEntry<String, String> g = new AbstractMap.SimpleEntry<>("Petrus", "Kadri");
        SimpleEntry<String, String> h = new AbstractMap.SimpleEntry<>("Mihkel", "Ants");
        SimpleEntry<String, String> i = new AbstractMap.SimpleEntry<>("Andero", "Ants");
        SimpleEntry<String, String> j = new AbstractMap.SimpleEntry<>("Petrus", "Tõnu");
        SimpleEntry<String, String> l = new AbstractMap.SimpleEntry<>("Petrus", "Ants");
        SimpleEntry<String, String> m = new AbstractMap.SimpleEntry<>("Andero", "Ants1");
        SimpleEntry<String, String> n = new AbstractMap.SimpleEntry<>("Andero1", "Ants1");
        SimpleEntry<String, String> o = new AbstractMap.SimpleEntry<>("Andero2", "Andero1");
        SimpleEntry<String, String> p = new AbstractMap.SimpleEntry<>("Andero2", "Andero3");
        SimpleEntry<String, String> q = new AbstractMap.SimpleEntry<>("Andero4", "Andero3");

        SimpleEntry<String, String> r = new AbstractMap.SimpleEntry<>("Andero4", "Petrus");

        List<SimpleEntry<String, String>> dos = new ArrayList<>();
//        dos.add(a);
//        dos.add(new AbstractMap.SimpleEntry<String, String>("Pets", "Paul Erdös"));
        dos.add(b);
        dos.add(c);
        dos.add(d);
        dos.add(e);
        dos.add(f);
//        dos.add(g);
        dos.add(h);
        dos.add(i);
//        dos.add(j);
        dos.add(l);
        dos.add(m);
        dos.add(n);
        dos.add(o);
        dos.add(p);
        dos.add(q);
    //    System.out.println(buildGraphAndFindErdosNumber(dos, "Petrus"));


//        SimpleEntry<String, String> uno = new AbstractMap.SimpleEntry<String, String>("Stina", "Liisi");
//        SimpleEntry<String, String> tres = new AbstractMap.SimpleEntry<String, String>("Stina", "Paul Erdös");
//
//        SimpleEntry<String, String> tres1 = new AbstractMap.SimpleEntry<String, String>("Liisi", "Paul Erdös");
//        SimpleEntry<String, String> tres2 = new AbstractMap.SimpleEntry<String, String>("Liisi", "Kartul");
//        SimpleEntry<String, String> tres3 = new AbstractMap.SimpleEntry<String, String>("Kartul", "Paul");
//        SimpleEntry<String, String> tres4 = new AbstractMap.SimpleEntry<String, String>("Stina", "Paul1");
//        List<SimpleEntry<String, String>> dos = new ArrayList<>();
//        dos.add(uno);
//        dos.add(tres);
//        dos.add(tres1);
//        dos.add(tres2);
//        dos.add(tres3);
//        dos.add(tres4);
//
//        System.out.println(buildGraphAndFindErdosNumber(dos, "Liisi"));
    }
}