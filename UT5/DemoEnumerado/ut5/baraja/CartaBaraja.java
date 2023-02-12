package ut5.baraja;

/**
 * clase CartaBaraja  
 * 
 *  
 */
public class CartaBaraja
{
  
    private  Palo palo;
    private Valor valor;

    /**
     * Constructor
     * Crea una carta con el valor y Palo indicados
     */
    public CartaBaraja(Valor valor, Palo palo)
    {
         this.palo = palo;
         this.valor = valor;
    }

    /**
     * Crea una carta de valor y palo aleatorios
     */
    public CartaBaraja(){
        this.palo = Palo.getAleatorio();
        this.valor = Valor.getAleatorio();
    }

    /**
     *  Accesor para el palo
     */
    public Palo getPalo()
    {
         return palo;
    }
    
    /**
     *  Accesor para el valor
     */
    public Valor getValor()
    {
          return valor;
    }
    
    /**
     *  Representación textual de la carta
     * 
     */
    public String toString()
    {
        return valor.toString() + " de " +  palo.toString();
    }


}