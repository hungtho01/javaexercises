public class Bai16 {
    boolean[] isPrime = new boolean[10000000];
    public void checkPrime(){
        for (int i = 0; i <= 9999999; i++){
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= (int)Math.sqrt(9999999); i++){
            if (isPrime[i] == true){
                for (int j = i * i; j <= 9999999; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
    public void taskA(){
        for (int i = 1000000; i <= 9999999; i++){
            if (isPrime[i]) System.out.print(i + " ");
        }
    }
    public void taskB(){
        for (int i = 1000000; i <= 9999999; i++){
            int j = i;
            while (j > 0){
                if (!isPrime[j % 10]) break;
                j /= 10;
            }
            if (j == 0) System.out.print(i + " ");
        }
    }
    public void taskC(){
        for (int i = 1000000; i <= 9999999; i++){
            int j = i;
            int temp = 0;
            while (j > 0){
                temp += j%10;
                j /= 10;
            }
            if (isPrime[temp]) System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        Bai16 obj = new Bai16();
        obj.checkPrime();
        obj.taskC();

    }
}
