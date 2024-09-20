package com.kodigo.algorithms;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal con método principal que invoca métodos para mostrar menú con opciones para generar test de algoritmos
 * de búsqueda (secuencial y binaria) y de ordenamiento(burbuja, insercción y selección)
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

       while(true)
       {
           try {
               showMenu();
               int leerOpcion = scanner.nextInt();
               if (leerOpcion == 1) {
                   testSearchAlgorithms();
               } else if (leerOpcion == 2) {
                   testSortingAlgorithms();
               } else if (leerOpcion == 3) {
                   break;
               }
               else{
                   throw new IllegalArgumentException("Debe seleccionar entre opciones 1,2 y 3");
               }
           }catch (InputMismatchException e)
           {
               System.out.println("Debe seleccionar entre opciones 1,2 y 3");
               scanner.next();
           }catch(IllegalArgumentException e)
           {
               System.out.println(e.getMessage());
               scanner.next();
           }
       }
    }

    /**
     * Genera un arreglo de enteros
     * @param size Tamaño del arreglo
     * @return arreglo de enteros de tamaño especificado en size
     */
    public static int[] generateArray(int size) {
        int[] array = new int[size]; // Inicializa el arreglo con el tamaño especificado
        // Llena el arreglo con valores aleatorios
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size); // Genera un valor aleatorio y lo asigna
        }
        return array; // Retorna el arreglo generado
    }

    /**
     * Realiza pruebas de rendimiento de los algoritmos de búsqueda y ordenamiento.
     *
     * Este método genera arreglos de diferentes tamaños, mide el tiempo
     * que tarda en realizar una búsqueda secuencial, ordenar el arreglo
     * y luego realizar una búsqueda binaria. Imprime los resultados en
     * un formato tabular.
     */
    public static void testSearchAlgorithms()
    {
        StringBuilder result = new StringBuilder();
        //Cabecera de la tabla
        result.append(String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n",
                "Tamaño del arreglo",
                "Secuencial (ns)",
                "Ordenamiento (ns)",
                "Binaria (ns)",
                "Total binaria (ns)",
                "Mejor tiempo",
                "Peor tiempo"));
        // Línea separadora
        result.append(String.format("%s\n", "-".repeat(120)));

        // Itera sobre diferentes tamaños de arreglo
        for(int i = 10; i <= 1000000; i+=20000)
        {
            Random random = new Random();
            int[] array = generateArray(i); // Genera un arreglo aleatorio
            int target = random.nextInt(); // Genera un número aleatorio como objetivo

            // Mide el tiempo de búsqueda secuencial en nanosegundos
            long startTime = System.nanoTime();
            int index = SearchAlgorithms.sequentialSearch(array,target);
            long endTime = System.nanoTime();
            long duration = endTime -startTime;

            // Mide el tiempo de ordenamiento
            startTime = System.nanoTime();
            Arrays.sort(array);
            endTime = System.nanoTime();
            long orderDuration = endTime - startTime;

            // Mide el tiempo de búsqueda binaria
            startTime = System.nanoTime();
            index = SearchAlgorithms.binarySearch(array,target);
            endTime = System.nanoTime();
            long binarySearchduration = endTime - startTime;

            // Obtiene los mejores y peores tiempos
            String bestTime = SearchAlgorithms.getBestTime(duration, (orderDuration + binarySearchduration));
            String worstTime = SearchAlgorithms.getWorstTime(duration, (orderDuration + binarySearchduration));

            // Agrega los resultados a la tabla
            result.append(String.format("|%-20d|%-20d|%-20d|%-20d|%-20d|%-20s|%-20s|\n",
                    i,
                    duration,
                    orderDuration,
                    binarySearchduration,
                    (orderDuration + binarySearchduration),
                    bestTime,
                    worstTime));
        }
        //Imprime los resultados
        System.out.println(result+"\n");
    }

    /**
     * Realiza pruebas de rendimiento de varios algoritmos de ordenamiento.
     *
     * Este método genera arreglos de diferentes tamaños y mide el tiempo
     * que tardan en ordenarse utilizando los algoritmos de burbuja, inserción
     * y selección. Imprime los resultados en un formato tabular.
     */
    public static void testSortingAlgorithms()
    {
        StringBuilder sortingResult = new StringBuilder();

        // Cabecera de la tabla
        sortingResult.append(String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n",
                "Tamaño del arreglo",
                "Burbuja (ns)",
                "Insercción (ns)",
                "Selección (ns)",
                "Mejor tiempo",
                "Peor tiempo"));

        // Línea separadora
        sortingResult.append(String.format("%s\n", "-".repeat(120)));

        // Itera sobre diferentes tamaños de arreglo
        for(int i = 10; i <= 100000; i+=3000)
        {
            Random random = new Random();
            int[] array = generateArray(i); // Genera un arreglo aleatorio

            // Clona el arreglo para los diferentes algoritmos
            int[] arrayCloneForInsertion = array.clone();
            int[] arrayCloneForSelection = array.clone();

            // Mide el tiempo de ordenamiento con el algoritmo de burbuja
            long startTime = System.nanoTime();
            SortingAlgorithms.bubbleSort(array);
            long endTime = System.nanoTime();
            long bubbleDuration = endTime - startTime;

            // Mide el tiempo de ordenamiento con el algoritmo de inserción
            startTime = System.nanoTime();
            SortingAlgorithms.insertionSort(arrayCloneForInsertion); // Ordena el arreglo clonado
            endTime = System.nanoTime();
            long insertionDuration = endTime - startTime;

            // Mide el tiempo de ordenamiento con el algoritmo de selección
            startTime = System.nanoTime();
            SortingAlgorithms.selectionSort(arrayCloneForSelection); // Ordena el arreglo clonado
            endTime = System.nanoTime();
            long selectionDuration = endTime - startTime;

            // Obtiene los mejores y peores tiempos de ejecución
            String bestTime = SortingAlgorithms.getBestTime(bubbleDuration, insertionDuration, selectionDuration);
            String worstTime = SortingAlgorithms.getWorstTime(bubbleDuration, insertionDuration, selectionDuration);

            // Agrega los resultados a la tabla
            sortingResult.append(String.format("|%-20d|%-20d|%-20d|%-20d|%-20s|%-20s|\n",
                    i,
                    bubbleDuration,
                    insertionDuration,
                    selectionDuration,
                    bestTime,
                    worstTime));
        }
        // Imprime los resultados de la prueba
        System.out.println(sortingResult);
    }

    /**
     * Muestra el menú de opciones disponibles para el usuario.
     *
     * Este método imprime en la consola las opciones que el usuario puede seleccionar,
     * incluyendo la generación de pruebas de rendimiento para algoritmos de búsqueda y
     * ordenamiento, así como la opción de salir del programa.
     */
    public static void showMenu()
    {
        // Muestra la opción para generar pruebas de algoritmos de búsqueda
        System.out.println("1. Generar test de tiempos de algoritmos de búsqueda (secuencial y binaria)");

        // Muestra la opción para generar pruebas de algoritmos de ordenamiento
        System.out.println("2. Generar test de tiempos de algoritmos de ordenamiento (burbuja, inserción y selección)");

        // Muestra la opción para salir del programa
        System.out.println("3. Salir");
    }

    }
