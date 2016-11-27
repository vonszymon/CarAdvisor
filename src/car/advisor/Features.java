package car.advisor;

public class Features {

	public static final Feature ceny[] = {
			new Feature("bardzo duzy", "bardzo_wysoka_cena"),
			new Feature("duzy", "wysoka_cena"),
			new Feature("umiarkowany", "umiarkowana_cena"),
			new Feature("maly", "niska_cena"),
			new Feature("bardzo maly", "bardzo_niska_cena") };
	public static final Feature pojemnosciSilnika[] = {
			new Feature("bardzo duza", "bardzo_duza_pojemnosc_silnika"),
			new Feature("duza", "duza_pojemnosc_silnika"),
			new Feature("srednia", "srednia_pojemnosc_silnika"),
			new Feature("mala", "mala_pojemnosc_silnika"),
			new Feature("bardzo mala", "bardzo_mala_pojemnosc_silnika") };
	public static final Feature bagazniki[] = {
			new Feature("maly", "maly_bagaznik"),
			new Feature("obszerny", "obszerny_bagaznik"),
			new Feature("praktyczny", "praktyczny_bagaznik") };
	public static final Feature ilosciMiejsc[] = {
			new Feature("2", "miejsc_2"), new Feature("4", "miejsc_4"),
			new Feature("5", "miejsc_5"), new Feature("5+", "miejsc_5_wiecej") };
	public static final Feature wymiary[] = {
			new Feature("bardzo duze", "bardzo_duze_wymiary"),
			new Feature("duze", "duze_wymiary"),
			new Feature("srednie", "srednie_wymiary"),
			new Feature("male", "male_wymiary"),
			new Feature("bardzo male", "bardzo_male_wymiary") };

}
