package BT1_CopyFileText;

import java.io.*;

public class Main {
    public static void copyFile(String sourceFile, String targetFile) throws Exception {
        File source = new File(sourceFile);
        if (!source.exists()) {
            System.out.println("Tiep nguon khong ton tai!");
            return;
        }
        File target = new File(targetFile);
        if (!target.exists()) {
            System.out.println("Tep dich da ton tai!");
            return;
        }

        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(target)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
        long fileSize = target.length();
        System.out.println("Da sao chep tep " + sourceFile + " vao " + targetFile + " voi " + fileSize + " byte. ");
    }

    public static void main(String[] args) throws Exception {
        copyFile("E:\\code_md3\\SS16_BT_IO Text File\\src\\BT1_CopyFileText\\source.txt",
                 "E:\\code_md3\\SS16_BT_IO Text File\\src\\BT1_CopyFileText\\target.txt");
    }
}