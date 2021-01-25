Tesztesetek írása akkor is javasolt, ha ez nem szerepel a feladatleírásban.

# 2020-11-03 (`week02d02`)

Írj egy `Phone` osztályt, `type` (`String`) és mem (`int`) attribútumokkal!
Generálj konstruktort, gettert és settert! Írj bele egy `main` metódust, amivel példányosítasz egy osztályt, és kiírod az attribútumok értékeit!

# 2020-11-04 (`week02d03`)

Írj egy `Product` oszályt `String name` és `String code` attribútumokkal!
Legyen egy konstruktora a két attribútummal! Legyen egy `areTheyEqual()`
metódusa, mely kap egy másik `Product` példányt, és eldönti, hogy
azonos-e az adott példánnyal. Két termék akkor egyezik, ha
a nevük megegyezik.

Bónusz: szigorúbb egyelőség a feltételre: a két termék kódjának hosszának különbsége
maximum egy karakter lehet.

# 2020-11-05 (`week02d04`)

Hozz létre egy `InputNames` Java osztályt, melynek van egy `main` metódusa.
Ciklusban kérj be öt nevet! A neveket tárold el egy tömbben!
Írd ki a tömb tartalmát, sortöréssel elválasztva (írd bele, hogy hanyadik elem - 1-től sorszámozva)!


# 2020-11-06 (`week02d05`)

Hozz létre egy `Languages` osztályt, `main` metódussal!
Ebben hozz létre egy listát, mely karakterláncokat tartalmaz!
Vegyetek fel 3 elemet: `Java`, `Python`, `JavaScript`!

Írd ki, az öt karakternél hosszabb programozási nyelveket!

# 2020-11-10 (`week03d02`)

Írj egy `Position` osztályt, melynek van egy `name` és egy `bonus` attribútuma!
Egy alkalmazotti pozíciót jelöl, melynek a `bonus` attribútuma tárolja, hogy
ebben a pozícióban évente mennyi bónuszt kap egy alkalmazott.
A `main` metódusban hozz létre egy `Position` objektumokat tartalmazo listát!

Menj végig a lista elemein, és írd ki azokat, ahol a bónusz magasabb, mint
150_000. Azonban a kiírás  
formátumát a `Position` osztály `toString()` metódusában implementáld!

# 2020-11-12 (`week03d04`)

Írj egy `Phone` oszályt, melynek van egy `prefix` és egy `number`
`String` attribútuma! Írj egy `PhoneParser` osztályt egy
`parse(String)` metódussal, ami beolvas egy `10-1234567`
formátumú szöveget, és visszaad egy `Phone` objektumot,
feltöltve a `prefix` értékét `10`, a `number` értékét `1234567`
értékekkel!

# 2020-11-13 (`week03d05`)

Írj egy `Operation` osztályt, mely konstruktorban kap egy 
összeadást, pl. `68+12`! A `getResult()` metódus visszaadja a 
művelet eredményét. Egy belső `leftOperand` és `rightOperand`
attribútumba dolgozz!

# 2020-11-16 (`week04d01`)

Készítsd el a `NameChanger` osztályt, melynek privát attribútuma
legyen a `String fillName`, mely egy ember teljes nevét reprezentálja!
A `fullName` attribútum `[vezetéknév][szóköz][keresztnév]` formátumban épül fel.
A konstruktor állítsa be a paraméterül kapott értékre az adattagot,
de ha az érték `null`, vagy üres String, akkor dobjon egy
`IllegalAgrumentException` kivételt a következő üzenettel: 
`Invalid name:[paraméter értéke]`!

Legyen egy `changeFirstName(String firstName)` metódusa, mely megváltoztatja az
objektum állapotát és kicseréli a vezetéknevet a paraméterül kapott értékre!

# 2020-11-18 (`week04d02`)

A `Search` osztályban írj egy `getIndexesOfChar()` 
metódust, mely első paraméterként vár egy `String` értéket,
második paraméterként egy `char` értéket! Visszaad egy listát,
melyben visszaadja, hogy a karakter hanyadik indexeken
szerepel az első paraméterként átadott listában.

Pl.: `almafa` szóban a `a` karakter: 0, 3, 5.

# 2020-11-18 (`week04d03`)

Írj egy számkitaláló programot a `GuessTheNumber` osztályba! A
program kitalál egy véletlenszerű számot 1 és 100 között. Majd
bekér a felhasználótól ciklusban számokat. Mindig megmondja,
hogy a szám, kisebb, nagyobb vagy egyenlő-e mint a gondolt szám.

Bónusz feladat: max 6-szor lehet kérdezni!

# 2020-11-24 (`week05d02`)

A `ChangeLetter` osztályban írj meg egy `String changeVowels(String)`
metódust, mely kicseréli a paraméterként átadott szövegben az angol magánhangzókat
csillag (`*`) karakterre.

# 2020-11-25 (`week05d03`)

## Junior

Írj egy olyan metódust a `ListCounter` osztályban, mely a kapott `String` listából
összeszámolja azokat, amelyek `a` vagy `A` betűvel kezdődnek! Ha nulla elemű a tömb,
vagy nincs benne ilyen elem, akkor nulla értéket adjon vissza!

## Senior

A `UserValidator` osztályba írj egy `validate(List<User>)` metódust, mely leellenőrzi a paraméterben
átadott felhasználókat! (A `User` egy `String name` és egy `int age` attribútumot tartalmazzon!)
Ha a lista `null`, dobjon kivételt! Ha a felhasználó `null`, dobjon kivételt! Ha
A felhasználó neve `null`, vagy üres, dobjon kivételt! Ha az életkor
kisebb, mint 0, vagy nagyobb, mint 120, dobjon kivételt!

# 2020-11-26 (`week05d04`)

## Junior

