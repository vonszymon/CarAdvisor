:- dynamic
    xpozytywne/2,
    xnegatywne/2.

polecam(skoda_citigo) :- klasa_miejskie(skoda_citigo),
    					bardzo_niska_cena(skoda_citigo).

polecam(fiat_tipo) :- klasa_kompaktowe(fiat_tipo), niska_cena(fiat_tipo).

polecam(seat_leon) :- klasa_kompaktowe(seat_leon), umiarkowana_cena(seat_leon).

polecam(ford_focus_st) :- klasa_kompaktowe_sportowe(ford_focus_st), wysoka_cena(ford_focus_st), miasto_trasa(ford_focus_st).

polecam(volvo_s80) :- klasa_wyzsza(volvo_s80),
    					wysoka_cena(volvo_s80), miasto_trasa(volvo_s80).

polecam(renault_espace) :- klasa_wyzsza(renault_espace), wysoka_cena(renault_espace), miasto_trasa(renault_espace), rodzinne(renault_espace).

polecam(skoda_octavia) :- klasa_srednia(skoda_octavia), umiarkowana_cena(skoda_octavia).

polecam(volkswagen_transporter) :- klasa_van(volkswagen_transporter), wysoka_cena(volkswagen_transporter).

polecam(dacia_duster) :- klasa_suv(dacia_duster), umiarkowana_cena(dacia_duster), miasto_trasa_teren(dacia_duster).

polecam(audi_q5) :- klasa_suv(audi_q5), wysoka_cena(audi_q5), miasto_trasa_teren(audi_q5).

polecam(land_rover_evoque) :- klasa_suv(land_rover_evoque), klasa_luksusowe(land_rover_evoque), bardzo_wysoka_cena(land_rover_evoque).

polecam(alfa_romeo_giulia_qv) :- klasa_sportowe(alfa_romeo_giulia_qv), klasa_wyzsza(alfa_romeo_giulia_qv), wysoka_cena(alfa_romeo_giulia_qv).

polecam(lamborghini_gallardo) :- klasa_sportowe(lamborghini_gallardo), klasa_luksusowe(lamborghini_gallardo),
    					bardzo_wysoka_cena(lamborghini_gallardo).

klasa_miejskie(_) :- miejska_taniocha(_),
					maly_smerf(_),
					negatywne(ma, praktyczny_bagaznik).

klasa_mikro(_) :- miejska_taniocha(_),
				fistaszek(_),
				negatywne(ma, praktyczny_bagaznik).

klasa_male(_) :- pozytywne(ma, praktyczny_bagaznik),
				pozytywne(ma, miejsc_4),
				miejska_taniocha(_),
				maly_smerf(_).

klasa_kompaktowe(_) :- pozytywne(ma, miejsc_5),
					miasto_trasa(_),
					pozytywne(ma, praktyczny_bagaznik),
					pozytywne(ma, srednie_wymiary).

klasa_kompaktowe_sportowe(_) :- miasto_trasa(_),
								negatywne(ma, praktyczny_bagaznik),
								pozytywne(ma, srednie_wymiary),
								szybka_bestia(_).

klasa_srednia(_) :- pozytywne(ma, miejsc_5),
					pozytywne(ma, duze_wymiary),
					rodzinne(_),
					miasto_trasa(_).

klasa_wyzsza(_) :- klasa_srednia(_),
				pozytywne(ma, bogate_wyposazenie).

klasa_luksusowe(_) :- klasa_wyzsza(_),
					pozytywne(ma, duza_pojemnosc_silnika),
					negatywne(ma, niskie_koszty_eksploatacji),
					pozytywne(przeznaczenie, zazdrosc_sasiadow).

klasa_sportowe(_) :- szybka_bestia(_),
					pozytywne(ma, duza_pojemnosc_silnika),
					pozytywne(przeznaczenie, zazdrosc_sasiadow),
					miasto_trasa(_).

klasa_terenowe(_) :- teren(_),
					negatywne(ma, bogate_wyposazenie),
					negatywne(ma, komfort_jazdy),
					negatywne(ma, niskie_koszty_eksploatacji).

klasa_suv(_) :- miasto_trasa_teren(_),
				pozytywne(ma, komfort_jazdy),
				negatywne(ma, niskie_koszty_eksploatacji),
				pozytywne(ma, bogate_wyposazenie).

klasa_van(_) :- miasto_trasa(_),
				pozytywne(ma, miejsc_5_wiecej),
				rodzinne(_).

miejska_taniocha(_) :- miasto(_),
					pozytywne(ma, niskie_koszty_eksploatacji).

miejska_taniocha(_) :- miasto(_),
					negatywne(ma, wysokie_osiagi),
					negatywne(ma, bogate_wyposazenie).

maly_smerf(_) :- pozytywne(ma, male_wymiary).
maly_smerf(_) :- pozytywne(ma, mala_pojemnosc_silnika).

fistaszek(_) :- pozytywne(ma, bardzo_male_wymiary).
fistaszek(_) :-	pozytywne(ma, bardzo_mala_pojemnosc_silnika).

szybka_bestia(_) :- pozytywne(ma, wysokie_osiagi),
					negatywne(ma, niskie_koszty_eksploatacji).

rodzinne(_) :- pozytywne(ma, obszerny_bagaznik),
			pozytywne(ma, komfort_jazdy).

miasto_trasa_teren(_) :- miasto_trasa(_),
						pozytywne(przeznaczenie, trasa).

miasto_trasa(_) :- pozytywne(przeznaczenie, miasto),
					pozytywne(przeznaczenie, trasa).

miasto(_) :- pozytywne(przeznaczenie, miasto),
			negatywne(przeznaczenie, trasa),
			negatywne(przeznaczenie, teren).

teren(_) :- pozytywne(przeznaczenie, teren),
			negatywne(przeznaczenie, miasto),
			negatywne(przeznaczenie, trasa).

bardzo_wysoka_cena(_) :- pozytywne(ma, bardzo_wysoka_cena).
wysoka_cena(_) :- bardzo_wysoka_cena(_); pozytywne(ma, wysoka_cena).
umiarkowana_cena(_) :- bardzo_wysoka_cena(_); wysoka_cena(_); pozytywne(ma, umiarkowana_cena).
niska_cena(_) :-bardzo_wysoka_cena(_); wysoka_cena(_); umiarkowana_cena(_); pozytywne(ma, niska_cena).
bardzo_niska_cena(_) :- bardzo_wysoka_cena(_); wysoka_cena(_); umiarkowana_cena(_); niska_cena(_); pozytywne(ma, bardzo_niska_cena).

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
