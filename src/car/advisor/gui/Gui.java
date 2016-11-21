package car.advisor.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.ButtonGroup;

/**
 * Created by Janusz on 21-11-2016.
 */
public class Gui {
    protected static void run () {
        String ceny[] = { "bardzo_wysoka", "wysoka", "umiarkowana", "niska","bardzo_niska" };
        String przeznaczenia[] = { "miasto_trasa_teren", "miasto_trasa", "miasto", "teren", "trasa" };
        String funkcje[] = { "miejska_taniocha", "szybka_bestia", "rodzinne" };
        String rozmiary[] = { "maly_smerf", "fistaszek" };

        JFrame frame = new JFrame();
        JRadioButton radioButton;

        JPanel cenyPanel = new JPanel();
        cenyPanel.setBorder(BorderFactory.createTitledBorder("Cena"));
        final ButtonGroup cenyGroup = new ButtonGroup();
        for (int i = 0; i < ceny.length; i++) {
            cenyPanel.add(radioButton = new JRadioButton(ceny[i]));
            radioButton.setActionCommand(ceny[i]);
            cenyGroup.add(radioButton);
        }

        JPanel przeznaczeniaPanel = new JPanel();
        przeznaczeniaPanel.setBorder(BorderFactory.createTitledBorder("Przeznaczenie"));
        final ButtonGroup przeznaczeniaGroup = new ButtonGroup();
        for (int i = 0; i < przeznaczenia.length; i++) {
            przeznaczeniaPanel.add(radioButton = new JRadioButton(przeznaczenia[i]));
            radioButton.setActionCommand(przeznaczenia[i]);
            przeznaczeniaGroup.add(radioButton);
        }

        JPanel funkcjePanel = new JPanel();
        funkcjePanel.setBorder(BorderFactory.createTitledBorder("Funkcja"));
        final ButtonGroup funkcjeGroup = new ButtonGroup();
        for (int i = 0; i < funkcje.length; i++) {
            funkcjePanel.add(radioButton = new JRadioButton(funkcje[i]));
            radioButton.setActionCommand(funkcje[i]);
            funkcjeGroup.add(radioButton);
        }

        JPanel rozmiaryPanel = new JPanel();
        rozmiaryPanel.setBorder(BorderFactory.createTitledBorder("Rozmiar"));
        final ButtonGroup rozmiaryGroup = new ButtonGroup();
        for (int i = 0; i < rozmiary.length; i++) {
            rozmiaryPanel.add(radioButton = new JRadioButton(rozmiary[i]));
            radioButton.setActionCommand(rozmiary[i]);
            rozmiaryGroup.add(radioButton);
        }

        frame.setLayout(new GridLayout(5, 1));
        frame.add(cenyPanel);
        frame.add(przeznaczeniaPanel);
        frame.add(funkcjePanel);
        frame.add(rozmiaryPanel);
        JPanel carAdvisorPanel = new JPanel();
        JButton chooseButton = new JButton("Wybierz");
        carAdvisorPanel.add(chooseButton);
        frame.add(carAdvisorPanel);

        chooseButton.addActionListener(ae -> {
            String cena = cenyGroup.getSelection().getActionCommand();
            String przeznaczenie = przeznaczeniaGroup.getSelection().getActionCommand();
            String funkcja = funkcjeGroup.getSelection().getActionCommand();
            String rozmiar = rozmiaryGroup.getSelection().getActionCommand();
            try {
                System.out.println("Cena " + cena + " przeznaczenie " + przeznaczenie + " funkcja " + funkcja + " rozmiar " + rozmiar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}