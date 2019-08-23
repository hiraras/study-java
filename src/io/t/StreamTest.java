package io.t;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;
import utils.Utils;

public class StreamTest {
    public static String DIR = "file-stu\\io stream\\";
    public static String BUFFERED_DIR = "file-stu\\buffered\\";
    public static ArrayList readFileByBytes(File file) throws IOException {
        // 读取字节流
        ArrayList<Integer> list = new ArrayList<>();
        if (!file.exists() || !file.isFile()) {
            return list;
        }
        FileInputStream fis = null;
        fis = new FileInputStream(file);
        int b = 0;
        while(b != -1) {
            b = fis.read();
            list.add(b);
        }
        fis.close();
        return list;
    }

    public static StringBuffer readFileByChars(File file) throws IOException {
        // 读取字符流
        char[] chars = new char[1024];
        if (!file.exists() || !file.isFile()) {
            return new StringBuffer();
        }
        FileInputStream fis = null;
        InputStreamReader isr = null;
        StringBuffer sb = new StringBuffer();

        fis = new FileInputStream(file);
        isr = new InputStreamReader(fis, "GBK");
        while(isr.read(chars) != -1) {
            sb.append(new String(chars));
            chars = new char[1024];
        }
        fis.close();
        isr.close();
        return sb;
    }
    public static void bufferedReaderTest() throws IOException {
        long startTime = new Date().getTime();
        File originFile = new File(BUFFERED_DIR + "1.txt");
        File outputFile = new File(BUFFERED_DIR + "copy.txt");
        InputStream inputStream = new FileInputStream(originFile);
        // 只有这个能设置读的字符集
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK");
        FileReader fileReader = new FileReader(originFile);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        char[] chars = new char[1024];
        while(bufferedReader.read(chars) != -1) {
            bufferedWriter.write(chars);
            chars = new char[1024];
        }
        bufferedWriter.flush();
        long endTime = new Date().getTime();
        chars = new char[1024];
        while(fileReader.read(chars) != -1) {
            fileWriter.write(chars);
            chars = new char[1024];
        }
        fileWriter.flush();
        long endTime2 = new Date().getTime();
        System.out.println("bufferedTime:" + (endTime - startTime));
        System.out.println("noBufferedTime:" + (endTime2 - startTime));
        fileReader.close();
        bufferedReader.close();
        fileWriter.close();
        bufferedWriter.close();
        inputStream.close();
        inputStreamReader.close();
        InputStream fis = new FileInputStream(originFile);
        InputStreamReader isr = new InputStreamReader(fis, "GBK");
        BufferedReader br = new BufferedReader(isr);
        String content = "";
        File outputFile2 = new File(BUFFERED_DIR + "copy2.txt");
        FileWriter fw = new FileWriter(outputFile2);
        BufferedWriter bw = new BufferedWriter(fw);
        // 读取一行内容
        while((content = br.readLine()) != null) {
            System.out.println(content);
            // 写入时换行
            bw.newLine();
            bw.write(content);
        }
        bw.flush();
        bw.close();
        fw.close();
        fis.close();
        isr.close();
    }
    public static void read() throws IOException {
        File image = new File(DIR + "1.jpg");
        File txt = new File(DIR + "hello.txt");
//        readFileByBytes();
//        readFileByChars(txt);
        bufferedReaderTest();
    }
    public static void writeFileByChars() throws IOException {
        // 用FileOutputStream、OutputStreamWriter、FileWriter来写文件
        File txt = new File(DIR + "hello.txt");
        File outputTxt = new File(DIR + "hello2.txt");
        File outputTxt2 = new File(DIR + "hello3.txt");
        File outputTxt3 = new File(DIR + "hello4.txt");
//        File outputTxt3 = new File("hello4.txt");
        StringBuffer sb = readFileByChars(txt);
        FileOutputStream fos = new FileOutputStream(outputTxt, true);
        FileOutputStream fos2 = new FileOutputStream(outputTxt2, true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        FileWriter fileWriter = new FileWriter(outputTxt3);
//            fos.write(sb.reverse().toString().getBytes());
        // 反转一下,并插入换行
        osw.write("\r\n" + sb.reverse().toString().trim());
        osw.flush();
        fos2.write(sb.toString().trim().getBytes());
        fileWriter.write("hi,this is java", 3, 12);
        fileWriter.flush();
        fos.close();
        fos2.close();
        osw.close();
        fileWriter.close();
    }
    public static void writeFileByBytes() throws IOException {
        File file = new File(DIR + "1.jpg");
        File outputFile = new File(DIR + "2.jpg");
        FileOutputStream fos = new FileOutputStream(outputFile);
        ArrayList list = readFileByBytes(file);
        byte[] data = list2Bytes(list);
        fos.write(data);
//        System.out.println(Arrays.toString(sb.toString().getBytes()));
        fos.close();
        fos.close();
    }
    public static void bufferedEffectiveTest() throws IOException {
        // 缓冲的速度会比不缓冲的快，因为直接写硬盘数据效率比较低，缓冲区会把数据缓存放到内存中，等到缓冲区满了
        // 一次性写到硬盘里，操作硬盘的次数少，效率高
        long startTime = new Date().getTime();
        File originFile = new File(BUFFERED_DIR + "2.mp4");
        InputStream inputStream = new FileInputStream(originFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        OutputStream outputStream = new FileOutputStream(BUFFERED_DIR + "copy.mp4");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] bytes = new byte[1024];
        while(bufferedInputStream.read(bytes) != -1){
            bufferedOutputStream.write(bytes);
            bytes = new byte[1024];
        }
        long endTime = new Date().getTime();
        System.out.println("bufferedTime:" + (endTime - startTime));
        FileInputStream fileInputStream = new FileInputStream(originFile);
        FileOutputStream fileOutputStream = new FileOutputStream(BUFFERED_DIR + "copy2.mp4");
        bytes = new byte[1024];
        while(fileInputStream.read(bytes) != -1){
            fileOutputStream.write(bytes);
            bytes = new byte[1024];
        }
        long endTime2 = new Date().getTime();
        System.out.println("noBufferedTime:" + (endTime2 - startTime));
        inputStream.close();
        bufferedInputStream.close();
        outputStream.close();
        bufferedOutputStream.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
    public static void write() throws IOException {
//        writeFileByChars();
//        writeFileByBytes();
        bufferedEffectiveTest();
    }
    public static void main(String[] args) {
        try {
            read();
//            write();
//            readExcel();
//            copyDir();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static byte[] list2Bytes(List<Integer> list) {
        // 将list元素转化为byte[]
        Iterator<Integer> it = list.iterator();

        byte[] bytes = new byte[list.size()];
        int index = 0;
        while(it.hasNext()) {
            bytes[index] = it.next().byteValue();
            index ++;
        }
        return bytes;
    }
    public static void readExcel() throws IOException {
        File file = new File(DIR + "1.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        ArrayList list = new ArrayList();
        while(fileInputStream.read(bytes) != -1) {
            list.add(Arrays.toString(bytes));
            bytes = new byte[1024];
        }
        System.out.println(list);
        fileInputStream.read();
    }
    public static void copyDir() throws IOException {
        // 无法直接复制文件夹
        File originDir = new File(BUFFERED_DIR);
        File targetDir = new File("file-stu\\buffered2\\");
        InputStream fis = new FileInputStream(originDir);
        OutputStream fos = new FileOutputStream(targetDir);

        byte[] bytes = new byte[1024];
        while (fis.read(bytes) != -1) {
            fos.write(bytes);
        }
        fis.close();
        fos.close();
    }
}
