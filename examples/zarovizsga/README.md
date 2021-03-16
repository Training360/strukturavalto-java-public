# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! 
Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz. A `pom.xml` tartalmát nyugodtan át lehet másolni. 
Projekt, könyvtár, repository neve legyen: `zarovizsga`. 
GroupId: `hu.nive.ujratervezes`, artifactId: `zarovizsga`. Csomagnév: `hu.nive.ujratervezes.zarovizsga`.

A feladatok megoldásához ajánlom figyelembe a cheet sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

Az öt feladatra (ebből kettő a Kutyák feladat) 3 órád van összesen!

Old meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik az idő első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! Utána nyugodtan folytathatod a megoldást, akár több órát is
ülhetsz felette, ha kész vagy, commitolj!

## Számjegyek

A `DigitsCounter` osztálynak legyen egy `int getCountOfDigits(String s)` metódusa,
mely megszámolja, hogy hány különböző számjegy van a bemeneti Stringben.

## Kutyák

Legyen egy `Dog` ősosztályod, annak egy `name` és `happiness` attribútuma.
Az osztályt ne lehessen példányosítani! A konstruktora paraméterül kapja meg
a kutya nevét! A `happiness` értéke `0` legyen! Legyenek az attribútumokhoz
getterek! Legyen egy `void feed()` és egy `void play(int hours)` metódusa is,
de ezek ne legyenek implementálva.

Legyen két leszármazottja, a `Beagle` és a `Husky`! Konstruktornak meg lehessen adni a nevet!
Ha meghívod a `Beagle` `feed()` metódusát, akkor a boldágságértéke kettővel nőjjön!
Ha a `play()` metódusát, akkor a paraméterként átadott órák száma szorozva kettővel
nőjjön a boldogságértéke!

Ha meghívod a `Husky` `feed()` metódusát, akkor a boldágságértéke néggyel nőjjön!
Ha a `play()` metódusát, akkor a paraméterként átadott órák száma szorozva hárommal
nőjjön a boldogságértéke!

Legyen egy `Kennel` osztály, mely nyilvántartja a kutyákat. A következő metódusokat implementáld:

* `void addDog(Dog dog)` - hozzáaad egy kutyát
* `feedAll()` - összes kutya `feed()` metódusát meghívja
* `Dog findByName(String name)` - kikeresi a kutyát név alapján, kivételt dob, ha nem találja
* `void playWith(String name, int hours)` - a paraméterként megadott kutyát kikeresi, és meghívja a `play()`
    metódusát az átadott `hours` paraméterrel
* `List<String> getHappyDogNames(int minHappiness)` - visszaadja azon kutyák neveit, melyeknek
    boldogsága nagyobb, mint a paraméterként átadott érték

Ez két feladatnak számít, első a `Dog`, `Husky` `Beagle` és `Kennel` osztályok
létrehozása, és a `Kennel` osztály első két metódusa egy feladat. A másik három metódus
még egy feladatnak számít.
    
## Munkaórák

A `WorkHours` osztályban implementáld a `String minWork(String file)` metódust!
A metódus paraméterként megkapja egy fájl elérési útvonalát. A tesztesetben ez a
`src/test/resources/hu/nive/ujratervezes/zarovizsga/workhours/workhours.txt`, így ebbe
a könyvtárba tedd a fájlt!

A fájl formátuma:

```plain
John Doe,8,2021-01-01
Jack Doe,7,2021-01-02
Jack Doe,8,2021-01-03
John Doe,2,2021-01-04
John Doe,8,2021-01-05
John Doe,7,2021-01-06
```

A dolgozó neve, mennyi órát dolgozott egy nap, és a nap.
Azt kell visszaadni, hogy ki melyik nap dolgozott a legkevesebbet.
A fenti fájl alapján John Doe 2021-01-04-én csak 2 órát dolgozott,
így a következő Stringet kell visszaadni: `John Doe: 2021-01-04`.
Egy napra, egy alkalmazotthoz mindig csak egy sor van.

## Kutyafajták

A `DogTypes` osztályba dolgozz, mely egy `DataSource`-ot kap konstruktorba.
A `DogTypesTest` hívja meg, ott van a `DataSource` deklarálva.
Nyugodtan írd át a benne lévő értékeket.

Legyen egy `List<String> getDogsByCountry(String country)`
metódusa, mely adatbázisból visszaadja az adott országhoz tartozó
kutyafajtákat! A teszteset a `V1__dogs.sql` állományt futtatja le Flyway-jel.
Létrehoz egy `dog_types` táblát, amiből a lényeges a `name` és a `country`
oszlop. Adatokat is beszúrja.
Ha lassú, akkor csak azokat a sorokat hagyd benne, amiben szerepel
a `HUNGARY` szó!

Vigyázz, a metódus kisbetűsen kapja az ország nevét, de az adatbázisban csupa nagybetűsen szerepel.
Vigyázz, a kutyák fajtái nagybetűkkel vannak, de kisbetűkkel kell visszaadni.
(Konvertálásokat végezheted Javaban vagy SQL-ben is.)

Név szerint sorbarendezve add vissza őket!  
  