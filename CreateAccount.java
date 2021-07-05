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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateAccount extends JFrame {

    Connection conn = null;

    private Container c;
    private JLabel account, pass, cpass, name, accountype, interest, img1;
    private JTextField account1, name1, innt;
    private JButton regestration, clear, return1;
    private JPasswordField pass1, cpass1;
    private ImageIcon img;
    private Font font;
    private JComboBox box;
    private String[] combox = {"Saving Account", "Credit Account", "Checking Account"};

    CreateAccount() {
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

        pass = new JLabel("Password:");
        pass.setBounds(85, 75, 195, 35);
        pass.setFont(font);
        pass.setForeground(Color.black);

        cpass = new JLabel("Password Confirm:");
        cpass.setBounds(85, 115, 195, 35);
        cpass.setFont(font);
        cpass.setForeground(Color.black);

        name = new JLabel("Name:");
        name.setBounds(85, 155, 195, 35);
        name.setFont(font);
        name.setForeground(Color.black);

        accountype = new JLabel("Account Type:");
        accountype.setBounds(85, 195, 195, 35);
        accountype.setFont(font);
        accountype.setForeground(Color.black);

        interest = new JLabel("Interest Rate(%):");
        interest.setBounds(85, 235, 195, 35);
        interest.setFont(font);
        interest.setForeground(Color.black);

        account1 = new JTextField();
        account1.setBounds(285, 35, 195, 35);
        account1.setEnabled(true);

        pass1 = new JPasswordField();
        pass1.setBounds(285, 75, 195, 35);
        pass1.setEnabled(true);

        cpass1 = new JPasswordField();
        cpass1.setBounds(285, 115, 195, 35);

        name1 = new JTextField();
        name1.setBounds(285, 155, 195, 35);
        name1.setFont(font);

        box = new JComboBox(combox);
        box.setBounds(285, 195, 195, 35);

        innt = new JTextField();
        innt.setBounds(285, 235, 195, 35);

        regestration = new JButton("Register");
       regestration.setBounds(85, 290, 105, 45);
        regestration.addActionListener(new ActionListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void actionPerformed(ActionEvent ex) {

                String pass = pass1.getText();
                String name = name1.getText();
                String rate = innt.getText();
                if (pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter your password");
                } else if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter your name");
                } else if (rate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter rate");
                } else {
                    try {
                        Class.forName("");
                        String url = "";
                        Connection conn = DriverManager.getConnection(url, "root", "");
                        String Qurey = "";
                        PreparedStatement pst = conn.prepareStatement(Qurey);

                       
                        pst.setString(1, cpass1.getText());
                        pst.setString(2, name1.getText());
                        pst.setString(3, (String) box.getSelectedItem());
                        pst.setString(4, innt.getText());

                        pst.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Enter successfullly!");

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }

            }

        });

        clear = new JButton("Clear");
        clear.setBounds(225, 290, 105, 45);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pass1.setText("");
                cpass1.setText("");
                name1.setText("");
                account1.setText("");
                innt.setText("");

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
                main.changeButtonStatus1(true);

            }

        });

        c.add(account);
        c.add(pass);
        c.add(cpass);
        c.add(name);
        c.add(accountype);
        c.add(interest);
        c.add(account1);
        c.add(pass1);
        c.add(cpass1);
        c.add(name1);
        c.add(box);
        c.add(innt);
        c.add(regestration);
        c.add(clear);
        c.add(return1);
        c.add(img1);

    }

    public static void main(String[] args) {

        CreateAccount frame = new CreateAccount();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setTitle("Personal Account Create");
        frame.setResizable(false);
    }

}
