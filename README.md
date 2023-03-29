# projekt: Swing retro-stiilis mäng
Markus Michelis, Robin Mürk

Projekti eesmärgiks oli teha algeline 2D mäng kasutades swing graafilist liidest. 
Programmi ülesehitus: Swing sarnaneb paljuski JavaFXile. Tegevus tõimub kõik kahes raamis (JFrame), kuhu sisse on pandud paneelid(JPanel). Kõik graafiline tegevus toimub JPaneli sees. 
Maastik on moodustatud klassiga Ruudustik.java, kus võetakse sisse maastiku pildid ja tekstfail igas reas olevale numbrile vastab üks piltidest. Pildid prinditakse ükshaaval õigesse kohta. 
Mängu loogika: On peamine paneel MänguPaneel kus luuakse muutujad ja kõik objektid: karakter, maastik, kirst jne. Luuakse uus Lõim (Thread) mis, vaikimisi kutsub sisseehitatud meetodi “run”, kus toimub ka peamine mängu tsükkel. Samuti on meetod “paint” mis kutsutakse vaikimisi, mis joonistab paneelile vastava graafika. Klaviatuuri sisend on võetud on võetud klassist KeyListner.


Klassid:
Main -  luuakse peaaken ja kutsutakse programm välja 
MänguPaneel - jooksutab mängu run meetodiga, kutsub kaardi ja tegelase joonistamise paint meetodiga, uuendab tegelase positsiooni uuendaPositsiooni meetodiga
Ruudusitik - joonistaMaastik meetodiga laseb joonistada kaardi
MenuPaneel - luuakse uus frame menüü jaoks ja lisatakse sinna vajalikud 
väljad nime ja mängu minemise jaoks
PeaTegelane - laseb printida karakterit meetodiga prindiKarakter
Andmed - liides hoidmaks andmeid (nagu ekraanilaius), mida vaja mitmes klassis
KlaviatuuriSisend - karakteri liigutamiseks valitud nupud, mida kasutatakse MänguPaneelis uuendaPositsiooni meetodis
Kast - genereerib suvalisse kohta antud alal kasti

Etappideks:
tegime algse tööjaotuse - alustasime mapi loomise, Main klassi ja mänguPaneeliga
kui need valmis liikusime tegelase, lõimede, peamise mängu tsükkli ja menüü juurde
viimaks lisasime kasutajalt nime küsimise ja kasti genereerimise

Panus:
Robin - Main, MänguPaneel, PeaTegelane, Andmed, KlaviatuuriSisend, Kast, lisaks ka KokkuPõrkeKast ja Ese klasside algus, mis oleks edasiarendusel kasulikud. Ajakulu - 20h

Markus - Main, MänguPaneel, MenuPaneel, Andmed, Ruudustik. Ajakulu - 18h kindlasti

Mured ja rahulolud:
Võtsime liiga suure projekti ette. Liiga palju aega kulus uue materjaliga tutvumiseks. Puudust tundsime eelkõige graafilise osa mitte tundmisest. Oleks pidanud alustama varem ja sügavamalt tutvuma Swingiga paremini, oleks jõudnud kaugemale. Rahule võib jääda sellega, et mäng toimib algselt ja saime uue väljakutsega hakkama, aga mängu sisulist poolt oleks vaja veel arendada. Kuna lõime graafilise liidesega mängu siis programmi käivitamisel oli kohe näha, mis viga ja mida parandada vaja.
