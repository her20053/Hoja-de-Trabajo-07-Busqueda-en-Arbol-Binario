import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class controlador{

    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();
        String OracionAnalizarIng = "A woman in her house is doing her homework next to her dog";
        String OracionAnalizarFrn = "Une femme dans sa maison fait ses devoirs à côté de son chien";
        String OracionAnalizarEsp = "Una mujer en su casa hace tarea al lado de su perro";

        try{

            File archivoTexto = new File("diccionario.txt");

            Scanner scan = new Scanner(archivoTexto); 

            while(scan.hasNextLine()) {

                String linea = scan.nextLine().toLowerCase();

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
                Association<String,ArrayList<HashMap<String,String>>> Nodotemp = new Association<>(key,Data);

                arbol.insertarNodo(key,Nodotemp);

            }

        }
        catch (FileNotFoundException errorArchivoNoEncontrado) {
            System.out.println("\nEl archivo de texto diccionario.txt no ha sido encontrado.\n");
        }


        // Analizando la oracion:
        String   traducirAIdimoa = "Spanish";

        String   oracionResultante = "";

        String[] oracionSeparada = OracionAnalizarEsp.toLowerCase().split(" ");

        for (String string : oracionSeparada) {

            String palabraTemp = string; 

            Nodo nodoEncontrado = arbol.localizarNodo(palabraTemp);
            if(nodoEncontrado != null){

                Association<String,ArrayList<HashMap<String, String>>> associationTemp = nodoEncontrado.getValor();
                ArrayList<HashMap<String, String>> arrayListTemp = associationTemp.getValue();
                for(int i = 0; i < arrayListTemp.size(); i++){

                    HashMap<String,String> hashMapTemp = arrayListTemp.get(i);
                    if(hashMapTemp.get(traducirAIdimoa) != null){
                        oracionResultante += hashMapTemp.get(traducirAIdimoa);
                    }    

                }

            }
            else{

                oracionResultante += " *" + palabraTemp + "* ";

            }

        }
        System.out.println(oracionResultante);
        
    }
}