import java.util.ArrayList;
import java.util.HashMap;

public class ArbolBinario {

    private Nodo raiz;

    public ArbolBinario(){

        raiz = null;

    }

    public Nodo getRaiz(){

        return this.raiz;

    }

    public void insertarNodo(String llave, Association<String,ArrayList<HashMap<String,String>>> valor){

        Nodo nuevoNodo = new Nodo(llave,valor);

        if(this.raiz == null){

            raiz = nuevoNodo;

        }

        else{

            Nodo NodoAuxiliar = this.raiz;

            Nodo padre;

            while(true){

                padre = NodoAuxiliar;

                NodoAuxiliar = NodoAuxiliar.getNodoIzquierda();

                if(NodoAuxiliar == null){

                    padre.setNodoIzquierda(nuevoNodo);
                    return;
    
                }

            }

        }

    }

    public boolean esVacio(){

        return this.raiz == null;

    }

    public Nodo localizarNodo(String palabra, String idiomaOriginal){

        Nodo temporal = this.raiz;

        // System.out.println(palabra + " " + idiomaNuevo + " " + idiomaOriginal);

        //System.out.println(temporal.getValor().getValue().get(0).get(idiomaOriginal).equals(palabra));

        // System.out.println(temporal.getValor().getValue().get(0).get("English") + " " + palabra);

        // //System.out.println(temporal.getValor().getValue().get(0).get(idioma));

        while(!temporal.getValor().getValue().get(0).get(idiomaOriginal).equals(palabra)){
        
            temporal = temporal.getNodoIzquierda();
            if(temporal == null){
                return null;
            }

        }
        return temporal;
        //     //System.out.println(temporal.getLlave() + " " + palabra);
        //     temporal = temporal.getNodoIzquierda();
        //     if(temporal == null){

        //         return null;

        //     }

        // }
        // return temporal;
        //return null;


    }

}
