# Weather App

Ca sa il pornesti:
Mergi in WeatherApp.kt si apesi pe sageata verde de langa fun main
Intrii in browser si cauti localhost:8080/orch/getforecast/{location}

Acest proiect a fost realizat in cadrul laboratorului 3 de sisteme distribuite.
Aceasta aplicatie simuleaza un serviciu meteo si vom realiza refactorizari pentru a o imbunatati.
Structura initiala:
-- de adaugat diagrama din laborator
In cadrul acestui laborator, vom lucra cu containerul Spring, cu o structura alcatuita din controllere, interfete si servicii.
Ne vom concentra pe respectarea principiilor SOLID, intelegerea notiunilor:
*Inversarea dependentelor: Utilizarea interfetelor (dependenta de interfete) si nu a implemetarilor acestora -> decuplarea serviciilor.
    Ex: Vom impleemnta TimeInterface pentru a decupla serviciul de prognoza de ceasul sistemului.
*Open/Closed Principle (Deschis la dezvoltare, Inchis la modificari): permite adaugarea de noi furnizori meteo fara a modifica controller-ul
*Segregarea interfectelor: Interfete atomice pentru cautarea locatiei si prognoza.
-> Am implementat clasa LocationModel, pentru a usura migrarea de la o implementare care localizeaza int-un anumit format informatia de altul

## Introduceți un nou serviciu pentru filtrarea în funcție de zona geografică a accesului larespectivele informații (există un black list furnizat ca referință/link relativ/absolut/url)dezone pentru care aplicația va anunța că nu este permis accesul la astfel de informații pentruzona x (x conform locației reale în care se află nodul de calcul (de fapt cea stabilitălanivellocal pentru sistemul de operare)))
-> La primirea unei cereri, trebuie sa verificam acea locatie intr-o lista neagra.
    ->BlacklistService+ BlacklistInterface :Vom crea o interfață și o implementare care să verifice dacă locația curentă este permisă.
    ->La primirea cererii, verificam in primul rand daca este permis accesul la informatii despre acea locatie.
