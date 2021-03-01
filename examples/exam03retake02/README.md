# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! 
Bármely régebbi osztályt megnyithatsz.
A feladatok megoldásához ajánlom figyelembe a cheet sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

A két feladatra 1,5 órád van összesen!

Oldd meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik a másfél óra az első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! Utána nyugodtan folytathatod a megoldást, akár több órát is
ülhetsz felette, ha kész vagy, commitolj!

## Pontozás

A feladatokra 10-10 pont adható.

A vizsgatevékenység akkor eredményes, ha a vizsgázó a megszerezhető összes
pontszám legalább 51 %-át elérte.

## Balatoni viharjelzés

A https://vmonitor.rsoe.hu/api/mapApi/stations.php címen le lehet tölteni
az aktuális balatoni viharjelzéseket.

Írj egy programot, mely kilistázza, hogy hol van vihar! Ábécésorrendbe rendezve!

A `BalatonStorm` osztály `getStationsInStorm()` metódusát implementáld!
Paraméterként kap egy `BufferedReader`-t, és visszaadja az állomások listáját.
A fájl a következő formátumú.

```json
[
  {
    "id": 5,
    "allomas": "Siófok (OMSZ)",
    "lat": "46.910647",
    "lng": "18.040237",
    "description": "A közforgalmú MAHART kikötőtől délnyugatra kb. 200 méterre",
    "level": 0,
    "groupId": "BE",
    "stationType": "LED"
  },
  {
    "id": 6,
    "allomas": "Siófok-H. Erzsébet",
    "lat": "46.91567",
    "lng": "18.06600000000003",
    "description": "Hotel Erzsébet szálló tetején.",
    "level": 0,
    "groupId": "BE",
    "stationType": "LED"
  }
]
```

Azokon az állomásokon van vihar, ahol a `level` értéke `3`.

# Tennivalólista

Írj egy tennivaló osztályt (`Todo`), melynek attribútumai: `text`, `state` és `priority`,
rendre `String`, `State` és `int` típusú. A `State` egy saját enum `COMPLETED` és
`NON_COMPLETED` értékekkel. A prioritás 1 és 5 közötti egész szám. Ha nem ilyet kap,
akkor kivételt dob. Konstuktorban csak a szövegét és a prioritását kell megadni,
alapértelmezetten `NON_COMPLETED` állapottal jön létre. Legyen egy `complete()` metódusa,
mely átállítja az állapotát!

Legyen egy `TodoList` osztály, mely több tennivalót tartalmaz! Egy `List<Todo>` attribútumban
tartalmazza a tennivalókat.

Metódusai:

* `getNumberOfItemsLeft()` - visszaadja a még el nem készült tennivalók számát 
* `getMostImportantTodosText()` - visszaadja a legyfontosabb tennivalókat. Nem feltétlen van 1-es prioritású.
* `deleteCompleted()` - a listából kitörli az elvégzetteket