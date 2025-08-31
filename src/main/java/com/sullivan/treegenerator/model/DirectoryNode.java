package com.sullivan.treegenerator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>DirectoryNode</h1>
 * @author Shawn Sullivan
 * CEN 4025C - 14148 <br>
 * August 30, 2025 <br>
 * DirectoryNode is the base class for the Tree Directory App. The DirectoryNode object acts as the root for each level
 * of the directory tree structure
 */

public class DirectoryNode {

    // Attributes
    private String fileName;
    private boolean isDirectory;
    private List<DirectoryNode> children =  new ArrayList<>();
    private int fileCount;
    private long totalSize;

    /**
     * Default constructor (for invocation by subclass constructors, typically implicit.)
     */
    public DirectoryNode(String fileName, boolean isDirectory, int fileCount, long totalSize) {
        this.fileName = fileName;
        this.isDirectory = isDirectory;
        this.fileCount = fileCount;
        this.totalSize = totalSize;
    }

    /**
     * Instantiates a DirectoryNode based on fileName and isDirectory provided. All other values are null
     * @param fileName String generated File.getName() and stored for display in tree directory
     * @param isDirectory boolean generated from File.isDirectory() and used in tree directory storage logic
     */
    // Custom Constructor
    public DirectoryNode(String fileName, boolean isDirectory) {
        this.fileName = fileName;
        this.isDirectory = isDirectory;
    }

    // Getters and setters

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public boolean isDirectory() {
        return isDirectory;
    }
    public void setDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }
    public List<DirectoryNode> getChildren() {
        return children;
    }
    public void setChildren(List<DirectoryNode> children) {
        this.children = children;
    }
    public int getFileCount() {
        return fileCount;
    }
    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }
    public long getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
}
