import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Sistema de Gestión de Estudiantes");
                frame.setContentPane(new SGEstudiantes().Sistema);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                SGEstudiantes sgEstudiantes = new SGEstudiantes();

                // Crear el JMenuItem "Archivo" y asociar ActionListener para cambiar el color del JPanel
                JMenuItem archivoItem = new JMenuItem("Rojo");
                JMenuItem archivo2Item = new JMenuItem("Azul");
                JMenuItem archivo3Item = new JMenuItem("Negro");
                JMenuItem archivo4Item = new JMenuItem("Blanco");
                archivoItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sgEstudiantes.Sistema.setBackground(Color.RED);
                    }
                });
                archivo4Item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sgEstudiantes.Sistema.setBackground(Color.white);
                    }
                });
                archivo2Item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sgEstudiantes.Sistema.setBackground(Color.BLUE);
                    }
                });

                archivo3Item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sgEstudiantes.Sistema.setBackground(Color.black);
                    }
                });

                // Crear el JMenu "Color" y agregar el JMenuItem
                JMenu archivoMenu = new JMenu("Color");
                archivoMenu.add(archivoItem);
                archivoMenu.add(archivo2Item);
                archivoMenu.add(archivo3Item);
                archivoMenu.add(archivo4Item);

                // Crear la barra de menú y agregar el JMenu "Color"
                JMenuBar menuBar = new JMenuBar();
                menuBar.add(archivoMenu);

                frame.setJMenuBar(menuBar);
                frame.setContentPane(sgEstudiantes.Sistema);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}
