:- dynamic
    xpozytywne/2,
    xnegatywne/2.

polecam(skoda_citigo) :- klasa(miejskie), pozytywne(ma, miejsc_4),
    					cena(bardzo_niska).

polecam(fiat_tipo) :- klasa(kompaktowe), 
					pozytywne(ma, srednia_pojemnosc_silnika),
					cena(niska).

polecam(seat_leon) :- klasa(kompaktowe),
					pozytywne(ma, srednia_pojemnosc_silnika),
					cena(umiarkowana).

polecam(ford_focus_st) :- klasa(kompaktowe_sportowe),
						pozytywne(ma, miejsc_5),
						pozytywne(ma, bardzo_duza_pojemnosc_silnika),
						cena(wysoka).

polecam(volvo_s80) :- klasa(wyzsza),
					pozytywne(ma, bardzo_duza_pojemnosc_silnika),
    					cena(wysoka).

polecam(renault_espace) :- klasa(wyzsza),
						pozytywne(ma, srednia_pojemnosc_silnika),
							cena(wysoka).

polecam(skoda_octavia) :- klasa(srednia),
						pozytywne(ma, duza_pojemnosc_silnika),
						cena(umiarkowana).

polecam(volkswagen_transporter) :- klasa(van), cena(wysoka).

polecam(dacia_duster) :- klasa(suv),
						pozytywne(ma, miejsc_5),
						pozytywne(ma, obszerny_bagaznik),
						cena(umiarkowana).

polecam(audi_q5) :- klasa(suv),
					pozytywne(ma, miejsc_5),
					pozytywne(ma, obszerny_bagaznik),
					cena(wysoka).

polecam(land_rover_evoque) :- klasa(suv),
							pozytywne(ma, miejsc_5),
							pozytywne(ma, praktyczny_bagaznik),
							cena(bardzo_wysoka).

polecam(alfa_romeo_giulia_qv) :- klasa(sportowe), klasa(wyzsza), cena(wysoka).

polecam(lamborghini_gallardo) :- klasa(sportowe), klasa(luksusowe),
    					cena(bardzo_wysoka).

klasa(miejskie) :- funkcja(miejska_taniocha),
					rozmiar(maly_smerf),
					negatywne(ma, praktyczny_bagaznik).

klasa(mikro) :- funkcja(miejska_taniocha),
				rozmiar(fistaszek),
				negatywne(ma, praktyczny_bagaznik).

klasa(male) :- pozytywne(ma, praktyczny_bagaznik),
				pozytywne(ma, miejsc_4),
				funkcja(miejska_taniocha),
				rozmiar(maly_smerf).

klasa(kompaktowe) :- pozytywne(ma, miejsc_5),
					przeznaczenie(miasto_trasa),
					pozytywne(ma, praktyczny_bagaznik),
					pozytywne(ma, srednie_wymiary).

klasa(kompaktowe_sportowe) :- przeznaczenie(miasto_trasa),
								negatywne(ma, praktyczny_bagaznik),
								pozytywne(ma, srednie_wymiary),
								funkcja(szybka_bestia).

klasa(srednia) :- pozytywne(ma, miejsc_5),
					pozytywne(ma, duze_wymiary),
					funkcja(rodzinne),
					przeznaczenie(miasto_trasa).

klasa(wyzsza) :- klasa(srednia),
				pozytywne(ma, bogate_wyposazenie).

klasa(luksusowe) :- klasa(wyzsza),
					pozytywne(ma, bardzo_duza_pojemnosc_silnika),
					negatywne(ma, niskie_koszty_eksploatacji),
					pozytywne(przeznaczenie, zazdrosc_sasiadow).

klasa(sportowe) :- funkcja(szybka_bestia),
					pozytywne(ma, bardzo_duza_pojemnosc_silnika),
					pozytywne(przeznaczenie, zazdrosc_sasiadow),
					przeznaczenie(miasto_trasa),
    				pozytywne(ma, duze_wymiary).

klasa(terenowe) :- przeznaczenie(teren),
					negatywne(ma, bogate_wyposazenie),
					negatywne(ma, komfort_jazdy),
					negatywne(ma, niskie_koszty_eksploatacji),
    				rozmiar(bulldog).

klasa(suv) :- przeznaczenie(miasto_trasa_teren),
				pozytywne(ma, komfort_jazdy),
				negatywne(ma, niskie_koszty_eksploatacji),
				pozytywne(ma, bogate_wyposazenie),
    			rozmiar(bulldog).

klasa(van) :- przeznaczenie(miasto_trasa),
				pozytywne(ma, miejsc_5_wiecej),
				funkcja(rodzinne),
    			rozmiar(bulldog).

rozmiar(maly_smerf) :- pozytywne(ma, male_wymiary),
					pozytywne(ma, mala_pojemnosc_silnika).

rozmiar(fistaszek) :- pozytywne(ma, bardzo_male_wymiary),
					pozytywne(ma, bardzo_mala_pojemnosc_silnika).

rozmiar(bulldog) :- pozytywne(ma, bardzo_duze_wymiary),
    				pozytywne(ma, bardzo_duza_pojemnosc_silnika).

funkcja(miejska_taniocha) :- przeznaczenie(miasto),
							pozytywne(ma, niskie_koszty_eksploatacji).

funkcja(miejska_taniocha) :- przeznaczenie(miasto),
					negatywne(ma, wysokie_osiagi),
					negatywne(ma, bogate_wyposazenie).

funkcja(szybka_bestia) :- pozytywne(ma, wysokie_osiagi),
					negatywne(ma, niskie_koszty_eksploatacji).

funkcja(rodzinne) :- pozytywne(ma, obszerny_bagaznik),
			pozytywne(ma, komfort_jazdy).

przeznaczenie(miasto_trasa_teren) :- przeznaczenie(miasto_trasa),
						pozytywne(przeznaczenie, trasa).

przeznaczenie(miasto_trasa) :- pozytywne(przeznaczenie, miasto),
					pozytywne(przeznaczenie, trasa).

przeznaczenie(miasto) :- pozytywne(przeznaczenie, miasto),
			negatywne(przeznaczenie, trasa),
			negatywne(przeznaczenie, teren).

przeznaczenie(teren) :- pozytywne(przeznaczenie, teren),
			negatywne(przeznaczenie, miasto),
			negatywne(przeznaczenie, trasa).

cena(bardzo_wysoka) :- pozytywne(ma, bardzo_wysoka_cena).
cena(wysoka) :- cena(bardzo_wysoka); pozytywne(ma, wysoka_cena).
cena(umiarkowana) :- cena(bardzo_wysoka); cena(wysoka); pozytywne(ma, umiarkowana_cena).
cena(niska) :- cena(bardzo_wysoka); cena(wysoka); cena(umiarkowana); pozytywne(ma, niska_cena).
cena(bardzo_niska) :- cena(bardzo_wysoka); cena(wysoka); cena(umiarkowana); cena(niska); pozytywne(ma, bardzo_niska_cena).

pozytywne(X,Y) :- xpozytywne(X,Y), !.

negatywne(X,Y) :- xnegatywne(X,Y), !.

pamietaj(X,Y,tak) :- assertz(xpozytywne(X,Y)).

pamietaj(X,Y,nie) :- assertz(xnegatywne(X,Y)).

wyczysc_fakty :- retractall(xpozytywne(_,_)),
				retractall(xnegatywne(_,_)).