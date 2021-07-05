package atm_project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StaticalAnalysis extends JFrame {

    private Container c;
    private JLabel account, all, avrg, saving, cheak, creadit, alldpass, allcreate, avrgdpass, avrgcreate, img1;
    private JTextField account1, avg, avg1, saveing1, cheak1, cheakdata, alldata, allcount, avgdata, avgcount;
    private JButton update, statistics, return1;
    private ImageIcon img;
    private Font font;

    StaticalAnalysis() {

        this.setBounds(400, 200, 600, 400);
        components();
    }

    public void components() {

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.green);

        font = new Font("Calibri (Body)", Font.BOLD, 12);

        // didn't use image for background if anyone want they can fllow my code !!!
        img = new ImageIcon(getClass().getResource(""));
        img1 = new JLabel("", img, JLabel.CENTER);
        img1.setBounds(0,0,0,0);

     
        account = new JLabel("Accunt Number:");
        account.setBounds(15, 35, 125, 35);
        account.setForeground(Color.black);
        account.setFont(font);
        c.add(account);

        all = new JLabel("All Balance:");
        all.setBounds(15, 145, 125, 35);
        all.setForeground(Color.black);
        all.setFont(font);
        c.add(all);

        avrg = new JLabel("Average Balance:");
        avrg.setBounds(15, 225, 125, 35);
        avrg.setForeground(Color.black);
        avrg.setFont(font);
        c.add(avrg);

       
        account1 = new JTextField("");
        account1.setBounds(135, 35, 125, 30);
        account1.setEditable(true);

        avg = new JTextField("");
        avg.setBounds(135, 145, 125, 30);
        avg.setEditable(true);

        avg1 = new JTextField("");
        avg1.setBounds(135, 225, 125, 30);
        avg1.setEditable(true);

        c.add(account1);
        c.add(avg);
        c.add(avg1);

       
        saving = new JLabel("Saving Accuont:");
        saving.setBounds(285, 15, 125, 35);
        saving.setForeground(Color.black);
        saving.setFont(font);
        c.add(saving);

        cheak = new JLabel("Checking Account:");
        cheak.setBounds(285, 50, 125, 35);
        cheak.setForeground(Color.black);
        cheak.setFont(font);
        c.add(cheak);

        creadit = new JLabel("Credit Account:");
        creadit.setBounds(285, 85, 125, 35);
        creadit.setForeground(Color.black);
        creadit.setFont(font);
        c.add(creadit);

        alldpass = new JLabel("Total Deposit:");
        alldpass.setBounds(285, 130, 125, 35);
        alldpass.setForeground(Color.black);
        alldpass.setFont(font);
        c.add(alldpass);

        allcreate = new JLabel("Total Credit:");
        allcreate.setBounds(285, 165, 125, 35);
        allcreate.setForeground(Color.black);
        allcreate.setFont(font);
        c.add(allcreate);

        avrgdpass = new JLabel("Average Deposit:");
        avrgdpass.setBounds(285, 210, 125, 35);
        avrgdpass.setForeground(Color.black);
        avrgdpass.setFont(font);
        c.add(avrgdpass);

        avrgcreate = new JLabel("Average Credit:");
        avrgcreate.setBounds(285, 245, 125, 35);
        avrgcreate.setForeground(Color.black);
        avrgcreate.setFont(font);
        c.add(avrgcreate);

       
        saveing1 = new JTextField("");
        saveing1.setBounds(415, 15, 105, 30);
        saveing1.setEnabled(true);

        cheak1 = new JTextField("");
        cheak1.setBounds(415, 50, 105, 30);
        cheak1.setEnabled(true);

        cheakdata = new JTextField("");
        cheakdata.setBounds(415, 85, 105, 30);
        cheakdata.setEnabled(true);

        alldata = new JTextField("");
        alldata.setBounds(415, 130, 105, 30);
        alldata.setEnabled(true);

        allcount = new JTextField("");
        allcount.setBounds(415, 165, 105, 30);
        allcount.setEnabled(true);

        avgdata = new JTextField("");
        avgdata.setBounds(415, 210, 105, 30);
        avgdata.setEnabled(true);

        avgcount = new JTextField("");
        avgcount.setBounds(415, 245, 105, 30);
        avgcount.setEnabled(true);

        c.add(saveing1);
        c.add(cheak1);
        c.add(cheakdata);
        c.add(alldata);
        c.add(allcount);
        c.add(avgdata);
        c.add(avgcount);

        //JButton update, statistics, return1
        update = new JButton("Update");
        update.setBounds(45, 305, 125, 40);

        statistics = new JButton("Statistics");
        statistics.setBounds(225, 305, 125, 40);

        return1 = new JButton("Return");
        return1.setBounds(405, 305, 125, 40);
        return1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();
                Main main = new Main();
                main.setVisible(true);
                main.setResizable(false);
                main.changeButtonStatus1(true);
            }
        });

        c.add(update);
        c.add(statistics);
        c.add(return1);
        c.add(img1);
    }

    public static void main(String[] args) {

        StaticalAnalysis frame = new StaticalAnalysis();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Statistical Analysis Box");

    }

}
