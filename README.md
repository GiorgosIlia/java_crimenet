# README.md

## Communication Analysis System

This Java application provides tools for analyzing communications between suspects. It allows users to input suspects, their aliases, locations, and communication details, and then visualize the communication network.

### Features

- Input and manage suspects' information
- Record and analyze communication data
- Visualize the communication network

### Requirements

- Java Development Kit (JDK) installed

### Usage

1. Clone the repository to your local machine.

```
git clone https://github.com/george313/java_crimenet.git
```

2. Compile and run the `Main.java` file using your preferred Java IDE or the command line.

3. Follow the prompts to input suspect and communication data.

4. Use the "Find" button to search for suspects by name.

5. Use the "Visualize Network" button to generate a graphical representation of the communication network.

### Contributing

If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch.
3. Make your changes and commit them.
4. Push the changes to your fork.
5. Create a pull request.

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

# Main Class (Main.java)

```java
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import edu.uci.ics.jung.algorithms.filters.KNeighborhoodFilter.EdgeType;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class Main {

    public static void main(String[] args) {

        ArrayList<Suspect> sus = new ArrayList<Suspect>();
        ArrayList<Communication> comm = new ArrayList<Communication>();        
        
        // (Code for creating suspects and communications goes here)
        
        //Creation of Registry object
        Registry registry = new Registry();
        
        registry.addSuspect(s1);
        registry.addSuspect(s2);
        registry.addSuspect(s3);
        registry.addSuspect(s4);
        registry.addSuspect(s5);
        
        for(int i=0; i<16; i++)
        {
            registry.addCommunication(comms[i]);
            comm.add(comms[i]);
        }
    
        sus.add(s1);
        sus.add(s2);
        sus.add(s3);
        sus.add(s4);
        sus.add(s5);
        
        new MyFrame(sus, comm);
                
    }
}
```

This is the main class of the Communication Analysis System. It initializes and manages the suspects, communications, and the graphical user interface. Suspects and communications are created and added to the registry. The program then visualizes the communication network using a graphical representation.

### Usage

To run the program, ensure you have the Java Development Kit (JDK) installed on your system. Compile and execute the `Main.java` file using your preferred Java IDE or the command line.

---
