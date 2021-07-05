package atm_project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Deposit extends JFrame {

    private static final long serialVersionUID = 1L;

    Connection conn = null;
    ResultSet result = null;
    PreparedStatement prestment = null;

    private Container c;
    private JLabel account, name, accountype, balance, money, img1;
    public JTextField account1, name1, money1, accountpye1, balanc;
    private JButton deposit, return1;
    private ImageIcon img;
    private Font font;
    public String drv;

    Deposit() {
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

        account = new JLabel("Account ID:");
        account.setBounds(85, 35, 195, 35);
        account.setFont(font);
        account.setForeground(Color.black);

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

        account1 = new JTextField("");
        account1.getText();
        account1.setBounds(285, 35, 195, 35);

        name1 = new JTextField();
        name1.setBounds(285, 75, 195, 35);
        name1.setEditable(true);

        accountpye1 = new JTextField();
        accountpye1.setBounds(285, 115, 195, 35);
        accountpye1.setEditable(true);

        balanc = new JTextField();
        balanc.setBounds(285, 155, 195, 35);
        balanc.setFont(font);
        balanc.setEditable(true);

        money1 = new JTextField();
        money1.setBounds(285, 195, 195, 35);

        deposit = new JButton("Deposit");
        deposit.setBounds(85, 290, 105, 45);
        deposit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ex) {

                String nm = "Name";
                String atp = "account_type";
                String balnc = "balance";

                result = find(account1.getText());

                try {
                    if (result.next()) {
                        name1.setText(result.getString("Name"));
                        accountpye1.setText(result.getString("account_type"));
                        balanc.setText(result.getString("balance"));
                    }

                    JOptionPane.showMessageDialog(null, "Enter successfullly!");

                } catch (Exception p) {
                    JOptionPane.showMessageDialog(null, p);
                }

            }

        });

        return1 = new JButton("Return");
        return1.setBounds(365, 290, 105, 45);
        return1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent en) {

                dispose();
                Main main = new Main();
                main.setVisible(true);
                main.setResizable(false);
                main.changeButtonStatus(true);

            }

        });

        c.add(account);

        c.add(balance);
        c.add(name);
        c.add(accountype);
        c.add(money);
        c.add(account1);
        c.add(accountpye1);
        c.add(balanc);
        c.add(name1);
        c.add(money1);

        c.add(deposit);

        c.add(return1);
        c.add(img1);

    }

    public ResultSet find(String s) {

        try {
            String url = "";
            conn = DriverManager.getConnection(url, "root", "");
            prestment = conn.prepareStatement("");
            prestment.setString(1, s);
            result = prestment.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
       

        return result;

    }

    public static void main(String[] args) {

        Deposit framei = new Deposit();
        framei.setVisible(true);
        framei.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        framei.setTitle("Personal Account Box");
        framei.setResizable(false);
    }

}
