:- dynamic
    xpozytywne/2,
    xnegatywne/2.

polecam(skoda_citigo) :- klasa(miejskie),
    					cena(bardzo_niska).

polecam(fiat_tipo) :- klasa(kompaktowe), cena(niska).

polecam(seat_leon) :- klasa(kompaktowe), cena(umiarkowana).

polecam(ford_focus_st) :- klasa(kompaktowe_sportowe), cena(wysoka).

polecam(volvo_s80) :- klasa(wyzsza),
    					cena(wysoka).

polecam(renault_espace) :- klasa(wyzsza), cena(wysoka).

polecam(skoda_octavia) :- klasa(srednia), cena(umiarkowana).

polecam(volkswagen_transporter) :- klasa(van), cena(wysoka).

polecam(dacia_duster) :- klasa(suv), cena(umiarkowana).

polecam(audi_q5) :- klasa(suv), cena(wysoka).

polecam(land_rover_evoque) :- klasa(suv), klasa(luksusowe), cena(bardzo_wysoka).

polecam(alfa_romeo_giulia_qv) :- klasa(sportowe), klasa(wyzsza), cena(wysoka).

polecam(lamborghini_gallardo) :- klasa(sportowe), klasa(luksusowe),
    					cena(bardzo_wysoka).

klasa_miejskie(_) :- funkcja(miejska_taniocha),
					rozmiar(maly_smerf),
					negatywne(ma, praktyczny_bagaznik).

klasa_mikro(_) :- funkcja(miejska_taniocha),
				rozmiar(fistaszek),
				negatywne(ma, praktyczny_bagaznik).

klasa_male(_) :- pozytywne(ma, praktyczny_bagaznik),
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
					pozytywne(ma, duza_pojemnosc_silnika),
					negatywne(ma, niskie_koszty_eksploatacji),
					pozytywne(przeznaczenie, zazdrosc_sasiadow).

klasa(sportowe) :- funkcja(szybka_bestia),
					pozytywne(ma, duza_pojemnosc_silnika),
					pozytywne(przeznaczenie, zazdrosc_sasiadow),
					przeznaczenie(miasto_trasa).

klasa(terenowe) :- przeznaczenie(teren),
					negatywne(ma, bogate_wyposazenie),
					negatywne(ma, komfort_jazdy),
					negatywne(ma, niskie_koszty_eksploatacji).

klasa(suv) :- przeznaczenie(miasto_trasa_teren),
				pozytywne(ma, komfort_jazdy),
				negatywne(ma, niskie_koszty_eksploatacji),
				pozytywne(ma, bogate_wyposazenie).

klasa(van) :- przeznaczenie(miasto_trasa),
				pozytywne(ma, miejsc_5_wiecej),
				funkcja(rodzinne).

rozmiar(maly_smerf) :- pozytywne(ma, male_wymiary).
rozmiar(maly_smerf) :- pozytywne(ma, mala_pojemnosc_silnika).

rozmiar(fistaszek) :- pozytywne(ma, bardzo_male_wymiary).
rozmiar(fistaszek) :- pozytywne(ma, bardzo_mala_pojemnosc_silnika).

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

pozytywne(X,Y) :- \+xnegatywne(X,Y), pytaj(X,Y,tak).

negatywne(X,Y) :- xnegatywne(X,Y), !.

negatywne(X,Y) :- \+xpozytywne(X,Y), pytaj(X,Y,nie).

pytaj(X,Y,tak) :- !, format('~w : ~w ? (t/n)~n',[X,Y]),
                    read(Reply),
                    (Reply = 't'),
                    pamietaj(X,Y,tak).

pytaj(X,Y,nie) :- !, format('~w : ~w ? (t/n)~n',[X,Y]),
                    read(Reply),
                    (Reply = 'n'),
                    pamietaj(X,Y,nie).

pamietaj(X,Y,tak) :- assertz(xpozytywne(X,Y)).

pamietaj(X,Y,nie) :- assertz(xnegatywne(X,Y)).

wyczysc_fakty :- write('Przycisnij cos aby wyjsc'), nl,
                    retractall(xpozytywne(_,_)),
                    retractall(xnegatywne(_,_)),
                    get_char(_).

wykonaj :- polecam(X), !,
            format('~nPolecam samochod ~w', X),
            nl, wyczysc_fakty.

wykonaj :- write('Ogarnij sie. Taki samochod nie istnieje'), nl,
            wyczysc_fakty.