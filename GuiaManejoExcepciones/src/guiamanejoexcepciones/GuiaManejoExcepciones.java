/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiamanejoexcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Facundo
 */
public class GuiaManejoExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        /*
    1.Definir una Clase que contenga algún tipo de dato de tipo array y agregue el código para generar y capturar una excepción ArrayIndexOutOfBoundsException (índice de arreglo fuera de rango).
        
        Integer[] array = {1,2};
        Integer position = null;
        try {
            System.out.println("enter any position of an array");
            position = read.nextInt();
            System.out.println(array[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("index out of range");
        }
        
        
        

    2. Defina una clase llamada DivisionNumero. En el método main utilice un Scanner para leer dos números en forma de cadena. A continuación, utilice el método parseInt() de la clase Integer, para convertir las cadenas al tipo int y guardarlas en
    dos variables de tipo int. Por ultimo realizar una división con los dos numeros y mostrar el resultado.
    Todas estas operaciones puede tirar excepciones a manejar, el ingreso por teclado puede causar una excepción de tipo InputMismatchException, el método Integer.parseInt() si la cadena no puede convertirse a entero, arroja una
    NumberFormatException y además, al dividir un número por cero surge una ArithmeticException. Manipule todas las posibles excepciones utilizando bloques try/catch para las distintas excepciones

        Integer numberOne = null;
        Integer numberTwo = null;
        String number = null;
        try {
            for (int i = 1; i < 3; i++) {
                System.out.println("Enter the number " + i);
                number = read.next();
                if (i == 1) {
                    numberOne = Integer.parseInt(number);
                } else {
                    numberTwo = Integer.parseInt(number);
                }
            }
            System.out.println("numeroOne / numeroTwo = " + (numberOne / numberTwo));
        } catch (InputMismatchException e) {
            System.out.println("error when entering the number by keyboard " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("error when converting a number from String to Integer " + e.getMessage());
        } catch(ArithmeticException e){
            System.out.println("error when dividing by zero " + e.getMessage());
        }



    3. Escribir un programa en Java que juegue con el usuario a adivinar un número. La computadora debe generar un número aleatorio entre 1 y 500, y el usuario tiene que intentar adivinarlo. Para ello, cada vez que el usuario introduce un valor, la
    computadora debe decirle al usuario si el número que tiene que adivinar es mayor o menor que el que ha introducido el usuario. Cuando consiga adivinarlo, debe indicárselo e imprimir en pantalla el número de veces que el usuario ha intentado
    adivinar el número. Si el usuario introduce algo que no es un número, se debe controlar esa excepción e indicarlo por pantalla.  En este último caso también se debe contar el carácter fallido como un intento.

         
        Integer number = 0;
        Integer guess = 0;

        try {
            do {
                number = (int) ((Math.random() * 1000) + (Math.random() * 100));
            } while (number > 500 || number < 0);
            System.out.println(number);
            do {
                System.out.println("enter the number to guess ");
                guess = read.nextInt();
                if (guess > number) {
                    System.out.println("is greater");
                } else if (guess < number) {
                    System.out.println("is less");
                }
            } while (guess != number);
        } catch (InputMismatchException e) {
            System.out.println("error when entering the number by keyboard " + e.getMessage());
        }
    


    4.Dado el método metodoA de la clase A, indique:
    a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción MioException?
        
        sentencia_a1 - sentencia_a2 - sentencia_a3 - sentencia_a6 - sentencia_a5
        
        ó
        
        sentencia_a1 - sentencia_a2 - sentencia_a4 - sentencia_a6 - sentencia_a5
        
    b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción MioException? 
         
        sentencia_a1 - sentencia_a2 - sentencia_a3 - sentencia_a4 - sentencia_a5
        
        class A {
            void metodoA() {
                sentencia_a1
                sentencia_a2
                try {
                    sentencia_a3
                    sentencia_a4
                } catch (MioException e){
                    sentencia_a6
                }
                sentencia_a5
            }
        }
        
        
        
    5. Dado el método metodoB de la clase B, indique:
    a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción MioException?
        
        sentencia_b1 - sentencia_b2 - sentencia_b3 - sentencia_b4;
        
    b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción MioException?
        
        sentencia_b1 - sentencia_b2 - sentencia_b4;
        
        class B {
            void metodoB() {
                sentencia_b1
                try {
                    sentencia_b2
                } catch (MioException e){
                    sentencia_b3
                }finally
                    sentencia_b4
                }
            }
        
       
        
        
        
        
    6. Indique que se mostrará por pantalla cuando se ejecute cada una de estas clases:
        
        class Uno{
            private static int metodo() {
                int valor=0;
                try {
                    valor = valor+1;
                    valor = valor + Integer.parseInt (”42”);
                    valor = valor +1;
                    System.out.println(”Valor final del try:” + valor) ;
                } catch (NumberFormatException e) {
                    Valor = valor + Integer.parseInt(”42”);
                    System.out.println(“Valor final del catch:” + valor);
                } finally {
                    valor = valor + 1;
                    System.out.println(”Valor final del finally: ” + valor) ;
                }
                valor = valor +1;
                System.out.println(”Valor antes del return: ” + valor) ;
                return valor;
            }
        
            public static void main (String[] args) {
                try {
                    System.out.println (metodo()) ;
                }catch(Exception e) {
                    System.err.println(”Excepcion en metodo() ”) ;
                    e.printStackTrace();
                }
            }
       }
       
        reply: 
            valor final del try: 44
            valor final del finally: 45
            valor anter del return: 46
            46
        
        
        class Dos{
            private static metodo() {
                int valor=0;
                try{
                    valor = valor + 1;
                    valor = valor + Integer.parseInt (”W”);
                    valor = valor + 1;
                    System.out.println(”Valor final del try: ” + valor) ;
                } catch ( NumberFormatException e ) {
                    valor = valor + Integer.parseInt (”42”);
                    System.out.println(”Valor final del catch: ” + valor) ;
                } finally {
                    valor =  valor + 1;
                    System.out.println(”Valor final del finally: ” + valor) ;
                    valor = valor + 1;
                    System.out.println(”Valor antes del return: ” + valor) ;
                    return valor;
                }
                public static void main (String[] args) {
                    try{
                        System.out.println ( metodo ( ) ) ;
                    } catch(Exception e) {
                        System.err.println ( ” Excepcion en metodo ( ) ” ) ;
                        e.printStackTrace();
                    }
                }
        }
        
        reply:
            valor final del catch: 43
            valor final del finally: 44
            valor antes del return: 45
            Excepcion en metodo()
            e.printSatackTrace();
        
        
        
        class Tres{
            private static metodo( ) {
                int valor=0;
                try{
                    valor = valor + 1;
                    valor = valor + Integer.parseInt (”W”);
                    valor = valor + 1;
                    System.out.println(”Valor final del try: ” + valor);
                } catch(NumberFormatException e) {
                    valor = valor + Integer.parseInt (”W”);
                    System.out.println(”Valor final del catch: ” + valor);
                } finally{
                    valor = valor + 1;
                    System.out.println(”Valor final del finally:” + valor);
                }
                valor = valor + 1;
                System.out.println(”Valor antes del return: ” + valor) ;
                return valor;
            }
        }
        
        public static void main (String[] args) {
            try{
                System.out.println( metodo ( ) ) ;
            } catch(Exception e) {
                System.err.println(”Excepcion en metodo ( ) ” ) ;
                e.printStackTrace();
            }
        }
        
        
        reply:
            valor final del finally: 2
            Excepcion en metodo ( )
            e.printStackTrace
        
        
        
    
        
    8. Dado el método metodoC de la clase C, indique:
    a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción MioException?
        
            sentencia_c1 - sentencia_c2 - sentencia_c4 - sentencia_c6
        ó
            sentencia_c1 - sentencia_c3 - sentencia_c4 - sentencia_c6
    
    b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción MioException?
        
            sentencia_c1 - sentencia_c2 - sentencia_c3 - sentencia_c6
        
    c) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción TuException?
        
            sentencia_c1 - sentencia_c2 - sentencia_c5 - throw(e) - sentencia_c6
        ó
            sentencia_c1 - sentencia_c3 - sentencia_c5 - throw(e) - sentencia_c6
        
        
        class C {
            void metodoC() throws TuException{
            sentencia_c1
            try {
                sentencia_c2
                sentencia_c3
            } catch (MioException e){
                sentencia_c4
            } catch (TuException e){
                sentencia_c5
                throw (e)
            }finally
                sentencia_c6
            }
        }
    */
        
    }

}
