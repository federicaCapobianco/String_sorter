import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        //create a popup window
        //Creating the Frame
        JFrame frame = new JFrame("String Sorter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);


        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        JLabel label = new JLabel("Input File:");
        JTextField tf = new JTextField(10); // accepts upto 10 characters

        JLabel label2 = new JLabel("Output File:");
        JTextField tf2 = new JTextField(10); // accepts upto 10 characters

        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");

        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);

        panel2.add(label2); // Components Added using Flow Layout
        panel2.add(tf2);

        panel3.add(send);
        panel3.add(reset);


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, panel2);
        frame.getContentPane().add(BorderLayout.SOUTH, panel3);

        frame.setVisible(true);

        StringSorter ss = new StringSorter();

        //read the strings from the file
        ss.read("src/test.txt");

        ss.sortStrings(ss.list.size());

        ss.write("src/sorted.txt");
    }

}