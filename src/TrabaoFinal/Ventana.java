package TrabaoFinal;
import java.awt.*;
import javax.swing.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.*;


public class Ventana extends JFrame implements Runnable{
    public JPanel panel;


    public Ventana(){

        setSize (500, 500);//Establecemos el tamaño de la ventana
        //setLocation (100, 200) //Establecemos la posicion inicial de la ventana
        setLocationRelativeTo(null);//Aparece ventana centro
        setTitle("Pruebas"); //Establecemos el título de la ventana
        //setBounds (100, 200, 500, 500); //establecemos posicion,tamaño


        //setResizable(false); //Estabclecer si la ventana puede cambiar o no
        setMinimumSize (new Dimension (25, 25));//Tamaño minimo ventana
        //this.getContentPane().setBackground(Color.BLUE); // Establecer color
        run();
        setVisible(true);
        setDefaultCloseOperation (EXIT_ON_CLOSE);

        // Asegúrate de que el foco esté en la ventana para capturar eventos de teclado
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        Thread hilo = new Thread(this);
        hilo.start();

    }

    @Override
    public void run(){

        colocarPanel();
        colocarEtiquetaTxt();
        colocarEtiquetaFoto();
        colocarBotones();
        //colocarRadioBoton();

    }


    private void colocarPanel(){
        panel = new JPanel(); //crear panel
        panel.setLayout(null); //desactivar diseño
        this.getContentPane().add(panel); //añadir panel a la ventana

        //panel.setBackground(Color.WHITE);
    }
    private void colocarBotones(){
        /*JButton boton = new JButton();
        boton.setBounds(120, 400, 300, 40);
        panel.add(boton);
        boton.setEnabled(true);// poder interaccionar o no
        boton.setText("Pulsa para salir!!!"); //texto a boton
        boton.setMnemonic('a'); // Alt + letra = boton funciona
        boton.setForeground(Color.BLUE);
        boton.setBackground(Color.PINK);
        boton.setFont(new Font("arial", 3, 15));
        boton.addActionListener(new MessageListener());*/

        JButton botonfoto2 = new JButton("Boton cambio");
        botonfoto2.setBounds(200, 150, 120, 70);
        ImageIcon cliaqui5 = new ImageIcon("avionrapido.jpg");
        botonfoto2.setIcon(new ImageIcon(cliaqui5.getImage().getScaledInstance(botonfoto2.getWidth(), botonfoto2.getHeight(), Image.SCALE_SMOOTH)));



        botonfoto2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Oculta la ventana principal
                VentanaModernPlane ventanaSecundaria2 = new VentanaModernPlane();
                ventanaSecundaria2.setVisible(true);  // Muestra la ventana secundaria
            }
        });
        panel.add(botonfoto2);

        //boton foto
        JButton botonfoto = new JButton();
        botonfoto.setBounds(50,150,120,70);
        ImageIcon cliaqui = new ImageIcon("avionormal2.jpg");
        botonfoto.setIcon(new ImageIcon(cliaqui.getImage().getScaledInstance(botonfoto.getWidth(),botonfoto.getHeight(),Image.SCALE_SMOOTH)));
        //botonfoto.setBackground(Color.GREEN);

        botonfoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Oculta la ventana principal
                VentanaNormalPlane ventanaSecundaria = new VentanaNormalPlane();
                ventanaSecundaria.setVisible(true);  // Muestra la ventana secundaria
            }
        });
        panel.add(botonfoto);

       /* JButton botonfoto2 = new JButton();
        botonfoto2.setBounds(200, 150, 120, 70);
        ImageIcon cliaqui2 = new ImageIcon("avionrapido.jpg");
        botonfoto2.setIcon(new ImageIcon(cliaqui2.getImage().getScaledInstance(botonfoto2.getWidth(), botonfoto2.getHeight(), Image.SCALE_SMOOTH)));
        //botonfoto2.setBackground(Color.GREEN);
        botonfoto2.setEnabled(true);
        panel.add(botonfoto2);*/



        //botonfoto2.addActionListener(new MessageListener2());

        JButton botonfoto3 = new JButton();
        botonfoto3.setBounds(350, 150, 120, 70);
        ImageIcon cliaqui3 = new ImageIcon("avioncaza.png");
        botonfoto3.setIcon(new ImageIcon(cliaqui3.getImage().getScaledInstance(botonfoto3.getWidth(), botonfoto3.getHeight(), Image.SCALE_SMOOTH)));
        //botonfoto2.setBackground(Color.GREEN);

        botonfoto3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Oculta la ventana principal
                VentanaUltraPlane ventanaSecundaria3 = new VentanaUltraPlane();
                ventanaSecundaria3.setVisible(true);  // Muestra la ventana secundaria
            }
        });
        panel.add(botonfoto3);




        JButton botonfoto4 = new JButton();
        botonfoto4.setBounds(380, 380, 75, 50);
        ImageIcon cliaqui4 = new ImageIcon("exit.jpg");
        botonfoto4.setIcon(new ImageIcon(cliaqui4.getImage().getScaledInstance(botonfoto4.getWidth(), botonfoto4.getHeight(), Image.SCALE_SMOOTH)));
        //botonfoto4.setBackground(Color.GREEN);
        panel.add(botonfoto4);
        botonfoto4.addActionListener(new MessageListener4());



        JButton botonfoto5 = new JButton();
        botonfoto5.setBounds(200, 275, 120, 70);
        ImageIcon cliaqui6 = new ImageIcon("game.png");
        botonfoto5.setIcon(new ImageIcon(cliaqui6.getImage().getScaledInstance(botonfoto5.getWidth(), botonfoto5.getHeight(), Image.SCALE_SMOOTH)));
        //botonfoto5.setBackground(Color.GREEN);

        botonfoto5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);  // Oculta la ventana principal
                SwingUtilities.invokeLater(() -> new VentanaJuego());
                //ventanaSecundaria4.setVisible(true);  // Muestra la ventana secundaria
            }
        });
        panel.add(botonfoto5);



        botonfoto4.setEnabled(true);
        botonfoto3.setEnabled(true);
        botonfoto.setEnabled(true);
        botonfoto2.setEnabled(true);
        botonfoto5.setEnabled(true);
    }
    private void colocarEtiquetaFoto() {
        JLabel etiqueta2 = new JLabel(new ImageIcon("cielo.jpg"));//añadir img
        //ImageIcon imagen = new ImageIcon("cielo.jpg");//añadir img
        //etiqueta2.setIcon(imagen); //añadir img
        etiqueta2.setBounds(0, -80, 520, 620); //tamaño,pos
        //etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));// ajustar imagen a etiqueta
        panel.add(etiqueta2);//añadirla panel
    }
    private void colocarEtiquetaTxt() {
        //ETIQUETA TIPO TEXTO
        JLabel etiqueta = new JLabel("", SwingConstants.CENTER); //crear etiqueta,texto centrado
        etiqueta.setText("Selecciona tipo de avion");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //centrar texto
        //etiqueta.setOpaque(true); //permite cambiar color fondo, por defecto false
        panel.add(etiqueta); //agregamos etiq a panel
        etiqueta.setBounds(85, 10, 300, 80);  //posicion y tamaño
        //etiqueta.setForeground(Color.BLUE); // color letra
        //etiqueta.setBackground(Color.WHITE); // color fondo
        //etiqueta.setFont(new Font("arial",3,20));
        etiqueta.setFont(new Font("Keraleeyam", 0, 20));
    }

    private void colocarRadioBoton(){
        JRadioButton radioboton1 = new JRadioButton("Opcion 1",true);
        radioboton1.setBounds(50,100,100,50);
        panel.add(radioboton1);
        radioboton1.setEnabled(true); //permitir/no permitir marcar este boton
        radioboton1.setText("Juego");
        radioboton1.setFont(new Font("arial",3,20));

        JRadioButton radioboton2 = new JRadioButton("Opcion 2",false);
        radioboton2.setBounds(50,150,100,50);
        panel.add(radioboton2);

        JRadioButton radioboton3 = new JRadioButton("Opcion 3",false);
        radioboton3.setBounds(50,200,100,50);
        panel.add(radioboton3);

        ButtonGroup gruporadiobotones = new ButtonGroup();
        gruporadiobotones.add(radioboton1);
        gruporadiobotones.add(radioboton2);
        gruporadiobotones.add(radioboton3);





    }



}
