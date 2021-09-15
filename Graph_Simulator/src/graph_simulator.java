import java.util.Scanner;

public class graph_simulator {
    public static <Graph> void main(String[] args)
    {   System.out.println("Choose a function ");
        System.out.println("1. Connected Components");
        System.out.println("2. Detect cycle");
        System.out.println("3. Shortest path");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter choice");
        int fchoice = myObj.nextInt();
        if(fchoice!=1&&fchoice!=2&&fchoice!=3)
        {
            System.out.println(
                    "Invalid input");
            System.exit(0);
        }
        System.out.println("Choose a graph to test functions");
        System.out.println("1. N cycle graph");
        System.out.println("2. A complete graph of n vertices");
        System.out.println("3. An empty graph on n vertices");
        // Create a Scanner object
        System.out.println("Enter choice");
        int graphchoice = myObj.nextInt();  // Read user input

        if(graphchoice!=1&&graphchoice!=2&&graphchoice!=3)
        {
            System.out.println(
                    "Invalid input");
            System.exit(0);
        }

        System.out.println("Enter number of vertices");
        int vert = myObj.nextInt();  // Read user input
        System.out.println("Entered number of vertices = " + vert);
        if(fchoice==1)
        {
            if(graphchoice==1)
            {

                Graph1 g1 = new Graph1(
                        vert); // 5 vertices numbered from 0 to 4
                int i;
                for(i=0;i<vert-1;i++)
                {
                    g1.addEdge(i, i+1);
                }
                g1.addEdge(0, vert-1);
                System.out.println(
                        "Following are connected components");
                g1.connectedComponents();

            }


            if(graphchoice==2)
            {
                Graph2 g2 = new Graph2(
                        vert); // 5 vertices numbered from 0 to 4

                for(int i=0;i<vert;i++)
                {
                    for(int j=0;j<vert;j++)
                    {
                        if(i!=j)
                        {

                            g2.addEdge(i, j);
                        }

                    }
                }
                System.out.println(
                        "Following are connected components");
                g2.connectedComponents();

            }



            if(graphchoice==3)
            {
                Graph3 g3 = new Graph3(
                        vert); // 5 vertices numbered from 0 to 4
                System.out.println(
                        "Following are connected components");
                g3.connectedComponents();
            }
        }
        if(fchoice==2)
        {
            if(graphchoice==1)
            {
                Graph4 g4 = new Graph4(vert);

                for(int i=0;i<vert-1;i++)
                {
                    g4.addEdge(i, i+1);
                }
                g4.addEdge(0, vert-1);

                if(g4.isCyclic())
                    System.out.println("Graph contains cycle");
                else
                    System.out.println("Graph doesn't "
                            + "contain cycle");
            }


            if(graphchoice==2)
            {
                Graph5 g5 = new Graph5(
                        vert); // 5 vertices numbered from 0 to 4

                for(int i=0;i<vert;i++)
                {
                    for(int j=0;j<vert;j++)
                    {
                        if(i!=j)
                        {

                            g5.addEdge(i, j);
                        }

                    }
                }
                if(g5.isCyclic())
                    System.out.println("Graph contains cycle");
                else
                    System.out.println("Graph doesn't "
                            + "contain cycle");

            }
            if(graphchoice==3)
            {
                Graph6 g6 = new Graph6(
                        vert);
                if(g6.isCyclic())
                    System.out.println("Graph contains cycle");
                else
                    System.out.println("Graph doesn't "
                            + "contain cycle");
            }
        }



        if(fchoice==3)
        {

            if(graphchoice==1)
            {

                Graph7 g7 = new Graph7(vert);
                int sourceVertex = 0;

                for(int i=0;i<vert-1;i++)
                {
                    g7.addEdge(i, i+1,1);
                }
                g7.addEdge(0, vert-1,1);
                g7.dijkstra_GetMinDistances(sourceVertex);



            }
            if(graphchoice==2)
            {

                Graph8 g8 = new Graph8(vert);
                int sourceVertex = 0;


                for(int i=0;i<vert;i++)
                {
                    for(int j=0;j<vert;j++)
                    {
                        if(i!=j)
                        {

                            g8.addEdge(i, j,1);
                        }

                    }
                }

                g8.dijkstra_GetMinDistances(sourceVertex);



            }
            if(graphchoice==3)
            {

                Graph9 g9 = new Graph9(vert);
                int sourceVertex = 0;

                g9.dijkstra_GetMinDistances(sourceVertex);
            }

        }
    }
}
