package normal.toolclass;

import java.rmi.server.ExportException;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class ToolClass {
    public static void regTest() {
        String regStr1 = "[1-9]\\d{4,9}";
        // matches要求整个序列都匹配
        System.out.println("1125073664".matches(regStr1)); // true
        String splitRegStr = " ";
        System.out.println(Arrays.toString("12 345 22".split(splitRegStr))); // [12, 345, 22]
        System.out.println("12 345 22".replaceAll(splitRegStr, "")); // 1234522
        String str2 = "91 27 46 38 50";
        String[] strArr = str2.split(" ");
        Arrays.sort(strArr);
        String result = "";
        for (int i = 0; i < strArr.length; i += 1) {
            result += strArr[i];
            result += " ";
        }
        result = result.trim();
        System.out.println(result); // 27 38 46 50 91
        String str3 = "jawieof2oia23423423ofiajef342ojifo";
        System.out.println(str3.replaceAll("\\d", "*")); // jawieof*oia********ofiajef***ojifo

        System.out.println(Pattern.matches("[1-9]\\d{4}", "12345")); // true
        String str4 = "ejfi jeif wiejf efe ef  efe xxx ewf  efefe feff";
        Pattern p1 = Pattern.compile("\\b\\w{3}\\b");
        Matcher m1 = p1.matcher(str4);
        System.out.println(m1.find()); // true
        while (m1.find()) {
            System.out.println(m1.group(0));
            System.out.println("start(): " + m1.start());
        }
        String regStr2 = "a*?b";
        String str5 = new String("aabbb");
        Pattern p2 = Pattern.compile(regStr2);
        Matcher m2 = p2.matcher(str5);
        while (m2.find()) {
            System.out.println(m2.group());
        }
    }
    public static void mathTest() {
        System.out.println("------math-start--------");
        // 绝对值函数
        System.out.println(1 == Math.abs(-1)); // true
        // 取大于等于当前值的最大整数
        System.out.println(Math.ceil(1.5) == 2); // 2.0, true
        System.out.println(Math.ceil(-1.5)); // -1.0
        System.out.println(Math.ceil(1)); // 1.0
        // 取小于等于当前值的最大整数
        System.out.println(Math.floor(12)); // 12.0
        System.out.println(Math.floor(11.2)); // 11.0
        // 取两数中的大的一个
        System.out.println(Math.max(2.2, 1.1)); // 2.2
        System.out.println(Math.max(2, 2)); // 2
        // 取两数中的小的一个
        System.out.println(Math.min(2.2, 1.1)); // 1.1
        System.out.println(Math.min(2, 2)); // 2
        // 取x的y次方
        System.out.println(Math.pow(2, 4)); // 16.0
        System.out.println(Math.pow(3, 3)); // 27.0
        // 取[0, 1)的随机数
        System.out.println(Math.random());
        // 取1-100的随机整数
        System.out.println((int)(Math.random() * 100 + 1));
        // 四舍五入
        System.out.println(Math.round(1.2)); // 1
        System.out.println(Math.round(1.5)); // 2
        // 取平方根
        System.out.println(Math.sqrt(9)); // 3.0
        System.out.println(Math.sqrt(4.84)); // 2.2
        System.out.println("------math-end--------");
    }
    public static void randomTest() {
        System.out.println("-------random-start--------");
        Random r = new Random();
        Random r2 = new Random(3);
        Random r3 = new Random(3);
        Random r4 = new Random();
        System.out.println(r.nextInt());
        // 得到范围为[0, 2]的整数随机数
        System.out.println(r.nextInt(3));
        System.out.println("for1:");
        // 如果用相同的种子创建两个 Random 实例，则对每个实例进行相同的方法调用序列，它们将生成并返回相同的数字序列。
        for (int i = 0; i < 9; i += 1) {
            System.out.println(r2.nextInt());
            System.out.println(r3.nextInt());
        }
        System.out.println("for2:");
        for (int i = 0; i < 9; i += 1) {
            System.out.println(r.nextInt());
            System.out.println(r4.nextInt());
        }
        System.out.println("-------random-end--------");
    }
    public static void systemTest() {
        System.out.println("---------system-start---------");
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime()); // 微秒
        System.out.println("---------system-end---------");
    }
    public static void bigIntegerTest() {
        System.out.println("--------bigInteger-start---------");
        try {
            Integer i = new Integer("2147483648");
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e);
        }

        BigInteger bi1 = new BigInteger("2147483648");
        System.out.println(bi1);
        BigInteger bi2 = new BigInteger("100");
        BigInteger bi3 = new BigInteger("50");
        System.out.println(bi2.add(bi3)); // 150
        System.out.println(bi2); // 100
        System.out.println(bi3); // 50
        System.out.println(bi2.subtract(bi3)); // 50
        System.out.println(bi2.multiply(bi3)); // 5000
        System.out.println(bi2.divide(bi3)); // 2
        System.out.println(bi3.divide(bi2)); // 0
        System.out.println(50 / 100); // 0
        BigInteger[] bArr = bi2.divideAndRemainder(bi3);
        System.out.println(bArr);
        System.out.println(bArr[0]); // 2 结果
        System.out.println(bArr[1]); // 0 余数
        System.out.println("--------bigInteger-end---------");
    }
    public static void bigDecimalTest() {
        System.out.println("-------bigDecimal-start-------");
        // 以下的计算精度会丢失
        System.out.println(0.09 + 0.01); // 0.09999999999999999
        System.out.println(1.0 - 0.32); // 0.6799999999999999
        System.out.println(1.015 * 100); // 101.49999999999999
        System.out.println(1.501 / 100); // 0.015009999999999999

        BigDecimal bd1 = new BigDecimal("0.09");
        BigDecimal bd2 = new BigDecimal("0.01");
        System.out.println(bd1.add(bd2)); // 0.01

        BigDecimal bd3 = new BigDecimal("1.0");
        BigDecimal bd4 = new BigDecimal("0.32");
        System.out.println(bd3.subtract(bd4)); // 0.68

        BigDecimal bd5 = new BigDecimal("1.015");
        BigDecimal bd6 = new BigDecimal("100");
        System.out.println(bd5.multiply(bd6)); // 101.500

        BigDecimal bd7 = new BigDecimal("1.501");
        BigDecimal bd8 = new BigDecimal("100");
        System.out.println(bd7.divide(bd8)); // 0.01501
        // 第二个参数为保留的小数点后几位,第三个参数指定保留小数的时候进行的模式，下面这个值表示四舍五入
        System.out.println(bd7.divide(bd8, 2, BigDecimal.ROUND_HALF_UP)); // 0.02
        System.out.println("-------bigDecimal-end-------");
    }
    public static void dateTest() {
        System.out.println("--------time-start---------");
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(new Date()); // Mon Jul 29 14:41:12 CST 2019
        // 下面为某一个时间点测试的时间
        System.out.println(System.currentTimeMillis()); // 1564380810601
        System.out.println(date1.getTime()); // 1564380810601
        date1.setTime(1564380696800L);
        System.out.println(date1.getTime()); // 1564380696800
        System.out.println(date2.getTime()); // 1564380810601

        String simpleDateFormatPattern = "yyyy-MM-dd HH:mm:ss:SSS";
        SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormatPattern);
        String str = sdf.format(new Date());
        System.out.println(str); // 2019-07-29 14:22:38:692
        // 将日期字符串转化为日期相关对象
        try {
            String strDate = "2020-01-31";
            // 使用parse方法要用try{}catch(e){}包裹
            Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
            System.out.println("date3:" + date3); // date3:Fri Jan 31 00:00:00 CST 2020
        } catch(Exception e) {
            System.out.println(e);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        System.out.println(calendar.getTime()); // Mon Jul 29 14:11:36 CST 2019
        System.out.println(calendar.getTime() instanceof Date); // true
        // 可以重新得到一个实例
        calendar = Calendar.getInstance();
        System.out.println(calendar.getTime()); // Mon Jul 29 14:42:29 CST 2019
        calendar.set(2013, 3, 2, 15, 24, 61);
        System.out.println(calendar.getTime()); // Tue Apr 02 15:25:01 CST 2013

        // 重置
        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // 获取实例所表示的时间的信息
        System.out.println(calendar.get(Calendar.YEAR)); // 年
        System.out.println(calendar.get(Calendar.MONTH)); // 月,0开始
        System.out.println(calendar.get(Calendar.DATE)); // 日
        System.out.println(calendar.get(Calendar.HOUR)); // 小时(12小时制)
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY)); // 小时(24小时制)
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 周几,周天为开始为1,周六为7
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); // 一年的第几天
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 本月第几天
        System.out.println(calendar.get(Calendar.MINUTE)); // 分钟
        System.out.println(calendar.get(Calendar.SECOND)); // 秒
        System.out.println(calendar.get(Calendar.MILLISECOND)); // 毫秒,仅仅只有毫秒
        System.out.println(calendar.getTimeInMillis()); // 获取时间戳,毫秒

        // 设置时间为两个小时前,根据第一个参数选择设置的是什么时间,第二个参数设置向前调整或是向后调整时间
        calendar.add(Calendar.HOUR_OF_DAY, -2);
        // 对比两个时间先后,小于返回-1,等于返回0,大于返回1
        System.out.println(calendar.compareTo(Calendar.getInstance())); // -1

        System.out.println("--------time-end---------");
    }
    public static void main(String[] args) {
//        regTest();
//        mathTest();
//        randomTest();
//        systemTest();
//        bigIntegerTest();
//        bigDecimalTest();
        // 包括Date、DateFormat、Calendar
//        dateTest();
        int num = getFebruaryDayNum(2000);
        System.out.println(num);
    }
    public static int getFebruaryDayNum(int year) {
        // 获取任意年二月天数
        Calendar c = Calendar.getInstance();
        c.set(year, 2, 1, 0 , 0, 0);
        c.add(Calendar.SECOND, -1);
        return c.get(Calendar.DATE);
    }
}
