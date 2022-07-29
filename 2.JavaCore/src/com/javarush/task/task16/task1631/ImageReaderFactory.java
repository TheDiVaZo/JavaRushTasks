package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public  class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        if(type == null) throw new IllegalArgumentException("Неизвестный тип картинки");
        else if(type.equals(ImageTypes.JPG)) {
            return new JpgReader();
        }
        else if(type.equals(ImageTypes.BMP)) {
            return new BmpReader();
        }
        else if(type.equals(ImageTypes.PNG)) {
            return new PngReader();
        }
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
