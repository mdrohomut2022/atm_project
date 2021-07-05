package atm_project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    Container c;
    private JLabel welc, img1;
    private JButton create, analysis, query;
    private JButton deposit;
    private JButton withdraw;
    private JButton transfer;
    private JButton relogin;
    private Font font;
    private Cursor curs;
    private ImageIcon img;

    public Main() {

        this.setBounds(400, 200, 600, 400);
        main();

    }

    public void main() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.green);

        font = new Font("Calibri (Body)", Font.BOLD, 16);
        curs = new Cursor(Cursor.HAND_CURSOR);

        // didn't use image for background if anyone want they can fllow my code !!!
        img = new ImageIcon(getClass().getResource(""));
        img1 = new JLabel("", img, JLabel.CENTER);
        img1.setBounds(0, 0, 0, 0);

        welc = new JLabel();
        welc.setText(" welcome to E-Banking");
        welc.setBounds(65, 15, 405, 35);
        welc.setFont(font);
        welc.setForeground(Color.black);

        create = new JButton("Create Account");
        create.setBounds(75, 75, 195, 45);
        create.setCursor(curs);
        create.setEnabled(true);
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
                CreateAccount frame = new CreateAccount();
                frame.setVisible(true);
                frame.setResizable(false);
            }

        });

        analysis = new JButton("Statistical analysis");
        analysis.setBounds(75, 155, 195, 45);
        analysis.setCursor(curs);
        analysis.setEnabled(true);
        analysis.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                StaticalAnalysis frame = new StaticalAnalysis();
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });

        query = new JButton("Accounts Qurey");
        query.setBounds(75, 235, 195, 45);
        query.setCursor(curs);
        query.setEnabled(true);
        query.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                Query frame = new Query();
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });

        deposit = new JButton("Deposit Money");
        deposit.setBounds(325, 75, 195, 45);
        deposit.setCursor(curs);
        deposit.setEnabled(true);

        deposit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                Deposit framei = new Deposit();
                framei.setVisible(true);
                framei.setResizable(false);

            }
        });

        withdraw = new JButton("Withdraw Money");
        withdraw.setBounds(325, 155, 195, 45);
        withdraw.setCursor(curs);
        withdraw.setEnabled(true);
        withdraw.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                Withdraw frame = new Withdraw();
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });

        transfer = new JButton("Transfer Money");
        transfer.setBounds(325, 235, 195, 45);
        transfer.setCursor(curs);
        transfer.setEnabled(true);
        transfer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
                Transfer frame = new Transfer();
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });

        relogin = new JButton("Re-login");
        relogin.setBounds(465, 1, 135, 45);
        relogin.setCursor(curs);
        relogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();
                Login frame = new Login();
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });

        c.add(welc);
        c.add(create);
        c.add(analysis);
        c.add(query);
        c.add(deposit);
        c.add(withdraw);
        c.add(transfer);
        c.add(relogin);
        c.add(img1);

    }

    public void changeButtonStatus(boolean flag) {
        deposit.setEnabled(flag);
        withdraw.setEnabled(flag);
        transfer.setEnabled(flag);

    }

    public void changeButtonStatus1(boolean fla) {
        query.setEnabled(fla);
        analysis.setEnabled(fla);
        create.setEnabled(fla);

    }

    public static void main(String[] args) {

        Main main = new Main();

        main.setVisible(true);
        main.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        main.setTitle("E-Banking");
        main.setResizable(false);

    }

}
