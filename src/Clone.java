

class CloneClass implements Cloneable {
    public int num = 1;
    public CloneClass clone() {
        CloneClass c = null;
        try{
            c = (CloneClass)super.clone();
        }catch(CloneNotSupportedException e){
            System.out.println(e);
        }
        return c;
    }
}

public class Clone {
    public static void main(String[] args) {
    }
}