Készíts egy `Product` osztályt melyben egy termékről tárolod a nevét és a lejárati dátumát (`LocalDate`)! Legyen egy konstruktora, ami a nevet kapja meg illetve a lejárati dátumot három részletben `int year`, `int month`, `int day` (`public Product(String name, int year, int month, int day)`)! A lejárati dátumot a konstruktorban állítsd össze! Legyen mindkettőhöz getter metódus! Készíts egy `Store` osztályt, melyben van egy `Product`-okat tároló lista. Legyen benne egy `addProduct(Product)` metódus!

Bónusz: Legyen benne egy `getNumberOfExpired()` metódus ami visszaadja a lejárt termékek számát! Használd a `LocalDate.now()` és az `isBefore()` metódusokat!

## Senior

Készíts egy osztályt `Product` néven, melynek van egy `price` (`long`) és egy `currency` (`String`) mezője. A `Product` a konstruktorában ellenőrizze a `currency` mezőt, melynek az értéke vagy `HUF`, vagy `USD` lehet.
Készíts egy metódust `convertPrice()` néven, melynek egy paramétere van (`currency`) és visszaadja a `currency`-nek megfelelő összeget (`double`). Használjunk 300 forintos átváltási árfolyamot! Példa: ha a `Product`-ot létrehozzuk a következőképp: `new Product(150, "HUF")`, majd meghívjuk a `convertPrice`-ot `USD` paraméterrel, akkor az elvárt visszatérési érték `0.5`.

Bónusz feladat: Használj enum-ot String helyett a pénznem reprezentációjára!

# 2020-11-27 (`week05d05`)

## Junior

Készíts egy osztályt `User` néven, melynek van egy `firstName` (`String`), egy `lastName` (`String`) és egy email (`String`) mezője! Legyen ellenőrzés a `User` konstruktorában, mely hibát jelez, ha nincs `@` és `.` (pont) az e-mail cimben! Készíts egy metódust is `getFullName()` névvel, mely visszaadja a `firstName` és a `lastName` változókat összefűzve. Legyen közöttük egy whitespace (" ").

## Senior

Készítsünk egy `Song` osztályt, melynek az alábbi mezői vannak:

- `String name`
- `long lengthInSeconds`
- `String artist`

A `Song` konstruktorában ellenőrizd, hogy a `name` és az `artist` üres-e! Dobj kivételt, ha igen! Ellenőrizd továbbá a `lengthInSeconds`-ot is, hogy nagyobb legyen, mint `0`!
Készítsünk egy `Playlist` osztályt, melynek van egy konstruktora, amiben `Song`-ok listáját fogadja el!
Írjunk egy metódust `findByLengthGreaterThan` néven, mely egy `int`-et vár paraméterként `mins` néven.
Azoknak a `Song`-oknak a listáját adjuk vissza, melyek hosszabbak percben (!), mint a `Song` `lengthInSeconds` mezője.

Bónusz feladat: Implementáljuk megfelelően a `toString` metódust a `Song` és a `Playlist` osztályban, hogy a `Playliset`-et kiirva a konzolra olvasható eredményt kapjunk!

# 2020-11-30 (`week06d01`)

## Junior

Írj egy olyan metódust az `ListSelector` osztályban, mely egy kapott listából minden második elemet kiválogat, és egy szövegként összerak, szögletes zárójelek között.
A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.
Ha üres a lista, akkor üres stringet adjunk vissza. Ha a paraméterül kapott lista `null`, akkor dobj `IllegalArgumentExceptiont` a metódusban!

## Senior

Írj egy `SeparatedSum.sum(String s)` metódust, mely kap egy `String`-et, melyben lebegőpontos számok szerepelnek pontosvesszővel elválasztva. A számoknál vessző a tizedeselválasztó. Ezt szétszedi, és összeadja külön a pozitív és külön a negatív számokat. Mivel térnél vissza ebből a metódusból?

# 2020-12-01 (`week06d02`)

## Junior

Hozz létre egy `Product` osztályt melynek adattagjai a név, kategória és ár, rendre `String`, `String` int! Készíts egy `Store` osztályt benne egy `Product` listával, amit konstruktorban kap meg. Legyen egy `getProductByCategoryName(Category)`, ami visszaadja, hogy a paraméterül kapott kategóriából hány darab van a listában!
Bónusz: A kategória legyen enum `FROZEN`, `DAIRY`, `BAKEDGOODS`, `OTHER` felsorolókkal!

## Senior

Hozz létre egy `Product` osztályt melynek adattagjai a név, kategória és ár. A kategória legyen enum `FROZEN`, `DAIRY`, `BAKEDGOODS`, `OTHER` felsorolókkal. Készíts egy `Store` osztályt benne egy `Product` listával, amit konstruktorban kap meg. Legyen egy `getProductsByCategory()` aminek az lényége, hogy visszaadja valamilyen adatszerkezetben, hogy melyik kategóriából hány darab van a listában. A "valamilyen adatszerkezet" a kreativításodra van bízva, az a lényeg, hogy valahogy egyben kapjam meg, hogy melyik kategóriából hány darab van.

# 2020-12-02 (`week06d03`)

## Junior

A `WordEraser` osztályban legyen egy `eraseWord(String words, String word)` metódus, mely az első paraméter szöveget úgy változtatja meg, hogy a második paraméter összes előforulását kitörli belőle. A `words` paraméterben a szavak szóközzel vannak elválasztva. A metódus térjen vissza a törölni kívánt szavak nélküli Stringgel. (Mellőzzük a `replace` és `replaceAll` használatát!)

## Senior

A `Series` osztályban hozz létre egy `calculateSeriesType()` metódust, mely egész számok listáját kapja, és eldönti, hogy növekvő, csökkenő vagy össze-vissza sorozatról van-e szó! Feltétel, hogy a bemeneti lista nem tartalmaz egymás után egyenlő értékeket. Ha a lista üres, vagy csak egy elemből áll, dobj kivételt! Mivel térnél vissza?

