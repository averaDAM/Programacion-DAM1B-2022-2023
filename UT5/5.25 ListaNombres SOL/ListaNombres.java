
/**
 * La clase mantiene una lista de nombres
 * en orden l�xicogr�fico  
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
 

public class ListaNombres
{
        private String[]  lista;
        private int pos;

        /**
         * Constructor de la clase ListaNombres
         * n es el tama�o m�ximo de la lista
         */
        public ListaNombres(int n) 
        {              
              lista = new String[n];
              pos = 0;
        }

        /**
         * @return  true si la lista est� vac�a   
         */
        public boolean  listaVacia()
        {
                 return pos == 0;
            
        }
        
        /**
         * 
         * @return  true si la lista est� llena   
         */
        public boolean  listaLlena()
        {
                return pos == lista.length;
            
        }
        
        /**
         * Inserta un nombre en la lista �nicamente
         * si no est� y la lista no est� llena. La inserci�n se hace de tal
         * manera que el nombre queda colocado en el 
         * lugar que le corresponde manteniendo el orden 
         * de la lista (no se utiliza ning�n algoritmo de ordenaci�n)
         * Importan may�sculas y min�sculas 
         * 
         * @param nombre el nombre a insertar
         * @return  true si la inserci�n se hace con �xito   
         *
         */
        public boolean insertarNombre(String nombre)
        {
              if(!listaLlena() && !estaNombre(nombre)){
                  insertarOrdenado(nombre);
                  return true;
              }
              else{
                  return false;
              }

            
        }

    /**
     * A�adido al proyecto de partida
     * Inserta ordenadamente el nombre en la lista.
     * Se asume que el nombre no est�, y que hay espacio
     */
    private void insertarOrdenado(String nombre) {
        //Algoritmo de inserci�n ordenada: diapositiva 94 a 98 de la Presentaci�n 1 UT5
        int i = pos-1;
        if(!listaVacia()){//Si no hacemos esto, rompe el compareTo del While a continuaci�n
            while(i>=0 && lista[i].compareTo(nombre)>0){
                //rotamos a la derecha
                lista[i+1] = lista[i];
                i--;
            }
        }
        //En este punto, ya tenemos la posici�n de inserci�n: i+1
        lista[i+1] = nombre;
        pos++;
    }

    /**
         *  Busca un nombre en la lista
         *  Puesto que la lista est� en todo momento ordenada
         *  se hace una b�squeda binaria
         *  @param  nombre el nombre a buscar
         *  @return   true si ya existe el nombre en la lista  
         *   
         */
        private boolean estaNombre(String nombre)
        {
            //La clase String permite usar binarySearch. Pero debemos evitar los null
            int posicion = Arrays.binarySearch(Arrays.copyOf(lista, pos), nombre);
            return (posicion  >= 0);
        }
        
        /**
         *  Busca y devuelve el nombre de mayor longitud
         *  en la lista. Si hay varios devuelve el
         *  primero encontrado
         *  Si la lista est� vac�a devuelve null
         *  
         *  @return   el nombre m�s largo  
         *  
         */
        public String nombreMasLargo()
        {
            //Recorremos el array almacenando la mayor longitud, y su palabra correspondiente
            int maxLongitud=0;
            String maxNombre=lista[0];
            for (int i = 0; i < pos; i++) {
                if(lista[i].length()>maxLongitud){
                    maxLongitud = lista[i].length();
                    maxNombre = lista[i];
                }
            }
            return maxNombre;
        }
        
        /**
         * Borra de la lista los nombres que empiezan por 
         * una letra determinada (s� importan may�sculas y min�sculas)
         * No es lo mismo borrarLetra('A') que borrarLetra('a')
         *
         * @param letra la letra por la que han de empezar los nombres 
         *    
         */
        public void borrarLetra(char letra)
        {
            //Borrado m�ltiple. Presentaci�n 1 UT5 diapositivas 54 a 56
            for (int i = pos; i >= 0 ; i--) { //Lo hago con for de derecha a izquierda
                if(lista[i].startsWith(String.valueOf(letra))){
                    borrarDePosicion(i);
                }
            }
        }
        
        /**
         * Borra un nombre de la posici�n indicada
         * 
         *
         * @param  p posici�n del nombre a borrar
         *  
         */
        private void borrarDePosicion(int p)
        {
            //Diapositivas 49 a 53
            System.arraycopy(lista, p+1, lista, p, pos - p - 1);
            pos --;
        }
         
       
        
        /**
         * Cuenta cu�ntos nombres empiezan por una determinada 
         * cadena sin importar   may�sculas o min�sculas
         *
         * @param  la cadena de comienzo
         * @return  la cantidad de nombres calculados   
         */
        public int empiezanPor(String inicio)
        {
            int cont = 0;
            inicio  = inicio.toUpperCase(); //Compararemos todo en may�sculas
            for (int i = 0; i < pos; i++) {
                if(lista[i].toUpperCase().startsWith(inicio)){
                    cont++;
                }
            }
            return cont;
        }
        
         /** 
         * 
         * Devuelve un array con los  nombres que empiezan por una determinada 
         * letra sin importar si es may�scula o min�scula
         * 
         * @param  la letra de comienzo
         * @return  la cantidad de nombres encontrados
         *          con esa letra   
         */ 
        public String[] empiezanPorLetra(char letra)
        {
            //Una alternativa al String.value para pasar de char u otro primitivo a String
            String letraMayus = (letra + "").toUpperCase();
            int cuantos = empiezanPor(letraMayus);
            String[] resultado = new String[cuantos];
            int cont = 0;
            for (int i = 0; i < pos; i++) {
                if(lista[i].toString().toUpperCase().startsWith(letraMayus)){
                    resultado[cont] = lista[i];
                    cont++;
                }
            }
            return resultado;
        }
        
       /**
         * Representaci�n textual de la cadena
         * 
         * @return la cadena resultante    
         */
        public String toString()
        {
            return Arrays.toString(Arrays.copyOf(lista, pos));
        }
        
          /**
         *  Mostrar la lista en pantalla 
         */
        public void printLista()
        {
                System.out.println(this.toString());
        }
        
          /**
         * Lee de un fichero de texto una serie 
         * de nombres con ayuda de un objeto de la 
         * clase Scanner y los almacena en la lista
         */
        public void cargarDeFichero() 
        {
			Scanner sc = null;
            try    {
                     sc = new Scanner(new File("nombres.txt"));
                     while (sc.hasNextLine() && !listaLlena()) {
						  insertarNombre(sc.nextLine());
					 }                          
                     
             }
             catch (IOException e)      {
                     e.printStackTrace();
             }
			 finally {
				 sc.close();
			 }
			 
        }
        
}
