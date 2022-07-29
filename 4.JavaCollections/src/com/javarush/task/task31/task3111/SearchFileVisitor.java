package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int maxSize;
    private int minSize;

    private List<Path> foundFiles = new ArrayList<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] byteContent = Files.readAllBytes(file); // размер файла: content.length
        String content = new String(byteContent);
        int countProperties = 0;
        int countPropertiesFile = 0;
        if(partOfName!=null) {
            countProperties++;
            if(file.getFileName().toString().contains(partOfName)) countPropertiesFile++;
        }
        if(partOfContent!=null) {
            countProperties++;
            if(content.contains(partOfContent)) countPropertiesFile++;
        }
        if(maxSize!=0) {
            countProperties++;
            if(byteContent.length < maxSize) countPropertiesFile++;
        }
        if(minSize!=0) {
            countProperties++;
            if(byteContent.length > minSize) countPropertiesFile++;
        }
        if(countProperties == countPropertiesFile) foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String name) {
        partOfName = name;
    }

    public void setPartOfContent(String content ) {
        partOfContent = content;
    }

    public void setMaxSize(int size) {
        maxSize = size;
    }

    public void setMinSize(int size) {
        minSize = size;
    }
}
