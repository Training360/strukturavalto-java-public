# Vizsgafeladat

A feladatok megoldásához bármilyen Java fejlesztőeszközt használhatsz! 

Új repository-ba dolgozz! A `pom.xml` tartalmát nyugodtan át lehet másolni. 
Amennyiben szeretnél, használhatsz Gradle-t is.
Projekt, könyvtár, repository neve legyen: `bemenetivizsga`. 
GroupId: `hu.nive.ujratervezes`, artifactId: `bemenetivizsga`. Csomagnév: `hu.nive.ujratervezes`.

A feladatok megoldásához ajánlom figyelembe a cheet sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

Az öt feladatra (ebből kettő a Pokemonok feladat) 3 órád van összesen!

Old meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik az idő első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! A határidő lejárta utáni commitokat nem tudjuk figyelembe venni.


## Maximummal szorzás

### Bevezetés

Ebben a feladatban egy metódust kell létrehoznod, ami egy tömböt dolgoz fel.

Az alább meghatározott metódust a `multiplybymaximum.MultiplyByMaximum` osztályban írd meg!

Használd
az előre megírt teszteseteket az algoritmusod kipróbálására!

### Feladatleírás

Írj egy metódust a `MultiplyByMaximum` osztályban a következő specifikáció alapján:

- a metódus neve:
  - `multiplyByMaximum` (maximummal szorzás)
- bemeneti paraméterei:
  - `numbers`, egy egész számokat tartalmazó tömb
  - `n`, egy egész szám
- visszatérési értéke:
  - egy új, egész számokat tartalmazó tömb

A `multiplyByMaximum()` metódus:

- kiválasztja a `numbers` tömb legnagyobb elemét (maximumát)
- a `numbers` tömb minden `n`-edik elemét megszorozza a maximummal
- a többi elemet átmásolja a bemeneti tömbből módosítás nélkül
- visszaadja az így létrejött új tömböt

Ne használd a beépített `sort()` vagy `max()` metódusokat a legnagyobb szám
kiválasztásához!

Kivételkezelés:

- ha a metódust úgy hívjuk meg, hogy a `numbers` paraméter egy üres tömb, akkor
  adjon vissza egy új, üres tömböt
- ha a metódust úgy hívjuk meg, hogy a `numbers` paraméter értéke `null`, akkor
  dobjon `IllegalArgumentException`-t
- ha a metódust úgy hívjuk meg, hogy az `n` paraméter értéke kisebb, mint `1`,
  akkor dobjon `IllegalArgumentException`-t

Az előre megírt tesztesetek segítenek a feladatmegoldásban!

### Példák

A példák megfelelnek az előre megírt teszteseteknek!

|     | `numbers`            | `n`  | visszatérési érték         |
| :-: | :------------------- | :--: | :------------------------- |
|  1  | `[0, 1, 5, 4]`       | `3`  | `[0, 1, 25, 4]`            |
|  2  | `[0, 3, 5, 4, 3, 6]` | `2`  | `[0, 18, 5, 24, 3, 36]`    |
|  3  | `[0, 2, 4, 3, 6]`    | `1`  | `[0, 12, 24, 18, 36]`      |
|  4  | `[0, 1, 5, 4]`       | `10` | `[0, 1, 5, 4]`             |
|  5  | `[]`                 | `1`  | `[]`                       |
|  6  | `null`               | `1`  | `IllegalArgumentException` |
|  7  | `[0, 1, 5, 4]`       | `0`  | `IllegalArgumentException` |
|  8  | `[0, 1, 5, 4]`       | `-1` | `IllegalArgumentException` |

## Pokémonok

### Bevezetés

Ebben a feladatban létre kell hoznod a `Pokebag` osztályt, amiben különböző
fajtájú pokémonokat lehet eltárolni.

Az osztályokat a lentebb olvasható leírás alapján, a `pokebag` csomagon
(package) belül hozd létre!

Használd
az előre megírt teszteseteket a megoldásod kipróbálására és ellenőrzésére!

### Feladatleírás

#### Pokemon

- Van életereje (`health`), aminek a kezdőértéke 10, valamint egy ereje
  (`strength`), ami a pokémon fajtájától függ.
- Van még neve (`name`), ami opcionálisan megadható, az alapértelmezett érték
  pedig a pokémon fajtájától függ.
- A `speak` (beszél) metódus implementálása a pokémon fajtájától függ.

#### Pikachu

- Az ereje (`strength`) 10 pont.
- Az alapértelmezett neve (`name`) Pikachu.
- A `speak` metódus visszatérési értéke `Pika-pika`.

#### Bulbasaur

- Az ereje (`strength`) 6 pont.
- Az alapértelmezett neve (`name`) Bulbasaur.
- A `speak` metódus visszatérési értéke `Bulba-saur`.

#### Charmander

- Az ereje (`strength`) 8 pont.
- Az alapértelmezett neve (`name`) Charmander.
- A `speak` metódus visszatérési értéke `Char-char`.

#### Pokebag

- Van egy pokémonokat tartalmazó listája.
- Az `add` (hozzáad) metódus paraméterként kap egy pokémont, majd azt hozzáadja
  a listához.
  - Ha a paraméterként értéke null, a metódus dobjon
    `IllegalArgumentException`-t.
