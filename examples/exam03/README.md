# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! 
Bármely régebbi osztályt megnyithatsz.
A feladatok megoldásához ajánlom figyelembe a cheet sheetet:

https://github.com/Training360/strukturavalto-java-public/blob/master/cheet-sheet/cheet-sheet.md

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

A két feladatra 1,5 órád van összesen!

Old meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Ha letelik a másfél óra az első commitodhoz képest és nem fejezted be, megint commitolj, akkor is,
ha nem vagy kész! Utána nyugodtan folytathatod a megoldást, akár több órát is
ülhetsz felette, ha kész vagy, commitolj!

## Hisztogram

Olvass be egy szöveges fájlt soronként, melyben soronkont számok vannak.
Majd hozz létre egy stringet, mely ugyanennyi sort tartalmaz,
és annyi csillagot ír ki egymás mellé soronkont, amennyi a bemeneti
fájlban lévő szám.

Azaz a bemeneti fájl:

```
3
4
1
2
```

A létrehozott String:

```
***
****
*
**
```

Figyelj, hogy az algoritmusod lehetőleg hatékony legyen!

A `Histogram` osztályba dolgozz, tesztje `HistogramTest`. Minden sor után legyen sortörés, az utolsó után is.

## Travel agency

Utazási iroda hajóutakat szervez. Minden hajóút egy adott hajóval történik, amelynek neve és befogadóképessége a egy `Boat` osztályban van tárolva.

Az utasok adott hajóra, adott osztályra foglalnak helyet. A helyfoglaláskor azonban ellenőrizni kell, hogy a befogadóképesség alapján van-e még hely. 
Ha nincs, egy kivételt várunk a megfelelő szöveggel.
A `CruiseClass` enum tárolja a különböző osztályokat. LUXURY, FIRST és SECOND osztályok vannak. Az ár számolása úgy történik, hogy venni kell
a hajóhoz tartozó alapárat, és meg kell szorozni az
osztályhoz tartozó szorzóval, rendre 3,0, 1,8 és 1,0. 

![UML](images/travel-agency.png)

* `bookPassenger()`: egy foglalás. Ellenőrizni kell, hogy van-e még elég hely.
* `getPriceForPassenger()`: visszaadja, hogy mennyibe kerülne a foglalás. Ez a metódus még NEM foglal.
* `findPassengerByName()`: foglalás megkeresése név alapján
* `getPassengerNamesOrdered()`: visszaadja a foglalást végzők neveit ábécé sorrendben
* `sumAllBookingsCharged()`: összegzi, hogy mennyi az összes bevétel
* `countPassengerByClass()`: visszaadja, hogy osztályonként mennyien foglaltak