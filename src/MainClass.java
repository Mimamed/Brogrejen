import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass //σ
{

    static String beginingG = "G: N = ";
    static String beginingH = "h: N = ";
    static String beginingJ = "J: N = ";
    static String beginingHöjdG = "stjocklek för G (m): ";
    static String beginingRadieR = "Radie för H(m): ";
    static String beginingRadier = "Radie för J(m): ";
    static JFrame win = new JFrame();
    static JPanel pan = new JPanel();
    static JButton uppdatera = new JButton("Beräkna");
    static JTextField längdB = new JTextField(), längdC = new JTextField(), spänningJ = new JTextField(), längdF = new JTextField(), vikt = new JTextField(), spänningH = new JTextField(), spänningG = new JTextField();
    static JLabel g = new JLabel("g:"), h = new JLabel("h:"), j = new JLabel("j:"), titelB = new JLabel("Längd B"), titelC = new JLabel("Längd C"), titelJ = new JLabel("σ för J"), titelF = new JLabel("Längd F"), titelVikt = new JLabel("Vikt"), felmedelande = new JLabel(), titelH = new JLabel("σ för H"), titelG = new JLabel("σ för G"), radieJ = new JLabel("Radie för J: "), radieH = new JLabel("Radie för H: "), höjdG = new JLabel("stjocklek för G: ");
    static double längdD;

    public static void main (String[] args)
    {
        setup();

    }

    private static void setup()
    {
        win.setVisible(true);
        win.setSize(500, 500);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.add(pan);
        pan.setLayout(null);
        pan.add(uppdatera);
        pan.add(längdB);
        pan.add(längdC);
        pan.add(spänningJ);
        pan.add(spänningH);
        pan.add(spänningG);
        pan.add(längdF);
        pan.add(vikt);
        pan.add(g);
        pan.add(h);
        pan.add(j);
        pan.add(titelB);
        pan.add(titelC);
        pan.add(titelJ);
        pan.add(titelF);
        pan.add(titelH);
        pan.add(titelG);
        pan.add(titelVikt);
        pan.add(radieH);
        pan.add(radieJ);
        pan.add(höjdG);
        längdB.setBounds(10,100,50,20);
        längdC.setBounds(80, 100, 50, 20);
        längdF.setBounds(150, 100, 50, 20);
        vikt.setBounds(220, 100, 50, 20);
        spänningJ.setBounds(290, 100, 50, 20);
        spänningH.setBounds(360, 100, 50, 20);
        spänningG.setBounds(430, 100, 50, 20);
        titelB.setBounds(längdB.getX(), 50, 50, 50);
        titelC.setBounds(längdC.getX(), 50, 50, 50);
        titelJ.setBounds(spänningJ.getX(), 50, 50, 50);
        titelG.setBounds(spänningG.getX(), 50, 50, 50);
        titelH.setBounds(spänningH.getX(), 50, 50, 50);
        titelF.setBounds(längdF.getX(), 50, 50, 50);
        titelVikt.setBounds(vikt.getX(), 50, 50, 50);
        g.setBounds(längdB.getX(), 130, 200, 50);
        h.setBounds(längdB.getX(), 160, 200, 50);
        j.setBounds(längdB.getX(), 190, 200, 50);
        höjdG.setBounds(längdB.getX(), 220, 200, 50);
        radieH.setBounds(längdB.getX(), 250, 200, 50);
        radieJ.setBounds(längdB.getX(), 280, 200, 50);
        felmedelande.setBounds(längdB.getX(), 300, 100, 20);
        felmedelande.setForeground(Color.red);
        uppdatera.setBounds(längdB.getX(), 400, 60,20);
        uppdatera.setFocusPainted(false);
        uppdatera.setMargin(new Insets(0,0,0,0));
        uppdatera.addActionListener(new Calculate());

        längdF.setText("");
        spänningJ.setText("");
        spänningG.setText("");
        spänningH.setText("");
        längdC.setText("");
        längdB.setText("");
        vikt.setText("");

    }


    static class Calculate implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            try
            { /*Math.toRadians(90) - Math.atan(Double.parseDouble(längdC.getText()) / Double.parseDouble(längdB.getText()))*/
                längdD = Math.sqrt(Math.pow(Double.parseDouble(längdC.getText()), 2) + Math.pow(Double.parseDouble(längdB.getText()), 2));
                double f1 = Double.parseDouble(vikt.getText()) * Math.cos(Math.toRadians(90) - Math.atan(Double.parseDouble(längdC.getText()) / Double.parseDouble(längdB.getText()))), f3 = (f1 * Math.sin(Math.toRadians(90) - Math.atan(Double.parseDouble(längdC.getText()) / Double.parseDouble(längdB.getText())))), f2 = (f1 * Math.cos(Math.toRadians(90) - Math.atan(Double.parseDouble(längdC.getText()) / Double.parseDouble(längdB.getText())))), höjd = ((f3 * 12) / (Double.parseDouble(spänningG.getText()) * Double.parseDouble(längdF.getText()) * Math.pow(10, 6))), radienR = Math.pow((f1 * 6) / (Double.parseDouble(spänningH.getText()) * Math.PI * Math.pow(10, 6)), 0.5), radienr = Math.pow((f2 *6) / (Double.parseDouble(spänningJ.getText()) * Math.PI * Math.pow(10, 6)), 0.5);
                System.out.println("vikt: " + vikt.getText() + "  längdC: " + längdC.getText() + "   längdB: " + längdB.getText() + "   längdD: " + längdD + "   f1: " + f1);
                g.setText(beginingG + f3);
                h.setText(beginingH + f1);
                j.setText(beginingJ + f2);
                höjdG.setText(beginingHöjdG + höjd);
                radieH.setText(beginingRadieR + radienR);
                radieJ.setText(beginingRadier + radienr);
            }catch (Exception d)
            {
                d.printStackTrace();
                System.out.println("något fel");

            }
        }
    }

}