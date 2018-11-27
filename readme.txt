Stworzone 	- klasy to : 

1. Konto 	- zawiera konta gotówkowe w PLN.
2. Akcja 	- zawiera akcje
3. Future	- zawiera kontrakty 
4. Trades	- zawiera wszystkie transakcje
5. QuotesEq	- zawiera notowania akcji (klasa QuotesEq)
6. QuotesFu	- zawiera notowania kontraktów (klasa QuotesFu)


Relacje :

Konto <-> Future - transakcje rozliczenia dziennego kontraktu
Notowania Futures <-> wiele notowań (daty) do jednego kontraktu
Notowania Equities <-> wiele notowań (daty) do jednej akcji


Transakcja : Identyfikuje instrument, rodzaj (np. Kupno/Sprzedaż), datę transakcji oraz datę rozliczenia, prowizję, opis. Osobne bazy danych transakcji dla każdego rodzaju instrumentów ze względu na wygodę odczytu danych- chodzi głównie o unikalny numer identyfikacyjny tak, żeby nie trzeba było sprawdzać dodatkowo, oprócz numeru, także typu instrumentu.

Account - rodzaje transakcji : Wpłata, Wypłata, Saldo (zapisanie salda).
Account : id, Name, value(to be calculated), date (to be calculated - last transacion date), description - krótki opcjonalny opis
