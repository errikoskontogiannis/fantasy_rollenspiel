package fantasy_rollenspiel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Scanner;

public class ButtonEventClass extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 8500302163751733942L;

    private JLabel wText;
    private JLabel bText;
    private JButton sButton;

    public ButtonEventClass() {

        sButton = new JButton("SPIELEN");

        sButton.addActionListener(this);

        sButton.setSize(500, 100);

        sButton.setBounds(-10, 370, 520, 100);

        sButton.setBackground(Color.BLACK);

        sButton.setForeground(Color.WHITE);

        wText = new JLabel("Willkomen im Auenland!");
        bText = new JLabel(" - Betaetigen Sie die Schaltflaeche Spielen, um zu beginnen.");

        wText.setBounds(160, 0, 500, 36);
        bText.setBounds(130, 0, 500, 16);

        Font wSchrift = wText.getFont().deriveFont(Font.BOLD + Font.PLAIN, 36);
        Font bSchrift = bText.getFont().deriveFont(Font.BOLD + Font.PLAIN, 16);

        wText.setFont(wSchrift);
        wText.setFont(bSchrift);

        wText.setForeground(Color.WHITE);
        bText.setForeground(Color.WHITE);

        add(wText);
        add(bText);

        setVisible(true);

        this.getContentPane().setBackground(Color.BLACK);

        this.getContentPane().add(sButton);

        this.getContentPane().add(wText);

        this.getContentPane().add(bText);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() != sButton) {

            return;

        }

        clearScreen();

        System.out.println("Bitte waehlen Sie Ihren Spielcharakter");

        Scanner in = new Scanner(System.in);

        String heldenTyp = in.nextLine();

        new Spiel(heldenTyp);

    }

    public static void main(String[] args) {

        ButtonEventClass bec = new ButtonEventClass();

        bec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bec.setSize(520, 500);

        bec.setVisible(true);

        bec.setBackground(Color.black);

    }

    public static void clearScreen() {

        for(int i = 0;i<100;i++){

            System.out.print("\n");

        }

    }

}