package calculator.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public  class ClassFinder {
    private String path;

    public ClassFinder(String path){
        this.path=path;
    }


    public List<String> getClassNames() {
        List<String> classNames = new ArrayList<String>();
        try {
            File dir = new File(path); //path указывает на директорию
            File[] arrFiles = dir.listFiles();
            for (File f : arrFiles) {
                ZipInputStream zip = new ZipInputStream(new FileInputStream(f));
                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                    if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                        // This ZipEntry represents a class. Now, what class does it represent?
                        String className = entry.getName().replace('/', '.'); // including ".class"
                        classNames.add(className.substring(0, className.length() - ".class".length()));
                    }
                }
            }
            return classNames;
        }
        catch (Exception e) {
            return classNames;
        }
    }
}
