package io.t;

import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;

import java.io.*;

public class OtherStreamTest {
    public static String DIR = "file-stu\\other stream\\";
    public static void main(String[] args) {
        printWithFormat();
        try {
//            lineNumReader();
//            dataStreamRead();
////            dataStreamWriter();
//            byteArrayOutputStream();
//            printWriter();
            mergeTest();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void mergeTest() throws IOException {
        // 合并流，下面的方法生成的merge.jpg虽然样子是01.jpg的样子，但是大小是两者之和
        FileInputStream fis1 = new FileInputStream(DIR + "01.jpg");
        FileInputStream fis2 = new FileInputStream(DIR + "02.jpg");
        SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(DIR + "merge.jpg"));
        byte[] bytes = new byte[1024];
        while(sis.read(bytes) != -1) {
            bos.write(bytes);
            bytes = new byte[1024];
        }
        fis1.close();
        fis2.close();
        sis.close();
        bos.close();
    }
    public static void printWithFormat() {
        // C语言写法
        System.out.printf("%.1f\n", 12.345); // 12.3
        System.out.printf("%.2f\n", 12.567); // 12.57
        System.out.printf("%.2f\n", 12.564); // 12.56
    }
    public static void printWriter() throws IOException {
        // 能够简化输出文件
        // A:只能操作目的地，不能操作数据源。
        // B:可以操作任意类型的数据。
        // C:如果启动了自动刷新，能够自动刷新。
        PrintWriter pw = new PrintWriter(new FileWriter(DIR + "printWriter.txt"));
        pw.println("hi, this is printWriter");
        pw.close();
    }
    public static void byteArrayOutputStream() throws IOException {
        // 写到内存中去了
        ByteArrayOutputStream baos = new ByteArrayOutputStreamEx();
        baos.write("helloworld".getBytes());
        baos.write("javajava".getBytes());
        baos.write("android".getBytes());
        baos.close();
        byte[] bys = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bys);
        int by = 0;
        while ((by = bais.read()) != -1) {
            System.out.print((char) by);
        }
        bais.close();
    }
    public static void dataStreamRead() throws IOException {
        File file = new File(DIR + "1.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        System.out.println(dataInputStream.readByte());
        System.out.println(dataInputStream.readShort());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readLong());
        System.out.println(dataInputStream.readFloat());
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readChar());
        System.out.println(dataInputStream.readBoolean());
        dataInputStream.close();
    }
    public static void dataStreamWriter() throws IOException {
        File file = new File(DIR + "dataStream.txt");
        FileOutputStream fileOunputStream = new FileOutputStream(file);
        DataOutputStream datOunputStream = new DataOutputStream(fileOunputStream);
        datOunputStream.writeByte(1);
        datOunputStream.writeShort(10);
        datOunputStream.writeInt(100);
        datOunputStream.writeLong(1000);
        datOunputStream.writeFloat(1.1f);
        datOunputStream.writeDouble(2.2);
        datOunputStream.writeChar('a');
        datOunputStream.writeBoolean(true);
        datOunputStream.close();
    }
    public static void lineNumReader() throws IOException {
        File file = new File(DIR + "1.txt");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), "GBK");
        LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
        String line = null;
        while((line = lineNumberReader.readLine()) != null){
            System.out.println(line + "   lineNum:" + lineNumberReader.getLineNumber());
        }

        inputStreamReader.close();
        lineNumberReader.close();
    }
}
