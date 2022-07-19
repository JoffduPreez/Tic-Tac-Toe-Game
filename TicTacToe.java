import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    public boolean X_turn = true;
    public JFrame frame = new JFrame();
    public JPanel titlePanel = new JPanel();
    public JPanel buttonPanel = new JPanel();
    public JLabel titleField = new JLabel();
    public JLabel msgField = new JLabel();
    public JButton[] buttons = new JButton[9];
    int[] board = new int[9];


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

		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
            buttons[i].setText("");
            buttons[i].setOpaque(true);
            board[i] = 999;
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

    public void gameOver (Boolean X_Won, int a, int b, int c) {
        if (X_Won == true) {
            msgField.setText("X Won the Game!");
        } else {
            msgField.setText("O Won the Game!");
        }

        buttons[a].setForeground(Color.GREEN);
        buttons[b].setForeground(Color.GREEN);
        buttons[c].setForeground(Color.GREEN);

		for(int i = 0; i < 9; i++) {
			// buttons[i].setEnabled(false);
			buttons[i].removeActionListener(this);;
		}
    }

    public void checkWin () {
        int sum;

        // check rows for win condition
        for (int i = 0; i <= 6; i+=3) {
            sum = 0;
            for (int j = 0; j <= 2; j++) {
                sum += board[i+j];
            }
            if (sum == 0) { // O won
                gameOver(false, i, i+1, i+2);
            }
            if (sum == 3) { // X won
                gameOver(true, i, i+1, i+2);
            }
        }

        for (int i = 0; i <= 2; i++) {
            sum = 0;
            for (int j = 0; j <= i+6; j += 3) {
                sum += board[i+j];
            }
            if (sum == 0) { // O won
                gameOver(false, i, i+3, i+6);
            }
            if (sum == 3) { // X won
                gameOver(true, i, i+3, i+6);
            }
        }

        sum = board[0] + board[4] + board[8];
        if (sum == 0) { // O won
            gameOver(false, 0, 4, 8);
        }
        if (sum == 3) { // X won
            gameOver(true, 0, 4, 8);
        }

        sum = board[2] + board[4] + board[6];
        if (sum == 0) { // O won
            gameOver(false, 2, 4, 6);
        }
        if (sum == 3) { // X won
            gameOver(true, 2, 4, 6);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i] && buttons[i].getText() == "") {
                if (X_turn) {
                    buttons[i].setText("X");
                    X_turn = false;
                    msgField.setText("O's turn");
                    board[i] = 1;
                    checkWin();
                } else {
                    buttons[i].setText("O");
                    X_turn = true;
                    msgField.setText("X's turn");
                    board[i] = 0;
                    checkWin();
                }
            }
        }
        // if the button is not taken:
        // record where player makes a move in a separate array. This array will be used to check who wins
        // add an X or an O to the button
        // Check if the player won
        // if the game is not over, switch it to O's turn

    }
}

