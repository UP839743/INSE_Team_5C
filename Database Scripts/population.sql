USE FDB;

INSERT INTO Club (CLUBID, CLUBNAME, MANAGER, STADIUM, CLUBPOSITION) VALUES
  (1, "Arsenal", "Aresene Wenger", "Emirates", 6),
  (2, "Chelsea", "Antonio Conte", "Stamford Bridge", 4),
  (3, "Manchester City", "Pep Guardiola", "The Etihad Arena", 1),
  (4, "Tottenham Hotspur", "Maurizio Pochettino", "White Heart Lane", 5)
;

INSERT INTO Player (CLUBID, FNAME, LNAME, SQUADNO, PLAYERPOSITION, HEIGHT, PREFFOOT, DOB, CLUBAPPS, SEASONAPPS, NATIONALITY, CLUBGOALS, SEASONGOALS, CLEANSHEETS) VALUES
  (1, "Petr", "Cech", 33, "GK", "6f4", "L", '1982-10-05', 105, 26, "Czech", 0, 0, 10),
  (1, "Per", "Mertesacker", 4, "DEF", "6f5", "R", '1984-09-29', 220, 11, "Germany", 10, 2, 0),
  (1, "Laurent", "Koscielny", 6, "DEF", "6f1", "R", '1985-09-10', 311, 20, "France", 23, 1, 0),
  (1, "Rob", "Holding", 16, "DEF", "6f1", "R",  '1995-09-20', 37, 19, "England", 1, 1, 0),
  (1, "Nacho", "Monreal", 18, "DEF", "5f9", "R", '1986-02-26', 197, 23, "Spain", 6, 3, 0),
  (1, "Shkodran", "Mustafi", 20, "DEF", "6f0", "L", '1992-04-17', 55, 18, "Germany", 4, 2, 0),
  (1, "Hector", "Bellerin", 24, "DEF", "5f8", "R", '1995-03-19', 143, 28, "Spain", 7, 3, 0),
  (1, "Sead", "Kolasinac", 31, "DEF", "6f0", "R", '1993-06-20', 22, 18, "Bosnia", 3, 3, 0),
  (1, "Henrikh", "Mkhitaryan", 7, "MID", "5f8", "L", '1989-01-21', 1, 1, "Armenia", 0, 0, 0),
  (1, "Aaron", "Ramsey", 9, "MID", "5f10", "B", '1990-12-26', 317, 18, "Wales", 51, 3, 0),
  (1, "Jack", "Wilshere", 10, "MID", "5f8", "B", '1992-01-01', 183, 23, "England", 14, 2, 0),
  (1, "Mesut", "Ozil", 11, "MID", "5f11", "L", '1988-10-15', 182, 21, "Germany", 36, 4, 0),
  (1, "Santi", "Cazorla", 19, "MID", "5f6", "L", '1984-12-13', 180, 0, "Spain", 29, 0, 0),
  (1, "Granit", "Xhaka", 29, "MID", "6f1", "B", '1992-09-27', 74, 28, "Switzerland", 6, 2, 0),
  (1, "Mohamed", "Elneny", 35, "MID", "5f11", "L", '1992-07-11', 60, 20, "Egypt", 2, 1, 0),
  (1, "Alexandre", "Lacazette", 9, "FWD", "5f9", "R", '1991-05-28', 28, 28, "France", 9, 9, 0),
  (1, "Alex", "Iwobi", 17, "FWD", "6f0", "R", '1996-05-03', 82, 23, "Nigeria", 8, 2, 0),
  (1, "Danny", "Welbeck", 23, "FWD", "6f0", "R", '1990-11-26', 91, 22, "England", 22, 5, 0),
  (1, "David", "Ospina", 13, "GK", "6f0", "R", '1988-08-31', 58, 9, "Columbia", 0, 0, 4),
  (1, "Pierre-Emerick", "Aubameyang", 14, "FWD", "6f0", "R", '1989-06-18', 0, 0, "Gabon", 0, 0, 0),
  (2, "Thibaut", "Courtois", 13, "GK", "6f5", "L", '1992-5-11', 139, 23, "Belgium", 0, 0, 12),
  (2, "Marcos", "Alonso", 3, "DEF", "6f2", "R", '1990-12-28', 68, 33, "Spain", 13, 7, 0),
  (2, "Antonio", "Ruediger", 2, "DEF", "6f3", "R", '1993-03-03', 29, 29, "Germany", 3, 3, 0),
  (2, "Andreas", "Christensen", 27, "DEF", "6f2", "R", '1996-04-10', 31, 28, "Denmark", 0, 0, 0),
  (2, "Cesar", "Azpilicueta", 28, "DEF", "5f10", "R", '1989-08-28', 261, 33, "Spain", 7, 2, 0),
  (2, "Victor", "Moses", 15, "DEF", "5f9", "R", '1990-12-12', 106, 22, "Nigerian", 16, 2, 0),
  (2, "Tiemoue", "Bakayoko", 14, "MID", "6f2", "R", '1994-08-17', 33, 33, "France", 3, 3, 0),
  (2, "NGolo", "Kante", 7, "MID", "5f6", "R", '1991-03-29', 71, 21, "France", 3, 1, 0),
  (2, "Eden", "Hazard", 10, "FWD", "5f8", "B", '1991-1-7', 281, 32, "Belgium", 84, 12, 0),
  (2, "Willian", "", 22, "FWD", "5f8", "R", '1988-08-09', 218, 37, "Brazil", 39, 8, 0),
  (2, "Alvaro", "Morata", 9, "FWD", "6f1", "R", '1992-10-23', 31, 31, "Spain", 12, 12, 0),
  (2, "David", "Luiz", 30, "DEF", "6f2", "B", '1987-04-22', 197, 16, "Brazil", 15, 2, 0),
  (2, "Ross", "Barkley", 8, "MID", "6f1", "R", '1993-12-5', 2, 2, "England", 0, 0, 0),
  (2, "Cesc", "Fabregas", 4, "MID", "5f11", "R", '1987-5-4', 164, 31, "Spain", 20, 2, 0),
  (2, "Pedro", "", 11, "FWD", "5f8", "B", '1987-7-28', 113, 30, "Spain", 26, 5, 0),
  (2, "Danny", "Drinkwater", 6, "MID", "5f10", "R", '1990-3-5', 18, 18, "England", 1, 1, 0),
  (2, "Olivier", "Giroud", 18, "FWD", "6f3", "L", '1986-9-30', 0, 0, "France", 0, 0, 0),
  (2, "Gary", "Cahill", 24, "DEF", "6f4", "R", '1985-12-19', 268, 29, "England", 25, 0, 0),
  (2, "Davide", "Zappacosta", 21, "DEF", "5f11", "R", '1992-6-11', 25, 25, "Italy", 2, 2, 0),
  (2, "Willy", "Caballero", 1, "GK", "6f1", "R", '1981-9-28', 8, 8, "Argentina", 0, 0, 3),
  (3, "Claudio", "Bravo", 1, "GK", "6f0", "R", '1983-4-13', 38, 8, "Chile", 0, 0, 3),
  (3, "Ederson", "", 31, "GK", "6f2", "L", '1993-8-17', 31, 31, "Brazil", 0, 0, 15),
  (3, "Benjamin", "Mendy", 22, "DEF", "6f0", "L", '1994-7-17', 5, 5, "France", 1, 1, 0),
  (3, "Danilo", "", 3, "DEF", "6f0", "R", '1991-7-15', 24, 24, "Brazil", 1, 1, 0),
  (3, "Kyle", "Walker", 2, "DEF", "5f11", "R", '1990-5-28', 34, 34, "England", 0, 0, 0),
  (3, "John", "Stones", 5, "DEF", "6f2", "R", '1994-5-24', 65, 24, "England", 5, 3, 0),
  (3, "Nicolas", "Otamendi", 30, "DEF", "6f0", "R", '1988-2-12', 124, 32, "Argentina", 7, 5, 0),
  (3, "Vincent", "Kompany", 4, "DEF", "6f4", "R", '1986-4-10', 323, 10, "Belgium", 17, 0, 0),
  (3, "Ilkay", "Gundogan", 8, "MID", "5f11", "R", '1990-10-24', 45, 29, "German", 7, 2, 0),
  (3, "Kevin", "De Bruyne", 17, "MID", "5f11", "R", '1991-6-28', 125, 35, "Belgium", 34, 11, 0),
  (3, "Fabian", "Delph", 18, "MID", "5f8", "L", '1989-11-21', 61, 21, "England", 5, 1, 0),
  (3, "Bernardo", "Silva", 20, "MID", "5f8", "L", '1994-8-10', 36, 36, "Portugal", 4, 4, 0),
  (3, "Fernandinho", "", 25, "MID", "5f9", "R", '1985-04-05', 217, 34, "Brazil", 20, 3, 0),
  (3, "David", "Silva", 21, "MID", "5f7", "L", '1986-01-08', 333, 27, "Spain", 56, 5, 0),
  (3, "Yaya", "Toure", 42, "MID", "6f1", "R", '1983-05-13', 310, 11, "Ivory Coast", 79, 0, 0),
  (3, "Raheem", "Sterling", 7, "FWD", "5f6", "R", '1994-12-8', 128, 34, "England", 40, 19, 0),
  (3, "Gabriel", "Jesus", 33, "FWD", "5f7", "R", '1997-4-3', 38, 27, "Brazil", 17, 10, 0),
  (3, "Sergio", "Aguero", 10, "FWD", "5f7", "R", '1988-6-2', 284, 31, "Argentina", 193, 24, 0),
  (3, "Leroy", "Sane", 19, "FWD", "6f0", "L", '1996-1-11', 70, 33, "German", 20, 11, 0),
  (3, "Aymeric", "Laporte", 14, "DEF", "6f2", "L", '1994-5-27', 1, 1, "France", 0, 0, 0),
  (4, "Hugo", "Lloris", 1, "GK", "6f2", "L", '1986-12-26', 240, 29, "France", 0, 0, 0),
  (4, "Kieran", "Trippier", 2, "DEF", "5f7", "R", '1990-9-19', 64, 23, "England", 1, 0, 0),
  (4, "Danny", "Rose", 3, "DEF", "5f7", "L", '1990-7-2', 153, 9, "England", 10, 0, 0),
  (4, "Toby", "Alderweireld", 4, "DEF", "6f1", "R", '1989-3-2', 103, 15, "Belgium", 6, 0, 0),
  (4, "Jan", "Vertonghen", 5, "DEF", "6f2", "L", '1987-4-24', 237, 33, "Belgium", 10, 1, 0),
  (4, "Davindson", "Sanchez", 6, "DEF", "6f1", "R", '1996-6-12', 28, 28, "Columbia", 1, 1, 0),
  (4, "Hueng-Min", "Son", 7, "FWD", "6f0", "B", '1992-08-07', 121, 34, "South Korea", 40, 11, 0),
  (4, "Harry", "Kane", 10, "FWD", "6f2", "R", '1993-7-28', 197, 32, "England", 130, 31, 0),
  (4, "Erik", "Lamela", 11, "FWD", "6f0", "L", '1992-04-03', 135, 14, "Argentina", 19, 0, 0),
  (4, "Victor", "Wanyama", 12, "MID", "6f0", "R", '1991-6-25', 57, 10, "Kenya", 6, 1, 0),
  (4, "Michel", "Vorm", 13, "GK", "6f0", "R", '1983-10-20', 38, 6, "Netherlands", 0, 0, 0),
  (4, "Eric", "Dier", 15, "DEF", "6f2", "R", '1994-1-15', 169, 34, "England", 8, 0, 0),
  (4, "Moussa", "Sissoko", 17, "MID", "6f1", "R", '1989-8-16', 68, 34, "France", 2, 2, 0),
  (4, "Fernando", "Llorente", 18, "FWD", "6f3", "R", '1985-2-26', 24, 24, "Spain", 2, 2, 0),
  (4, "Mousa", "Dembele", 19, "MID", "6f1", "L", '1987-7-16', 223, 26, "Belgium", 10, 0, 0),
  (4, "Dele", "Alli", 20, "MID", "6f1", "R", '1996-4-11', 128, 32, "England", 41, 9, 0),
  (4, "Christian", "Eriksen", 23, "MID", "5f8", "R", '1992-2-14', 209, 30, "Denmark", 50, 8, 0),
  (4, "Serge", "Aurier", 24, "DEF", "5f8", "R", '1992-12-24', 17, 17, "Ivory Coast", 1, 1, 0),
  (4, "Ben", "Davies", 33, "DEF", "5f9", "L", '1993-4-24', 116, 26, "Wales", 4, 2, 0),
  (4, "Lucas", "Moura", 27, "FWD", "5f7", "R", '1992-8-13', 0, 0, "Brazil", 0, 0, 0)
