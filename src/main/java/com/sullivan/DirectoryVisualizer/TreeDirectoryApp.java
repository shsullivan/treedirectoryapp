package com.sullivan.DirectoryVisualizer;

import java.util.Scanner;

public class TreeDirectoryApp {
    public static void main(String[] args) {
        boolean run = true;
        Scanner sc = new Scanner(System.in);

        while (run) {
            System.out.println("\nWelcome to Directory Visualizer");
            System.out.println("1. Create Directory Tree Visualizer");
            System.out.println("2. Exit Application");
            System.out.println("Select from the options above: ");
            String choice = sc.nextLine();
            run = false;
        }
    }
}
