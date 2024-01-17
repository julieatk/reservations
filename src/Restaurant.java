
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Restaurant implements ActionListener {

    public ArrayList<Reservation> reservations = new ArrayList<>();

    private JFrame mainFrame;
    private JPanel mainpanel;
    private JPanel panel;
    private JPanel buttonpanel;
    private JPanel userpanel;
    private JButton peopleButton;
    private JButton timeButton;
    private JButton timemadeButton;
    private JTextField insertTime;
    private JTextArea textArea;
    private JTextField insertPeople;
    private JTextField insertname;
    private JButton submit;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;


    public Restaurant() throws IOException {


        addReservation();
        displayReservations();

        mainFrame = new JFrame();

        mainpanel = new JPanel();

        panel = new JPanel();

        buttonpanel = new JPanel();

        userpanel = new JPanel();

        peopleButton = new JButton();
        peopleButton.addActionListener(this);

        timeButton = new JButton();
        timeButton.addActionListener(this);

        timemadeButton = new JButton();
        timemadeButton.addActionListener(this);

        insertTime = new JTextField();
        insertPeople = new JTextField();
        insertname = new JTextField();

        submit = new JButton();

        label1 = new JLabel("Sort by number of people");
        label2 = new JLabel("Sort by time for");
        label3 = new JLabel("Sort by time made");
        label4 = new JLabel("submit");


        textArea = new JTextArea();
        for (int x = 0; x < reservations.size(); x++) {
            textArea.setText(textArea.getText() + reservations.get(x).getInfo() + "\n");

        }

        mainFrame.setSize(1000, 1000);
        int borderSize = 50;
        mainpanel.setLayout(new BorderLayout());
        panel.setLayout(new GridLayout(1, 2));
        buttonpanel.setLayout(new GridLayout(3, 1));
        userpanel.setLayout(new GridLayout(1, 3));


        mainpanel.add(panel, BorderLayout.CENTER);
        panel.add(textArea);
        textArea.setEditable(false);
        panel.add(buttonpanel);
        buttonpanel.add(peopleButton);
        peopleButton.add(label1);
        buttonpanel.add(timeButton);
        timeButton.add(label2);
        buttonpanel.add(timemadeButton);
        timemadeButton.add(label3);
        mainpanel.add(userpanel, BorderLayout.SOUTH);
        userpanel.add(insertname);
        userpanel.add(insertPeople);
        userpanel.add(insertTime);
        userpanel.add(submit);
        submit.add(label4);


        try {
            BufferedImage image = ImageIO.read(new File("src/image.png"));

            JLabel imagelabel = new JLabel(new ImageIcon(image));

            imagelabel.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

            mainpanel.add(imagelabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mainpanel.setLayout(new FlowLayout());

        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainpanel);
        frame.setSize(1500, 800); // Set an appropriate size
        frame.setVisible(true);


}



    public void addReservation() {
        reservations.add(new Reservation());
        reservations.add(new Reservation());
        reservations.add(new Reservation());
        reservations.add(new Reservation());

    }

    public void displayReservations() {
        System.out.println("**********");
        for (Reservation r : reservations) {
            r.printInfo();
        }

    }


    public void sortByTimeFor() {
        //bubble
        for (int y = 1; y < reservations.size(); y++) {
            for (int x = 1; x < reservations.size(); x++) {
                if (reservations.get(x - 1).timeFor > reservations.get(x).timeFor) {
                    Reservation temp = reservations.get(x);
                    reservations.set(x, reservations.get(x - 1));
                    reservations.set(x - 1, temp);
                }

            }
        }
    }


    public void sortByNPeople() {
        //selection
        int n = reservations.size();

        for (int x = 0; x < n - 1; x++) {
            int min = x;
            for (int j = x + 1; j < n; j++) {
                if (reservations.get(j).NPeople < reservations.get(min).NPeople) {
                    min = j;
                }
            }
            Reservation temp = reservations.get(x);
            reservations.set(x, reservations.get(min));
            reservations.set(min, temp);
        }
    }




    public void sortByTimeMade() {
        //insertion
        int n = reservations.size();

        for (int x = 1; x < n; x++) {
            int j = x;
            Reservation stored = reservations.get(x);

            while (j > 0 && stored.timeMade < reservations.get(j - 1).timeMade) {
                reservations.set(j, reservations.get(j - 1));
                j--;
            }

            reservations.set(j, stored);
        }
    }





    public static void main(String[] args) throws IOException {
        Restaurant Oleana = new Restaurant();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object buttonClicked = e.getSource();
        if (buttonClicked == peopleButton) {
            System.out.println("Sort people button clicked");
            sortByNPeople();
            displayReservations();
            textArea.setText("");
            for (int x = 0; x < reservations.size(); x++) {
                textArea.setText(textArea.getText() + reservations.get(x).getInfo() + "\n");


            }
        }

        if (buttonClicked == timeButton) {
            System.out.println("Sort time button clicked");
            sortByTimeFor();
            displayReservations();
            textArea.setText("");
            for (int x = 0; x < reservations.size(); x++) {
                textArea.setText(textArea.getText() + reservations.get(x).getInfo() + "\n");
            }
        }

        if (buttonClicked == timemadeButton) {
            System.out.println("Sort time made button clicked");
            sortByTimeMade();
            displayReservations();
            textArea.setText("");
            for (int x = 0; x < reservations.size(); x++) {
                textArea.setText(textArea.getText() + reservations.get(x).getInfo() + "\n");
            }
        }
    }
}







