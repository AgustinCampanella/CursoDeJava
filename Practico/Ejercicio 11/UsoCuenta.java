public class UsoCuenta {

    public static void main(String[] args) {
	// write your code here

        CuentaCorriente Cuenta1 = new CuentaCorriente("Juan", 10000);
        CuentaCorriente Cuenta2 = new CuentaCorriente("Pedro", 54000);

        Cuenta1.transferencia(Cuenta2, 2500);

        Cuenta1.getDatos();
        Cuenta1.getSaldo();
        Cuenta2.getDatos();
        Cuenta2.getSaldo();


    }
}
