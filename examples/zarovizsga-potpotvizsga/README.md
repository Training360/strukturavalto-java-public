# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! 
Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz. A `pom.xml` tartalmát nyugodtan át lehet másolni. 
Projekt, könyvtár, repository neve legyen: `zarovizsga-potpotvizsga`. 
GroupId: `hu.nive.ujratervezes`, artifactId: `zarovizsga-potpotvizsga`. Csomagnév: `hu.nive.ujratervezes.zarovizsga`.

A feladatok megoldásához ajánlom figyelembe a cheet sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

Az öt feladatra (ebből kettő a _Fishtank_ feladat) 3 órád van összesen!

Old meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik az idő első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! Utána nyugodtan folytathatod a megoldást, akár több órát is
ülhetsz felette, ha kész vagy, commitolj!

## Unique finder

Hozd létre a `UniqueFinder` osztályt, és abban a `uniqueChars` metódust, ami paraméternek kap egy `String`-et, és 
térjen vissza az abban levő karakterek listájával. Minden karakter csak egyszer szerepeljen a listában, az inputban nézett első előfordulásának megfelelő helyen.

Ha a metódus null-t kap paraméterben, akkor dobj `IllegalArgumentException`-t!

## Count chars

Hozdd létre a `DaVinciCode` osztályt, és abban a `decode` metódust, ami paraméternek várja egy file elérési útját és a keresett karaktert, ami lehet `'0'`, `'1'` vagy `'x'`.

Ha paraméterként nem ezen karakterek egyikét kapja, akkor dobjon egy kivételt!

A fájl `0`, `1` és `x` karaktereket tartalmaz. A metódus térjen vissza azzal, hogy a második paraméterben kapott karakter hányszor szerepel a fájlban.

Hozzunk létre egy egyszerű alkalmazást, amivel egy akvárium működését modellezhetjük.

## Halak (OOP feladatrész, 20 pont, hozzá tartozó teszt: FishTest)

Minden halnak van neve, súlya grammban és színe.

Emellett minden hal számára elérhetőek az alábbi metódusok:

- `status()`: adja vissza a hal adatait egy Stringben, pl `Dory, weight: 9, color: blue, short-term memory loss: true`

- `feed()`: megnöveli a hal súlyát, a pontos implementáció a hal fajtájától függ.

### Clownfish

A bohóchal 1 grammot hízik etetéskor.

### Tang

A tang 1 grammot hízik etetéskor, és rövidtávú-memória zavarban szenvedhet.

### Kong

A kong 2 grammot hízik etetéskor.

## Akvárium (Collections feladatrész, 20 pont, hozzá tartozó teszt: AquariumTest)

Az Aquarium osztálynak az alábbi metódusai vannak:

- `addFish()`, amivel halakat lehet hozzáadni

- `feed()`, ami megeteti az összes halat az akváriumban, és ezzel megnöveli a súlyukat

- `removeFish()`, eltávolít minden olyan halat az akváriumból, ami legalább 11 grammos

- `getStatus()`, ami visszaadja a halak státuszát egy String listában

# House cup

Minerva McGalagony megelégelte, hogy Dumbledore mennyire lazán veszi a házak pontversenyét, és saját kezébe vette a dolgokat. Mostantól a pontokat transzparens módon, adatbázisban fogjuk vezetni.

## Adatbázis

Az adatbázisban egyetlen tábla van `house_points` néven, az alábbi oszlopokkal:

- `house_name varchar`
- `student_name varchar`
- `points_earned int`

Egy hallgató többször is szerezhet pontot a tanév során a házának, ilyenkor az több rekordban lesz rögzítve. Például:

| house_name | student_name    | points_earned |
|------------|-----------------|--------------:|
| Gryffindor | Harry Potter    | 50            |
| Slytherin  | Draco Malfoy    | 10            |
| Slytherin  | Draco Malfoy    | 20            |
| Gryffindor | Harry Potter    | -15           |
| Hufflepuff | Cedric Diggory  | 25            |

## Java alkalmazás

Hozd létre a `HouseCup` osztályt, ami konstruktor paraméterben megkapja az adatbázis eléréshez szükséges `DataSource` példányt. Az osztályban hozd létre az alábbi metódusokat:

- `getPointsOfHouse(String houdse)`: adja vissza, hogy a paraméterként megadott ház mennyi pontot szerzett
