
package colasdeprioridad;

public class ColaPrioridad {
        
    private Arbol m;
    private int operaciones;
    
    ColaPrioridad(){
        
        m = new Arbol();
        
    }
    
    void crearP(int dato){
        
        int i, j;
        
        m.cont++;
        
        i = m.cont;
        j = i/2;
        
        operaciones = operaciones + 6;
        
        while(m.a[j] < dato){
        
            m.a[i] = m.a[j];
            i = j;
            j = i/2;
            
            operaciones = operaciones + 11;
            
        }
    
        m.a[i] = dato;
        
        operaciones = operaciones + 3;
        
    }
    
    public int retirarP(){
        
        int i, j, temp, elemento;
        
        elemento = m.a[1];     
        temp = m.a[m.cont];
        m.cont = m.cont - 1;
        
        i = 1;
        j = 2;
        
        while(j <= m.cont){
        
            if(j < m.cont){
            
                if(m.a[j] < m.a[j+1]){
                
                    j++;
                    
                }
                
            }
            
            if(temp >= m.a[j]){
                
                break;
                
            }
            
            m.a[i] = m.a[j];
            i = j;
            j = 2*i;
            
        }
        
        m.a[i] = temp;
        
        return elemento;
        
    }

    public int getOperaciones() {
        return operaciones;
    }

    public Arbol getM() {
        return m;
    }
    
}
