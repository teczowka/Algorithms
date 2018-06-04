import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //list of vertexes ang edges
    List<Integer> list = new ArrayList<>();
    List<Integer> blue = new ArrayList<>();
    int vertexNumber = 0;
    int edges = 0;
    int start = 0;

    Vertex[] arrayOfVertexes;

    class Vertex{
        //number of vertex
        int vertex = 0;
        //vertex connected
        int vertexConnected = 0;
        //cost of edge
        int cost = 0;
    }

    void readFromFile(String filepath) throws java.io.IOException {
        Scanner s = new Scanner(new File(filepath));

        while(s.hasNext())
            list.add(s.nextInt());
        s.close();
    }

    void setParameters() {
        vertexNumber = list.get(0);
        edges = list.get(1);
        start = list.get(2);
        arrayOfVertexes = new Vertex[edges];
    }

    void setVertexes() {
        int index = 3;
        int temp = 0;
        while(list.size() != index) {
            Vertex v = new Vertex();
            v.vertex = list.get(index);
            index++;
            v.vertexConnected = list.get(index);
            index++;
            v.cost = list.get(index);
            index++;
            arrayOfVertexes[temp] = v;
            temp++;
        }
    }

     //choosing the cheapest edge
     int cheapestPath(int vertexNumber) {
       
         int cheaper = -1;
         int temp = 0;
         for(int i = 0; i < arrayOfVertexes.length-1; i++) {
             if (arrayOfVertexes[i].vertex == vertexNumber || arrayOfVertexes[i].vertexConnected == vertexNumber) {
                 temp++;
             }
         }

         //wszystkie miasta polaczone z vertexNumber
         Vertex[] neighbours = new Vertex[temp];
         temp = 0;
         for(int i = 0; i < arrayOfVertexes.length-1; i++) {
             if (arrayOfVertexes[i].vertex == vertexNumber) {
                 neighbours[temp] = arrayOfVertexes[i];
                 temp++;
             }else if(arrayOfVertexes[i].vertexConnected == vertexNumber) {
                 neighbours[temp] = arrayOfVertexes[i];
                 temp++;
             }
         }

         //sorting cities by the lowest cost
         for(int i = 0; i < neighbours.length; i++) {
             for(int j = 1; j < neighbours.length-i ; i++) {
                 if(neighbours[i].cost > neighbours[j].cost) {
                     Vertex x = neighbours[i];
                     neighbours[i] = neighbours[j];
                     neighbours[j] = x;
                 }
             }
         }

         //choosing first grey city
         for(int i = 0; i < neighbours.length; i++) {
             if(neighbours[i].vertex == vertexNumber) {
                 if(blue.contains(neighbours[i].vertexConnected))
                     continue;
                 else {
                     cheaper = neighbours[i].vertexConnected;
                     break;
                 }
             } else if(neighbours[i].vertexConnected == vertexNumber) {
                 if(blue.contains(neighbours[i].vertex))
                     continue;
                 else {
                     cheaper = neighbours[i].vertex;
                     break;
                 }
             }
         }
         return cheaper;
    }

    void prim() {
        //adding vertex that we start from
        blue.add(start);

        int cost = 0, cheapest = 0;
        int mst = 0;


    }

    public static void main(String[] args) {
        Main m = new Main();

        try {
        m.readFromFile("/home/Dominika/IdeaProjects/PrimAlgorithm/src/text.txt");
        } catch(Exception e) { e.printStackTrace(); }

        m.setParameters();
        m.setVertexes();

    }
}
