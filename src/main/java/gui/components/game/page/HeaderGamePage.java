package gui.components.game.page;

import entities.Player;
import gui.components.GameFrame;
import javax.swing.*;
import java.awt.*;

public class HeaderGamePage extends JPanel {
    //FIELDS
    protected GameFrame currentGameFrame;
    protected Player player1;
    protected Player player2;
    protected JTextArea player1Text;
    protected JTextArea turnText;
    protected JTextArea player2Text;

    //CONSTRUCTORS
    public HeaderGamePage(GameFrame gf, Player player1, Player player2) {
        super();
        this.setLayout(new GridLayout());
        this.setBackground(GameFrame.BOARD_COLOR);

        this.currentGameFrame = gf;
        this.player1 = player1;
        this.player2 = player2;
        this.player1Text = new JTextArea("["+player1.getPieces().getName().toUpperCase()+"] "+player1.getUsername());
        this.turnText = new JTextArea("..");
        this.player2Text = new JTextArea("["+player2.getPieces().getName().toUpperCase()+"] "+player2.getUsername());

        this.player1Text.setFont(gf.getApplicationFont(false));
        this.player1Text.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.turnText.setFont(gf.getApplicationFont(false));
        this.turnText.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        this.player2Text.setFont(gf.getApplicationFont(false));
        this.player2Text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        this.add(this.player1Text);
        this.add(this.turnText);
        this.add(this.player2Text);
    }

    //METHODS
    public void highlightTurn(Player player) {
        if (this.player1.equals(player)) {
            this.player1Text.setFont(this.currentGameFrame.getApplicationFont(true));
            this.player1Text.setForeground(Color.RED);
            this.turnText.setText(this.player1.getUsername()+"'s turn");

            this.player2Text.setFont(this.currentGameFrame.getApplicationFont(false));
            this.player2Text.setForeground(Color.BLACK);
        }
        else {
            this.player2Text.setFont(this.currentGameFrame.getApplicationFont(true));
            this.player2Text.setForeground(Color.RED);
            this.turnText.setText(this.player2.getUsername()+"'s turn");

            this.player1Text.setFont(this.currentGameFrame.getApplicationFont(false));
            this.player1Text.setForeground(Color.BLACK);
        }
    }

    public void swapPieces() {
        this.player1Text.setText("["+player1.getPieces().getName().toUpperCase()+"] "+player1.getUsername());
        this.player2Text.setText("["+player2.getPieces().getName().toUpperCase()+"] "+player2.getUsername());
    }
}
