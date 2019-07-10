package basic;

public class Loop {
    public void loop1(){
        for(int i = 10000; i < 100000; i += 1) {
            int gewei = i % 10;
            int shiwei = i / 10 % 10;
            int baiwei = i / 100 % 10;
            int qianwei = i / 1000 % 10;
            int wanwei = i / 10000;
            if (gewei + shiwei + qianwei + wanwei == baiwei) {
                System.out.println(i);
            }
        }
    }
    public Loop loop2() {
        System.out.println(1);
        return this;
    }
    public void loop3() {
        for(int j=0;j<4;j++){
            String str = "";
            for (int k=0;k<5;k++){
                str += "*";
            }
            System.out.println(str);
        }
    }
    public void loop4() {
        for(int j=0;j<4;j++){
            String str = "";
            for (int k=0;k<5;k++){
                if (k <= j) {
                    str += "*";
                }
            }
            System.out.println(str);
        }
    }
    public void loop5() {
        for(int j=0;j<9;j++){
            String str = "";
            for (int k=0;k<9;k++){
                if (k <= j) {
                    str += "" + (k + 1) + '*' + (j + 1) + ';';
                }
            }
            System.out.println(str);
        }
    }
    public static void main(String[] args) {
        Loop lp1 = new Loop();
        lp1.loop2().loop2();
        lp1.loop3();
        lp1.loop4();
        lp1.loop5();
    }
}
