package com.mycompany.tarea1;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    
    static Scanner intro = new Scanner(System.in);
    static Random r= new Random();
    
    public static void main(String [] Args) {
        int array[] = intro();
        print(sortAsc(array));
        print(sortDes(array));
        
        arraysTest(array);
    }
    
    /*
     *Método intro que llama al método input para establecer
     *la cantidad de números a generar.
    */
    public static int[] intro() {
        int n;
        System.out.println("Ingrese la cantidad de números a generar");
        n=input();
        return randomFill(n);
    }
    
    /*
     *Método input que recibe entrada del teclado cualquiera
     *y asegura que sea un número mediante el metodo err.
    */
    
    public static int input(){
        int input=0;
        String in=intro.next();
        try {
            input=err(in);
        } catch (Exception ex) {  
        }
        return input;
    }
    
    /*
     *Método err que se asegura que el String recibido es un numero 
     *entero y lo transforma a int.
     *Si el String no es transformable a int, pide un input nuevo.
     *Llama al método validInt que se asegura de que el int a enviar
     *está dentro de ciertos parámetros.
    */
    
    public static int err(String input) throws Exception {
        int in=0;
        try {
            in=Integer.parseInt(input);
        } catch (Exception ex) {
            System.out.println("Favor ingresar Dígitos y no carácteres");
            in=err(intro.next());
        }
        validInt(in);
        return in; 
    }
    
    /*
     *Método validInt que se asegura que el int recibido este entre 0
     *y 100 (limite establecido por simple conveniencia)
     *en caso que el int recibido no cumpla esto pide un input nuevo.
    */
    
    public static int validInt(int in){
        if (in<0 || in >100) {
            System.out.println("Favor ingresar un número entre 0 y 100");
            in=input();
        }
        return in;
    }
    
    /*
     *Método randomFill llena y retorna un arreglo de largo n con numeros 
     *aleatorios de 0 a 100 (límites establecidos por conveniencia)
    */
    
    public static int[] randomFill(int n) {
        int array[] = new int[n];
        for (int i=0;i<n;i++) {
            array[i]=r.nextInt(100);
        }
        return array;
    }
    
    /*
     *Método sortAsc ordena y retorna un arreglo de números int de mayor a menor
     *mediante el método de la burbuja
    */
    
    public static int[] sortAsc(int[] array) {
        long start=timerStart();
        
        for(int i=0;i<array.length-1;i++) {
            for(int j=0;j<array.length-1;j++) {
                if (array[j]<array[j+1]) {
                    int aux = array[j+1];
                    array[j+1] = array[j];
                    array[j] = aux;
                }
            }
        }
        
        System.out.println("Tiempo transcurrido: ");
        timerStop(start);
        
        return array;
    }
    
    /*
     *Método sortAsc ordena y retorna un arreglo de números int de menor a mayor
     *mediante el método de la burbuja
    */
    
    public static int[] sortDes(int[] array) {
        long start=timerStart();
        
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    int aux = array[j];
                    array[j]=array[j+1];
                    array[j+1]=aux;
                }
            }
        }
        
        System.out.println("Tiempo transcurrido: ");
        timerStop(start);
        
        return array;
    }
    
    /*
     *Método print recorre un arreglo y lo imprime
    */
    
    public static void print(int[] array) {
        System.out.println("-------------------------------------------");
        for (int i=0;i<array.length;i++) {
            System.out.print(" | "+array[i]+" | ");
        }
        System.out.println();
    }
    
    /*
     *Método arraysTest realiza un ordenamiento mediante java.util.Arrays
     *y mide el tiempo qye se demora en realizar el proceso.
    */
    
    public static void arraysTest(int[] array) {
        long start = timerStart();
        Arrays.sort(array);
        System.out.println("Tiempo transcurrido: ");
        timerStop(start);
        print(array);
    }
    
    /*
     *Método timerStart establece un long para el tiempo actual en milisegundos
     *de el cumputador y lo retorna.
    */
    
    public static long timerStart() {
        long start = System.currentTimeMillis();
        return start;
    }
    
    /*
     *Método timerStop recibe un long y lo compara con uno generado en el tiempo actual
     *para establecer el tiempo concurrido entre ambos e imprimir este valor en milisegundos
    */
    
    public static void timerStop(long start) {
        long fin = System.currentTimeMillis();
         
        double tiempo = (double) ((fin - start));
         
        System.out.print(tiempo +"  Milisegundos");
    }
}
