import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        concultarCambio consulta = new concultarCambio();
        Scanner leer = new Scanner(System.in);
        String moneda,monedaConsultada = "",monedaCambio="";



        while(!salir){

            menu.tabla();
            int opcion = leer.nextInt();

            switch (opcion){

                case 1:
                    monedaConsultada = "USD";
                    monedaCambio = "ARS";
                    break;
                case 2:
                    monedaConsultada = "ARS";
                    monedaCambio = "USD";
                    break;
                case 3:
                    monedaConsultada = "USD";
                    monedaCambio = "MXN";
                    break;
                case 4:
                    monedaConsultada = "MXN";
                    monedaCambio = "USD";
                    break;
                case 5:
                    monedaConsultada = "USD";
                    monedaCambio = "BRL";
                    break;
                case 6:
                    monedaConsultada = "BRL";
                    monedaCambio = "USD";
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("opcion no valida");
                    continue;

            }

            if(!salir){

                System.out.println("Ingrese la cantidad a convertir");
                double dineroAConvertir = leer.nextDouble();

                System.out.println("la conversion de "+dineroAConvertir + " " +monedaConsultada+" a " + monedaCambio + " es " + dineroAConvertir * consulta.consultaDeCambio(monedaConsultada,monedaCambio));
            }

        }
        System.out.println("Finalizo la ejecucion, gracias por usar nuestros servicios");
    }
}