import javax.swing.*;

public class Main {
    public static void main(String... arg){
        Buttons but = new Buttons("Calculator-2");
        but.setVisible(true);
        but.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        but.setSize(350,300);
        but.setResizable(true);
        but.setLocationRelativeTo(null);


    }
}
