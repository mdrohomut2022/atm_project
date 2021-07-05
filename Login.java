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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import atm_project.Main;

public class Login extends JFrame implements ActionListener {

    
    private static final long serialVId = 1L;
    Connection conn = null;
    PreparedStatement prestment = null;
    ResultSet result = null;

    private Container c;
    private JLabel id, pass, img1;
    public JTextField userid;
    private JPasswordField userpass;
    private JRadioButton customer, clerk;
    private ButtonGroup btngroup;
    private JButton login, reset;
    private ImageIcon img;
    private Font font;

    Login() {
        setBounds(400, 200, 600, 400);

        component(); 
    }

    private void component() {

        c = this.getContentPane(); 
        c.setLayout(null);
        c.setBackground(Color.green);

        font = new Font("Calibri (Body)", Font.BOLD, 16);

        // didn't use image for background if anyone want they can fllow my code !!!
        img = new ImageIcon(getClass().getResource(""));
        img1 = new JLabel("", img, JLabel.CENTER);
        img1.setBounds(0,0,0,0);

        id = new JLabel();
        id.setText("Account ID:");
        id.setBounds(145, 55, 105, 35);
        id.setForeground(Color.black);
        id.setFont(font);

        pass = new JLabel();
        pass.setText("Password:");
        pass.setBounds(145, 105, 105, 35);
        pass.setForeground(Color.black);
        pass.setFont(font);

        userid = new JTextField("");
        userid.setBounds(255, 55, 195, 35);
        userid.setFont(font);

        userpass = new JPasswordField("");
        userpass.setBounds(255, 105, 195, 35);
        userpass.setFont(font);

        btngroup = new ButtonGroup();

        customer = new JRadioButton("customer");
        customer.setBounds(175, 165, 105, 25);
        customer.setBackground(null);
        customer.setOpaque(false);
        customer.setBackground(new Color(0, 0, 0, 0));
        customer.setForeground(Color.black);
        c.add(customer);

        clerk = new JRadioButton("clerk", true);
        clerk.setBounds(285, 165, 105, 25);
        clerk.setBackground(new Color(0, 0, 0, 0));
        clerk.setOpaque(false);
        clerk.setForeground(Color.black);
        c.add(clerk);

        btngroup.add(customer);
        btngroup.add(clerk);

        login = new JButton("Login");
        login.setBounds(165, 215, 125, 45);

        reset = new JButton("Reset");
        reset.setBounds(315, 215, 125, 45);
        reset.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                userid.setText("");
                userpass.setText("");

            }
        });

        c.add(id);
        c.add(pass);
        c.add(userid);
        c.add(userpass);
        c.add(login);
        c.add(reset);
        c.add(img1);

        login.addActionListener(this);

    }

    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent evt) {

        String user = userid.getText();

        String pass = userpass.getText();

        if (user.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please,Input your Id and Pass");

        } else if (pass.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please,Input your Password");

        } else {

            try {

                String query = "";
                conn = DriverManager.getConnection("", "root", "");
                prestment = conn.prepareStatement(query);
                prestment.setString(1, userid.getText());
                prestment.setString(2, userpass.getText());
                result = prestment.executeQuery();

                if (result.next()) {
                    if (customer.isSelected()) {

                        dispose();
                        Main main = new Main();
                        main.setVisible(true);
                        main.setResizable(false);
                        main.changeButtonStatus(true);
                    } else {
                        dispose();
                        Main main = new Main();
                        main.setVisible(true);
                        main.setResizable(false);
                        main.changeButtonStatus1(true);
                    }

                    JOptionPane.showMessageDialog(null, "you are successfully login");
                } else {
                    JOptionPane.showMessageDialog(null, "user or pass incorrect? try again.");
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

    }

    public static void main(String[] args) {

        Login fram = new Login();

        fram.setVisible(true);
        fram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fram.setTitle("Login Dialog_Box");
        fram.setResizable(false);

    }

}
