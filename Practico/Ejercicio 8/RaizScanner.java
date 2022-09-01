import java.util.Scanner;

public class RaizScanner {

    double num;

    public void scan() {
        System.out.println("Ingrese un numero");
        Scanner sc = new Scanner(System.in);
        num = Math.sqrt(sc.nextDouble());

        System.out.println("La raiz obtenida es " + num);
    }

}
