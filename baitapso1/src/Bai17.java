import java.util.Scanner;
public class Bai17 {
    int n,k;
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter n: ");
        n = in.nextInt();
        System.out.println("Please enter k: ");
        k = in.nextInt();
    }
    public long findC(int n,int k){
        if (n == k || k == 0) return 1;
        else return findC(n-1,k-1) + findC(n-1,k);
    }

    public static void main(String[] args) {
        Bai17 obj = new Bai17();
        obj.input();
        System.out.println(obj.findC(obj.n,obj.k));
    }
}
