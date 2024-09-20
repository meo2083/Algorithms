package com.kodigo.algorithms;

/**
 * Clase con métodos que utilizan algoritmos de ordenamiento de la burbuja, por inserción y por selección
 */
public class SortingAlgorithms {

    private static final String BUBBLE = "BURBUJA";
    private static final String INSERTION = "INSERCIÓN";
    private static  final String SELECTION = "SELECCIÓN";

    /**
     * <pre>
     * Ordenamiento Burbuja:
     * Repite mientras haya intercambios:
     *     Para cada elemento en el array:
     *         Si el elemento es mayor que el siguiente:
     *             Intercambia los elementos
     * <b>Ejemplo:</b>
     *      <b>Array:</b> [64, 34, 25, 12, 22]
     * <b>Ejecución:</b>
     *      <b>Primera Pasada:</b>
     *          Compara 64 y 34, intercambia → [34, 64, 25, 12, 22]
     *          Compara 64 y 25, intercambia → [34, 25, 64, 12, 22]
     *          Compara 64 y 12, intercambia → [34, 25, 12, 64, 22]
     *          Compara 64 y 22, intercambia → [34, 25, 12, 22, 64]
     *      <b>Segunda Pasada:</b>
     *          Compara 34 y 25, intercambia → [25, 34, 12, 22, 64]
     *          Compara 34 y 12, intercambia → [25, 12, 34, 22, 64]
     *          Compara 34 y 22, intercambia → [25, 12, 22, 34, 64]
     *      <b>Tercera Pasada:</b>
     *          Compara 25 y 12, intercambia → [12, 25, 22, 34, 64]
     *          Compara 25 y 22, intercambia → [12, 22, 25, 34, 64]
     *      El array ya está ordenado, así que se detiene el proceso.
     * </pre>
     * @param array Arreglo de elementos a ordenar
     */
    public  static void bubbleSort(int[] array) {
        int n = array.length; //Tamaño del arreglo
        boolean swapped; //Bandera para verificar si se realizaron intercambios
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                //Compara elementos adyacentes
                if (array[i - 1] > array[i]) {
                    // Intercambia si están en el orden incorrecto
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true; // Se realizó un intercambio
                }
            }
            n--; // Reduce el rango de comparación
        } while (swapped); // Continúa hasta que no haya más intercambios
    }

    /**
     * <pre>
     * Ordenamiento por Inserción:
     * Para cada elemento desde el segundo hasta el final:
     *     Guarda el elemento actual
     *     Mueve los elementos mayores al elemento actual a la derecha
     *     Inserta el elemento en su posición correcta
     * <b>Ejemplo:</b>
     *      <b>Array:</b> [64, 34, 25, 12, 22]
     * <b>Ejecución:</b>
     *         <b>Paso 1:</b> i = 1, key = 34
     *              Compara 34 con 64, coloca 34 antes de 64 → [34, 64, 25, 12, 22]
     *         <b>Paso 2:</b> i = 2, key = 25
     *              Compara 25 con 64 y 34, coloca 25 antes de 34 → [25, 34, 64, 12, 22]
     *         <b>Paso 3:</b> i = 3, key = 12
     *              Compara 12 con 64, 34 y 25, coloca 12 al principio → [12, 25, 34, 64, 22]
     *         <b>Paso 4:</b> i = 4, key = 22
     *              Compara 22 con 64, 34 y 25, coloca 22 antes de 25 → [12, 22, 25, 34, 64]
     * </pre>
     * @param array Arreglo de elementos a ordenar
     */
    public static void insertionSort(int[] array) {
        int n = array.length;  // Longitud del arreglo
        for (int i = 1; i < n; i++) {
            int key = array[i]; // Elemento actual a insertar
            int j = i - 1; // Índice del elemento anterior

            // Desplaza los elementos mayores que 'key' una posición a la derecha
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]; // Desplazamiento
                j--; // Decrementa el índice
            }
            // Inserta el elemento 'key' en su posición correcta
            array[j + 1] = key;
        }
    }

    /**
     * <pre>
     * Ordenamiento por selección:
     * Para cada posición en el array:
     *    Encuentra el índice del elemento más pequeño desde la posición actual hasta el final
     *    Intercambia el elemento más pequeño con el elemento en la posición actual
     * <b>Ejemplo:</b>
     *      <b>Array:</b> [64, 25, 12, 22, 11]
     * <b>Ejecución:</b>
     *      <b>Primera pasada:</b>
     *          Encuentra el elemento más pequeño en la parte desordenada ([64, 25, 12, 22, 11]).
     *          El elemento más pequeño es 11.
     *          Intercambia 11 con el primer elemento (64).
     *          Lista después del primer paso: [11, 25, 12, 22, 64]
     *      <b>Segunda pasada:</b>
     *          Encuentra el elemento más pequeño en la parte desordenada ([25, 12, 22, 64]).
     *          El elemento más pequeño es 12.
     *          Intercambia 12 con el primer elemento de la parte desordenada (25).
     *          Lista después del segundo paso: [11, 12, 25, 22, 64]
     *      <b>Tercera pasada:</b>
     *          Encuentra el elemento más pequeño en la parte desordenada ([25, 22, 64]).
     *          El elemento más pequeño es 22.
     *          Intercambia 22 con el primer elemento de la parte desordenada (25).
     *          Lista después del tercer paso: [11, 12, 22, 25, 64]
     *      <b>Cuarta pasada:</b>
     *          Encuentra el elemento más pequeño en la parte desordenada ([25, 64]).
     *          El elemento más pequeño es 25.
     *          No es necesario intercambiar ya que 25 ya está en la posición correcta.
     *          Lista después del cuarto paso: [11, 12, 22, 25, 64]
     *     <b>Terminación</b>
     *          La lista ya está ordenada, ya que no hay más elementos en la parte desordenada.
     * </pre>
     * @param array Arreglo de elementos a ordenar
     */
    public static void selectionSort(int[] array) {
        int n = array.length; // Longitud del arreglo
        // Recorre el arreglo hasta el penúltimo elemento
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Inicializa el índice del elemento mínimo
            // Busca el elemento mínimo en el resto del arreglo
            for (int j = i + 1; j < n; j++) {
                // Actualiza minIndex si se encuentra un elemento menor
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Nuevo índice del mínimo
                }
            }
            // Intercambia el elemento encontrado con el elemento en la posición 'i'
            int temp = array[minIndex]; // Almacena el valor mínimo
            array[minIndex] = array[i]; // Coloca el mínimo en su lugar
            array[i] = temp; // Coloca el antiguo valor en la posición del mínimo
        }
    }

    /**
     * Retorna el nombre del algoritmo de ordenamiento con mejor tiempo de ejecución
     * @param durationForBubbleSort Tiempo de ejecución de ordenamiento usando algoritmo de la burbuja
     * @param durationForInsertionSort Tiempo de ejecución usando algoritmo de insercción
     * @param durationForSelectionSort Tiempo de ejecución usando algoritmo de selección
     * @return Mejor tiempo de ejecución
     */
    public static String getBestTime(long durationForBubbleSort, long durationForInsertionSort, long durationForSelectionSort)
    {
        long min = Math.min(durationForBubbleSort, Math.min(durationForInsertionSort, durationForSelectionSort));
        String result = "";
        if(min == durationForBubbleSort){
            result = BUBBLE;
        }else if(min == durationForInsertionSort)
        {
            result = INSERTION;
        }else if(min == durationForSelectionSort) {
            result = SELECTION;
        }
        return result;
    }

    /**
     * Retorna el peor tiempo entre los métodos de la burbuja, inserción y selección
     * @param durationForBubbleSort Tiempo de ejecución por burbuja
     * @param durationForInsertionSort Tiempo de ejecución por inserción
     * @param durationForSelectionSort Tiempo e ejecución por selección
     * @return Peor tiempo entre algoritmos burbuja, inserción y selección
     */
    public static String getWorstTime(long durationForBubbleSort, long durationForInsertionSort, long durationForSelectionSort)
    {
        long max = Math.max(durationForBubbleSort, Math.min(durationForInsertionSort, durationForSelectionSort));
        String result = "";
        if(max == durationForBubbleSort){
            result = BUBBLE;
        }else if(max == durationForInsertionSort)
        {
            result = INSERTION;
        }else if(max == durationForSelectionSort) {
            result = SELECTION;
        }
        return result;
    }

}
