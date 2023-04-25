package cuentas.test;

import cuentas.modelo.Cuenta;
import cuentas.modelo.SaldoInsuficienteException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Incluye la clase DemoCuenta en el paquete cuentas.test
 */
public class DemoCuenta {

    /**
     * La clase acepta a través de argumentos del main
     * el importe de la cuenta. Si el valor del importe es correcto se crea
     * la cuenta
     * A continuación de pide (con Scanner) al usuario la cantidad a ingresar
     * y se añade y después la cantidad a sacar y se reintegra.
     *
     * Hay que capturar todas las posibles excepciones que se puedan dar
     * indicando mensajes de error adecuados en cada caso
     * Incluye un bloque finally en el que se muestre el estado de la cuenta (toString() de Cuenta)
     * Puede que tengas que tratar otra excepción dentro de finally
     *
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cuenta c = null; //Declaramos la cuenta fuera del try/catch para que tenga ámbito en toda la función
        try{
            //Recibimos el importe como primer argumento
            //Puede generar un ArrayIndexOutOfBoundException si no se recibe nada
            //También un NumberFormatException si lo recibido no es un número (probad un argumento con letras o símbolos)
            double importe = Double.parseDouble(args[0]);
            c = new Cuenta(importe);

            System.out.print("Introduce el importe a ingresar: ");
            double cantidad = sc.nextDouble();
            c.ingresar(cantidad);

            System.out.print("Introduce el importe a retirar: ");
            cantidad = sc.nextDouble();
            c.sacar(cantidad);//Genera una excepción verificada SaldoInsuficienteException, que por tanto hay que gestionar
        }
        catch (ArrayIndexOutOfBoundsException e){//Si no se ha recibido ningún argumento
            System.out.println("Error en nº de argumentos: " + e.getMessage());
        }catch(NumberFormatException e){
            System.out.println("Error en formato numérico " + e.getMessage());
        }catch(IllegalArgumentException e){//Error en algún parámetro pasado a las funciones
            System.out.println("Error al manipular la cuenta: " + e.getMessage());
        }catch(SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
        finally {
            try{
                //Si no ponemos la llamada explícita a toString() no sería necesario capturar la NullPointerException
                //pero podría imprimir "null"
                System.out.println(c.toString());
            }
            catch(NullPointerException e){
                System.out.println("No se ha inicializado la cuenta");
            }
        }


    }
}
