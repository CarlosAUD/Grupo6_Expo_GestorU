package Expo;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame file = new JFrame("Cargar y Mostrar Imagen");
        file.setContentPane(new Form().panel);
        file.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        file.pack();
        file.setVisible(true);
    }
}
