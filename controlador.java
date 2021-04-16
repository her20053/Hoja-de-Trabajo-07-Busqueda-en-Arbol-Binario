import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class controlador{

    public static void main(String[] args) {
        
        HashMap<String,Association<String,String>> diccionario = new HashMap<>(); 
        Scanner sc = new Scanner(System.in);

            //se utiliza un try catch para aseguranos que el archivo pueda ser leido correctamente 
        try{

            //creando variables
            File archivoTexto = new File("diccionario.txt"); //creando nuestro nuevo archivo

            Scanner scan = new Scanner(archivoTexto); //instanciando la clase scanner con el archivo

            BinaryTree<Association<String,ArrayList<HashMap<String,String>>>> arbolBinario = new BinaryTree<>();

            while(scan.hasNextLine()) { //while para que se lean todas las lineas en el archivo


                String linea = scan.nextLine().toLowerCase(); //guardando los elementos (de cada linea) como variables
                //separando los elementos por sus comas
                String[] separar = linea.split(",");

                String ing = separar[0];
                String esp = separar[1];
                String fra = separar[2];


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

                Association<String,ArrayList<HashMap<String,String>>> temp = new Association<>(key,Data);

                arbolBinario.setValue(temp);

                // if(arbolBinario.isEmpty()){

                //     // Aqui creamos el primer arbol
                //     primeraInstancia = false;

                // }
                // else {

                //     // Aqui se agrega el nodo a la raiz

                // }

                //guardando cada lenguaje en variables


                //creando los diccionarios en ingles
                // Association<String,String> diccionarioIng1 = new Association<>(ing, esp);
                // diccionario.put(ing + "IE", diccionarioIng1);
                // Association<String,String> diccionarioIng2 = new Association<>(ing, fra);
                // diccionario.put(ing + "IF", diccionarioIng2);
                // //creando los diccionarios en espanol
                // Association<String,String> diccionarioEsp1 = new Association<>(esp, ing);
                // diccionario.put(esp + "EI", diccionarioEsp1);
                // Association<String,String> diccionarioEsp2 = new Association<>(esp, fra);
                // diccionario.put(esp + "EF", diccionarioEsp2);
                // //creando los diccionarios en frances
                // Association<String,String> diccionarioFra1 = new Association<>(fra, ing);
                // diccionario.put(fra + "FI", diccionarioFra1);
                // Association<String,String> diccionarioFra2 = new Association<>(fra, esp);
                // diccionario.put(fra + "FE", diccionarioFra2);

                //System.out.println(diccionarioIng1);
                //System.out.println(ing + " " +esp +" " + fra); //imprimiendo las lineas

            }
        }
        catch (FileNotFoundException errorArchivoNoEncontrado) {
            // Se le advierte al usuario que el archivo no es existente, se termina el programa.
            System.out.println("\nEl archivo de texto diccionario.txt no ha sido encontrado.\n");
        }

        System.out.println("Ingrese la palabra que desea traducir");
        String palabra = sc.nextLine().toLowerCase();
        System.out.println("La traduccion de la palabra al esp es " + diccionario.get(palabra + "IE"));
    }

}