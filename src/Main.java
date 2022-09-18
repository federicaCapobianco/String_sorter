import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame implements ActionListener {
    String inputFileName;
    String outputFileName;
    public Main() {
        super("Test using JFilePicker");

        setLayout(new FlowLayout());

        // set up a file picker component
        JFilePicker filePicker = new JFilePicker("Input file: ", "Browse...");
        filePicker.setMode(JFilePicker.MODE_SAVE);
        filePicker.addFileTypeFilter(".txt", "text files");

        // set up a file picker component
        JFilePicker filePicker2 = new JFilePicker("Output file: ", "Browse...");
        filePicker2.setMode(JFilePicker.MODE_SAVE);
        filePicker2.addFileTypeFilter(".txt", "text files");

        // access JFileChooser class directly
        JFileChooser fileChooser = filePicker.getFileChooser();
        fileChooser.setCurrentDirectory(new File("D:/"));

        // access JFileChooser class directly
        JFileChooser fileChooser2 = filePicker2.getFileChooser();
        fileChooser2.setCurrentDirectory(new File("D:/"));


        //add a compute button
        JButton sort = new JButton("Sort");

        /*
        //add action to sort button
        sort.addActionListener(this);
        sort.setActionCommand("Sort");
        */

        sort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //INPUT FILE
                System.out.println(filePicker.getPath());
                //OUTPUT FILE
                System.out.println(filePicker2.getPath());


                StringSorter ss = new StringSorter();

                //read the strings from the file
                try {
                    ss.read(filePicker.getPath());
                } catch (IOException a) {
                    throw new RuntimeException(a);
                }

                ss.sortStrings(ss.list.size());

                try {
                    //works locally but not on desktop why??
                    ss.write(filePicker2.getPath());
                } catch (IOException a) {
                    throw new RuntimeException(a);
                }
            }
        });


        // add the component to the frame
        add(filePicker);
        add(filePicker2);
        add(sort);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setLocationRelativeTo(null);    // center on screen
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Sort")) {

            System.out.println(inputFileName);

            StringSorter ss = new StringSorter();

            //read the strings from the file
            try {
                ss.read("src/test.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ss.sortStrings(ss.list.size());

            try {
                ss.write("src/sorted.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

}