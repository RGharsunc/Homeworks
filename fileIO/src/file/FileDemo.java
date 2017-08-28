package file;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vardan on 06.08.2017.
 */
public class FileDemo {

    static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException {
        File f = new File("E:\\java\\java12\\java123");
        File f1 = new File("E:\\java1");
        File dir = new File("E:\\new file");
        File f3 = new File("e:\\java1\\javaText.txt");
        System.out.println(f3.exists());
        System.out.println("is f3 file " + f3.isFile());
        System.out.println("is f3 directory " + f3.isDirectory());
        System.out.println(f3.canWrite());
        System.out.println(f3.canRead());
        System.out.println(f3.setReadOnly());
        System.out.println(f3.setWritable(true));
        System.out.println(f3.canWrite());


        File files[] = f1.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i]);
            }
        }
        dir.mkdir();
        f.mkdirs();
        System.out.println(dir.getName());


    }
}
