# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! 
Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz! A `pom.xml` tartalmát nyugodtan át lehet másolni. 
Projekt, könyvtár, repository neve legyen: `kepesitovizsga-potvizsga`. 
GroupId: `hu.nive.ujratervezes`, artifactId: `kepesitovizsga-potvizsga`. Csomagnév: `hu.nive.ujratervezes.kepesitovizsga`.

A feladatok megoldásához ajánlom figyelembe a cheet sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

Az öt feladatra (ebből kettő az Army feladat) 3 órád van összesen!

Old meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik az idő első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! A vizsga lezárása előtti 15 perces intervallumban pusholhatsz csak.

## Betűk többszörözése

Hozd létre a `LetterMultiplier` osztályt, és annak a `multiply(String input, int number)` metódusát!
A metódus feladata, hogy a paraméterben kapott String minden betűjét többszörözze meg annyi darabra, amit számként paraméterben kapott, és ezt a Stringet adja vissza.

Azaz ha a bemeneti string `java`, az egész szám pedig `3`, akkor a kimeneti string `jjjaaavvvaaa`,

Ha az inputban kapott String üres String, vagy null, vagy a számként megkapott paraméter kisebb, mint 0, dobjon `IllegalArgumentException`-t.

## Forest simulator

Ebben a feladatban modellezned kell egy erdőt, tele fával, és egy
favágót, mely a megfelelő fákat kivágja. Sőt, a fák nőnek is, eső
hatására.

### Tree (fa)

Hozz létre a `hu.nive.ujratervezes.forest` csomagban
egy `Tree` osztályt, melynek van egy magassága (`height`)!
Létre lehessen hozni magasság megadása nélkül (ekkor az alapértelmezett
érték a `0`), és a magasság megadásával is!
Legyen egy `irrigate()` metódusa, paraméter nélkül, azonban ezt
ne implementáld! Lehessen lekérdezni a magasságát!

### WhitebarkPine

Ez egy fa, az `irrigate()` metódusának hívása esetén a magassága
nőjjön kettővel!

### FoxtailPine

Ez egy fa, az `irrigate()` metódusának hívása esetén a magassága
nőjjön kettővel!

### Lumberjack (favágó)

Létre lehessen hozni egy favágót paraméter megadása nélkül!
Legyen egy `canCut()` metódusa, amely paraméterül vár egy fát.
Visszaad egy logikai értéket, mely `true`, ha a fa magasabb, mint
4 egység.

### Forest (erdő)

Az erdőben fák vannak. Létrehozhatod úgy, hogy fák listáját adod
át paraméterül. A következő metódusai legyenek:

* `rain()` - mindegyik fának meghívja az `irrigate()` metódusát
* `cutTrees()` - paraméterül vár egy `Lumberjack` példányt. Mindegyik
    fát eltávolítja az erdőből, melyet a favágó ki tud vágni. Ne
    feledd, erre van a favágó `canCut()` metódusa!
* `isEmpty()` - logikai értékkel tér vissza, hogy üres-e az erdő
* `getStatus()` - egy string listában visszaadja, hogy milyen fák vannak az erdőben, pl.

```text
[
  'There is a 3 tall WhitebarkPine in the forest.',
  'There is a 2 tall WhitebarkPine in the forest.',
  'There is a 4 tall FoxtailPine in the forest.'
]
```

Minden fához egy sor tartozik. Nem kell összesíteni a fákat típus szerint!

## Ignore the comments

Írd meg a `hu.nive.ujratervezes.io.FileHandler` osztály
`sumIgnoreComments()` nevű metódusát. Ez egy fájlnak a
relatív elérési útvonalát várja. A fájl főként egész számokat tartalmaz.
Azonban vannak olyan sorok, melyeket nem kell feldolgozni,
ezek két perjellel (`//`) kezdődnek. Azon számokat, melyek
előtt nincsenek perjelek, össze kell adni. Egy szám
értéke maxium 10_000. Minden sor csak egy számot tartalmaz,
vagy perjelekkel kezdődően bármit.


### Példa

Bemenet:

```text
1
2
3
```

Kimenet:

`6`, hiszen a három szám összege hat

Bemenet:

```text
1
// 8
2
// aaaa
3
```

Kimenet:

`6`, hiszen a három szám összege hat, és a perjelekkel kezdődő
sorokat nem kell figyelembe venni

## Webshop

Egy webshop adatbázisával dolgozol, amelyben rendelések (`orders`) vannak.

### Adatbázis

Az adatbázis egyetlen táblát tartalmaz, `orders` néven, az alábbi oszlopokkal:

- `id` int primary key (elsődleges kulcs)
- `total` int
- `order_date` datettime
- `customer_name` varchar

Például:

| id   | total  | order_date               | customer_name         |
| :--- | :----- | :----------------------- | :-------------------- |
| 1    | 959.1  | 2021-01-22T00:28:53.986Z | Olga Johns            |
| 2    | 703.6  | 2021-01-22T09:23:59.829Z | Maria Lebsack         |
| 3    | 1374.1 | 2021-01-24T13:52:07.161Z | Gloria Hyatt          |
| 4    | 1385   | 2021-01-22T03:40:41.063Z | Clara Spinka          |
| 5    | 747.7  | 2021-01-20T21:52:58.248Z | Lonnie Stamm          |
| 6    | 517.9  | 2021-01-24T15:38:49.595Z | Maria Lebsack         |
| 7    | 830.4  | 2021-01-20T07:29:12.267Z | Lonnie Stamm          |
| 8    | 967.3  | 2021-01-20T12:53:27.423Z | Pat Glover            |
| 9    | 931.2  | 2021-01-21T07:33:14.933Z | Maria Lebsack         |
| 10   | 1141.2 | 2021-01-19T20:56:49.386Z | Stacy Doyle Jr.       |
| 11   | 569.4  | 2021-01-20T23:42:01.551Z | Lester Wyman          |
| 12   | 1023.4 | 2021-01-24T03:24:39.362Z | Gloria Hyatt          |
| 13   | 788.7  | 2021-01-21T00:49:51.610Z | Mrs. Carrie Powlowski |
| 14   | 996.5  | 2021-01-19T20:53:52.471Z | Barry Pollich         |
| 15   | 450.7  | 2021-01-21T11:35:42.433Z | Mrs. Carrie Powlowski |

## Java alkalmazás

Hozd létre a `WebshopService` osztályt, melyben egyetlen publikus metódus van, `getValuableCustomers` néven, 
ami térjen vissza azoknak az ügyfelek a nevével (`customer_name`), akik több, 1000-ért rendeltek, ABC szerint növekvő sorrendben.

Ha az adatbázis üres, akkor a metódus térjen vissza üres listával.
