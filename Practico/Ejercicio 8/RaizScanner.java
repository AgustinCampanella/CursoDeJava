import java.util.Scanner;

public class RaizScanner {

    int num;
    double result;

    public void scan() {
        System.out.println("Ingrese un numero");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        result = Math.sqrt(num);

        System.out.println("La raiz de " + num +" es = " + result);
    }

}
