import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class Buttons extends JFrame {
    JButton plusminus, clear, delete, spot, freeSpace;

    private List<JButton> buttonNumbers = new ArrayList<JButton>();
    private Map<String, JButton> buttonSigns = new LinkedHashMap<>();

    static JTextArea t1 = new JTextArea();
    static JPanel buttonPanel = new JPanel();
    static int i;
    static String a, numS = "0";
    static double num, numB, numF;
    static boolean plus, minus, dev, mult;

    eHandler handler = new eHandler();

    public  Buttons(String s){
        super(s);
        setLayout(new FlowLayout());
        setTitle("Calculator");
        buttonPanel.setLayout(new GridLayout(6,4));
        plusminus= new JButton("+/-");
        clear = new JButton("C");
        delete = new JButton("DEL");
        spot = new JButton(".");
        freeSpace = new JButton(" ");

        initButtonNumbersList();
        initButtonSignsList();

        t1 = new JTextArea();
        t1.setEditable(false);

        //buttonPanel.setSize(350,300);
        add(t1, BorderLayout.NORTH);
        //buttonPanel.add(t1, 0);
        buttonPanel.add(plusminus);
        buttonPanel.add(clear);
        buttonPanel.add(delete);
        buttonPanel.add(buttonSigns.get("/"));
        buttonPanel.add(buttonNumbers.get(7));
        buttonPanel.add(buttonNumbers.get(8));
        buttonPanel.add(buttonNumbers.get(9));
        buttonPanel.add(buttonSigns.get("*"));
        buttonPanel.add(buttonNumbers.get(4));
        buttonPanel.add(buttonNumbers.get(5));
        buttonPanel.add(buttonNumbers.get(6));
        buttonPanel.add(buttonSigns.get("-"));
        buttonPanel.add(buttonNumbers.get(1));
        buttonPanel.add(buttonNumbers.get(2));
        buttonPanel.add(buttonNumbers.get(3));
        buttonPanel.add(buttonSigns.get("+"));
        buttonPanel.add(freeSpace);
        buttonPanel.add(buttonNumbers.get(0));
        buttonPanel.add(spot);
        buttonPanel.add(buttonSigns.get("="));
        add(buttonPanel,BorderLayout.CENTER);
        add(buttonPanel);

        addButtonListeners(buttonNumbers);
        addButtonListeners(buttonSigns.values());
        spot.addActionListener(handler);
        delete.addActionListener(handler);
        clear.addActionListener(handler);
        plusminus.addActionListener(handler);

    }

    private void initButtonNumbersList() {
        for (int i = 0, l = 10; i<l; i++) {
            buttonNumbers.add(new JButton(String.valueOf(i)));
        }
    }

    private void addButtonListeners(Collection<JButton> list) {
        for (JButton jb: list) {
            jb.addActionListener(handler);
        }
    }
    private void initButtonSignsList(){
        buttonSigns.put("/", new JButton("/"));
        buttonSigns.put("*", new JButton("*"));
        buttonSigns.put("-", new JButton("-"));
        buttonSigns.put("+", new JButton("+"));
        buttonSigns.put("=", new JButton("="));

    }

    public class eHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){

            if((Double.parseDouble(numS))>=999999){
                t1.setText(null);
                numS = "0";
                numB = 0;
                JOptionPane.showMessageDialog(null, "acest numar este prea lung");
            }

            if(e.getSource()==plusminus){
                if(Double.parseDouble(numS) - (int)Double.parseDouble(numS)!=0){
                    numS = Double.toString(-Double.parseDouble(numS));
                    double numOut = Double.parseDouble(numS);
                    if(numOut - (int)numOut != 0){
                        t1.setText(Double.toString(numOut));
                    }else {
                        i = (int)numOut;
                        t1.setText(Integer.toString(i));
                    }
                }else {
                    numS = Double.toString((int) - Double.parseDouble(numS));
                    double numOut = Double.parseDouble(numS);
                    if(numOut - (int)numOut !=0){
                        t1.setText(Double.toString(numOut));
                    }else {
                        i = (int)numOut;
                        t1.setText(Integer.toString(i));
                    }

                }
            }
            if(e.getSource()==clear){
                t1.setText(null);
                numS = "0";
                numB = 0;
            }
            if(e.getSource()==delete){
                String tmp = t1.getText();
                t1.setText(tmp.substring(0,tmp.length()-1));
            }
            if(e.getSource()==spot){
                numS += ".";
            }
            if(e.getSource()== buttonSigns.get("+")){
                numB = Double.parseDouble(numS);
                numS = "0";
                plus = true;
                minus = false;
                mult = false;
                dev = false;
            }
            if(e.getSource()== buttonSigns.get("-")){
                numB = Double.parseDouble(numS);
                numS = "0";
                plus = false;
                minus = true;
                mult = false;
                dev = false;
            }
            if(e.getSource()==  buttonSigns.get("/")){
                numB = Double.parseDouble(numS);
                numS = "0";
                plus = false;
                minus = false;
                mult = false;
                dev = true;
            }
            for (JButton jb: buttonNumbers) {
                if(e.getSource()==jb){
                    System.out.println("clicked");
                    numS = Calc.count(numS, Integer.parseInt(jb.getText()));
                    double numOut = Double.parseDouble(numS);
                    if(numOut - (int)numOut !=0){
                        t1.setText(Double.toString(numOut));
                    }else {
                        i = (int)numOut;
                        t1.setText(Integer.toString(i));
                    }
                }
            }

            if(e.getSource()== buttonSigns.get("=")){
                System.out.println("clicked");
                num = Double.parseDouble(numS);
                Buttons.equals(numB,num);
            }

        }
    }

    private static void equals(double x1, double x2) {
        if(plus){
            numF = x1 + x2;
            if(numF - (int)numF !=0){
                numF = numF * 10000;
                numF = (int)numF;
                numF = numF / 10000;
                a = Double.toString(numF);
                t1.setText(a);
            }else {
                i = (int)numF;
                t1.setText(Integer.toString(i));
            }
            num = 0;
            numB = 0;
            numS = "0";
            plus = false;
        }
        if(minus){
            numF = x1 - x2;
            if(numF - (int)numF !=0){
                numF = numF * 10000;
                numF = (int)numF;
                numF = numF / 10000;
                a = Double.toString(numF);
                t1.setText(a);
            }else {
                i = (int)numF;
                t1.setText(Integer.toString(i));

            }
            num = 0;
            numB = 0;
            numS = "0";
            minus = false;
        }
        if(mult){
            numF = x1 * x2;
            if(numF - (int)numF !=0){
                numF = numF * 10000;
                numF = (int)numF;
                numF = numF /10000;
                a = Double.toString(numF);
                t1.setText(a);
            }else {
                i = (int)numF;
                t1.setText(Integer.toString(i));
            }
            num = 0;
            numB = 0;
            numS = "0";
            mult = false;

        }
        if(dev){
            numF = x1 / x2;
            if(numF - (int)numF !=0){
                numF = numF * 10000;
                numF = (int)numF;
                numF=numF/10000;
                a = Double.toString(numF);
                t1.setText(a);
            }else {
                i = (int)numF;
                t1.setText(Integer.toString(i));

            }
            num = 0;
            numB = 0;
            numS = "0";
            dev = false;
        }
    }
}
