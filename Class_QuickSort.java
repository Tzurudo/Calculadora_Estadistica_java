package calculadoraestadistica;

public class Class_QuickSort {

    public void ordenar_quickSort(Object[] A, int izq, int der) {
        if (izq < der) {
            // Comprobación de límites del arreglo
            if (izq >= 0 && der < A.length) {
                Object pivote = A[izq];
                int i = izq;
                int j = der;
                Object aux;

                while (i < j) {
                    // Comprobación de tipos y comparación
                    while (i < der && comparar(A[i], pivote) <= 0) {
                        i++;
                    }

                    while (j > izq && comparar(A[j], pivote) > 0) {
                        j--;
                    }

                    if (i < j) {
                        // Intercambiar A[i] y A[j]
                        aux = A[i];
                        A[i] = A[j];
                        A[j] = aux;
                    }
                }

                // Colocar el pivote en su posición final
                A[izq] = A[j];
                A[j] = pivote;

                // Recursividad para las sublistas
                if (izq < j - 1) {
                    ordenar_quickSort(A, izq, j - 1);
                }
                if (j + 1 < der) {
                    ordenar_quickSort(A, j + 1, der);
                }
            }
        }
    }

    // Método de comparación para valores genéricos
    private int comparar(Object a, Object b) {
        if (a instanceof Comparable && b instanceof Comparable) {
            return ((Comparable<Object>) a).compareTo(b);
        }
      
        return 0; // Por defecto, se consideran iguales
    }
}
