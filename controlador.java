import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class controlador{

    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();

        String OracionAnalizarIng = null;
        String OracionAnalizarFrn = null;
        String OracionAnalizarEsp = null;

        ArrayList<String> listaOraciones = new ArrayList<>();

        try{

            File archivoTexto = new File("oraciones.txt");

            Scanner scan = new Scanner(archivoTexto); 

            int lineaActual = 0;

            while(scan.hasNextLine()) {
                String linea = scan.nextLine().toLowerCase().substring(1);
                listaOraciones.add(linea.substring(0, linea.length()-1));
                // if(lineaActual == 0) {OracionAnalizarIng = linea; lineaActual++; listaOraciones.add(OracionAnalizarIng);}
                // if(lineaActual == 1) {OracionAnalizarFrn = linea; lineaActual++; listaOraciones.add(OracionAnalizarFrn);}
                // if(lineaActual == 2) {OracionAnalizarEsp = linea; lineaActual++; listaOraciones.add(OracionAnalizarEsp);}
            }
            scan.close();
            OracionAnalizarIng = listaOraciones.get(0);
            OracionAnalizarFrn = listaOraciones.get(1);
            OracionAnalizarEsp = listaOraciones.get(2);

        }
        catch (FileNotFoundException errorArchivoNoEncontrado) {
            System.out.println("\nEl archivo de texto oraciones.txt no ha sido encontrado.\n");
        }

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
            scan.close();

        }
        catch (FileNotFoundException errorArchivoNoEncontrado) {
            System.out.println("\nEl archivo de texto diccionario.txt no ha sido encontrado.\n");
        }

        
        String oracionATraducir;
        String idiomasATraducir;
        String idiomaOriginal;

        while(true){

            Scanner sc = new Scanner(System.in);
            System.out.println("\nPorfavor elija la oracion que desea traducir: \n");
            for(int i = 0; i < listaOraciones.size(); i++){
                System.out.println((i+1) + " > " + listaOraciones.get(i));
            }
            System.out.print("No. ");
            String respuesta = sc.nextLine();
            if(respuesta.equals("1")){
                idiomaOriginal = "English";
                oracionATraducir = listaOraciones.get(0).replace("^\"|\"$", "");
                break;
            }
            else if(respuesta.equals("2")){
                idiomaOriginal = "French";
                oracionATraducir = listaOraciones.get(1).replace("^\"|\"$", "");
                break;
            }
            else if(respuesta.equals("3")){
                idiomaOriginal = "Spanish";
                oracionATraducir = listaOraciones.get(2).replace("^\"|\"$", "");
                break;
            }
            else{
                System.out.println("Respuesta incorrecta...");
            }
        }

        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("\nPorfavor elija a que idioma desea traducir: \n");
            System.out.println("1 Ingles");
            System.out.println("2 Espanol");
            System.out.println("3 Frances");
            System.out.print("No. ");
            String respuesta = scan.nextLine();
            if(respuesta.equals("1")){
                idiomasATraducir = "English";
                scan.close();
                break;
            }
            else if(respuesta.equals("2")){
                idiomasATraducir = "Spanish";
                scan.close();
                break;
            }
            else if(respuesta.equals("3")){
                idiomasATraducir = "French";
                scan.close();
                break;
            }
            else{
                System.out.println("Respuesta incorrecta...");
            }
        }


        String   idiomaOriginalABuscar = idiomaOriginal;

        String   traducirAIdimoa = idiomasATraducir;

        String   oracionResultante = "";

        String[] oracionSeparada = oracionATraducir.toLowerCase().split(" ");

        System.out.println("\n\nSe desea traducir al idioma: " + traducirAIdimoa + "\n\n");


        System.out.println("Oracion traducida:");
        for (String str : oracionSeparada){

            Nodo nodoLocalizado = arbol.localizarNodo(str, idiomaOriginalABuscar);

            if(nodoLocalizado != null){

                oracionResultante += nodoLocalizado.getValor().getValue().get(0).get(idiomasATraducir);
            }
            else{
                oracionResultante += " *" + str + "* ";
            }

        }
        System.out.println(oracionResultante);

        System.out.println("\nDiccionario InOrder:\n");

        Nodo nodoRaiz = arbol.getRaiz();

        while(nodoRaiz.getNodoIzquierda() != null){
            System.out.println(nodoRaiz.getValor().getValue().get(0));
            nodoRaiz = nodoRaiz.getNodoIzquierda();
        }
        
    }
}