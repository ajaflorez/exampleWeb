package primalidad;

public class Primalidad {
    private int valor;  // Encapsulamiento -> get y set
    
    
    public boolean esPrimo(int numero) {
        if(numero > 3) {
            if (numero % 2 != 0) {
                for(int i = 3; i <= numero / 3; i++) {
                    if(numero % i == 0)
                        return false;
                }
                return true;
            }
            else
                return false;
        }
        return true;
    }
    public int mcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        else {
            return mcd(b, a % b);
        }        
    }
    
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        if(valor > 0)
            this.valor = valor;
        else
            this.valor = 0;
    }
    public Primalidad(int valor) {
        this.valor = valor;
    }
}
