import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class controlador{

    // Comenzamos el programa 
    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();

        try{

            //creando variables
            File archivoTexto = new File("diccionario.txt"); //creando nuestro nuevo archivo

            Scanner scan = new Scanner(archivoTexto); //instanciando la clase scanner con el archivo

            while(scan.hasNextLine()) { //while para que se lean todas las lineas en el archivo


                String linea = scan.nextLine().toLowerCase(); //guardando los elementos (de cada linea) como variables

                //separando los elementos por sus comas

                String ing = linea.split(",")[0];
                String esp = linea.split(",")[1];
                String fra = linea.split(",")[2];

                String key = ing;

                ArrayList<HashMap<String,String>> Data = new ArrayList<>();

                HashMap<String,String> entrada1 = new HashMap<>();
                entrada1.put("Spanish", esp);
                HashMap<String,String> entrada2 = new HashMap<>();
                entrada1.put("English", ing);
                HashMap<String,String> entrada3 = new HashMap<>();
                entrada1.put("French", fra);

                Data.add(entrada1);
                Data.add(entrada2);
                Data.add(entrada3);

                //           k    ,                 v -> Lista [ diccionario1: ING , diccionario2 , diccionario2]
                Association<String,ArrayList<HashMap<String,String>>> Nodotemp = new Association<>(key,Data);

                arbol.insertarNodo(key,Nodotemp);

            }
            
            Nodo nodoRaiz = arbol.getRaiz();
            while(nodoRaiz.getNodoIzquierda() != null){
                System.out.println(nodoRaiz.getValor().toString());
                nodoRaiz = nodoRaiz.getNodoIzquierda();
            }

        }
        catch (FileNotFoundException errorArchivoNoEncontrado) {
            // Se le advierte al usuario que el archivo no es existente, se termina el programa.
            System.out.println("\nEl archivo de texto diccionario.txt no ha sido encontrado.\n");
        }
        
    }
}