package com.sullivan.treegenerator;

import com.sullivan.treegenerator.model.DirectoryNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.stream.Stream;

public class TreeDirectoryApp {

    public static DirectoryNode treeGenerator(File directory) throws IOException {

        DirectoryNode node = new DirectoryNode(directory.getName(), directory.isDirectory());

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    DirectoryNode child = treeGenerator(file);
                    node.getChildren().add(child);
                    node.setFileCount(node.getFileCount() + child.getFileCount());
                    node.setTotalSize(node.getTotalSize() + child.getTotalSize());
                    }
            }
        }
        else {
            node.setFileCount(1);
            node.setTotalSize(directory.length());
        }
        return node;
    }

    private static String byteSize(long bytes) {
        if (bytes < 1024) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String unit = "KMGTPE".charAt(exp - 1) + "B";
        return String.format("%.1f %s", bytes / Math.pow(1024, exp), unit);
    }

    public static void printTree(DirectoryNode node, int depth) {
        System.out.println(
            "  ".repeat(depth) +
            (node.isDirectory() ?
                ">"+ node.getFileName() + " (" + node.getFileCount() + " files " + byteSize(node.getTotalSize()) + ")" :
                "|--" + node.getFileName() + " " + byteSize(node.getTotalSize())
            )
        );
        for (DirectoryNode child : node.getChildren()) {
            printTree(child, depth + 1);
        }
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
                    String rootPath = sc.nextLine();
                    File rootFile = new File(rootPath);
                    try {
                        if (!rootFile.exists() || !rootFile.isDirectory()) {
                            System.out.println("Directory does not exist or is not a directory.");
                            break;
                        }
                        DirectoryNode root = treeGenerator(rootFile);
                        printTree(root, 0);
                    }
                    catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    run = false;
                    System.out.println("Thanks for using the Directory Visualizer");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
