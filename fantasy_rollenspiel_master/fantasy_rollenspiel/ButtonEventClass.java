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

@SuppressWarnings("ALL")
public class ButtonEventClass extends JFrame implements ActionListener {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 8500302163751733942L;
	private JLabel text1;
    private JButton button;
    
    public ButtonEventClass() {
        button = new JButton("Spielen!");
        button.addActionListener(this);
        button.setSize(500, 100);
        button.setBounds(-10, 370, 520, 100);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);

        text1 = new JLabel("Willkomen im Auenland!"
                + " Bet�tigen Sie die Schaltfl�che Spielen, um zu beginnen.");
        text1.setBounds(120, 20, 500, 40);
        Font schrift1 = text1.getFont().deriveFont(Font.BOLD + Font.PLAIN, 10);
        text1.setFont(schrift1);
        text1.setForeground(Color.black);
        add(text1);
        setVisible(true);

        this.getContentPane().add(button);
        this.getContentPane().add(text1);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() != button) {
        	return;
        }
        
        clearScreen();
        
        System.out.println("Waehlen Sie bitte einen Heldentyp");
        
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
