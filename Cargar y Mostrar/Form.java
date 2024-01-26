package Expo;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Form {
    public JLabel imageLabel;
    public JPanel panel;
    public ImageIcon imageIcon;

    public Form() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(800, 800));

        // Crear componentes
        imageLabel = new JLabel();
        JButton openButton = new JButton("Abrir Imagen");
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 500);

        // Configurar el botón para abrir el JFileChooser
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImage();
            }
        });

        // Configurar el JSlider para cambiar el tamaño de la imagen
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (imageIcon != null) {
                    Image image = imageIcon.getImage().getScaledInstance(source.getValue(), source.getValue(), Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(image);
                    imageLabel.setIcon(imageIcon);
                }
            }
        });

        // Configurar el diseño
        panel.add(openButton, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(slider, BorderLayout.SOUTH);
    }

    // Método para abrir el JFileChooser y cargar la imagen seleccionada
    public void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        // Filtrar solo archivos de imagen
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".png") || f.isDirectory();
            }

            public String getDescription() {
                return "Archivos de Imagen (.png)";
            }
        });

        int result = fileChooser.showOpenDialog(panel);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            imageLabel.setIcon(imageIcon);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
        }
    }

    }