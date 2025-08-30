package com.sullivan.treegenerator.model;

import java.util.ArrayList;
import java.util.List;

public class DirectoryNode {

    // Attributes
    private String fileName;
    private boolean isDirectory;
    private List<DirectoryNode> children =  new ArrayList<>();
    private int fileCount;
    private long totalSize;

    // Constructor
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
