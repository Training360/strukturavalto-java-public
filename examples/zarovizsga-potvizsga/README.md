# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! 
Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz. A `pom.xml` tartalmát nyugodtan át lehet másolni. 
Projekt, könyvtár, repository neve legyen: `zarovizsga-potvizsga`. 
GroupId: `hu.nive.ujratervezes`, artifactId: `zarovizsga-potvizsga`. Csomagnév: `hu.nive.ujratervezes.zarovizsga`.

A feladatok megoldásához ajánlom figyelembe a cheet sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

Az öt feladatra (ebből kettő a _Cleaning_ feladat) 3 órád van összesen!

Old meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik az idő első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! Utána nyugodtan folytathatod a megoldást, akár több órát is
ülhetsz felette, ha kész vagy, commitolj!

## Számjegyek

A `Words` osztálynak legyen egy `boolean hasMoreDigits(String s)` metódusa,
mely visszaadja, hogy a szóvan több számjegy van-e, mint többi karakter.
Azaz a `aa111` szóban három számjegy van és kettő többi, azaz `true`
értéket ad vissza.

## Takarítás

Legyen egy `Cleanable` interfészed, annak `int clean()` és `String getAddress()`
metódusa. Ez azt jelenti, hogy valamit ki lehet takarítani (amit visszaad a metódus,
az a takarítás ára), valamint lennie kell egy címének is.

Legyen két osztály, mely implementálja, a `House` és a `Office`! 
A `House` egy családi ház, melynek meg lehessen adni a címét és az alapterületét.
A ház kitakarítása négyzetméterenként 80 Ft.
Az `Office` egy iroda, melynek meg lehessen adni a címét, az alapterületét és a szintek
számát. Az iroda kitakarítása négyzetméterenként 100 Ft. Természetesen az összes
szintet számolni kell.

Legyen egy `CleaningService` osztály, mely nyilvántartja az ingatlanokat. A következő metódusokat implementáld:

* `void add(Cleanable cleanable)` - hozzáaad egy ingatlant
* `int cleanAll()` - kitakarítja az összes ingatlant, és visszaadja, hogy mennyibe került, ezután nem 
    marad egy ingatlan sem
* `int cleanOnlyOffices()` - kitakarítja csak az irodákat, és visszaadja, hogy mennyibe került. Ezután
    csak a házak maradnak. 
* `List<Cleanable> findByAddressPart(String address)` - visszaadja azokat az ingatlanokat,
melynek címében szerepel a paraméterként megadott érték
* `String getAddresses()` - visszaadja az ingatlanok címeit vesszővel és egy szóközzel
    elválasztva

Ez két feladatnak számít, első az osztályok és interfész
létrehozása, és a `CleaningService` osztály első metódusa egy feladat. A többi metódus
még egy feladatnak számít.
    
## Emberek

A `People` osztályban implementáld a `int getNumberOfMales(String path)` metódust!
A metódus paraméterként megkapja egy fájl elérési útvonalát. A tesztesetben ez a
`src/test/resources/people.csv`, így ebbe
a könyvtárba tedd a fájlt!

A fájl formátuma:

```plain
id,first_name,last_name,email,gender,ip_address
1,Rebekkah,Lashmore,rlashmore0@rambler.ru,Male,140.220.218.69
2,Chiquia,Konmann,ckonmann1@auda.org.au,Male,54.83.30.17
3,Gloria,Bascomb,gbascomb2@ebay.co.uk,Male,67.210.132.201

```

A metódus adja vissza, hogy hány férfi van a fájlban!

## Emberek, de adatbázisban

A `PeopleDao` osztályba dolgozz, mely egy `DataSource`-ot kap konstruktorban.
A `PeopleDaoTest` hívja meg, ott van a `DataSource` deklarálva.
Nyugodtan írd át a benne lévő értékeket.

Legyen egy `String findIpByName(String firstName, String lastName) `
metódusa, mely adatbázisból visszaadja az adott névhez tartozó
ip címet! A teszteset a `V1__people.sql` állományt futtatja le Flyway-jel.
Létrehoz egy `people` táblát, amiből a lényeges a `first_name`, `last_name` és
az `ip_address`
oszlop. Adatokat is beszúrja.
