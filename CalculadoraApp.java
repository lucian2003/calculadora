package calculadora_package;

//Programa Java de una calculadora

import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 

class CalculadoraApp extends JFrame implements ActionListener { 
 // creamos la ventana principal
 static JFrame VentanaPrincipal; 

 // campo de tipo textfield 
 static JTextField texto; 

 // VARIABLES PARA GUARDAR LOS VALORES INTRODUCIDOS
 String s0, s1, s2; 

 // constructor 
 CalculadoraApp() 
 { 
     s0 = s1 = s2 = ""; 
 } 

 
 public static void main(String args[]) 
 { 
     // create a frame 
	 VentanaPrincipal = new JFrame("CALCULADORA"); 

     try { 
         // LookAndFeel para utilizar comportamiento nativo en nuestra plataforma (windows)
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
     } 
     catch (Exception e) { 
         System.err.println(e.getMessage()); 
     } 

     // creamos una instancia de la clase
     CalculadoraApp c = new CalculadoraApp(); 

     // creamos un campo textfield
     texto = new JTextField(16); 

     // textfield no editable
     texto.setEditable(false); 

     // creamos los botones
     JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1; 

     b0 = new JButton("0"); 
     b1 = new JButton("1"); 
     b2 = new JButton("2"); 
     b3 = new JButton("3"); 
     b4 = new JButton("4"); 
     b5 = new JButton("5"); 
     b6 = new JButton("6"); 
     b7 = new JButton("7"); 
     b8 = new JButton("8"); 
     b9 = new JButton("9"); 

 
     beq1 = new JButton("="); 


     ba = new JButton("+"); 
     bs = new JButton("-"); 
     bd = new JButton("/"); 
     bm = new JButton("*");
     beq = new JButton("C"); 

     be = new JButton("."); 

     // creamos la ventana 
     JPanel p = new JPanel(); 

     // añadimos action listeners 
     bm.addActionListener(c); 
     bd.addActionListener(c); 
     bs.addActionListener(c); 
     ba.addActionListener(c); 
     b9.addActionListener(c); 
     b8.addActionListener(c); 
     b7.addActionListener(c); 
     b6.addActionListener(c); 
     b5.addActionListener(c); 
     b4.addActionListener(c); 
     b3.addActionListener(c); 
     b2.addActionListener(c); 
     b1.addActionListener(c); 
     b0.addActionListener(c); 
     be.addActionListener(c); 
     beq.addActionListener(c); 
     beq1.addActionListener(c); 

     VentanaPrincipal.add(p); 

     // marcamos el tamaño de la ventana
     VentanaPrincipal.setSize(230, 210); 
     
     // ponemos en principio la venta vacia
     VentanaPrincipal.getContentPane().setLayout(null);
     
     
     //insertamos cada componente en las ubicacion deseada de la ventana
     ba.setBounds(10, 10, 40, 23);
     b1.setBounds(60, 10, 40, 23);
     b2.setBounds(110, 10, 40, 23);
     b3.setBounds(160, 10, 40, 23);
     bs.setBounds(10, 40, 40, 23);
     b4.setBounds(60, 40, 40, 23);
     b5.setBounds(110, 40, 40, 23);
     b6.setBounds(160, 40, 40, 23);
     bm.setBounds(10, 70, 40, 23);
     b7.setBounds(60, 70, 40, 23);
     b8.setBounds(110, 70, 40, 23);
     b9.setBounds(160, 70, 40, 23);
     bd.setBounds(10, 100, 40, 23);
     be.setBounds(60, 100, 40, 23);
     b0.setBounds(110, 100, 40, 23);
     beq.setBounds(160, 100, 40, 23);
     beq1.setBounds(10, 130, 40, 23);
     texto.setBounds(60, 130, 140, 23);
     
     // añadimos los componentes a la ventana
     VentanaPrincipal.getContentPane().add(ba);
     VentanaPrincipal.getContentPane().add(b1); 
     VentanaPrincipal.getContentPane().add(b2);
     VentanaPrincipal.getContentPane().add(b3);
     VentanaPrincipal.getContentPane().add(bs);
     VentanaPrincipal.getContentPane().add(b4);
     VentanaPrincipal.getContentPane().add(b5);
     VentanaPrincipal.getContentPane().add(b6);
     VentanaPrincipal.getContentPane().add(bm);
     VentanaPrincipal.getContentPane().add(b7);
     VentanaPrincipal.getContentPane().add(b8);
     VentanaPrincipal.getContentPane().add(b9);
     VentanaPrincipal.getContentPane().add(bd);
     VentanaPrincipal.getContentPane().add(be);
     VentanaPrincipal.getContentPane().add(b0);
     VentanaPrincipal.getContentPane().add(beq);

     VentanaPrincipal.getContentPane().add(beq1);
     VentanaPrincipal.getContentPane().add(texto);

     VentanaPrincipal.setVisible(true);
     //VentanaPrincipal.show(); 
 } 
 public void actionPerformed(ActionEvent e) 
 { 
     String s = e.getActionCommand(); 

     // SI el valor es un numero
     if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') { 
         // SI solo se ha introducido el primer numero 
         if (!s1.equals("")) 
             s2 = s2 + s; 
         else
             s0 = s0 + s; 

         texto.setText(s0 + s1 + s2); 
     } 
     else if (s.charAt(0) == 'C') { 
         // eliminamos los datos introducidos
         s0 = s1 = s2 = ""; 

         texto.setText(s0 + s1 + s2); 
     } 
     else if (s.charAt(0) == '=') { 

         double te; 

         
         if (s1.equals("+")) 
             te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
         else if (s1.equals("-")) 
             te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
         else if (s1.equals("/")) 
             te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
         else
             te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 

         
         texto.setText(s0 + s1 + s2 + "=" + te); 

         
         s0 = Double.toString(te); 

         s1 = s2 = ""; 
     } 
     else { 
         // SI no hay datos introducidos
         if (s1.equals("") || s2.equals("")) 
             s1 = s; 
         
         else { 
             double te; 

             
             if (s1.equals("+")) 
                 te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
             else if (s1.equals("-")) 
                 te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
             else if (s1.equals("/")) 
                 te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
             else
                 te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 

             
             s0 = Double.toString(te); 

            
             s1 = s; 

           
             s2 = ""; 
         } 

       
         texto.setText(s0 + s1 + s2); 
     } 
 } 
}