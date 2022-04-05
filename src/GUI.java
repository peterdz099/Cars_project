import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InterruptedIOException;

public class GUI extends Thread {

    private Samochod s = new Samochod();
    private JPanel panel1;
    private JButton wlaczButton;
    private JButton wylaczButton;
    private JTextField textSamModel;
    private JTextField textSamNumer;
    private JTextField textSamWaga;
    private JTextField textSamPredkosc;
    private JButton dodajNowyButton;
    private JTextField textSkWaga;
    private JTextField textSkNazwa;
    private JButton zmniejszBiegButton;
    private JButton zwiekszBiegButton;
    private JTextField textSkCena;
    private JTextField textSkBieg;
    private JButton dodajGazuButton;
    private JButton ujmijGazuButton;
    private JTextField textS_obroty;
    private JTextField textS_nazwa;
    private JTextField textS_cena;
    private JTextField textS_waga;
    private JButton nacisnijButton;
    private JTextField textSpWaga;
    private JTextField textSpStan;
    private JTextField textSpNazwa;
    private JButton zwolnijButton;
    private JTextField textSpCena;
    private JComboBox comboBox1;
    private JPanel Mapa;
    private JLabel autko;
    private JButton usuńButton;
    private JPanel map;
    private int count = 0;

    public void run() {
        while (true) {
            refresh();
            //System.out.println("XXX");
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public GUI() {
        start();
        wlaczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.wlacz();
                refresh();
            }
        });
        wylaczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.wylacz();
                refresh();
            }
        });

        zwiekszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getSkrzynia().zwiekszBieg();
                refresh();
            }
        });
        zmniejszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getSkrzynia().zmniejszBieg();
                refresh();
            }
        });
        dodajGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getSilnik().zwiekszObroty();
                refresh();
            }
        });
        ujmijGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getSilnik().zmniejszObroty();
                refresh();
            }
        });
        nacisnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getSkrzynia().sprzeglo.wcisnij();
                refresh();
            }
        });
        zwolnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.getSkrzynia().sprzeglo.zwolnij();
                refresh();
            }
        });
        dodajNowyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NowySamochodGUI(comboBox1);
                f.pack();
                f.setVisible(true);
            }
        });

        Mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                s.jedzDo(new Pozycja(e.getX()-25, e.getY()-25));
                refresh();
            }

        });

        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.interrupt();
                comboBox1.removeItem(s);
                refresh();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = (Samochod) comboBox1.getSelectedItem();
                refresh();
            }
        });
    }

    public void refresh(){
        //int a=1;
        if(comboBox1.getSelectedIndex() != -1){
            textSamModel.setText(s.getModel());
            textSamNumer.setText(s.getNumerRejestracyjny());
            textSamWaga.setText(Integer.toString(s.getWaga()));
            textSamPredkosc.setText(Double.toString(s.getAktPredkosc()));

            textSkNazwa.setText(s.getSkrzynia().getNazwa());
            textSkBieg.setText(Integer.toString(s.getSkrzynia().getAktualnyBieg()));
            textSkCena.setText(Integer.toString(s.getSkrzynia().getCena()));
            textSkWaga.setText(Integer.toString(s.getSkrzynia().getWaga()));

            textS_nazwa.setText(s.getSilnik().getNazwa());
            textS_obroty.setText(Integer.toString(s.getSilnik().getObroty()));
            textS_waga.setText(Integer.toString(s.getSilnik().getWaga()));
            textS_cena.setText(Integer.toString(s.getSilnik().getCena()));

            textSpCena.setText(Integer.toString(s.getSkrzynia().sprzeglo.getCena()));
            textSpWaga.setText(Integer.toString(s.getSkrzynia().sprzeglo.getWaga()));
            textSpStan.setText(Boolean.toString(s.getSkrzynia().sprzeglo.isStanSprzegla()));
            textSpNazwa.setText(s.getSkrzynia().sprzeglo.getNazwa());
            autko.setVisible(true);

            autko.setLocation((int) s.getAktPozycja().getX(), (int) s.getAktPozycja().getY());
        }else{
            textSamModel.setText("");
            textSamNumer.setText("");
            textSamWaga.setText("");
            textSamPredkosc.setText("");

            textSkNazwa.setText("");
            textSkBieg.setText("");
            textSkCena.setText("");
            textSkWaga.setText("");

            textS_nazwa.setText("");
            textS_obroty.setText("");
            textS_waga.setText("");
            textS_cena.setText("");

            textSpCena.setText("");
            textSpWaga.setText("");
            textSpStan.setText("");
            textSpNazwa.setText("");
            autko.setVisible(false);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
