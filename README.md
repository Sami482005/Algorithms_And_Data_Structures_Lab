## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

---

# Project: Hamra Route Finder

This Java console app models a subset of Hamra as a graph of connecting points (buildings/intersections) and computes the shortest path between two named locations, printing simple directions.

Files of interest:
- `src/Project/ConnectingPoints.java` — Vertex model with kind, name, (x,y) coordinates
- `src/Project/Edge.java` — Undirected edge with distance
- `src/Project/Graph.java` — Undirected weighted graph + Dijkstra shortest path
- `src/Project/Directions.java` — Turns a path into left/right/straight steps with distances
- `src/Project/Main.java` — CLI to ask for start/destination and print directions

Run:
```bash
javac -d bin $(find src -name "*.java")
java -cp bin Project.Main
```

When prompted, type names from the current sample dataset (you can change them in `Main.sampleHamraGraph()`):
- LAU
- Crepaway
- Starbucks
- HamraMain
- Bliss

Example output:
```
Enter your current location (name): LAU
Enter your destination (name): Starbucks
Start at LAU
Go straight 300 meters to Crepaway
Go straight 300 meters to Starbucks
```

Customize your map:
- Replace `sampleHamraGraph()` in `Main.java` with your actual list of `ConnectingPoints` and `addEdge(...)` calls.
- Coordinates are in meters; assume +X East, +Y North for direction wording.