## 2020-12-03 (`week06d04`)

## Junior

Készíts az egy `Budget` osztályt, amely a konstruktorában `Item` példányokat vár listában (`List`). Az `Item` tartalmazza az alábbi attribútumokat: `int price`, `int month`, `String name`. A `Budget` osztály tárolja el egy attribútumban a konstruktorban megkapott `items` listát. Írj egy metódust, `getItemsByMonth` néven, mely egy hónapot vár (1-12) és visszaadja az `Item`-eket az adott hónapban! Bónusz feladat: ellenőrizzük a bemeneti paramétereket!

## Senior

A `ShoppingCart` osztályba dolgozz! Legyen egy `addItem(String name, int quantity)` metódusa, mellyel új bevásárlólista tételt lehet felvenni (termék neve és mennyisége). Az adatokat egy `Item` listába tárolja. Amennyiben már benne van az adott termék, ne újonnan vegye fel, hanem adja hozzá a mennyiséget a már felvett tételhez! Lehessen visszakérdezni név alapján a felvett mennyiséget a `getItem(String name): int` metódussal. Ha nem szerepel benne, `0` értéket adjon vissza!

# 2020-12-04 (`week06d05`)

## Junior

Készíts egy `Biscuit` nevű osztályt, amelynek van két attribútuma: `BiscuitType type` és `int gramAmount`. A `BiscuitType` legyen felsorolásos típus a három kedvenc kekszfajtáddal! A `Biscuit` nevű osztálynak legyen egy `static` metódusa `of` néven, mely paraméterként egy `BiscuitType`-ot, és egy `int gramAmount`-ot vár és visszaad egy új `Biscuit` objektumot amelyet a megadott paraméterek alapján hoz létre. Bónusz feladat: konzolra írás esetén a `Biscuit` jelenítse meg a `type` és a `gramAmount` mezőket!

## Senior

Készíts egy `Bottle` nevű osztályt, amelynek van 2 attribútuma: `BottleType type` és `int filledUntil`. A `BottleType` legyen felsorolásos típus az alábbi értékekkel: `GLASS_BOTTLE` és `PET_BOTTLE`! A `Bottle` nevű osztálynak legyen egy `static` metódusa `of` néven, mely paraméterként egy `BottleType`-ot vár és visszaad egy új `Bottle` objektumot amelyet a megadott paraméter alapján hoz létre. A `Bottle` osztálynak legyen egy `fill` metódusa, mely egy `int fillAmount` paramétert vár. A `fill` meghívása esetén végezzen ellenőrzést, hogy megtelt-e már a `Bottle` objektum. Az ehhez szükséges `int maximumAmount` mezőt a `BottleType` tartalmazza! Ha túlcsordulna a `Bottle` objektum, akkor dobj kivételt!

# 2020-12-07 (`week07d01`)

## Junior

Készíts egy osztályt `MathAlgorithms` néven. Ebben az osztályban legyen egy `isPrime(int x)` metódus ami a paraméterül kapott számról eldönti, hogy prím-e vagy sem és ennek megfelelően `true` vagy `false` értékkel tér vissza. Aki már tart ott és tudja mit jelent a `static` az nyugodtan implementálhatja a metódust statikus metódusként. Az egyszerűség kedvért a prímeket most csak a pozitív egész számok körében értelmezzük, így bónuszként rá lehet ellenőrizni, hogy `x > 0`,  és ha nem, akkor kivételt dobni. Prímeknek tekintjük azokat számokat melyek csak egyel és önmagukkal oszthatók, tehát a 2, 3, 5, 7, 11, 13 stb.

## Senior

