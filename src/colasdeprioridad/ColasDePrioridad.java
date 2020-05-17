
package colasdeprioridad;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ColasDePrioridad extends JFrame implements ActionListener {

    JButton botonMejor = new JButton("Calcular mejor caso");
    JButton botonMedio = new JButton("Calcular caso medio");
    JButton botonPeor = new JButton("Calcular peor caso");
    JButton botonIngreso = new JButton("Ingresar tamaño");
    JButton botonGraficar = new JButton("Graficar operaciones elementales ( cola de tamaño 20 - 500 )");
    
    JLabel jLNumero = new JLabel("Ingrese el tamaño de la cola");
    JLabel jLContador = new JLabel("Operaciones Elementales por contador: ");
    JLabel jL1 = new JLabel("Colas de prioridad");
    
    JLabel maximo = new JLabel("43.000");
    JLabel y1 = new JLabel("35.835");
    JLabel y2 = new JLabel("28.668");
    JLabel y3 = new JLabel("21.501");
    JLabel y4 = new JLabel("14.334");
    JLabel y5 = new JLabel("7.167");
    JLabel y6 = new JLabel("0");
    
    JLabel x1 = new JLabel("500");
    JLabel x2 = new JLabel("450");
    JLabel x3 = new JLabel("400");
    JLabel x4 = new JLabel("350");
    JLabel x5 = new JLabel("300");
    JLabel x6 = new JLabel("250");
    JLabel x7 = new JLabel("200");
    JLabel x8 = new JLabel("150");
    JLabel x9 = new JLabel("100");
    JLabel x10 = new JLabel("50");
    JLabel x11 = new JLabel("20");
    
    JTextField cCola = new JTextField();
    JTextField tamaño = new JTextField("100");
    int largo = 100;
    ColaPrioridad cola = null;
    String situacion;
    
    public static void main(String[] args) {
        
        ColasDePrioridad c = new ColasDePrioridad();
        c.setSize(1200, 750);
        c.setTitle("Colas de Prioridad por contador");
        c.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        c.setVisible(true);
        
    }

    ColasDePrioridad(){
        
        Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        c.add(botonMejor);
        c.add(botonMedio);
        c.add(botonPeor);
        c.add(botonIngreso);
        c.add(botonGraficar);
        
        c.add(jLNumero);
        c.add(jLContador);
        c.add(jL1);
        
        c.add(maximo);
        
        c.add(y1);
        c.add(y2);
        c.add(y3);
        c.add(y4);
        c.add(y5);
        c.add(y6);
        
        c.add(x1);
        c.add(x2);
        c.add(x3);
        c.add(x4);
        c.add(x5);
        c.add(x6);
        c.add(x7);
        c.add(x8);
        c.add(x9);
        c.add(x10);
        c.add(x11);
        
        c.add(cCola);
        c.add(tamaño);
        
        jLNumero.setBounds(200, 50, 200, 20);
        jLContador.setBounds(400, 100, 250, 20);
        
        cCola.setBounds(635, 100, 100, 20);
        tamaño.setBounds(250, 100, 50, 20);
        
        botonMejor.setBounds(750, 50, 200, 20);
        botonMejor.setBackground(Color.green);
        botonMejor.addActionListener(this);
        botonMedio.setBounds(750, 100, 200, 20);
        botonMedio.setBackground(Color.yellow);
        botonMedio.addActionListener(this);
        botonPeor.setBounds(750, 150, 200, 20);
        botonPeor.setBackground(Color.red);
        botonPeor.addActionListener(this);
        botonIngreso.setBounds(200, 150, 160, 20);
        botonIngreso.setBackground(Color.cyan);
        botonIngreso.addActionListener(this);
        botonGraficar.setBounds(200, 180, 750, 20);
        botonGraficar.addActionListener(this);
        botonGraficar.setBackground(Color.ORANGE);
        
    }
    
    public void pintar(String sit){
        
        Graphics g = getGraphics();
        
        g.drawLine(100, 240, 100, 650);
        g.drawLine(100, 240, 98, 245);
        g.drawLine(100, 240, 102, 245);
        
        maximo.setBounds(30, 215, 60, 10);
        y1.setBounds(30, 281, 60, 10);
        y2.setBounds(30, 347, 60, 10);
        y3.setBounds(40, 413, 50, 10);
        y4.setBounds(40, 479, 50, 10);
        y5.setBounds(40, 545, 50, 10);
        y6.setBounds(80, 615, 10, 10);
        
        g.drawLine(100, 650, 1150, 650);
        g.drawLine(1145, 648, 1150, 650);
        g.drawLine(1145, 652, 1150, 650);
        
        x1.setBounds(1085, 630, 40, 10);
        x2.setBounds(985, 630, 40, 10);
        x3.setBounds(885, 630, 40, 10);
        x4.setBounds(785, 630, 40, 10);
        x5.setBounds(685, 630, 40, 10);
        x6.setBounds(585, 630, 40, 10);
        x7.setBounds(485, 630, 40, 10);
        x8.setBounds(385, 630, 40, 10);
        x9.setBounds(285, 630, 40, 10);
        x10.setBounds(185, 630, 40, 10);
        x11.setBounds(125, 630, 40, 10);
        
        jL1.setBounds(520, 660, 200, 15);
        g.setColor(Color.red);
        g.drawLine(500, 700, 510, 700);
        
        int espacio = 0;
        int ejeY, ejeY2, ejeY3, contador;
        int anteriorY = 650;
            
        while(espacio <= 500){
        
            largo = espacio;
            
            cola = new ColaPrioridad();
            
            if(sit.equals("mejor")){
        
                llenarMejorCaso();

            } else if (sit.equals("medio")){

                llenarCasoMedio();
                
            } else {

                llenarPeorCaso();
                
            }
            
            contador = cola.getOperaciones();
            
            ejeY = (int) (650 - 400*(contador/(43000.0)));
            
            g.setColor(Color.red);
            g.drawLine(100+(espacio*2), ejeY, 100+((espacio-1)*2), anteriorY);
            
            
            espacio = espacio + 1; 
            
            anteriorY=ejeY;
        
        }
        
        largo = Integer.parseInt(tamaño.getText());
        
    }
    
    void llenarMejorCaso(){
        
        int numero = largo;
        
        for(int i=0; i<largo;i++){
            
            cola.crearP(numero);
            numero--;
            
        }
        
    }
    
    void llenarCasoMedio(){
        
        for(int i=0; i<largo;i++){
            
            int numero = (int)(Math.random()*1000);
            
            cola.crearP(numero);
            
        }
        
    }
    
    void llenarPeorCaso(){
        
        for(int i=0; i<largo;i++){
            
            cola.crearP(i);
            
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    if(e.getSource() == botonIngreso){
        
        cola = new ColaPrioridad();
        largo = Integer.parseInt(tamaño.getText());
        
    } else if (e.getSource() == botonMejor && cola != null){
        
        cola = new ColaPrioridad();
        llenarMejorCaso();
        cCola.setText(Integer.toString(cola.getOperaciones()));
        botonGraficar.setText("Graficar mejor caso ( cola de tamaño 20 - 500 )");
        situacion = "mejor";
        
    } else if (e.getSource() == botonMedio && cola != null) {
    
        cola = new ColaPrioridad();
        llenarCasoMedio();
        cCola.setText(Integer.toString(cola.getOperaciones()));
        botonGraficar.setText("Graficar caso medio ( cola de tamaño 20 - 500 )");
        situacion = "medio";
        
    } else if (e.getSource() == botonPeor && cola != null){
    
        cola = new ColaPrioridad();
        llenarPeorCaso();
        cCola.setText(Integer.toString(cola.getOperaciones()));
        botonGraficar.setText("Graficar peor caso ( cola de tamaño 20 - 500 )");
        situacion = "peor";
        
    } else if (e.getSource() == botonGraficar && situacion!=null){
        
        Graphics g = getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(102, 250, 1200, 400);
        pintar(situacion);
        
    }
        
    }
    
}
