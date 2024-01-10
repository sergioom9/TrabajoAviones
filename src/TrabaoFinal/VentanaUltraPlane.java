package TrabaoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaUltraPlane extends JFrame implements Runnable {
    VentanaUltraPlane(){
        setSize (500, 500);//Establecemos el tamaño de la ventana
        //setLocation (100, 200) //Establecemos la posicion inicial de la ventana
        setLocationRelativeTo(null);//Aparece ventana centro
        setTitle("AvionModerno"); //Establecemos el título de la ventana
        //setBounds (100, 200, 500, 500); //establecemos posicion,tamaño


        //setResizable(false); //Estabclecer si la ventana puede cambiar o no
        setMinimumSize (new Dimension(25, 25));//Tamaño minimo ventana
        //this.getContentPane().setBackground(Color.BLUE); // Establecer color

        run();
        setVisible(true);
        setDefaultCloseOperation (EXIT_ON_CLOSE);

    }

    @Override
    public void run(){

        colocarPanel();
        colocarEtiquetaTxt();
        colocarEtiquetaFoto();
        colocarBotones();
        //colocarRadioBoton();
    }
    public JPanel panel;
    private void colocarPanel(){
        panel = new JPanel(); //crear panel
        panel.setLayout(null); //desactivar diseño
        this.getContentPane().add(panel); //añadir panel a la ventana
        //panel.setBackground(Color.WHITE);
    }
    private void colocarBotones(){

        JButton botonfoto2 = new JButton();
        botonfoto2.setBounds(160, 200, 220, 140);
        ImageIcon cliaqui2 = new ImageIcon("imagenventanaavultra.jpg");
        botonfoto2.setIcon(new ImageIcon(cliaqui2.getImage().getScaledInstance(botonfoto2.getWidth(), botonfoto2.getHeight(), Image.SCALE_SMOOTH)));
        //botonfoto2.setBackground(Color.GREEN);
        botonfoto2.setEnabled(true);
        panel.add(botonfoto2);


        JButton botonfoto4 = new JButton();
        botonfoto4.setBounds(380, 380, 75, 50);
        ImageIcon cliaqui4 = new ImageIcon("exit.jpg");
        botonfoto4.setIcon(new ImageIcon(cliaqui4.getImage().getScaledInstance(botonfoto4.getWidth(), botonfoto4.getHeight(), Image.SCALE_SMOOTH)));
        //botonfoto4.setBackground(Color.GREEN);
        botonfoto4.setEnabled(true);
        panel.add(botonfoto4);
        botonfoto4.addActionListener(new MessageListener4());

        JButton botonfoto5 = new JButton();
        botonfoto5.setBounds(30, 380, 75, 50);
        ImageIcon cliaqui5 = new ImageIcon("back.png");
        botonfoto5.setIcon(new ImageIcon(cliaqui5.getImage().getScaledInstance(botonfoto5.getWidth(), botonfoto5.getHeight(), Image.SCALE_SMOOTH)));
        //botonfoto5.setBackground(Color.GREEN);
        botonfoto5.setEnabled(true);
        botonfoto5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Oculta la ventana principal
                Ventana ventananormal = new Ventana();
                ventananormal.setVisible(true);  // Muestra la ventana secundaria
            }
        });
        panel.add(botonfoto5);
    }
    private void colocarEtiquetaFoto() {
        JLabel etiqueta2 = new JLabel(new ImageIcon("galaxia.jpg"));//añadir img
        ImageIcon imagen = new ImageIcon("galaxia.jpg");//añadir img
        etiqueta2.setIcon(imagen); //añadir img
        etiqueta2.setBounds(0, -80, 500, 600); //tamaño,pos
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));// ajustar imagen a etiqueta
        panel.add(etiqueta2);//añadirla panel



    }
    private void colocarEtiquetaTxt() {
        //ETIQUETA TIPO TEXTO
        JLabel etiqueta = new JLabel("", SwingConstants.CENTER); //crear etiqueta,texto centrado
        etiqueta.setText("ESTE ES EL AVION ULTRA");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //centrar texto
        //etiqueta.setOpaque(true); //permite cambiar color fondo, por defecto false
        panel.add(etiqueta); //agregamos etiq a panel
        etiqueta.setBounds(35, 10, 450, 80);  //posicion y tamaño
        etiqueta.setForeground(Color.WHITE); // color letra
        //etiqueta.setBackground(Color.WHITE); // color fondo
        //etiqueta.setFont(new Font("arial",3,20));
        etiqueta.setFont(new Font("Keraleeyam", 0, 30));



        JLabel etiqueta2 = new JLabel("", SwingConstants.CENTER); //crear etiqueta,texto centrado
        etiqueta2.setText("Nos encontramos ante un avion ultra el cual puede ");
        etiqueta2.setHorizontalAlignment(SwingConstants.CENTER); //centrar texto
        //etiqueta2.setOpaque(true); //permite cambiar color fondo, por defecto false
        panel.add(etiqueta2); //agregamos etiq a panel
        etiqueta2.setBounds(35, 0, 450, 200);  //posicion y tamaño
        etiqueta2.setForeground(Color.WHITE); // color letra
        //etiqueta2.setBackground(Color.WHITE); // color fondo
        etiqueta2.setFont(new Font("arial",0,15));



        JLabel etiqueta3 = new JLabel("", SwingConstants.CENTER); //crear etiqueta,texto centrado
        etiqueta3.setText("volar a maxima velocidad pero con 2 pasajeros ");
        etiqueta3.setHorizontalAlignment(SwingConstants.CENTER); //centrar texto
        //etiqueta3.setOpaque(true); //permite cambiar color fondo, por defecto false
        panel.add(etiqueta3); //agregamos etiq a panel
        etiqueta3.setBounds(35, 25, 450, 200);  //posicion y tamaño
        etiqueta3.setForeground(Color.WHITE); // color letra
        //etiqueta3.setBackground(Color.WHITE); // color fondo
        etiqueta3.setFont(new Font("Arial", 0, 15));

        JLabel etiqueta4 = new JLabel("", SwingConstants.CENTER); //crear etiqueta,texto centrado
        etiqueta4.setText("aparte de eso tiene capacidad de disparo y rastreo");
        etiqueta4.setHorizontalAlignment(SwingConstants.CENTER); //centrar texto
        //etiqueta4.setOpaque(true); //permite cambiar color fondo, por defecto false
        panel.add(etiqueta4); //agregamos etiq a panel
        etiqueta4.setBounds(35, 50, 450, 200);  //posicion y tamaño
        etiqueta4.setForeground(Color.WHITE); // color letra
        //etiqueta4.setBackground(Color.WHITE); // color fondo
        etiqueta4.setFont(new Font("Arial", 0, 15));


    }










}

