package car.advisor.database;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;

import car.advisor.UserPreferences;

import com.google.common.collect.ImmutableMap;

public class CarDatabase {

	private final Map<Boolean, String> boolString;

	public CarDatabase() {
		boolString = ImmutableMap.of(true, "tak", false, "nie");
		new Query("consult", new Term[] { new Atom("car-db.pl") })
				.hasSolution();
	}

	public String find(UserPreferences prefs) {
		clearPreferences();
		setPreferences(prefs);
		return findMatching();
	}

	private void setPreferences(UserPreferences prefs) {
		setPrzeznaczenieMiasto(prefs.isPrzeznaczenieMiasto());
		setPrzeznaczenieTrasa(prefs.isPrzeznaczenieTrasa());
		setPrzeznaczenieTeren(prefs.isPrzeznaczenieTeren());
		setPrzeznaczenieZazdrosc(prefs.isPrzeznaczenieZazdroscSasiadow());
		setBogateWyposazenie(prefs.isBogateWyposazenie());
		setKomfortJazdy(prefs.isKomfortJazdy());
		setKosztyEksploatacji(prefs.isNiskieKosztyEksploatacji());
		setWysokieOsiagi(prefs.isWysokieOsiagi());
		setBagaznik(prefs.getBagaznik());
		setDuzyZasieg(prefs.maDuzyZasieg());
		setMultiFeature(prefs.getCena());
		setMultiFeature(prefs.getIloscMiejsc());
		setMultiFeature(prefs.getPojemnoscSilnika());
		setMultiFeature(prefs.getWymiary());
		setMultiFeature(prefs.getTypSilnika());
	}

	private void clearPreferences() {
		new Query("wyczysc_fakty").hasSolution();
	}

	private String findMatching() {
		Query searchCar = new Query("polecam(X)");
		Map<String, Term> solutions[] = searchCar.allSolutions();
		List<String> distinctResult = new LinkedList<>();
		for (Map<String, Term> solution : solutions) {
			String name = solution.get("X").name();
			if (!distinctResult.contains(name))
				distinctResult.add(name);
		}
		String resultString = "Znaleziono " + distinctResult.size()
				+ " samochody:\n";
		for (String name : distinctResult) {
			resultString += name + "\n";
		}
		return resultString;
	}

	private void setPrzeznaczenieMiasto(Boolean value) {
		new Query("pamietaj", new Term[] { new Atom("przeznaczenie"),
				new Atom("miasto"), new Atom(boolString.get(value)) })
				.hasSolution();
	}

	private void setPrzeznaczenieTrasa(Boolean value) {
		new Query("pamietaj", new Term[] { new Atom("przeznaczenie"),
				new Atom("trasa"), new Atom(boolString.get(value)) })
				.hasSolution();
	}

	private void setPrzeznaczenieTeren(Boolean value) {
		new Query("pamietaj", new Term[] { new Atom("przeznaczenie"),
				new Atom("teren"), new Atom(boolString.get(value)) })
				.hasSolution();
	}

	private void setPrzeznaczenieZazdrosc(Boolean value) {
		new Query("pamietaj",
				new Term[] { new Atom("przeznaczenie"),
						new Atom("zazdrosc_sasiadow"),
						new Atom(boolString.get(value)) }).hasSolution();
	}

	private void setBogateWyposazenie(Boolean value) {
		new Query("pamietaj",
				new Term[] { new Atom("ma"), new Atom("bogate_wyposazenie"),
						new Atom(boolString.get(value)) }).hasSolution();
	}

	private void setKomfortJazdy(Boolean value) {
		new Query("pamietaj", new Term[] { new Atom("ma"),
				new Atom("komfort_jazdy"), new Atom(boolString.get(value)) })
				.hasSolution();
	}

	private void setKosztyEksploatacji(Boolean value) {
		new Query("pamietaj", new Term[] { new Atom("ma"),
				new Atom("niskie_koszty_eksploatacji"),
				new Atom(boolString.get(value)) }).hasSolution();
	}

	private void setWysokieOsiagi(Boolean value) {
		new Query("pamietaj", new Term[] { new Atom("ma"),
				new Atom("wysokie_osiagi"), new Atom(boolString.get(value)) })
				.hasSolution();
	}

	private void setDuzyZasieg(Boolean value) {
		new Query("pamietaj", new Term[] { new Atom("ma"),
				new Atom("duzy_zasieg"), new Atom(boolString.get(value)) })
				.hasSolution();
	}

	private void setBagaznik(String value) {
		if (value.equals("maly_bagaznik"))
			new Query("pamietaj", new Term[] { new Atom("ma"),
					new Atom("praktyczny_bagaznik"), new Atom("nie") })
					.hasSolution();
		else
			setMultiFeature(value);
	}

	private void setMultiFeature(String value) {
		new Query("pamietaj", new Term[] { new Atom("ma"), new Atom(value),
				new Atom("tak") }).hasSolution();
	}
}
