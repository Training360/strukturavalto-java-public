# Vizsgafeladat

A feladatok megoldásához csak az IDEA fejlesztőeszközt és
a [Java API-t](https://docs.oracle.com/en/java/javase/15/docs/api/index.html)
használhatod. Bármely régebbi osztályt megnyithatsz, de csak azt.

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!
Majd old meg a feladatokat, minden feladat megoldását egy külön commitban
add be!
Amikor letelik az egy óra az első commitodhoz képest, megint commitolj, akkor is,
ha nem vagy kész! Utána nyugodtan folytathatod a megoldást, akár 2 órát is
ülhetsz felette, ha kész vagy, commitolj!

Nem baj, ha nem egy commitban megy fel egy megoldás, de próbálj rá törekedni.

A két feladatra 1 órád van összesen!

A junior és mid level csoport két feladata van elől, a senior csoporté 
hátul. Mindenki megoldhatja a másik csoport feladatát is!

Ha úgy érzed, nem megy a senior csoport feladata, kezdheted tiszta lappal,
és csináld meg a junior/mid level csoport feladatát! (Ekkor a teszt esetek
commitolásához képest újra van egy órád!)

## Pontozás

Mindegyik feladatra maximum húsz pont adható.

Egy feladatra 0 pontot ér, ha le sem fordul az adott projekt. Tovább 0 pontot ér, ha a lefordul,
de egy teszteset sem fut le sikeresen. 0 pontot ér, ha a forráskód olvashatatlan, nem felel meg
a konvencióknak, nem követi a clean code alapelveket. 0 pont adandó, ha kielégíti a teszteseteket, de a szöveges követelményeknek nem felel meg.
Pontokat a további működési funkciók megfelelősségének arányában kell adni a vizsgafeladatra:

* 5 pont: az adott projekt lefordul, néhány teszteset sikeresen lefut, és ezek funkcionálisan is helyesek. Azonban több teszteset nem fut le, és a kód is olvashatatlan.
* 10 pont: a projekt lefordul, a tesztesetek legtöbbje lefut, ezek funkcionálisan is helyesek, és a clean code elvek nagyrészt betartásra kerültek.
* 20 pont: ha a projekt lefordul, a tesztesetek lefutnak, funkcionálisan helyesek, és csak
apróbb funkcionális vagy clean code hibák szerepelnek a megoldásban.

A vizsgatevékenység akkor eredményes, ha a vizsgázó a megszerezhető összes
pontszám legalább 51 %-át elérte. 

## Junior/mid level feladatok

### Tömbök

Írj egy olyan metódust az `ArraySelector` osztályban, mely egy kapott tömbből minden második elemet
kiválogat, és egy szövegként összerak, szögletes zárójelek között!

A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem
páros, a második, azaz egyes indexű elem páratlan, stb.

Ha nulla elemű a tömb, akkor üres stringet adjon vissza!

## CV

Egy önéletrajzot reprezentáló osztályt kell létrehozni,
melyben van egy név, valamint skillek (hogy mihez ért az illető). A
skill egy névvel és egy számmal (szint) rendelkezik, utóbbi
1 - 5 között.

Az önéletrajz a `Cv` osztály pár metódussal,
a skill a `Skill` osztály.

A skillek megadása a nevével, valamint a szintjével
történik, pl. `programming (5)`.

A `findSkillLevelByName()` a skill neve alapján visszaadja
annak szintjét.

## Senior feladatok

## Fotókollekció

Írj egy `Photo` osztályt, melynek van egy neve és egy minősítése! Létre lehet hozni
csak névvel, vagy névvel és minősítéssel. A minősítés egy `Quality` enum, hogy a felhasználó
hány csillagot adott rá, lehet ez `Quality.NO_STAR`, `Quality.ONE_STAR` és `Quality.TWO_STAR`.
A `Photo` osztály implementálja a `Qualified` interfészt, melynek definiált a `Quality getQuality()` 
és a `void setQuality(Quality)` metódusa.

Írj egy `PhotoCollection` osztályt, mely a fotók egy listáját tartalmazza! Fotókat lehet hozzáadni
névvel, ekkor még nem kapnak csillagot. Az `addPhoto()` metódus legyen varargs-os!

Írj egy `starPhoto()` metódust, mely kikeresi a megfelelő nevű fotót, és beállítja rajta a paraméterként
átadott minősítést! Ha nem talál a megadott névvel fotót, `PhotoNotFoundException` kivételt dob. Ez
egy saját kivétel, terjessze ki a `RuntimeException` osztályt!

Írj egy `numberOfStars()` metódust, mely visszaadja, hogy a képeken összesen mennyi csillag van!
Ha nincs minősítése, akkor 0 csillag. Ha a minősítése `Quality.ONE_STAR`, akkor egy csillaggal kell
 számolni. Ha a minősítése `Quality.TWO_STAR`, akkor két csillaggal kell számolni.

Tartsd be az elnevezési konvenciókat! A megoldásban csak foreach-eket használj!

## Fájlkezelés - lottószámok

Az `src/test/resources` mappában találsz egy `otos.csv` fájlt 
(ez egyébként a https://bet.szerencsejatek.hu/jatekok/otoslotto/sorsolasok
címről tölthető le), és olvasd be. Tárold el, hogy melyik számot hányszor húzták ki. A fájl pontosvesszővel (`;`) elválasztva tárolja
a mezőket. A 12 - 16. mező (nullával indexelve 11 - 15) tárolja a kihúzott számokat.

Írj egy `LottoReader` osztályt! Használj egy 90 elemű tömb attribútumot! Vigyázz, a 90-es szám a tömb 89. eleme.

Konstruktorban töltsd be a fájlt, ami paraméterként egy `InputStream`-et vár. 
Mivel a fájl folytonosan frissül a megadott webhelyen és így a tesztesetek konkrét várt értékei is változhatnak, 
a mellékelt fájl alapján dolgozz!