- A `getNumberOfPokemons` (pokémonok számának lekérése) visszaadja a listában
  eltárolt pokémonok számát.
- A `getStrongest` (legerősebb lekérése) metódus visszaadja a legnagyobb erővel
  (`strength`) rendelkező pokémont.
  - Ha ugyanannyi több pokémon ereje is, rád van bízva, melyiket adja vissza ezek
    közül.
  - Ha a lista nem tartalmaz egy elemet sem, a metódus dobjon
    `NoSuchElementException`-t.
- A `getByIndex` (lekérés sorszám alapján) metódus visszaadja a paraméterként
  megkapott sorszámú pokémont a listából.
- A `fight` (harc) metódus két sorszámot kap, majd szimulál egy harcot e között
  a két pokémon között: a nagyobb erővel (`strength`) rendelkező pokémon nyer.
  - Ha a két pokémonnak megegyezik az ereje, rád van bízva, melyik nyer.
  - Csökkentse 1-gyel a vesztes pokémon életerejét (`health`).
  - Hívja meg a győztes `speak` metódusát és a visszatérési értékét írasd ki
    a parancssorra.
  - Adja vissza a győztes pokémont.
  - Ha a két paraméterként átadott `index` megegyezik, a metódus dobjon
    `IllegalArgumentException`-t (tehát ha önmagával kellene küzdenie a
    pokémonnak).

Az előre megírt tesztesetek segítenek a feladatmegoldásban!

## A leghosszabb szó

### Bevezetés

Ebben a feladatban egy metódust kell létrehoznod, ami egy fájlt dolgoz fel.

Az alább meghatározott metódust a `longestword` csomagban (package) előre
elkészített `LongestWord` osztályban írd meg!

Használd
az előre megírt teszteseteket a megoldásod leellenőrzésére!

A megoldásod kipróbálására használd a `test-files` mappában található
példafájlokat!

### Feladatleírás

Hozd létre a következő metódust a `hu.nive.ujratervezes.longestword` csomagban
(package) található `LongestWord` osztályban:

- a metódus neve:
  - findLongestWord (a leghosszabb szó megtalálása)
- bemeneti paraméterei:
  - `fileName` (fájlnév), szöveges típus
- visszatérési értéke:
  - szöveges típus

A `findLongestWord()` metódus:

- feldolgozza a `fileName` paraméterben megadott nevű fájlt
- visszaadja a fájlban található összes szó közül a leghosszabbat
- ha több ugyanolyan hosszúságú szó van, amik a fájlban a leghosszabbak,
  mindegy, hogy melyiket adja vissza
- a szavak szóközökkel vannak elválasztva
- a szavak nem feltétlenül (csak) betűket tartalmazhatnak
- az írásjeleket (`.`, `,`, stb) tekintsük a szavak részeinek
  - pl. `mattis.` egy szó, nem kell a ponttal külön foglalkozni
- ha valamilyen hiba miatt nem sikerült feldolgozni a megadott fájlt (pl. a
  fájl nem létezik), a metódus visszatérési értéke legyen egy üres string:
  `""`

Az előre megírt tesztesetek segítenek a feladatmegoldásban!

### Példák

A példák megfelelnek az előre megírt teszteseteknek!

|     | fájlnév        | visszatérési érték                               |
| :-: | :------------- | :----------------------------------------------- |
|  1  | `test1.txt`    | `Maurisinfaucibusmassaeuscelerisqueenim.`        |
|  2  | `test2.txt`    | `000000000000000001`                             |
|  3  | `test3.txt`    | `aaaaaaaaaa` vagy `bbbbbbbbbb` vagy `cccccccccc` |
|  4  | `test4.txt`    | `42`                                             |
|  5  | `doesNotExist` | `""` (üres string)                               |

Segítsünk a Madárbarátok Országos Szövetsége számára adatbázisban nyilvántartani az amatőr madárfigyelők észleléseit! 

## Madárfigyelés

Az adatbázis egy táblát tartalmaz, `birds_spotted` néven, az alábbi oszlopokkal:

- `spotter` `varchar`
- `species` `varchar`
- `date_of_spotting` `date`

Például:

| spotter        | species           | date_of_spotting |
|:---------------|:------------------|-----------------:|
| Jane Goldfinch | american robin    |       2020-06-02 |
| Jack Osprey    | northern cardinal |       2020-05-17 |
| Jack Osprey    | european robin    |       2020-05-20 |
| Bill Goshawk   | house sparrow     |       2020-06-11 |
| Bill Goshawk   | downy woodpecker  |       2020-07-03 |
| Jack Osprey    | house sparrow     |       2020-07-15 |

### Java alkalmazás

Hozd létre az `BirdWatcher` osztályt, ami konstruktor paraméterben kapja meg az adatbáziseléréshez szükséges adatokat.

Az osztálynak egyetlen metódusa van, a `getUniqueBirds`, ami térjen vissza egy String listában az összes észlelt 
madárfaj nevével, egy madarat csak egyszer szerepeltetve, függetlenül az észlelések számától. A madárfajok ABC-sorrendben 
szerepljenek a listában!

Üres adatbázis esetén a metódus térjen vissza üres listával!
