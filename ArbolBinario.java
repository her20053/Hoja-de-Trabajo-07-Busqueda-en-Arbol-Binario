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

    public Nodo localizarNodo(String palabra){

        Nodo temporal = this.raiz;

        while(temporal.getLlave() != palabra){

            temporal = temporal.getNodoIzquierda();
            if(temporal == null){

                return null;

            }

        }
        return temporal;


    }

}
