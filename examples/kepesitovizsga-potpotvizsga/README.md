# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd!
Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz! A `pom.xml` tartalmát nyugodtan át lehet másolni.
Projekt, könyvtár, repository neve legyen: `kepesitovizsga-pot-potvizsga`.
GroupId: `hu.nive.ujratervezes`, artifactId: `kepesitovizsga-pot-potvizsga`. 
Csomagnév: `hu.nive.ujratervezes.kepesitovizsga_pot_potvizsga`.

A feladatok megoldásához ajánlom figyelembe a cheat sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

Az öt feladatra (Az Állatkert feladat 3 külön részből áll) 3 órád van összesen!

Oldd meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik az idő első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! A vizsga lezárása előtti 15 perces intervallumban pusholhatsz csak.


## Számjegyek (Algoritmus feladat, 15 pont)

A `NumberOfDigits` osztályba írj egy `getNumberOfDigits()` metódust, amely egy egész számot vár paraméterül!
A metódus adja vissza azt, hogy ha 1-től kezdve a paraméterként átadott számig leírjuk az összes egész számot,
akkor hány számjegyet írtunk le!

## Nagybetűk (Fájlkezelés feladat, 20 pont)

Az `UpperCaseLetters` osztályban a `characters.txt` fájl felhasználásával írd meg a `getNumberOfUpperCase(Path path)`
metódust, ami visszaadja a fájlban található mindenféle karakterek közül a nagybetűk számát!

(A `characters.txt` az `src/main/resources` könyvtárban található.)

## Állatkert

### 1. feladatrész (Objektumorientált feladat, 20 pont)

Egy állatkertben a náluk gondozott állatokról (`ZooAnimal`) adatbázist vezetnek. Minden állatnak van neve, valamint
nyilvántartanak egy hosszúság adatot, amely csak néhány állatnál fontos (azoknál, amelyeknek valamely testrészük hosszú)
és egy súlyadatot, amely csak az igazán nehéz állatoknál érdekes:
- az oroszlánok (`Lion`) az állatkertbe kerülésükkor csak egy nevet kapnak, a többi tulajdonságuk elhanyagolható.
- a zsiráfok (`Giraffe`) esetében viszont már nyilvántartják a nyakuk hosszúságát is (a súlyuk nekik is elhanyagolható).
- az elefántoknál (`Elephant`) pedig a hosszúság értelemszerűen az ormány hosszát jelenti, illetve az előzőeken túl már fontos a súlyuk is.

Hozd létre ezeket az osztályokat, az ehhez szükséges adatokat megtalálod a tesztekben!

### 2. feladatrész (Kollekciók feladat, 30 pont)

A Zoo osztály reprezentálja az állatkertet. Ebben egy `Set` adatszerkezetben tárolják az állatokat, lekérdezhető formában. 
Az osztálynak két konstruktora is van, az egyik egy üres konstruktor, a másik pedig paraméterként megkapja az adatbázis 
eléréséhez szükséges adatokat (ez a 3. feladadtrészhez lesz szükséges). A következő metódusokat kell megvalósítani:

- `getAnimals()` : ezen a metóduson keresztül érhetjük el az adatszerkezetet.
- `addAnimal(ZooAnimal animal)` : ezzel a metódussal lehet egy új állatot adni az adatszerkezethez.
- `getHeaviestAnimalInTheZoo()` : visszaadja az állatkert legnehezebb állatát.
- `countWeights()` : összeszámolja, hogy mennyit nyomnak az állatkert állatai együttesen.
- `findExactAnimal(ZooAnimal animal)` : megkeresi a paraméterként megadott állatot (amennyiben az létezik).
- `findExactAnimalByName(String name)` : megkeresi a paraméterként megadott névvel rendelkező állatot (amennyiben az létezik).
- `getNumberOfAnimals()` : visszaadja, hogy hány állat található jelenleg az állatkertben.
- `getAnimalsOrderedByName()` : visszaad egy másik adatszerkezetet, amelyben ABC-sorrendben található az állatok neve.
- `getAnimalStatistics()` : visszaad egy másik adatszerkezetet (egy `Map`-et), amelyből kiolvasható, hogy milyen fajta állatból mennyi van az állatkertben.

### 3. feladatrész (Adatbáziskezelés feladat, 15 pont)

- `loadAnimals()` : betölti az adatbázisból az állatok adatait az osztályba.
- `addAnimalToDatabase(ZooAnimal animal)` : ezzel a metódussal lehet egy új állatot feltölteni az adatbázisba.