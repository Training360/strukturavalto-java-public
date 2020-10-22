# Junior Java backend fejlesztő gyakorlati feladatok

Ez a repository tartalmazza a Junior Java backend fejlesztő gyakorlati feladatait
és megoldásait.

* A `demos` könyvtár tartalmazza a videón szereplő példákat
* Az `examples` könyvtár tartalmazza a feladatokat, a feladatokhoz tartozó automata teszteseteket
* A `solutions` könyvtár tartalmazza a megoldásokat

## Tematika

### Bevezetés a nyelvi eszközökbe

Eszközkészlet

* background - Java történeti háttér
* introjdk - Java platform
* intromaven - Maven
* introide - IDE
* introgit - Git használata az IDE-ben

Java osztályok

* classstructureio - Kiírás és beolvasás konzolról
* classstructureattributes - Objektumok és attribútumok
* classstructuremethods - Metódusok
* classstructureconstructors - Konstruktorok
* classstructureintegrate - UML, példányok konzol íráskor/olvasáskor

A nyelv építőkövei

* conventions - Kódolási konvenciók
* localvariables - Literálok és lokális változók
* statements - Kifejezések és utasítások
* packages - Csomagok
* javaapi - Java API
* distjar - JAR állomány
* stringtype - Szöveges típus
* introdate - Dátum és időkezelés alapok
* introcontrol - Bevezetés a vezérlési szerkezetekbe

Bonyolultabb típusok

* array - Tömbök
* arrayofarrays - Tömbök tömbje
* arrays - Tömbök kezelése
* arraylist - Lista
* debug - Debug
* finalmodifier - Konstans értékek használata
* math - Math és Random osztály

Bevezetés az osztályok és objektumok világába

* objects - Objektumok
* attributes - Bevezetés az attribútumok használatába
* introconstructors - Bevezetés a konstruktorok használatába
* intromethods - Bevezetés a metódusok használatába
* references - Referenciák

### A Java nyelv részletes megismerése

Típusok és operátorok

* literals - Literálok
* primitivetypes - Egyszerű típusok
* enumtype - Felsorolásos típus
* operators - Operátorok
* typeconversion - Típuskonverzió
* numbers - Egész és lebegőpontos számok

Vezérlési szerkezetek

* introjunit - Unit tesztelés JUnittal
* controlselection - Vezérlési szerkezetek és az elágazás
* controliteration - Ciklusok
* controladvanced - Haladó vezérlési szerkezetek
* introexception - Bevezetés a kivételkezelésbe

String, StringBuilder

* stringbasic - String alapok
* stringconcat - Konkatenáció
* stringmethods - Főbb String metódusok
* stringbuilder - StringBuilder
* stringscanner - Scanner
* filescanner - Fájl olvasása Scannerrel
* formatlocaleprintf - printf

Programozási tételek és egyéb algoritmusok

* algorithmssum - Összegzés tétele
* algorithmscount - Számlálás tétele
* algorithmsmax - Szélsőérték keresés tétele
* algorithmsdecision - Eldöntés tétele
* recursion - Rekurzió

### Objektumorientáltság

Attribútumok és metódusok

* immutable - Immutable objektumok
* javabeans - JavaBeans objektumok
* methodstructure - Metódusok
* methodpass - Értékmásolás szerinti paraméterátadás
* methodparam - Metódus paraméterek
* methodvarargs - Változó hosszúságú paraméterlista
* methodchain - Metódus hívások láncolása
* methoverloading - Metódusnév túlterhelés
* staticattrmeth - Statikus attribútumok és metódusok

Konstruktorok és inicializátorok

* defaultconstructor - Default és paraméter nélküli konstruktor
* constructoroverloading - Konstruktor túlterhelés
* initializer - Inicializátorok

Öröklődés

* introinheritance - Öröklődés
* inheritanceconstructor - Konstruktorok és az öröklődés viszonya
* objectclass - Object ősosztály
* inheritanceattributes - Attribútumok öröklődése
* inheritancemethods - Metódusok öröklődése

Absztrakt osztályok és interfészek

* abstractclass - Absztrakt osztályok
* interfaces - Interfészek
* interfacedefaultmethods - Default interfész metódusok
* interfacestaticmethods - Statikus interfész metódusok
* interfaceextends - Interfészek és az öröklődés viszonya
* enumabstract - Absztrakt metódusok implementálása felsorolásos típusokban
* statemachine - Állapotgép

Haladó OO elvek

* polymorphism - Polimorfizmus
* virtualmethod - Dinamikus kötés
* isahasa - is-a has-a kapcsolatok

### Kivétel- és fájlkezelés

Kivételkezelés

* exceptions - Kivételkezelés
* exceptionclass - Saját kivétel
* exceptionmulticatch - Multi catch
* exceptionresource - Try-With-Resources szerkezet

Fájlkezelés

* ioreadstring - Szöveges állomány beolvasása
* iowritestring - String kiírása szöveges állományba
* ioreadwritebytes - Bájtos beolvasása fájlból és kiírása fájlba
* ioreader - String olvasása Readerrel
* iowriter - String írása Writerrel
* ioprintwriter - Különböző típusok írása PrintWriterrel
* iostringwriter - Kiírás Stringbe StringWriterrel
* ioreadbytes - Bájtok olvasása InputStreammel
* ioreaderclasspath - String olvasása classpath-ról
* iowritebytes - Bájtok írása OutputStreammel
* iodatastream - Adatok írása OutputStreamre, és olvasás
* iozip - Bájtok írása tömörítéssel
* ioconvert - Konvertálás a típusok között
* iofiles - Files osztály használata
* iofilestest - Fájlkezelés tesztelése


### Kollekciók és osztálykönyvtárak

Kollekció típusok

* genericsusage - Generikusok használata, diamond operátor
* collectionsequalshash - equals, hashCode
* collectionslist - List, ArrayList kontra LinkedList
* collectionsset - Set
* collectionsqueue - Queue
* collectionsmap - Map
* collectionsautoboxing - Autoboxing használata kollekcióknál

Alapvető algoritmusok

* collectionsiterator - Bejárás
* collectionscomp - Comparable és Comparator
* searching - Keresés
* sorting - Rendezés
* collectionsclass - Collections osztály (keresésen, rendezésen felüli metódusok)
* clone - A clone() metódus, deep clone
* properties - Properties állományok

Lambda kifejezések

* lambdaintro - Bevezetés a lambda kifejezések használatába
* lambdaoptional - Optional használata
* lambdacomparator - Comparator módosítások

Streamek

* lambdastreams - Streamek
* lambdaintermediate - Intermediate műveletek
* lambdaprimitives - Primitívek használata streamekben
* lambdacollectors - Collectors

Dátum és időkezelés

* datenewtypes - Új típusok, LocalDate, LocalTime, parse
* dateoldtypes - Régi dátum- és időkezeléssel kapcsolatos típusok

Architektúrák

* jvm - JVM
* thirdparty - Third party library-k