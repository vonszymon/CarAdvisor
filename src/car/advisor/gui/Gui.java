package car.advisor.gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import car.advisor.Feature;
import car.advisor.Features;
import car.advisor.UserPreferences;
import car.advisor.database.CarDatabase;

/**
 * Created by Janusz on 21-11-2016.
 */
public class Gui {

	public static void main(String[] args) {
		Gui.run();
	}

	private static void run() {

		CarDatabase db = new CarDatabase();

		boolean first = true;
		boolean logiczny[] = { true, false };

		JFrame frame = new JFrame();
		JRadioButton radioButton;

		JPanel cenyPanel = new JPanel();
		cenyPanel.setBorder(BorderFactory.createTitledBorder("Budzet"));
		final ButtonGroup cenyGroup = new ButtonGroup();
		for (Feature cena : Features.ceny) {
			cenyPanel.add(radioButton = new JRadioButton(cena.label));
			radioButton.setActionCommand(cena.value);
			radioButton.setText(cena.label);
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			cenyGroup.add(radioButton);
		}

		first = true;
		JPanel pojemnosciSilnikaPanel = new JPanel();
		pojemnosciSilnikaPanel.setBorder(BorderFactory
				.createTitledBorder("Pojemnosc silnika"));
		final ButtonGroup pojemnosciSilnikaGroup = new ButtonGroup();
		for (Feature pojemnoscSilnika : Features.pojemnosciSilnika) {
			pojemnosciSilnikaPanel.add(radioButton = new JRadioButton(
					pojemnoscSilnika.label));
			radioButton.setActionCommand(pojemnoscSilnika.value);
			radioButton.setText(pojemnoscSilnika.label);
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			pojemnosciSilnikaGroup.add(radioButton);
		}

		first = true;
		JPanel bagaznikiPanel = new JPanel();
		bagaznikiPanel.setBorder(BorderFactory.createTitledBorder("Bagaznik"));
		final ButtonGroup bagaznikiGroup = new ButtonGroup();
		for (Feature bagaznik : Features.bagazniki) {
			bagaznikiPanel.add(radioButton = new JRadioButton(bagaznik.label));
			radioButton.setActionCommand(bagaznik.value);
			radioButton.setText(bagaznik.label);
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			bagaznikiGroup.add(radioButton);
		}

		first = true;
		JPanel ilosciMiejscPanel = new JPanel();
		ilosciMiejscPanel.setBorder(BorderFactory
				.createTitledBorder("Ilosc miejsc"));
		final ButtonGroup ilosciMiejscGroup = new ButtonGroup();
		for (Feature iloscMiejsc : Features.ilosciMiejsc) {
			ilosciMiejscPanel.add(radioButton = new JRadioButton(
					iloscMiejsc.label));
			radioButton.setActionCommand(iloscMiejsc.value);
			radioButton.setText(iloscMiejsc.label);
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			ilosciMiejscGroup.add(radioButton);
		}

		first = true;
		JPanel wymiaryPanel = new JPanel();
		wymiaryPanel.setBorder(BorderFactory.createTitledBorder("Wymiary"));
		final ButtonGroup wymiaryGroup = new ButtonGroup();
		for (Feature wymiar : Features.wymiary) {
			wymiaryPanel.add(radioButton = new JRadioButton(wymiar.label));
			radioButton.setActionCommand(wymiar.value);
			radioButton.setText(wymiar.label);
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			wymiaryGroup.add(radioButton);
		}

		first = true;
		JPanel przeznaczenieMiastoPanel = new JPanel();
		przeznaczenieMiastoPanel.setBorder(BorderFactory
				.createTitledBorder("Przeznaczenie - miasto"));
		final ButtonGroup przeznaczenieMiastoGroup = new ButtonGroup();
		for (boolean aLogiczny : logiczny) {
			przeznaczenieMiastoPanel.add(radioButton = new JRadioButton(String
					.valueOf(aLogiczny)));
			radioButton.setActionCommand(String.valueOf(aLogiczny));
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			przeznaczenieMiastoGroup.add(radioButton);
		}

		first = true;
		JPanel przeznaczenieTerenPanel = new JPanel();
		przeznaczenieTerenPanel.setBorder(BorderFactory
				.createTitledBorder("Przeznaczenie - teren"));
		final ButtonGroup przeznaczenieTerenGroup = new ButtonGroup();
		for (boolean aLogiczny : logiczny) {
			przeznaczenieTerenPanel.add(radioButton = new JRadioButton(String
					.valueOf(aLogiczny)));
			radioButton.setActionCommand(String.valueOf(aLogiczny));
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			przeznaczenieTerenGroup.add(radioButton);
		}

		first = true;
		JPanel przeznaczenieTrasaPanel = new JPanel();
		przeznaczenieTrasaPanel.setBorder(BorderFactory
				.createTitledBorder("Przeznaczenie - trasa"));
		final ButtonGroup przeznaczenieTrasaGroup = new ButtonGroup();
		for (boolean aLogiczny : logiczny) {
			przeznaczenieTrasaPanel.add(radioButton = new JRadioButton(String
					.valueOf(aLogiczny)));
			radioButton.setActionCommand(String.valueOf(aLogiczny));
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			przeznaczenieTrasaGroup.add(radioButton);
		}

		first = true;
		JPanel przeznaczenieZazdroscSasiadowPanel = new JPanel();
		przeznaczenieZazdroscSasiadowPanel.setBorder(BorderFactory
				.createTitledBorder("Przeznaczenie - zazdrosc sasiadow"));
		final ButtonGroup przeznaczenieZazdroscSasiadowGroup = new ButtonGroup();
		for (boolean aLogiczny : logiczny) {
			przeznaczenieZazdroscSasiadowPanel
					.add(radioButton = new JRadioButton(String
							.valueOf(aLogiczny)));
			radioButton.setActionCommand(String.valueOf(aLogiczny));
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			przeznaczenieZazdroscSasiadowGroup.add(radioButton);
		}

		first = true;
		JPanel bogateWyposazeniePanel = new JPanel();
		bogateWyposazeniePanel.setBorder(BorderFactory
				.createTitledBorder("Bogate wyposazenie"));
		final ButtonGroup bogateWyposazenieGroup = new ButtonGroup();
		for (boolean aLogiczny : logiczny) {
			bogateWyposazeniePanel.add(radioButton = new JRadioButton(String
					.valueOf(aLogiczny)));
			radioButton.setActionCommand(String.valueOf(aLogiczny));
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			bogateWyposazenieGroup.add(radioButton);
		}

		first = true;
		JPanel komfortJazdyPanel = new JPanel();
		komfortJazdyPanel.setBorder(BorderFactory
				.createTitledBorder("Komfort jazdy"));
		final ButtonGroup komfortJazdyGroup = new ButtonGroup();
		for (boolean aLogiczny : logiczny) {
			komfortJazdyPanel.add(radioButton = new JRadioButton(String
					.valueOf(aLogiczny)));
			radioButton.setActionCommand(String.valueOf(aLogiczny));
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			komfortJazdyGroup.add(radioButton);
		}

		first = true;
		JPanel niskieKosztyEksploatacjiPanel = new JPanel();
		niskieKosztyEksploatacjiPanel.setBorder(BorderFactory
				.createTitledBorder("Niskie koszty eksploatacji"));
		final ButtonGroup niskieKosztyEksploatacjiGroup = new ButtonGroup();
		for (boolean aLogiczny : logiczny) {
			niskieKosztyEksploatacjiPanel.add(radioButton = new JRadioButton(
					String.valueOf(aLogiczny)));
			radioButton.setActionCommand(String.valueOf(aLogiczny));
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			niskieKosztyEksploatacjiGroup.add(radioButton);
		}

		first = true;
		JPanel wysokieOsiagiPanel = new JPanel();
		wysokieOsiagiPanel.setBorder(BorderFactory
				.createTitledBorder("Wysokie osiagi"));
		final ButtonGroup wysokieOsiagiGroup = new ButtonGroup();
		for (boolean aLogiczny : logiczny) {
			wysokieOsiagiPanel.add(radioButton = new JRadioButton(String
					.valueOf(aLogiczny)));
			radioButton.setActionCommand(String.valueOf(aLogiczny));
			if (first) {
				radioButton.setSelected(true);
				first = false;
			}
			wysokieOsiagiGroup.add(radioButton);
		}

		frame.setLayout(new GridLayout(5, 1));
		frame.add(cenyPanel);
		frame.add(pojemnosciSilnikaPanel);
		frame.add(bagaznikiPanel);
		frame.add(ilosciMiejscPanel);
		frame.add(wymiaryPanel);
		frame.add(przeznaczenieMiastoPanel);
		frame.add(przeznaczenieTerenPanel);
		frame.add(przeznaczenieTrasaPanel);
		frame.add(przeznaczenieZazdroscSasiadowPanel);
		frame.add(bogateWyposazeniePanel);
		frame.add(komfortJazdyPanel);
		frame.add(niskieKosztyEksploatacjiPanel);
		frame.add(wysokieOsiagiPanel);

		JPanel carAdvisorPanel = new JPanel();
		JButton chooseButton = new JButton("Szukaj");
		carAdvisorPanel.add(chooseButton);
		frame.add(carAdvisorPanel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);

		UserPreferences preferences = new UserPreferences();

		chooseButton.addActionListener(ae -> {
			preferences.setCena(cenyGroup.getSelection().getActionCommand());
			preferences.setPojemnoscSilnika(pojemnosciSilnikaGroup
					.getSelection().getActionCommand());
			preferences.setBagaznik(bagaznikiGroup.getSelection()
					.getActionCommand());
			preferences.setIloscMiejsc(ilosciMiejscGroup.getSelection()
					.getActionCommand());
			preferences.setWymiary(wymiaryGroup.getSelection()
					.getActionCommand());
			preferences.setPrzeznaczenieMiasto(Boolean
					.valueOf(przeznaczenieMiastoGroup.getSelection()
							.getActionCommand()));
			preferences.setPrzeznaczenieTeren(Boolean
					.valueOf(przeznaczenieTerenGroup.getSelection()
							.getActionCommand()));
			preferences.setPrzeznaczenieTrasa(Boolean
					.valueOf(przeznaczenieTrasaGroup.getSelection()
							.getActionCommand()));
			preferences.setPrzeznaczenieZazdroscSasiadow(Boolean
					.valueOf(przeznaczenieZazdroscSasiadowGroup.getSelection()
							.getActionCommand()));
			preferences.setBogateWyposazenie(Boolean
					.valueOf(bogateWyposazenieGroup.getSelection()
							.getActionCommand()));
			preferences.setKomfortJazdy(Boolean.valueOf(komfortJazdyGroup
					.getSelection().getActionCommand()));
			preferences.setNiskieKosztyEksploatacji(Boolean
					.valueOf(niskieKosztyEksploatacjiGroup.getSelection()
							.getActionCommand()));
			preferences.setWysokieOsiagi(Boolean.valueOf(wysokieOsiagiGroup
					.getSelection().getActionCommand()));
			db.find(preferences);
			String chosenCar = db.find(preferences);
			JOptionPane.showMessageDialog(frame, chosenCar);
		});
	}
}