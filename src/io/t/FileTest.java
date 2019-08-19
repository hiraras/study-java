package io.t;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import utils.Utils;
import java.io.FilenameFilter;
public class FileTest {
    public static String PRO_DIR = "F:/study/java/test";
    public static void judgedMethodsTest() {
        System.out.println("------------judgedMethodsTest-start--------------");
        // 路经以当前项目所在文件夹为参照，./表示test这个文件夹目录，../表示test文件夹的上一级
        // 可通过file.list()获取某个目录下的文件、文件夹列表来查看
        // 下面file1为目录，file3为文件
        File file1 = new File(PRO_DIR);
        // 判断是否存在该目录或文件
        System.out.println(file1.exists()); // true
        File file2 = new File("src/io/t/t");
        // 判断是否为目录(文件夹)
        System.out.println(file2.isDirectory()); // // true
        File file3 = new File("file-stu/1.txt");
        System.out.println(file3.exists()); // true
        // 判断是否为文件
        System.out.println(file3.isFile()); // true
        File file4 = new File("./");
        // 查看文件夹中的子文件夹或文件，如果file不是文件夹是文件，则返回null，空文件夹返回[]
        System.out.println(Arrays.toString(file4.list())); // [.git, .gitignore, .idea, file-stu, java.iml, note, out, src, 新建文本文档.txt]
        System.out.println(Arrays.toString(file3.list())); // null
        System.out.println(Arrays.toString(file2.list())); // []
        // 文件夹是否可读、写
        System.out.println(file1.canRead()); // true
        System.out.println(file1.canWrite()); // true
        // 文件是否可读、写
        System.out.println(file3.canRead()); // true
        System.out.println(file3.canWrite()); // true
        // 文件夹是否隐藏
        System.out.println(file1.isHidden()); // false
        System.out.println("------------judgedMethodsTest-end--------------");
    }

    public static void operateFileTest() {
        System.out.println("------------operateFileTest-start--------------");
        // 操作文件，测试该方法时，请先将file-stu目录下的除了1.txt文件和test文件夹外的其他文件、文件夹全部删除
        try {
            File file1 = new File("file-stu");
            File file2 = new File("file-stu/1.txt");
            // 在file1表示的目录下，寻找后面的目录或文件
            File file3 = new File(file1, "new file.txt");
            File file4 = new File(file1, "/parent/new file");
            File file5 = new File(file1, "/new file");
            File file6 = new File(file1, "1.txt");
            boolean flag = false;
            // 创建新文件
            file3.createNewFile();
            flag = file6.createNewFile();
            System.out.println(flag); // false,已存在的话会返回false
            // 创建新文件夹，只能创建一级目录，且父目录必须存在，否则无法成功创建一个目录
            flag = file4.mkdir();
            System.out.println(flag); // false
            flag = file5.mkdir();
            System.out.println(flag); // true
            // 创建新文件夹，可以创建多级目录，父目录不一定存在
            flag = file4.mkdirs();
            System.out.println(flag); // true
            // 删除文件、文件夹
            // A:如果一个文件夹内有内容，不能直接删除
            // B:Java程序的删除不走回收站，直接删除
            flag = file4.delete();
            System.out.println(flag); // true
            file3.delete();
            flag = file1.delete();
            System.out.println(flag); // false，因为里面有内容
            // 重命名，如果新的文件在其他目录下，则移动到新文件夹并重命名
//            file2.renameTo(file3);
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("------------operateFileTest-end--------------");
    }
    public static void getFileMsgTest() {
        System.out.println("------------getFileMsgTest-start--------------");
        try {
            File file1 = new File("file-stu");
            File file2 = new File("file-stu/1.txt");
            File file3 = new File(file1, "test");
            File file4 = new File(file1, "new");
            // 返回的是一个File类对象，这个File对象表示是当前File对象的绝对路径名形式
            System.out.println(file1.getAbsoluteFile()); // F:\study\java\test\file-stu
            // 返回的是一个字符串，这个字符串就是当前File对象的绝对路径名的字符串形式
            System.out.println(file1.getAbsolutePath()); // F:\study\java\test\file-stu
            // 获取文件、文件夹名字
            System.out.println(file1.getName()); // file-stu
            // 返回文件的大小
            System.out.println(file2.length()); // 文件大小
            // 返回文件的最后修改时间
            System.out.println(file2.lastModified());
            // 返回目录下的文件和文件夹名字字符串
            System.out.println(Arrays.toString(file3.list())); // [2.txt, new]
            // 返回目录下的文件和文件夹对象(File类型数据)
            System.out.println(Arrays.toString(file3.listFiles())); // [file-stu\test\2.txt, file-stu\test\new]
            System.out.println(Arrays.toString(file1.getAbsolutePath().split("\\\\"))); // [F:, study, java, test, file-stu]
            System.out.println(file3.getPath()); // file-stu\test
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("------------getFileMsgTest-end--------------");
    }
    public static void main(String[] args) {
//        judgedMethodsTest();
//        operateFileTest();
//        getFileMsgTest();
        File file = new File("./");
        List list = getTxtFile(file);
        System.out.println(list);
        filterFiles(file, "txt");
    }
    public static List getTxtFile(File file) {
        List list = new ArrayList();
        try {
            if (file.exists() && file.isDirectory()) {
                list.addAll(getFiles(file, ".txt"));
            }
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            return list;
        }
    }
    public static List getFiles(File dir, String fileType) {
        File[] files = dir.listFiles();
        List list = new ArrayList();
        for (int i = 0; i < files.length; i += 1) {
            if (files[i].getName().indexOf(fileType) > -1) {
                list.add(files[i].getName());
            }
            if (files[i].isDirectory()) {
                list.addAll(getFiles(files[i], fileType));
            }
        }
        return list;
    }
    public static void filterFiles(File dir, String fileType) {
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.indexOf("." + fileType) > -1;
            }
        });
        System.out.println(Arrays.toString(files));
    }
}
