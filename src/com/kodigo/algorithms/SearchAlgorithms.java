package com.kodigo.algorithms;

/**
 * Clase con métodos que utilizan algoritmos de búsqueda secuencial y búsqueda binaria
 * Ambos retornan el índice del objetivo buscado y -1 si no lo encuentra
 */
public class SearchAlgorithms {

    private static final String SECUENTIAL = "SECUENCIAL";
    private static final String BINARY = "BINARIA";


    /**
     * <pre>
     * Búsqueda secuencial:
     * Para cada elemento en el array:
     *  Si el elemento es igual al objetivo:
     *      Retorna el índice
     * Retorna -1 si no lo encuentra
     * <b>Ejemplo:</b>
     *      <b>Array:</b> [3, 5, 7, 9, 11]
     *      <b>Objetivo:</b> 7
     * <b>Ejecución:</b>
     *      <b>Paso 1:</b> Compara el primer elemento (3) con el objetivo (7). No son iguales.
     *      <b>Paso 2:</b> Compara el segundo elemento (5) con el objetivo (7). No son iguales.
     *      <b>Paso 3:</b> Compara el tercer elemento (7) con el objetivo (7). Son iguales, por lo que se retorna el índice 2.
     * </pre>
     * @param array Arreglo de elementos
     * @param target Elemento a buscar en el arreglo
     * @return Indice de elemento buscado, -1 si no fue encontrado
     */
    public  static int sequentialSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * <pre>
     * Búsqueda binaria:
     * Mientras left <= right:
     *     mid = (left + right) / 2
     *     Si array[mid] es igual al objetivo:
     *         Retorna mid
     *     Si array[mid] es menor que el objetivo:
     *         Ajusta left a mid + 1
     *     De lo contrario:
     *         Ajusta right a mid - 1
     * Retorna -1 si no se encuentra
     * <b>Ejemplo:</b>
     *      <b>Array:</b> [3, 5, 7, 9, 11]
     *      <b>Objetivo:</b> 9
     * <b>Ejecución:</b>
     *  	<b>Paso 1:</b> Calcula el índice medio: mid = (0 + 4) / 2 = 2. El valor en el índice 2 es 7.
     *  	7 < 9, así que ajusta el índice izquierdo a mid + 1, left = 3.
     *  	<b>Paso 2:</b> Calcula el nuevo índice medio: mid = (3 + 4) / 2 = 3. El valor en el índice 3 es 9.
     *  	9 == 9, así que se retorna el índice 3.
     * </pre>
     * @param array Arreglo de elementos
     * @param target Elemento a buscar en el arreglo
     * @return Indice de elemento buscado, -1 si no fue encontrado
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Retorna el nombre del algoritmo con mejor tiempo de ejecución
     * @param durationSequentialSearch tiempo de ejecución de algoritmo de búsqueda secuencial
     * @param totalDurationBinarySearch tiempo total de ejecución de algoritmo de búsqueda binaria
     * @return Nombre de algoritmo con mejor tiempo
     */
    public static String getBestTime(long durationSequentialSearch, long totalDurationBinarySearch)
    {
        if (durationSequentialSearch < totalDurationBinarySearch)
        {
            return SECUENTIAL;
        }else {
            return BINARY;
        }
    }

    /**
     * Obtiene el peor tiempo de ejecución entre los algoritmos de búsqueda secuencial y binaria
     * @param durationSequentialSearch Tiempo de ejecución de búsqueda secuencial
     * @param totalDurationBinarySearch Tiempo de ejecución de búsqueda binaria
     * @return Peor tiempo entre algorimos de búsqueda secuencial y binaria
     */
    public  static String getWorstTime(long durationSequentialSearch, long totalDurationBinarySearch)
    {
        if (durationSequentialSearch > totalDurationBinarySearch)
        {
            return SECUENTIAL;
        }else {
            return BINARY;
        }
    }

}
