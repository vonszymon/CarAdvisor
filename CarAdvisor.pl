:- dynamic
    xpozytywne/2,
    xnegatywne/2.

polecam(skoda_szkoda) :- klasa_miejskie(skoda_szkoda),
    					niska_cena(skoda_szkoda).

polecam(volvo_srolvo) :- klasa_kompaktowe(volvo_srolvo),
    					umiarkowana_cena(volvo_srolvo).

polecam(lambo_bambo) :- klasa_sportowe(lambo_bambo),
    					bardzo_wysoka_cena(lambo_bambo).

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