Készíts egy osztályt `Fibonacci` néven! Legyen benne egy `fib` metódus, ami egy `int n` paramétert vár! A visszatérési értékünk legyen egy `long` szám, ami az n-edik fibonacci számot tartalmazza. (A fibonacci szám az az az előző kettő fibonacci szám összege és az első két szám az 1, 1.

Bónusz feladat: implementáld az algoritmust ciklus nélkül és mentsd el a részeredményeket egy statikus változóba!

Pontosítás: Ha n = 0, akkor 0-t adunk vissza, ha n = 1, akkor 1-et, ezért lesz a 2. elem szintén 1, mert 0 + 1 = 1

# 2020-12-08 (`week07d02`)

## Junior

Készíts egy `DigitSum` osztályt és benne `sumOfDigits(int x)` metódus mely visszaadja a paraméterül kapott szám számjegyeinek összegét! pl.: 123 esetén a visszatérési érték 6.

## Senior

Készíts egy interfészt `User` néven. Az interfésznek legyen egy `String getUsername()`, egy `String getFirstName()`, egy `String getLastName()` és egy `String getFullName()` metódusa! Implementáld a `User` interfészt egy `UserImpl` nevű osztályban, mely konstruktor paraméterként várja az `username`, a `firstName` és a `lastName` paramétereket. A `getFullName` metódushoz adjunk az interfészben egy default implementációt!

Bónusz feladat: Készítsünk egy statikus függvényt az `User` interfészben `of` néven, mely létrehoz egy új `User` típusú objektumot!

# 2020-12-09 (`week07d03`)

## Junior

Hozz létre egy NumberList osztályt! Ennek legyen egy metódusa `isIncreasing(List<Integer>)`, mely egy számokból álló listát vár paraméterül és megnézi, hogy a listában a számok növekvő sorrendben szerepelnek-e és ennek megfelelően igaz vagy hamis értékkel tér vissza! Speciális eset ha két egymást követő szám egyenlő, ez nem probléma a 1, 2, 3, 3, 3, 5 számokat növekvőnek tekintjük.

## Senior

Készítsünk egy `Date` osztályt, mely az alábbi attribútumokkal rendelkezik: `int year`, `int month`, `int day`. Az összes attribútum legyen `final`! Készítsünk továbbá egy statikus of metódust, mely a `year`, `month` és `day` paramétereket várja és létrehoz egy `Date` objektumot ezek alapján. Legyen továbbá a `Date`-nek egy `withYear(int year)`, `withMonth(int month)` és egy `withDay(int day)` metódusa, melyek egy új `Date` objektumot adnak vissza az eredeti `Date` objektum adataival, azzal a különbséggel, hogy az új objektum a megadott paraméter értékét tartalmazza a megfelelő helyen (`year`, `month` vagy `day`).

# 2020-12-10 (`week07d04`)

## Junior

Hozz létre egy `Lab` nevű osztályt, ami azt tárolja el, hogy melyik feladattal készültél el! Három attribútuma: `title` ami a tananyag neve, egy `completed`, hogy elkészültél-e vele, és a `completedAt`, ami azt tárolja, hogy mikor! Legyen két konstruktora! Az egyik csak a címet várja, ekkor úgy állítsa be a példányt, hogy még nem készültél el. Legyen egy másik, ami várja a címet és a dátumot Ekkor azt állítsa be, hogy elvégezted a gyakorlati feladatot. Írj egy `complete` metódust, ami kap egy dátumot, és beállítja, hogy elvégezted a gyakorlati feladatot. Legyen egy `complete` metódusa, ami semmit nem vár, ez azt állítja be, hogy MOST végezted el a gyakorlati feladatot. Írd meg a `toString` metódusát is!

## Senior

A `ShoppingList` osztályba írj egy `long calculateSum(String path)` metódust, mely a paraméterként átadott fájlból beolvassa a bevásárlólista tartalmát, és összegzi az árat! A fájl a következő formátumú sorokat tartalmazza: `kenyér;2;30`, ahol az első a termék neve, a második a darabszám, a harmadik az egységár. Azaz ezen sor esetén 2 * 30 = 60 értékkel kell számolni.

# 2020-12-11 (`week07d05`)

## Junior

Készíts egy `Vehicle`, egy `Car`, egy `Truck` és egy `Motorcycle` osztályt. A `Vehicle` osztálynak legyen egy `int getNumberOfGears` és egy `TransmissionType getTransmissionType` metódusa. A fenti osztályok értelemszerűen öröklődjenek egymásból és mindegyiknek implementálja a sebességek számát és a váltó típusát. A lehetséges váltótípusok: `MANUAL`, `AUTOMATIC`, `SEQUENTIAL`. Az alapértelmezett váltó típus (a `Vehicle` osztályban) MANUAL, de a `Car` automatikus, míg a `Motorcycle` `SEQUENTIAL`. Az alapértelmezett sebesség szám 5.

## Senior

Kérj be a felhasználótól három sort, majd a fájl nevét! Mentsd el a sorokat ebbe a fájlba! A `SaveInput` osztályba dolgozz!

# 2020-12-14 (`week08d01`)

## Junior

A feladatban egy robot mozgását fogjuk szimulálni. Képzelj el egy koordináta rendszert, ahol a robot az origóban van. A robot négy irányba képes mozogni fel, le, balra és jobbra. A `week08d01.Robot` osztályban írj egy `move()` metódust ami egy karaktersorozatot vár.  pl: FFLLLLLBBBBJJJJJJJ, ahol az F = fel, L=le, B=bal, J=jobb. A metódus visszatérési értéke legyen a robot mozgás utáni pozíciója. A feladat szabadon bővíthető osztályokkal és metódusokkal. Bónusz kiegészítés, hogyha más karaktert is tartalmaz a paraméter String nem csak a FLBJ valamelyikét, akkor dobjunk IllegalArgumentExceptiont!

## Senior

A török szultán elhatározza, hogy a 100 nap múlva lévő születésnapján szabadon enged néhány rabot a börtönéből. A börtönben 100 cella van. Mindegyik cella zárva van. Ha egyet fordítunk a kulcson akkor nyitva lesz, ha még egyet akkor zárva ha hármat akkor ismét nyitva és így tovább.
A szultán azt a parancsot adja, hogy az első nap mindegyik cellán fordítsanak egyet.  (Ekkor minden cella nyitva lesz). A második napon minden másodikon fordítsanak egyet, így minden második zárva lesz. A harmadik napon minden harmadikon fordítsanak egyet így a 3. cella zárva , de a 6. cella például nyitva lesz. A `week08d01.Sultan` osztályba írj egy metódust `openDoors()` néven,  aminek visszatérési értékéből kiderül, hogy mely ajtók lesznek nyitva a 100. napon! Az osztály szabadon bővíthető!


# 2020-12-15 (`week08d02`)

## Junior
Készíts a `week08d02` csomagban egy `Lottery` osztályt, melynek legyen egy `getNumbers()` metódusa, ami visszaad egy listát amiben 5 véletlen szám van 1-90 között, tehát kvázi készíts egy lottósorsoló programot. A sorrendre nem kell figyelni, a lényeg, hogy a számok különbözők legyenek!

## Senior
Adott a `countries.txt` állomány, melyet helyezz el a projekt gyökérkönyvtárába. A fájlban az adatok a következők: ország_neve népesség hány_színű_a_zászló szomszédos_országok_száma. Készíts a week08d02 csomagba egy `CountryStatistics` osztályt melyben van egy metódus, ami az adatokat beolvassa egy listába. A lista legyen az osztály privát attribútuma, és legyen hozzá getter metódus, figyelj arra, hogy ezen keresztül ne lehessen megváltoztatni a listát. Készíts egy metódust `maxPopulaton()` néven, ami a listából visszaadja a legnagyobb népességű ország minden adatát. Adatok:
```
Nepal 31 3 2
Csad 13 3 6
Kongoi_Demokratikus_Koztarsasag 79 3 9
Honduras 8 2 3
Kirgizisztán 6 2 4
Dzsibuti 1 4 3
Togo 7 4 3
Kambodzsa 15 3 3
Guyana 1 5 3
Albánia 3 2 4
Libanon 4 3 2
```

# 2020-12-16 (`week08d03`)

## Junior
Készíts `week08d03` csomagban egy `StringLists` osztályt és benne egy `stringListsUnion(List<String> first, List<String> second)` metódust, mely két string listát vár paraméterül és visszaadja az uniójukat. Az úniónak minden elemet tartalmaznia kell mindkét listából, de egy elem nem szerepelhet kétszer!

## Senior
Készíts a `week08d03` csomagban egy `StringLists` osztályt és benne egy `shortestWords(List<String> words)` metódust, mely paraméterül kap egy String listát és a legrövidebb szavakat vissza adja belőle egy Listában. PL :{"aaa", "aa", "bb", "cccc", "dd"} Itt a legrövidebb szavak az "aa", "bb", "dd".

# 2020-12-17 (`week0804`)

## Junior

Hozz létre egy `CanMark` interfészt egy `int giveMark()` metódussal! Ez azt jelenti, hogy valaki
tud osztályzatot adni. Ennek legyen két implementációja, egy `GoodMood`
osztály, mely mindig `5` értéket ad vissza, és egy `BadMood` osztály, mely mindig `3` értéket ad vissza!
Azaz jó hangulatban valaki mindig ötöst ad, rossz hangulatban hármast.
Legyen egy `Trainer` osztály, melynek van egy `CanMark` attribútuma, mely konstruktorral állítható be! És
legyen egy `int giveMark()` metódusa, mely továbbhív, azaz "delegál" a `CanMark` példány felé!
Hozz létre a `main()` metódusban egy `Trainer` példányt, aki jó hangulatban van (azaz konstruktorban 
adj át neki egy `GoodMood` példányt, és egy másikat, aki `BadMood` példányt kap! Majd hívd meg
a `giveMark()` metódusát mindkettőnek, és nézd meg, mit ad vissza!

## Senior

Legyen a classpath-on egy `examples.md` fájl, mely a gyakorlati feladatok leírásait tartalmazza
a következő formátumban! A `ExamplesStore` osztályba írj egy `getTitlesOfExamples()`
metódust, mely visszaadja a feladatok címeit egy listában! 

```
# Első feladat

Írj egy programot, amely
kiírja az összeadás eredményét!

# Második feladat

Írj egy programot,
mely kiírja a kivonás eredményét!
```

# 2020-12-18 (`week08d05`)

# Junior
A week08d05 csomagban készíts egy osztályt MathAlgorithms néven. Legyen benne egy metódus, greatestCommonDivisor(), ami paraméterül vár két pozitív egész számot és visszaadja a legnagyobb közös osztójukat.

## Senior
Egy repülőgéppel átszeljük az óceánt és a közben méréseket végzünk. Tudjuk, hogy partól indulunk és parthoz érünk. A méréseket adott időközönként egyenletesen végezzük. A mérések azt mutatják, hogy sziget vagy óceán fölött repülünk éppen. Az 1-es szigetet míg a 0 óceánt jelöl.
pl.: 111000010100001  sorozatban egy három "hosszú" sziget majd négy hosszú "óceán", aztán sziget, víz, sziget, majd óceán és végül egy szigeten leszálltunk. A map.txt állományban egy "térképet" tárolunk. A feladat az, hogy "repüljünk" a térkép fölött végig és határozzuk meg a leghosszabb óceán szakasz hosszát.
A térkép fölött csak egyszer repülhetünk el és amikor leszálltunk már tudnunk is kell az eredményt. (Magyarul ne olvasd be a file-t a memóriába) A feladatot a week08d05.Plane osztályba végezzük el.
A térkép: 10000000111110000000000001111111111000010000010000100000111111110000101000000000111110000000000000000100000001000000000000111111000000000100000000000011


# 2020-12-23 (`week09d03`)

## Junior-Senior
A  mai feladatban Mikulásnak segítünk ajándékokat kiosztani. A `week09d03` csomagba  dolgozz. Készíts egy `Present` nevű enumot a következő felsorolókkal: `Toy`, `Electronic`, `Housekepping`, `Decoration`. Ezek fogják az ajándékok típusát reprezentálni. Készíts egy `Person` osztályt legyen neki neve és életkora és legyen egy Present típusú attribútuma. A nevet és életkort konstruktorban kapja meg. Legyen egy `setPresent()` metódusa ami beállítja az ajándék attribútumot véletlenszerűen, egy kitétel van, 14 év fölötti nem kaphat játékot. Ennek megvalósításához szabadon bővíthetőek az eddig elkészült elemek. Legyen egy `SantaClaus` osztály, akinek van egy `Person` listája, amit konstruktorban kap meg. Legyen neki egy `getThroughChimneys()` metódusa, ami végigmegy az emberek listáján és meghívja minden ember `setPresent()` metódusát. 

# 2021-01-04 (`week10d01`)

## Junior

Túrázás közben egy GPS eszköz rögzíti a pontokat. Eltárolja a GPS koordinátákat, valamint a magasságot (mindegyik lebegőpontos érték).
Írj a `week10d01.Hiking` osztályba egy `getPlusElevation()` metódust, mely megkapja a magasságok listáját, és visszaadja
a emelkedések összegét. Azaz pl. `10,20,15,18` esetén `13`, ugyanis `(20 - 10) + (18 - 15)`. A `20` méterről `15` méterre ereszkedést nem számolja bele,
hiszen az ereszkedés, és nem emelkedés.

## Senior

Túrázás közben egy GPS eszköz rögzíti a pontokat. Eltárolja a GPS koordinátákat, valamint a magasságot (mindegyik lebegőpontos érték).
Ezt egy fájlba tárolja, melynek formátuma:

```
47.497913, 19.040236, 400
47.497912, 19.040232, 420
47.497916, 19.040236, 410
```

Írj a `week10d01.HikingFile` osztályba egy `getPlusElevation()` metódust, mely kap egy `InputStream`-et, és visszaadja
külön az ereszkedések, és külön az emelkedések összegét. Azaz pl. `10,20,15,18` esetén az emelkedés `13`, ugyanis `(20 - 10) + (18 - 15)`. 
A `20` méterről `15` méterre ereszkedést pedig `5`.

# 2021-01-05 (`week10d02`)

## Junior

Van egy egész számok listája, amelyben egy szám azt jelzi, hogy az adott számú buszmegállóban egy ember fel akar szállni. A `12,12,0,3,4,4` sorozat tehát azt jelenti, hogy a 12-es buszmegállóban 2-en, a 0-ásban 1 ember, 3-asban egy ember, 4-esben 2 ember akar felszállni. A `MaxTravel` osztály `getMaxIndex()` metódusa adja vissza, hogy hanyas megállóban szeretnének a legtöbben felszálln! Maximum 30 megálló lehet.

Leegyszerűsítve a feladat az, hogy a paraméterként átadott tömbben keresse meg, hogy melyik szám szerepel a legtöbbször.


## Senior

Adott egy fájl, `utasadat.txt`, mely a következőket tartalmazza:

```
0 20190326-0700 6572582 RVS 20210101
0 20190326-0700 8808290 JGY 7
0 20190326-0700 1680423 TAB 20190420
12 20190326-0716 3134404 FEB 20190301
12 20190326-0716 9529716 JGY 0
```

Egy sor egy felszálló adatait tárolja.
Egy sorban a megálló száma az első oszlop. Írj egy `Travel.getStopWithMax(InputStream)` metódust, mely
visszaadja, hogy melyik megállóban szerettek volna a legtöbben
felszállni! Maximum 30 megálló lehet.

# 2021-01-08 (`week10d05`)


## Junior

Készítsünk egy `Calculator` nevű osztályt, melynek van egy `findMinSum(int[] arr)` metódusa. A metódus feladata, hogy kiírja a legkisebb összegeket `4` számból, amiket lehetséges összerakni az `arr` tömb elemeiből. Példa: ha az `arr` tartalma `[1, 3, 5, 7, 9]`, akkor a minimum összeg `1+3+5+7=16`.


## Senior

Készítsünk egy `Calculator` nevű osztályt, melynek van egy `findMinMaxSum(int[] arr)` metódusa. A metódus feladata, hogy kiírja a legnagyobb és a legkisebb összegeket `4` számból, amiket lehetséges összerakni az `arr` tömb elemeiből. Példa: ha az `arr` tartalma `[1, 3, 5, 7, 9]`, akkor a minimum összeg `1+3+5+7=16` , a maximum összeg `3+5+7+9=24`.

A `Calculator` osztály tartalmazzon egy `main` metódust is, amely a konzolról olvassa be a számokat és azokból készít tömböt, amivel meghívja a `findMinMaxSum` metódust.


# 2021-01-11 (`week11d01`)

## Junior

Készítsünk egy `DivisorFinder` nevű osztályt, melynek van egy `int findDivisors(int n)` metódusa. A feladat az, hogy megnézzük a szám minden egyes számjegyére, hogy osztója-e a számnak, majd számoljuk össze őket. Példa: a `425`-ben az `5` osztója a számnak, ezért a visszatérési érték `1`.


## Senior

Készítsünk egy `PairFinder` nevű osztályt, melynek van egy `int findPairs(int[] arr)` metódusa. A feladat az, hogy a tömb elemeiből kikeressük, hogy hány darab pár van bennük. Ha egy szám kétszer szerepel a tömbben, akkor az egy párnak számít. Példa: A `[5, 1, 4, 5]` tömbben kétszer szerepel az 5, ezért a visszatérési érték `1`. A `[7, 1, 5, 7, 3, 3, 5, 7, 6, 7]` tömbben négyszer szerepel a 7, ezért ez 2 párnak számít, illetve a 3 kétszer szerepel, így a visszatérési érték `3`.

# 2021-01-12 (Csoportmunka) (`week11d02`)


## Junior

A feladatban egy biciklis futár egy heti munkáját rögzítjük és készítünk statissztikákat.

A futár minden fuvar után feljegyzi, hogy a hét hányadik napján történt a fuvar. Ezután azt, hogy az adott nap hányadik fuvarját teljesítette és ezután azt, hogy hány kilométer volt az adott fuvar. A futár egy-egy fuvarját reprezentálja a `Ride` nevű osztály, adatagokkal, konstruktorra, getterekkel.

Készítsd el a `Courier` osztályt. Ez fogja a futárt reprezentálni. Legyen egy rides listája ami fuvarokat tárol. Legyen egy addRide metódus, ami csak sorrendben enged hozzáadni elemeket a listához. Figyeljünk viszont arra, hogy nem feltétlenül minden nap dolgozott a futár, de ha már bekerült egy 3. napi fuvar, akkor ne kerülhessen be egy 2. napi. És arra is figyelj, hogy a napon belül is sorrendben kerüljenek be az adatok. Ha a paraméterül kapott Ride nem felel meg a feltételeknek dobjunk `IllegalArgumentException`-t.

pl egy helyes listára:
1 1 12
1 2 11
2 1 10
4 1 19

Készíts egy metódust, ami visszad egy napot amikor a futár nem dolgozott. Ha több ilyen nap is van akkor a korábbit!

## Senior

A feladatban egy biciklis futár egy heti munkáját rögzítjük és készítünk statissztikákat.

A futár minden fuvar után feljegyzi, hogy a hét hányadik napján történt a fuvar. Ezután azt, hogy az adott nap hányadik fuvarját teljesítette és ezután azt, hogy hány kilométer volt az adott fuvar. A futár egy-egy fuvarját reprezentálja a `Ride` nevű osztály.

Készítsd el a `Courier` osztályt. Ez fogja a futárt reprezentálni. Legyen egy metódusa, ami a mellékelt fájl fuvarjait beolvassa és eltárolja a memóriában. Figyelem a fuvarok nem sorrendben vannak! (Készíts magadnak minta fájlt!)

Készíts egy metódust ami visszaadja a hét legelső fuvarjának minden adatát. Figyelj arra, hogy nem sorrendben vannak a fuvaraok és lehet, hogy nem is dolgozott az 1-es számú napon. 
Készíts egy metódust, ami visszaadja valamilyen formában, hogy mely napokon nem dolgozott a futár!
Készíts egy metódust, ami visszaadja valamilyen formában napokra lebontva, hogy melyik nap hány kilométert tekert!  
 
# 2021-01-13 (`week11d03`)

## Junior

Készíts egy `WordFilter` osztályt, melyben van egy `List<String> wordsWithChar(List<String> words, char c)` metódus. A metódus kiválógatja a paraméterül kapott String listából azokat a szavakat, melyekben előfordul a c karakter, majd ezeket visszaadja egy listában.

## Senior

Készítsünk egy `CharCounter` osztályt, melyben van egy `int countChars(String[] chars)` metódus. A feladat az, hogy összeszámoljuk azokat a karaktereket asz összes `chars`-ban lévő `String`-ből, amelyek mindegyik `String`-ben szerepelnek. Példa: Ha a chars-ban `["abc", "cba", "ab"]` szerepel, akkor a visszatérési érték `2`, mert az `a` és a `b` karakter szerepel mindegyik `String`-ben.

# 2021-01-14 (`week11d04`)

## Junior

Adott az aktuális könyvtárban több, fájl, melynek a nevei: `number00.txt`, `number03.txt`, `number20.txt`, egészen `99`-ig.
Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az állományból a benne lévő
számot, és ezt összegezd! Használd a `Files.isRegularFile()` metódust arra, hogy megnézd, létezik-e a fájl!
Használd a `Files.readString()` metódust a fájl beolvasására! A `FilesSum` osztály `int sumNumbers()` metódusába dolgozz!

	try {
            String content = Files.readString(Path.of("helloworld.txt"));
            System.out.println(content);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read", e);
        }

        System.out.println(Files.isRegularFile(Path.of("kutya.txt")));
        System.out.println(Files.isRegularFile(Path.of("helloworld.txt")));

## Senior

Adott egy nevek listája. Add vissza egy listában, hogy milyen hosszúságú `J` karakterrel kezdődő nevek szerepelnek a listában! Minden szám
csak egyszer szerepeljen! A `NameLength` osztály `getLengths(List<String>)` metódusába dolgozz!
Ha a bemenet pl. `List.of("Joe", "Jack", "Jane", "Jake", "George", "William")`, a visszatérési érték `[3, 4]` legyen! 


# 2021-01-18 (`week12d01`)

## Junior

Készíts egy `GradeRounder` osztályt, amiben van egy `int[] grades roundGrades(int[] grades)` metódus. A `grades` tömb pontszámokat tartalmaz 0 és 100 között. A feladat az, hogy kerekítsük a benne lévő számokat a következő szabály szerint: Ha a pontszám és az `5` következő többszöröse közötti különbség kisebb, mint `3`, akkor kerekítsük fel a számot az `5` következő többszörösére. Fontos: a `40` pont alatti pontszámok elégtelenek, ezeket egyáltalán nem kell kerekíteni. Példa: a pontszám `84`. `85 - 84` kevesebb mint `3`, így felfelé kerekítünk.

## Senior

Készíts egy `GoodsPacker` osztályt, melynek van egy `int packGoods(int[][] types, int capacity)` metódusa. A `types` tömb számpárokat tartalmaz, melyek tárgyak súlyát és értékét tartalmazzák, például: `[(7, 160), (3, 90), (2, 15)]`. Az első szám a súly kilogrammban, a második szám az érték forintban. A feladat az, hogy kiszámoljuk, hogy a megadott táskamérethez (`capacity`) mennyi a tárgyak maximum értéke, amit belepakolhatunk a táskába. Például ha a `types` `[(7, 160), (3, 90), (2, 15)]` és a `capacity` `20`, akkor a maximum érték `555`.


# 2021-01-19 (csoportmunka) (`week12d02`) 

## Junior
Készítsd el a `Site` (telek) nevű osztályt. Egy telek jellemzői, páros vagy páratlan oldalon található, (0 = páros oldal 1 = páratlan oldal), a telek hossza méterben. Illetve egy `Fence` enum, ami a kerítés állapotát írja le. A kerités állapota lehet, `PERFECT`, `NEED_UPGRADE`, `NO_FENCE`. (konstruktor, getterek)

Készítsd el a `Street` neű osztályt, melyben eladott telkek listája található. Kezdetben ez egy üres lista.
Készíts egy `sellSite(Site site)` metódust, ami egy telek eladását reprezentálja, vagyis hozzádunk egy telket a listához.

Határozd meg az utoljára eladott telek (lista utolsó eleme) házszámát, ha tudjuk, hogy a telkeket a két oldalon egymás után adták el! (páros oldalon kettőtől, páratlan oldalon 1-től indul a számozás)
pl:
0 10 PERFECT\
0 7 NEED_UPGRADE\
1 12 NEED_UPGRADE\
0 9 PERFECT\
0 11 NO_FENCE\
1 13 PERFECT
A példában a házszámok rendre: 2,4,1,6,8,3

Készíts statisztikát, ami a kerítés állapota alapján visszaadja, hogy mennyi telket adtak el kerítésfajtánként! (Egy metódus legyen, a visszatérési értéket ti döntitek el, de abból legyen egyértelmű, hogy melyikből mennyit adtak el.)

## Senior
A kerites.txt fájlban egy utca telek nyilvántartását találjuk. Minden sorban három adat található. Az első szám megadja, hogy a telek a páros (0) vagy a páratlan (1) oldalán van az utcának; a második a telek szélességét adja meg méterben (egész szám, értéke 8 és 20 között lehet); a harmadik pedig az utcafronti kerítés színét leíró karakter. A szín az angol ábécé nagybetűje. Ha a kerítést már elkészítették, de nem festették be, akkor a „#” karakter, ha még nem készült el, akkor a „:” (kettőspont) karakter
szerepel. Az utca hossza legfeljebb 1000 méter. Mindkét oldalon elkelt legalább 3-3 telek. Amikor vásárolunk mindig csak az utojára eladott telek rákövetkezőjét vehetjük, vagy a másik oldalon utoljára eladott rákövetkezőjét. 

Példa:

0 10 P\
1 8 K\
1 10 :\
1 9 S\
0 10 P 

Magyarázat: Az első telek a páros oldalon található, 10 méter széles, a kerítés kész és P színnel festették be. A harmadik telek a páratlan oldalon van szintén 10 méter, a kerítés kész, de még nincs befestve. A házszámok a következők sorban: 2,1,3,5,4

Feladatok:
Olvasd be a fájl tartalmát a memóriába! Minta file-t hozz létre magadnak!
Az eddig eladott telkekből készítsünk egy sorrendet, méghozzá a méretük alapján!
Határozzuk meg a fájl utolsó sorában szereplő telek házszámát!
Írd ki egy fájlba, a páratlan oldal utcaképét!
Pl.: (1)KKKKKKKK(3)::::::::::(5)SSSSSSSSS
Magyarázat: A házszám zárójelben, majd annyi a kerítést leíró jellemző, amilyen hosszú a telek.

# 2021-01-20 (`week12d03`) 

## Junior

Készítsd el a week12d03.NumberStat osztályt melyben legyen egy metódus, ami paraméterül vár egy egész számokból álló listát. Add vissza azt a számot amelyik pontosan egyszer szerepel a listában. Ha több ilyen szám van akkor a kisebbet! Ellenőrizd, hogy olyan listát fogadunk el, ami legalább 1 elemű, ha a lista nem ilyen, dobj kivételt!
pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3
Bónusz: Módosítsd az osztályt. Legyen egy egész számokból álló lista attribútuma. A fent megírt metódus ezen a listán dolgozzon. A lista elemeit fájlból töltsük fel. A file úgy néz ki, hogy egy sorban három szám van vesszővel elválasztva. Tehát:

```
1,1,4
2,3,5
2,2,5
```

## Senior

Készítsünk egy osztályt `AgeSorter` néven, melynek van egy `int[] sortAges(int[] ages)` metódusa. Az `ages` tömbben emberek életkorai szerepelnek. A feladat az, hogy visszaadjunk egy tömböt, mely az életkorokat tartalmazza sorrendbe rendezve. Ne használjunk beépített sorrendbe rendező algoritmusokat (`Collections.sort`) a feladat megoldásához!

# 2021-01-21 (`week12d04`)

## Junior

Töltsd le a példa bináris állomány a https://github.com/Training360/strukturavalto-java-public/raw/master/examples/week12d04/src/main/resources/secret.dat címről!
Ez bájtokat tartalmaz, egy szöveg van titkosítva benne. Olvasd be bájtonként, és mindegyik bájthoz adjál hozzá tízet! Ez valójában egy karakterkód, ezt alakítsd át `char` típusú értékké!
Majd egymás után írd ki ezeket a konzolra! Ne használj közöttük sortörést!


## Senior

A `Client` osztály reprezentál egy ügyfelet `name` és `regNumber` attribútummal (`String`). Az második a regisztrációs száma, mely egyedileg azonosít egy ügyfelet.  Írj egy `Clients` osztályt, mely az ügyfeleket tartja nyilván.
Regisztrációs szám alapján le kell tudni kérdezni egy ügyfelet a `findByRegNumber(String)` metódussal. Dobjon `IllegalArgumentException`-t, ha nincs. Fontos, hogy nagyon gyors legyen a lekérdezés a regisztrációs szám alapján!
Ezen kívül legyen benne egy `List<Client> findByName(String)` metódus is, ami pedig névtöredék alapján keres! Ez lehet lassabb.

# 2021-01-22 (`week12d05`)

## Junior

Töltsd le az index.hu nyitólapját böngészőből, ez egy html állomány! Másold be a projektedbe (`index.html`) néven! 
Ez egy szöveges állomány. Olvasd be, és számold meg, hány sorban szerepel a koronavírus szó!

## Senior

Adott az alábbi osztály:

```java
public class Employee {
    private int age;
    private int skillLevel;
    private String name;
    private List<String> skills;
}
```

Készítsetek az `EmployeeFilter` osztályba egy `List<Employee> countSeniorDevs(List<Employee> employees)`
metódust, mely a megadott `employees`-ből kiválogatja a senior (ahol a skill level nagyobb, vagy egyenlő, mint 3) fejlesztőket!
A fejlesztők rendelkeznek a programming skill-lel!

# 2021-01-25 (`week13d01`)

## Junior

A GitHubon a `examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv` fájl tartalmazza a magyar városok listáját.
Add vissza a leghosszabb nevű várost!

## Senior

A GitHubon a `examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv` fájl tartalmazza a magyar városok listáját.
Add vissza az ábécésorrendben első város nevét és irányítószámát!