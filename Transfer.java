package atm_project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Transfer extends JFrame {

    Connection con = null;

    private Container c;
    private JLabel account1, name, accountype, balance, money, transfer, img1;
    private JTextField account2, name1, innt, money1, transfer1;
    private JButton registration, return1;
    private JPasswordField pass, cpass;
    private ImageIcon img;
    private Font font;

    Transfer() {
        this.setBounds(400, 200, 600, 400);
        initial();
    }

    public void initial() {

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.green);

        // didn't use image for background if anyone want they can fllow my code !!!
        img = new ImageIcon(getClass().getResource(""));
        img1 = new JLabel("", img, JLabel.CENTER);
        img1.setBounds(0,0,0,0);

        font = new Font("Calibri (Body)", Font.BOLD, 16);

        account1 = new JLabel("Account ID:");
        account1.setBounds(85, 35, 195, 35);
        account1.setFont(font);
        account1.setForeground(Color.black);

        name = new JLabel("Name");
        name.setBounds(85, 75, 195, 35);
        name.setFont(font);
        name.setForeground(Color.black);

        accountype = new JLabel("Account Type:");
        accountype.setBounds(85, 115, 195, 35);
        accountype.setFont(font);
        accountype.setForeground(Color.black);

        balance = new JLabel("Balance:");
        balance.setBounds(85, 155, 195, 35);
        balance.setFont(font);
        balance.setForeground(Color.black);

        money = new JLabel(" Money:");
        money.setBounds(85, 195, 195, 35);
        money.setFont(font);
        money.setForeground(Color.black);

        transfer = new JLabel("Target Accout ID:");
        transfer.setBounds(85, 235, 195, 35);
        transfer.setFont(font);
        transfer.setForeground(Color.black);

       
        account2 = new JTextField();
        account2.setBounds(285, 35, 195, 35);
        account2.setEnabled(true);

        pass = new JPasswordField();
        pass.setBounds(285, 75, 195, 35);
        pass.setEnabled(true);

        cpass = new JPasswordField();
        cpass.setBounds(285, 115, 195, 35);

        name1 = new JTextField();
        name1.setBounds(285, 155, 195, 35);
        name1.setFont(font);

        money1 = new JTextField();
        money1.setBounds(285, 195, 195, 35);

        transfer1 = new JTextField();
        transfer1.setBounds(285, 235, 195, 35);

      
        registration = new JButton("Transfer");
        registration.setBounds(85, 290, 105, 45);
        registration.addActionListener(new ActionListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent ex) {

                try {
                    Class.forName("");
                    String url = "";
                    Connection con = DriverManager.getConnection(url, "root", "");
                    String Qurey = "";
                    PreparedStatement pst = con.prepareStatement(Qurey);

                   
                    pst.setString(1, account1.getText());
                    pst.setString(2, cpass.getText());
                    pst.setString(3, name1.getText());
                    pst.setString(4, money1.getText());
                    pst.setString(5, innt.getText());

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Enter successfullly!");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }

        });

        return1 = new JButton("Return");
        return1.setBounds(365, 290, 105, 45);
        return1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
                Main main = new Main();
                main.setVisible(true);
                main.setResizable(false);
                main.changeButtonStatus(true);

            }

        });

        c.add(account1);

        c.add(balance);
        c.add(name);
        c.add(accountype);
        c.add(money);
        c.add(account2);
        c.add(pass);
        c.add(cpass);
        c.add(name1);
        c.add(money1);
        c.add(transfer);
        c.add(transfer1);

        c.add(registration);

        c.add(return1);
        c.add(img1);

    }

    public static void main(String[] args) {

        Transfer frame = new Transfer();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Personal Account Box");
        frame.setResizable(false);
    }

}
