package com.kodigo.algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

       while(true)
       {
            showMenu();
            int leerOpcion = scanner.nextInt();
            if(leerOpcion == 1)
            {
                testSearchAlgorithms();
            }else if(leerOpcion == 2)
            {
                testSortingAlgorithms();
            }
            else if(leerOpcion == 3)
            {
                break;
            }else{
                System.out.println("Opción no válida");
                scanner.close();
            }
       }

    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }

    private static void testSearchAlgorithms()
    {
        StringBuilder result = new StringBuilder();
        result.append(String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n",
                "Tamaño del arreglo",
                "Secuencial (ns)",
                "Ordenamiento (ns)",
                "Binaria (ns)",
                "Total binaria (ns)",
                "Mejor tiempo",
                "Peor tiempo"));
        result.append(String.format("%s\n", "-".repeat(120)));
        for(int i = 10; i <= 1000000; i+=20000)
        {
            Random random = new Random();
            int[] array = generateArray(i);
            long startTime = System.nanoTime();
            int target = random.nextInt();
            int index = SearchAlgorithms.sequentialSearch(array,target);
            long endTime = System.nanoTime();
            long duration = endTime -startTime;
            startTime = System.nanoTime();
            Arrays.sort(array);
            endTime = System.nanoTime();
            long orderDuration = endTime - startTime;
            startTime = System.nanoTime();
            index = SearchAlgorithms.binarySearch(array,target);
            endTime = System.nanoTime();
            long binarySearchduration = endTime - startTime;
            String bestTime = SearchAlgorithms.getBestTime(duration, (orderDuration + binarySearchduration));
            String worstTime = SearchAlgorithms.getWorstTime(duration, (orderDuration + binarySearchduration));
            result.append(String.format("|%-20d|%-20d|%-20d|%-20d|%-20d|%-20s|%-20s|\n",
                    i,
                    duration,
                    orderDuration,
                    binarySearchduration,
                    (orderDuration + binarySearchduration),
                    bestTime,
                    worstTime));
        }
        System.out.println(result+"\n");
    }

    private static void testSortingAlgorithms()
    {
        StringBuilder sortingResult = new StringBuilder();
        sortingResult.append(String.format("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|\n",
                "Tamaño del arreglo",
                "Burbuja (ns)",
                "Insercción (ns)",
                "Selección (ns)",
                "Mejor tiempo",
                "Peor tiempo"));
        sortingResult.append(String.format("%s\n", "-".repeat(120)));
        for(int i = 10; i <= 100000; i+=3000)
        {
            Random random = new Random();
            int[] array = generateArray(i);
            int[] arrayCloneForInsertion = array.clone();
            int[] arrayCloneForSelection = array.clone();
            long startTime = System.nanoTime();
            SortingAlgorithms.bubbleSort(array);
            long endTime = System.nanoTime();
            long bubbleDuration = endTime - startTime;
            startTime = System.nanoTime();
            SortingAlgorithms.insertionSort(arrayCloneForInsertion);
            endTime = System.nanoTime();
            long insertionDuration =git push -u origin main endTime - startTime;
            startTime = System.nanoTime();
            SortingAlgorithms.selectionSort(arrayCloneForSelection);
            endTime = System.nanoTime();
            long selectionDuration = endTime - startTime;
            String bestTime = SortingAlgorithms.getBestTime(bubbleDuration, insertionDuration, selectionDuration);
            String worstTime = SortingAlgorithms.getWorstTime(bubbleDuration, insertionDuration, selectionDuration);
            sortingResult.append(String.format("|%-20d|%-20d|%-20d|%-20d|%-20s|%-20s|\n",
                    i,
                    bubbleDuration,
                    insertionDuration,
                    selectionDuration,
                    bestTime,
                    worstTime));
        }
        System.out.println(sortingResult);
    }

    private static void showMenu()
    {
        System.out.println("1. Generar test de tiempos de algoritmos de búsqueda (secuencial y binaria)");
        System.out.println("2. Generar test de tiempos de algoritmos de ordenamiento (burbuja, inserción y selección)");
        System.out.println("3. Salir");
    }

}