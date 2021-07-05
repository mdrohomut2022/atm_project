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
import java.sql.Statement;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Query extends JFrame {

    Connection conn = null;
    PreparedStatement pst = null;

    private Container c;
    private JLabel name, minmum, after, maximum, before, format, img1;
    private JTextField name1, minmumid, after1, maximumid, befor1;
    private JButton query, return1;
    private JTextArea area;
    private Font font, f;
    private ImageIcon img;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollbar;
    private String[] colum = {"ID", "Name", "Create Time", "Balance"};
    private String[] row = new String[4];

    Query() {
        this.setBounds(400, 200, 600, 400);
        component();
    }

    public void component() {

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.green);

         // didn't use image for background if anyone want they can fllow my code !!!
        img = new ImageIcon(getClass().getResource(""));
        img1 = new JLabel(img, JLabel.CENTER);
        img1.setBounds(0,0,0,0);

        f = new Font("Calibri (Body)", Font.CENTER_BASELINE, 14);
        font = new Font("arial", Font.BOLD, 16);

       
        name = new JLabel("Name:");
        name.setBounds(15, 15, 105, 35);
        name.setFont(font);
        name.setForeground(Color.black);

        minmum = new JLabel("min ID:");
        minmum.setBounds(15, 55, 105, 35);
        minmum.setFont(font);
        minmum.setForeground(Color.black);

        after = new JLabel("after:");
        after.setBounds(15, 95, 105, 35);
        after.setFont(font);
        after.setForeground(Color.black);

        maximum = new JLabel("max ID:");
        maximum.setBounds(225, 55, 105, 35);
        maximum.setFont(font);
        maximum.setForeground(Color.black);

        before = new JLabel("Before:");
        before.setBounds(225, 95, 105, 35);
        before.setFont(font);
        before.setForeground(Color.black);

        format = new JLabel("(Format Example:2021-06-12)");
        format.setBounds(105, 135, 305, 35);
        format.setFont(font);
        format.setForeground(Color.blue);

       
        name1 = new JTextField();
        name1.setBounds(105, 15, 115, 35);
        name1.setFont(font);

        minmumid = new JTextField();
        minmumid.setBounds(105, 55, 115, 35);
        minmumid.setFont(font);

        after1 = new JTextField();
        after1.setBounds(105, 95, 115, 35);
        after1.setFont(font);

        maximumid = new JTextField();
        maximumid.setBounds(305, 55, 115, 35);
        maximumid.setFont(font);

        befor1 = new JTextField();
        befor1.setBounds(305, 95, 115, 35);
        befor1.setFont(font);

       
        query = new JButton("Query");
        query.setBounds(455, 15, 115, 45);
        query.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                   
                    conn = DriverManager.getConnection("", "root", "");
                    Statement pst = conn.createStatement();

                    String sql = "";
                    ResultSet rs = pst.executeQuery(sql);
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    while (rs.next()) {

                        model.addRow(new String[]{rs.getString(1), rs.getString(3), rs.getString(7), rs.getString(6)});

                    }

                    conn.close();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        });

        return1 = new JButton("Return");
        return1.setBounds(455, 85, 115, 45);
        return1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();
                Main main = new Main();
                main.setVisible(true);
                main.setResizable(false);
                main.changeButtonStatus1(true);
            }
        });

     
        table = new JTable();
        table.setOpaque(true);
        table.setForeground(Color.BLUE);
        table.setEnabled(true);

     
        model = new DefaultTableModel();
        model.setColumnIdentifiers(colum);
        table.setModel(model);

        scrollbar = new JScrollPane(table);
        scrollbar.setAlignmentY(CENTER_ALIGNMENT);
        scrollbar.setBounds(25, 180, 555, 165);

        c.add(scrollbar);
        c.add(name);
        c.add(minmum);
        c.add(after);
        c.add(maximum);
        c.add(before);
        c.add(format);

        c.add(name1);
        c.add(minmumid);
        c.add(after1);
        c.add(maximumid);
        c.add(befor1);

        c.add(query);
        c.add(return1);

       
        c.add(img1);
    }

    public static void main(String[] args) {
        Query frame = new Query();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("Query Box");
        frame.setResizable(false);

    }

}
