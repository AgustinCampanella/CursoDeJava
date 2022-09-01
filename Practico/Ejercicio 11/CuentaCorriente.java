import java.util.Random;

public class CuentaCorriente {

    double saldo;
    String nombreTitular;
    long numeroCuenta;

    public CuentaCorriente (String nombre, double saldo){
        this.nombreTitular = nombre;
        this.saldo = saldo;
        this.numeroCuenta = Math.abs(new Random().nextLong());
    }

    public void setIngreso(double monto){
        if(monto > 0){
            this.saldo += monto;
        } else {
            System.out.println("Monto invalido");
        }
    }

    public void setReintegro(double monto){
        if(monto <= this.saldo){
            this.saldo -= monto;
        } else {
            System.out.println("No cuenta con los fondos suficientes para realizar la operación");
        }
    }

    public void getSaldo() {
        System.out.println("$"+ saldo + " restantes");
    }

    public void getDatos(){
        System.out.println("Nombre: " + nombreTitular +"\nID Num." + numeroCuenta );
    }

    public void transferencia(CuentaCorriente cuenta, double monto){
        if(monto <= this.saldo){
            this.setIngreso(monto);
            cuenta.setIngreso(monto);
            System.out.println("Transferencia exitosa");
        }
    }

}
