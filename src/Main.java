import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //list of vertexes ang edges
    List<Integer> list = new ArrayList<>();
    int vertexNumber = 0;
    int edges = 0;
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
        arrayOfVertexes = new Vertex[edges];
    }

    public static void main(String[] args) {
        Main m = new Main();
        try {
        m.readFromFile("/home/Dominika/IdeaProjects/PrimAlgorithm/src/text.txt"); }
        catch(Exception io) { }
    }
}
