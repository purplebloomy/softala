INSERT INTO Paikka
(paikka_id, hloMaara, lisatiedot)
VALUES
(5009, 999, 'taulutussit korvattu simpukoilla');

INSERT INTO Opettaja
(etunimi, sukunimi, puhNro, email, lisatiedot)
VALUES
('Katka', 'Rapunen', 0401337101, 'katka.rapunen@pitkaleka.com', 'Palkka maksetaan katkarapuina');

INSERT INTO Kouluttaja
(etunimi, sukunimi, puhNro, email, lisatiedot)
VALUES
('Tuhka', 'Tomaattikastike', 050101337, 'tuhka.tomaattikastike@makaroni.com', 'Kouluttajan kohtalo on muuttua kastikkeeksi');

INSERT INTO Koulutus
(pvm, alkamisaika, paattymisaika, paikka, aihe, kuvaus, opettaja)
VALUES
('2015-09-08', '13:37', '13:38', 5009, 'Katkarapujen koulutus', 'Luento kertoo syv�llisesti katkarapujen sielunel�m�st�', 1);

INSERT INTO koulutus
(pvm, alkamisaika, paattymisaika, paikka, aihe, kuvaus, opettaja)
VALUES
('2014-10-27', '14:45', '15:15', 5009, 'Pizzanpy�ritys', 'Opetellaan tekem��n erilaisia pizzoja', 1);

INSERT INTO koulutus
(pvm, alkamisaika, paattymisaika, paikka, aihe, kuvaus, opettaja)
VALUES
('2018-03-22', '16:00', '18:00', 5009, 'Hajoamisen ensiasteet', 'Harjoitellaan Githubin k�ytt�� ja todenn�k�isesti hajotaan siihen', 1);

INSERT INTO koulutus
(pvm, alkamisaika, paattymisaika, paikka, aihe, kuvaus, opettaja)
VALUES
('2016-01-01', '10:00', '12:00', 5001, 'P�iv�unien lyhyt oppim��r�', 'Pohditaan, mit� hy�tyj� ja haittoja p�iv�unista on... ja ehk� nukutaan', 1);

INSERT INTO koulutus
(pvm, alkamisaika, paattymisaika, paikka, aihe, kuvaus, opettaja)
VALUES
('2016-02-14', '14:00', '18:00', 5001, 'Pussailun pitk� oppim��r�', 'Pussailun harjoittelua, ota mukaan oma parisi', 1);

INSERT INTO Koulutuksen_kouluttajat
(koulutus_id, kouluttaja_id)
VALUES
(1, 2);