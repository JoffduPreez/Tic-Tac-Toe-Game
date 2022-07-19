import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe {
    public boolean X_turn = true;
    public JFrame frame = new JFrame();
    public JPanel titlePanel = new JPanel();
    public JPanel buttonPanel = new JPanel();
    public JLabel titleField = new JLabel();
    public JLabel msgField = new JLabel();
    public JButton[] buttons = new JButton[9];


    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
    }


    TicTacToe () {
        frame.setSize(800, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.lightGray);

		titleField.setBackground(Color.lightGray);
		titleField.setForeground(Color.BLUE);
		titleField.setFont(new Font("Ink Free",Font.BOLD,75));
		titleField.setHorizontalAlignment(JLabel.CENTER);
		titleField.setText("Tic-Tac-Toe");
		titleField.setOpaque(true);

        msgField.setBackground(Color.lightGray);
		msgField.setForeground(Color.BLUE);
		msgField.setFont(new Font("Ink Free",Font.BOLD,35));
		msgField.setHorizontalAlignment(JLabel.CENTER);
		msgField.setText("");
		msgField.setOpaque(true);

        titlePanel.setLayout(new GridLayout(2,1));
        titlePanel.setBounds(0,0,800,150);
        titlePanel.add(titleField);
        titlePanel.add(msgField);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(Color.lightGray);

		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			// buttons[i].addActionListener(this);
		}

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    public void firstTurn () {
        Random rand = new Random();
        int randomInt;

        randomInt = rand.nextInt(2);

        if (randomInt == 0) {
            msgField.setText("X's turn");
            X_turn = true;
        } else if (randomInt == 1) {
            msgField.setText("O's turn");
            X_turn = false;
        }
    }
}

/*
 * Need methods for:
 * 
 * Randomly pick turn of first player
 * Display whos turn it is
 * 
 */