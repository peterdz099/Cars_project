import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowySamochodGUI extends JFrame {
    private JRadioButton benzynaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton a5BiegówRadioButton;
    private JRadioButton a6BiegówRadioButton;
    private JTextField nazwa;
    private JTextField model;
    private JTextField numer;
    private JTextField vMAX;
    private JPanel NowySamochodGUI;
    private JButton dodajButton;
    private JButton anulujButton;
    private JTextField marka;


    public NowySamochodGUI(JComboBox comboBox) {
        setContentPane(NowySamochodGUI);
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Samochod nowy = new Samochod(false,numer.getText(),model.getText(),Integer.valueOf(vMAX.getText()));
                if(a5BiegówRadioButton.isSelected()){
                    int biegi=5;
                    nowy.getSkrzynia().setIloscBiegow(biegi);
                    nowy.getSkrzynia().setNazwa("Manualna 5-bieogwa");
                    nowy.getSkrzynia().setWaga(350);
                }
                if(benzynaRadioButton.isSelected()){
                    nowy.getSilnik().setNazwa("Benzyna");
                    nowy.getSilnik().setWaga(500);
                }
                comboBox.addItem(nowy);

                dispose();
            }
        });
    }

}

