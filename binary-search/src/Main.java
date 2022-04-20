import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
cd .. - подняться на папку выше
git status - проверка добавления файлов
git add *.out - добавить в коммит файлы с расширением .out
git commit -m'название коммита' - коммит
git push - отправить на удаленный репозиторий

javac src/Main.java
java -cp src Main < 1.in > test1.out
diff test1.out 1.out
 */
public class Main {

    static int binarySearch(int num, int[] numArray) {
        int ind = -1;
        int l = 0;   //left
        int r = numArray.length - 1; //right
        
        while (true) {
            int m = (l + r)/2; // middle
            if (num > numArray[m]) {
                l = m;
            } else if (num < numArray[m]) {
                r = m;
            } else {
                ind = m;
                break;
            }
            if (r == l+1 || r == l) {
                if (num == numArray[r]) ind = r;
                if (num == numArray[l]) ind = l;
                break;
            }
        }
        return ind;
    }
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] numArray = new int[N];
            String[] strNumbers = bufferedReader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                numArray[i] = Integer.parseInt(strNumbers[i]);
            }
            int K = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < K; i++) {
                int searchNumber = Integer.parseInt(bufferedReader.readLine());
                int ind = binarySearch(searchNumber, numArray);
                System.out.println(ind);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
