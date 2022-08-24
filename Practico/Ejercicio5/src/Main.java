public class Main {

    public static void main(String[] args) {
        float fracc1 = 6/5.f;
        float fracc2 = 2/3.f;
        float fracc3 = 7/2.f;
        float fracc4 = 2/30.f;
        float fracc5 = 1/3.f;

        float resultado = (fracc1 - (fracc2 * fracc3) + fracc4) / (fracc5 / 5);

        System.out.println(resultado);
    }
}
