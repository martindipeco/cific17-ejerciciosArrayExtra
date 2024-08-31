import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //EJERCICIOS EXTRA: 1
        //base tomada del calculo de notas minimas y maximas
        //Pedimos el ingreso de la cantidad de personas
        String stringCantPersonas = JOptionPane.showInputDialog("Ingrese la cantidad de personas:");

        // Convertir la entrada a un número entero
        try {
            int numeroPersonas = Integer.parseInt(stringCantPersonas);

            //creamos los arrays paralelos
            String[] arrayPersonas = new String[numeroPersonas];
            double[] arrayAlturas = new double[numeroPersonas];

            for (int i= 0; i < numeroPersonas; i++)
            {
                arrayPersonas[i] = JOptionPane.showInputDialog("Ingrese el nombre de la persona " + (i+1));
                boolean alturaValida = false;

                while (!alturaValida) {
                    String alturaInput = JOptionPane.showInputDialog("Ingrese la altura de " + arrayPersonas[i] + ":");
                    try {
                        arrayAlturas[i] = Double.parseDouble(alturaInput);

                        if (arrayAlturas[i] <= 0) {
                            throw new NumberFormatException(); // Forzar la excepción si es negativo
                        }
                        alturaValida = true;
                    }
                    catch (NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null, "Altura inválida. " +
                                "Por favor ingrese un número positivo.");
                    }
                }
            }

            // Encontramos la altura mínima y máxima
            //asignamos por defecto nota min y max al index 0, mismo para nombre persona
            double sumaAlturas = 0.0;
            double alturaMin = arrayAlturas[0];
            double alturaMax = arrayAlturas[0];

            String personaMin = arrayPersonas[0];
            String personaMax = arrayPersonas[0];

            //iteramos para comparar y reemplazar máximos y mínimos
            for (int i = 1; i < numeroPersonas; i++)
            {
                sumaAlturas += arrayAlturas[i];
                if (arrayAlturas[i] < alturaMin)
                {
                    alturaMin = arrayAlturas[i];
                    personaMin = arrayPersonas[i];
                }
                if (arrayAlturas[i] > alturaMax)
                {
                    alturaMax = arrayAlturas[i];
                    personaMax = arrayPersonas[i];
                }
            }

            // Calcular la altura media
            double alturaMedia = sumaAlturas / numeroPersonas;

            //mostramos la lista de personas con su altura
            String listaPersonas = "Lista de personas con su altura\n";
            for (int i = 0; i < numeroPersonas; i++)
            {
                listaPersonas = listaPersonas + (i + 1) + ": " + arrayPersonas[i] + " - Altura: " + arrayAlturas[i] + "\n";
            }
            JOptionPane.showMessageDialog(null, listaPersonas);

            // Mostramos la persona con la altura mínima y máxima, el promedio y la mediana
            JOptionPane.showMessageDialog(null, "La persona más baja es: "
                    + personaMin + " con una altura de " + alturaMin);
            JOptionPane.showMessageDialog(null, "La persona más alta es: "
                    + personaMax + " con una altura de " + alturaMax);
            JOptionPane.showMessageDialog(null, "La altura promedio es " + alturaMedia + " mts");
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
        }

        //EJERCICIO EXTRA: 2
        //Se propone usar "bubble sort" manual para no usar los métodos de Arrays de Java

        int[] numeros1al5 = new int[5];

        for (int i = 0; i < 5; i++)
        {
            boolean numeroValido = false;
            while (!numeroValido) {
                try
                {
                    System.out.print("Ingrese el número " + (i + 1) + "  de 5: ");
                    numeros1al5[i] = Integer.parseInt(scanner.nextLine());
                    numeroValido = true; // Si el número es válido, salimos del bucle
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                }
            }
        }
        // Ordenar de menor a mayor usando el algoritmo de burbuja
        for (int i = 0; i < numeros1al5.length - 1; i++)
        {
            for (int j = 0; j < numeros1al5.length - 1 - i; j++)
            {
                if (numeros1al5[j] > numeros1al5[j + 1])
                {
                    // Intercambiar numeros[j] y numeros[j+1]
                    int temp = numeros1al5[j];
                    numeros1al5[j] = numeros1al5[j + 1];
                    numeros1al5[j + 1] = temp;
                }
            }
        }

        // Mostrar los números ordenados de menor a mayor
        System.out.print("Números ordenados de menor a mayor: ");
        for (int num : numeros1al5)
        {
            System.out.print(num + " ");
        }

        // Ordenar de mayor a menor usando el algoritmo de burbuja
        for (int i = 0; i < numeros1al5.length - 1; i++)
        {
            for (int j = 0; j < numeros1al5.length - 1 - i; j++)
            {
                if (numeros1al5[j] < numeros1al5[j + 1])
                {
                    // Intercambiar numeros[j] y numeros[j+1]
                    int temp = numeros1al5[j];
                    numeros1al5[j] = numeros1al5[j + 1];
                    numeros1al5[j + 1] = temp;
                }
            }
        }
        // Mostrar los números ordenados de mayor a menor
        System.out.print("\nNúmeros ordenados de mayor a menor: ");
        for (int num : numeros1al5)
        {
            System.out.print(num + " ");
        }

        //EJERICICIO EXTRA 3
        int[] numerosUnicos = new int[5];
        System.out.println("Por favor ingrese 5 números sin repetir");

        // Usamos un bucle for para ingresar 5 números únicos
        for (int i = 0; i < 5; i++)
        {
            boolean numeroValido = false;
            int numeroIngresado = 0;

            // Bucle para verificar que el número ingresado sea válido y no esté repetido
            while (!numeroValido) {
                try {
                    System.out.print("Ingrese el número " + (i + 1) + " de 5: ");
                    numeroIngresado = Integer.parseInt(scanner.nextLine());

                    // Verificar si el número ya está en el array
                    boolean repetido = false;
                    for (int j = 0; j < i; j++)
                    {
                        if (numerosUnicos[j] == numeroIngresado) {
                            repetido = true;
                            break; // Salir del bucle si el número es repetido
                        }
                    }

                    if (!repetido)
                    {
                        numeroValido = true; // Si no es repetido, es válido
                    }
                    else
                    {
                        System.out.println("Número repetido. Por favor, ingrese un número diferente.");
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                }
            }
            // Guardar el número válido en el array
            numerosUnicos[i] = numeroIngresado;
        }

        // Mostrar los números ingresados
        System.out.print("Números ingresados: ");
        for (int num : numerosUnicos)
        {
            System.out.print(num + " ");
        }


        //EJERCICIO EXTRA 4
        String[] palabras = new String[3];

        // Leer las 3 palabras
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese la palabra " + (i + 1) + " de 3: ");
            palabras[i] = scanner.nextLine();
        }

        // Ordenar las palabras por longitud de mayor a menor utilizando el algoritmo de burbuja
        for (int i = 0; i < palabras.length - 1; i++)
        {
            for (int j = 0; j < palabras.length - 1 - i; j++)
            {
                if (palabras[j].length() < palabras[j + 1].length())
                {
                    // Intercambiar palabras
                    String temp = palabras[j];
                    palabras[j] = palabras[j + 1];
                    palabras[j + 1] = temp;
                }
            }
        }

        // Mostrar las palabras ordenadas
        System.out.println("Palabras ordenadas de mayor a menor por longitud:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
}
