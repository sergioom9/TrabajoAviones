package TrabaoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class VentanaJuego extends JFrame implements ActionListener, KeyListener {
    public JPanel panel;
    private Image personaje, Fuego,fondoImagen;
    private List<Disparo> disparos = new ArrayList<>();
    private int personajeX = 200;
    private int personajeY = 500;


    private int nivel = 1;  // Nivel inicial
    private int tiempoCuentaRegresiva = 10;  // Tiempo inicial en segundos
    private Timer timerCuentaRegresiva;
    private int velocidadDisparos = 5;  // Velocidad inicial de los disparos



    private void aumentarNivel() {
        nivel++;
        velocidadDisparos += 2;  // Incrementa la velocidad de los disparos al pasar de nivel
    }
    public VentanaJuego() {
        // Configuración de la ventana
        setSize(500, 700);
        setLocationRelativeTo(null);
        setTitle("Juego");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Inicialización de imágenes
        ImageIcon icono = new ImageIcon("avionjugo.jpg");
        Image imagenPersonaje = icono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        personaje = new ImageIcon(imagenPersonaje).getImage();

        ImageIcon icono2 = new ImageIcon("fuego.png");
        Image imagenFuego = icono2.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        Fuego = new ImageIcon(imagenFuego).getImage();

        // Agregar escuchadores de eventos
        addKeyListener(this);
        crearPanel();
        fondoImagen = new ImageIcon("galaxia.jpg").getImage();

        // Ajustar posición inicial del avión
        personajeX = 50; // Ajusta según tu preferencia
        personajeY = 100; // Ajusta según tu preferencia


        // Configurar temporizadores
        Timer timer = new Timer(10, this);
        timer.start();

        Timer generadorDisparos = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarDisparoAleatorio();
            }
        });
        generadorDisparos.start();

        int intervaloCuentaRegresiva = 1000;  // 1 segundo
        timerCuentaRegresiva = new Timer(intervaloCuentaRegresiva, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCuentaRegresiva();
            }
        });
        timerCuentaRegresiva.start();

        // Hacer la ventana visible
        setVisible(true);
    }

    // Método para generar disparos aleatorios
    private void generarDisparoAleatorio() {
        Random rand = new Random();
        int x = rand.nextInt(panel.getWidth() - 20);
        int y = panel.getHeight();
        disparos.add(new Disparo(x, y, velocidadDisparos,nivel));  // Utiliza la velocidad actualizada
    }

    private void crearPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo = new ImageIcon("galaxia.jpg");
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);

                // Dibujar el avión en la posición actualizada
                g.drawImage(personaje, personajeX, personajeY, this);

                // Dibujar cuenta regresiva y nivel
                dibujarCuentaRegresiva(g);
                //dibujarNivel(g);

                // Dibujar los disparos
                dibujarDisparos(g);
                // Dibujar el nivel
                dibujarNivel(g);
            }
        };
        panel.setLayout(null);
        getContentPane().add(panel);
    }

    /*@Override
    public void paint(Graphics g) {
        super.paint(g);

        // Dibujar el avión en la posición actualizada
        g.drawImage(personaje, personajeX, personajeY, this);

        // Dibujar los disparos
        for (Disparo disparo : disparos) {
            g.drawImage(Fuego, disparo.getX(), disparo.getY(), this);
        }
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mover los disparos y verificar colisiones en cada actualización

        moverDisparos();
        verificarColisiones();

        // Repintar el panel
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && personajeX > 0) {
            personajeX -= 10;
        } else if (key == KeyEvent.VK_RIGHT && personajeX < getWidth() - 50) {
            personajeX += 10;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Lógica para tecla presionada
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && personajeX > 0) {
            personajeX -= 5;
        } else if (key == KeyEvent.VK_RIGHT && personajeX < getWidth() - 50) {
            personajeX += 5;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    //
    }

    // Método para mover los disparos
    private void moverDisparos() {
        Iterator<Disparo> iter = disparos.iterator();
        while (iter.hasNext()) {
            Disparo disparo = iter.next();
            disparo.mover();
            if (disparo.getY() < 0) {
                iter.remove();
            }
        }
    }

    // Método para verificar colisiones con el avión
    private void verificarColisiones() {
        Rectangle avionRect = new Rectangle(personajeX, personajeY, 50, 50);

        for (Disparo disparo : disparos) {
            Rectangle disparoRect = new Rectangle(disparo.getX(), disparo.getY(), 20, 20);
            if (avionRect.intersects(disparoRect)) {
                // Colisión detectada, realiza acciones adicionales si es necesario
                JOptionPane.showMessageDialog(this, "¡Has sido alcanzado por un disparo! Fin del juego.");
                aumentarNivel();
                System.exit(0);
            }
        }
    }
    private void actualizarCuentaRegresiva() {
        tiempoCuentaRegresiva--;

        // Si el tiempo llega a cero, pasar al siguiente nivel
        if (tiempoCuentaRegresiva <= 0) {
            nivel++;
            tiempoCuentaRegresiva = 10;  // Restablecer el tiempo para el siguiente nivel
            aumentarVelocidadDisparos();  // Método para aumentar la velocidad de los disparos
        }

        // Volver a pintar el panel para mostrar los cambios
        panel.repaint();
    }

    private void aumentarVelocidadDisparos() {
        // Lógica para aumentar la velocidad de los disparos en función del nivel actual
        // Puedes ajustar la lógica según tus preferencias
        int nuevaVelocidad = nivel * 2;  // Ejemplo: velocidad = nivel * 2
        for (Disparo disparo : disparos) {
            disparo.setVelocidad(nuevaVelocidad);
        }
    }

    private void dibujarCuentaRegresiva(Graphics g) {
        // Dibujar la cuenta regresiva en la parte superior
        Font font = new Font("Arial", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Nivel " + nivel + " - Tiempo: " + tiempoCuentaRegresiva + "s", 10, 30);
    }

    private void dibujarNivel(Graphics g) {
        // Dibujar el nivel actual en la parte superior
        Font font = new Font("Arial", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Nivel " + nivel, 10, 30);
    }
    private void dibujarDisparos(Graphics g) {
        // Dibujar los disparos
        for (Disparo disparo : disparos) {
            g.drawImage(Fuego, disparo.getX(), disparo.getY(), this);
        }
    }
    private static class Disparo {
        private int x;
        private int y;
        private int velocidad,nivel;

        public Disparo(int x, int y, int velocidad,int nivel) {
            this.x = x;
            this.y = y;
            this.velocidad = velocidad;
            this.nivel=nivel;
        }

        // Método para mover el disparo
        public void mover() {
            if(nivel==1){
                y -= velocidad;
            }else if(nivel==2){
                y -= velocidad*2;
            }else if(nivel==3){
                y -= velocidad*3;
            }else if(nivel==4){
                y -= velocidad*4;
            }else{

            }
        }

        // Métodos para obtener las coordenadas del disparo
        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
        public void setVelocidad(int velocidad) {
            this.velocidad = velocidad;
        }
    }



}

