import java.util.Random;
public class Bai18 {
    int[] a = new int[51];int n;
    public void input(){
        Random in = new Random();
        n = in.nextInt(50) + 1;
        for (int i = 0; i < n; i++){
            a[i] = in.nextInt(900) + 100;
        }
    }
    public boolean checkSymmetricArray(){
        for (int i = 0; i <= (n-1)/2; i++){
            if (a[i] != a[n-1-i]) return false;
        }
        return true;
    }
    public void execute(){
        System.out.println("n = " + n);
        System.out.println("Array is : ");
        for (int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
        if (checkSymmetricArray()) System.out.println("Array is a symmetric array");
        else System.out.println("Array isn't a symmetric array");
    }

    public static void main(String[] args) {
        Bai18 obj = new Bai18();
        obj.input();
        obj.execute();
    }
}
