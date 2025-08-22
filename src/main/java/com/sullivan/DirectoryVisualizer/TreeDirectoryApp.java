package com.sullivan.DirectoryVisualizer;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class TreeDirectoryApp {

    public static void directoryGenerator(Path path, int depth) throws IOException {

        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);

        if(attrs.isDirectory()) {
            DirectoryStream<Path> stream = Files.newDirectoryStream(path);
            System.out.println(depthVisual(depth) + ">" + path.getFileName());

            for(Path child : stream) {
                directoryGenerator(child, depth + 1);
            }
        }
        else {
            System.out.println(depthVisual(depth) + "|--" + path.getFileName());
        }
    }

    public static String depthVisual(int depth) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        boolean run = true;
        Scanner sc = new Scanner(System.in);

        while (run) {
            System.out.println("\nWelcome to Directory Visualizer");
            System.out.println("1. Create Directory Tree Visualizer");
            System.out.println("2. Exit Application");
            System.out.println("Select from the options above: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter the path of the root file for your directory: ");
                    String path = sc.nextLine();
                    Path rootPath = Paths.get(path);
                    try {
                        directoryGenerator(rootPath, 0);
                    }
                    catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    run = false;
                    System.out.println("Thanks for using the Directory Visualizer");
                    break;
            }
        }
    }
}
