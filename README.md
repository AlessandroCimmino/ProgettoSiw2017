# ProgettoSiw2017

REQUISITI:
Si vuole realizzare il sistema informativo su Web per la gestione di una piccola galleria d’arte.
Possono accedere al sistema utenti generici e un amministratore.
L’amministratore, previa autenticazione, può inserire e rimuovere le informazioni relative alle
opere d’arte presenti nella galleria; per semplicità supponiamo che le opere d’arte siano quadri
e che per ciascuno di essi siano di interesse il titolo, l’anno in cui è stato realizzato, la tecnica,
le dimensioni, l’autore. Dell’autore sono di interesse nome, cognome, nazionalità data di
nascita e data di morte.
L’utente generico può accedere alle informazioni della galleria attraverso diversi percorsi di
navigazione, opportunamente predisposti (ad esempio, per autore, oppure per anno, etc.).

CASI D'USO:

------------CASO D'USO UC1-----------

INSERIMENTO OPERA D'ARTE
  1.  L'amministratore vuole inserire i dati relativi ad un'opera d'arte presente nella galleria
  2.  L'amministratore inserisce titolo, anno di pubblicazione, tecnica e dimensioni e sceglie l'autore
  3.  L'amministratore conferma l'operazione
  4.  Il sistema registra l'opera d'arte

Estensioni
  1-2a. L'amministratore annulla l'operazione

------------CASO D'USO UC2-----------

RIMOZIONE OPERA D'ARTE
  1.  L'amministratore vuole rimuovere un'opera d'arte dal sistema
  2.  L'amministratore visualizza le opere d'arte
  3.  Il sistema mostra l'elenco delle opere d'arte
  4.  L'amministratore sceglie l'opera d'arte da eliminare
  5.  Il sistema chiede una conferma all'amministratore
  6.  L'amministratore conferma
  7.  Il sistema rimuove l'opera d'arte

Estensioni
  4a. L'amministratore inserisce il titolo o l'autore dell'opera d'arte
    1.  Il sistema mostra l'elenco delle opere d'arte in corrispondenza con il parametro inserito

------------CASO D'USO UC3-----------

MODIFICA DATI OPERA D'ARTE
  1.  L'amministratore vuole modificare i dati di un'opera d'arte
  2.  L'amministratore seleziona l'opera da modificare
  3.  Il sistema mostra i dati dell'opera d'arte da aggiornare
  4.  L'amministratore inserisce i dati aggiornati
  5.  L'amministratore conferma l'operazione
  6.  Il sistema registra l'opera aggiornata

Estensioni
  1-4a  L'amministratore annulla l'operazione

------------CASO D'USO UC4-----------

VISUALIZZAZIONE OPERE D'ARTE

L'utente può visualizzare le opere d'arte della galleria in vari modi.
Può visualizzare l'elenco di tutte le opere d'arte, cercare un'opera in base al titolo
all'autore, all'anno di pubblicazione, alle dimensioni o alla tecnica.