;

INSERT INTO Manager (CLUBID, FNAME, LNAME, DOB, JOINEDCLUB, NATIONALITY) VALUES
  (1, "Arsene", "Wenger", '1949-10-22', '1996-1-10', "France"),
  (2, "Antonio", "Conte", '1969-07-31', '2016-4-1', "Italy"),
  (3, "Pep", "Guardiola", '1971-1-18', '2013-1-16', "Spanish"),
  (4, "Mauricio", "Pochettino", '1972-3-2', '2014-5-27', "Argentina")
;

INSERT INTO Stadium (NAME, CLUBID, ADDRESS, POSTCODE, CAPACITY, DATEBUILT) VALUES
  ("Emirates", 1, "Hornsey Road, London", "N7 7AJ", 59867, '2006-7-22'),
  ("Stamford Bridge", 2, "Fulham Road, Fulham, London", "SW6 1HS", 41631, '1876-1-1'),
  ("The Etihad", 3, "Ashton New Road, Manchester", "M11 3FF", 55097, '2003-10-8'),
  ("White Hart Lane", 4, "High Road, Tottenham", "N17 0AP", 36284, '1899-4-9')
;

INSERT INTO Trophies (COMPETITION, YEAR, CLUBID) VALUES
  ("Premier League", 1998, 1),
  ("Premier League", 2002, 1),
  ("Premier League", 2004, 1),
  ("Premier League", 2005, 2),
  ("Premier League", 2006, 2),
  ("Premier League", 2010, 2),
  ("Premier League", 2012, 3),
  ("Premier League", 2014, 3),
  ("Premier League", 2015, 2),
  ("Premier League", 2017, 2),
  ("FA Cup", 1998, 1),
  ("FA Cup", 2000, 2),
  ("FA Cup", 2002, 1),
  ("FA Cup", 2003, 1),
  ("FA Cup", 2005, 1),
  ("FA Cup", 2007, 2),
  ("FA Cup", 2009, 2),
  ("FA Cup", 2010, 2),
  ("FA Cup", 2011, 3),
  ("FA Cup", 2012, 2),
  ("FA Cup", 2014, 1),
  ("FA Cup", 2015, 1),
  ("FA Cup", 2017, 1),
  ("Champions League", 2012, 2)
;

INSERT INTO Fixtures (MATCHDATE, HOMETEAM, AWAYTEAM, HOMETEAMSCORE, AWAYTEAMSCORE) VALUES
  ('2014-8-18',   "Burnley",      "Chelsea",          1,  3)
;

INSERT INTO News (CLUBID, TITLE, CONTENT) VALUES
  (1, "Sample Title", "Sample Content"),
  (3, "Another Sample Title", "Some more sample content")
;
