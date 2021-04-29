# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! 
Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz. A `pom.xml` tartalmát nyugodtan át lehet másolni. 
Projekt, könyvtár, repository neve legyen: `kepesitovizsga`. 
GroupId: `hu.nive.ujratervezes`, artifactId: `kepesitovizsga`. Csomagnév: `hu.nive.ujratervezes.kepesitovizsga`.

A feladatok megoldásához ajánlom figyelembe a cheet sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

Az öt feladatra (ebből kettő az Army feladat) 3 órád van összesen!

Old meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik az idő első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! A vizsga lezárása előtti 15 perces intervallumban pusholhatsz csak.

## Add digits

Hozd létre az `AddDigits` osztályt, és annak az `addDigits(String input)` metódusát.

A metódus feladata, hogy a paraméterben kapott Stringben található összes számjegyet adja össze, és ennek az összegét adja vissza.
Ha a bemeneti String üres, vagy `null`, adjon vissza `-1` értéket.

## Phonebook

Egy alkalmazást írunk, ahol a megrendelő szeretné az alkalmazásban tárolt ügyfeleit és azok telefonszámát exportálni fájlba.

Hozd létre a `Phonebook` osztályt, és abban az `exportPhonebook(Map<String, String> contacts, String output)` metódust!

A paraméterben kapott mapben a kulcsok nevek, az értékek pedig telefonszámok.
Írd ki az összes kulcs-érték párt az outputként megadott címre, minden kulcs-érték párt egy új sorba, az alábbi szintaxisban:

`név: telefonszám`

A kiírás sorrendje a fájlba nem fontos, de a map összes elemét pontosan egyszer írd ki a fájlba!

Láthatod, hogy a tesztesetek a `phonebookOutput` könyvtárba dolgoznak. Ezt hozd létre, hogy az
osztályod tudjon bele írni!

Nem szükséges figyelni arra, hogy ne tárold a teljes fájltartalmat memóriában. Azaz
használhatsz akár `Files` egy metódusát fájlba írásra, akár `Writer` példányt is. 

Ha a metódus akármelyik paraméternek `null` értéket kapna, akkor dobj `IllegalArgumentException`-t!


## Army

Hozzunk létre egy egyszerű alkalmazást, amivel egy középkori hadsereg működését modellezhetjük.

### Katonai egységek (OOP feladat, 20 pont, tesztosztály: MilitaryUnitTest)

Minden egységnek (`MilitaryUnit` absztrakt ősosztály) vannak életerő pontjai (`int`) és támadási sebzése (`int`). Az egységeknek lehet páncéljuk
(vagy van, vagy nincs).

Minden katonai egység számára elérhetőek az alábbi metódusok:

- `doDamage()`: adja vissza az egység sebzését `int` értékként.

- `sufferDamage(int damage)`: a paraméterül kapott értéket levonja az egység életerő pontjaiból,
  ha az egység páncélozott, akkor csak az érték felét vonjuk le.

#### Archer

Az íjász életereje 50 pont, sebzése 20.
Nem rendelkezik páncéllal.

#### Heavy Cavalry

A nehézlovas életereje 150 pont, sebzése 20.
Páncélozott.

A lovasság a csatát rohammal indítja,
így minden lovas első támadása háromszoros sebzést okoz,
az utána következők egyszereset.

(Azaz az első `doDamage` meghívása háromszoros értéket ad vissza, a többi egyszeres értéket.
Tárold le egy attribútumban, hogy hanyadik támadás van, azaz hányszor került meghívásra a `doDamage`
metódus, és ez alapján dönts!)

#### Swordsman

A kardforgató életereje 100 pont, sebzése 10.
Vagy van páncélja vagy nincs.

Minden kardforgatónak van pajzsa, amivel kivédi az első őt ért csapást.
A pajzs az első kapott sebzés 100%-át felfogja, majd összetörik, tovább nem használható.

(Tárold le attribútumban, hogy a pajzsa ép-e vagy sem! Ez alapján dönts a sebzésről!
Az első `sufferDamage` hívás után módosítsd az attribútum értékét!)

### Sereg (Collections feladat, 20 pont, tesztosztály: ArmyTest)

A hadseregnek az alábbi metódusai vannak:

- `addUnit(MilitaryUnit militaryUnit)`, amivel egy katonai egységet tudunk hozzáadni a sereghez,

- `damageAll(int damage)`, ami a sereg minden egységének életerejéből levonja a paraméterül kapott értéket, 
  valamint eltávolítja a seregből azokat az egységeket, melyeknek így 25 pont alá csökkent az életerejük 
  (azaz harcképtelenek vagy halottak),

- `getArmyDamage()`, ami visszaadja, hogy az aktuális támadással mennyi sebzést okoz a sereg összesen,

- `getArmySize()`, ami visszaadja, hogy hány egységből áll a sereg.

## Jurassic

Dr Ian Malcolmnak igaza volt: az élet utat tör. A Jurassic Parkban szabályozatlan körülmények között is szaporodnak a 
dinoszauruszok. Hogy fel lehessen mérni a probléma nagyságát, a gondozók összegyűjtötték egy adatbázisba, hogy a fajokból 
mennyi a hivatalos egyedszám, amennyinek lennie kéne, és ehhez képest a park kamerái és mozgásérzékelői hányat találtak.

### Adatbázis

Az adatbázis egyetlen táblát tartalmaz, `dinosaur` néven, az alábbi oszlopokkal:

- `breed` `varchar` (elsődleges kulcs)
- `expected` `int`
- `actual` `int`

Például:

| breed             | expected        | actual |
|:------------------|----------------:|-------:|
| Tyrannosaurus rex |               2 |      2 |
| Maiasaurus        |              21 |     22 |
| Stegosaurus       |               4 |      4 |
| Velociraptor      |               8 |     37 |
| Hypsilophodontida |              33 |     34 |

### Java alkalmazás

Hozd létre a `JurassicPark` osztályt, ami konstruktor paraméterben kapja meg az adatbáziseléréshez szükséges `DataSource` példányt.

Az osztályban egyetlen publikus metódus van, `checkOverpopulation` néven, ami térjen vissza azoknak a fajtáknak a nevével, 
amiknél a valós létszám magasabb, mint az elvárt (a fenti példában a Maiasaurus, a Velociraptor és a Hypsilophodontida), ABC szerint növekvő sorrendben.

Ha az adatbázis üres, akkor a metódus térjen vissza üres listával.
