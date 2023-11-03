# Feedback homework 01:
anchored to [[191.00_anchor]]

---

## Overview:
Ich sammele hier einige Probleme / Fehler die während der ersten Hausaufgabe womöglich mehrfach aufgetreten sind, sodass man sie nochmal anschauen kann.

## Aufgabe 1:

**was macht git add**:
hier befindet sich foo.txt in der Staging Area, aber weiterhin auch in der working area, wie bar.txt
Mit git add fügen wir die Änderungen der ausgewählten Dateien in die Staging area hinzu. Das heißt also, dass wir die Änderungen zum vorherigen Zustand ( etwa dem Commit auf dem wir aufbauen werden) in die Staging area setzen. **Gleichzeitig** bleibt die Datei mit ihrem neuen Zustand aber im working area, wird also nicht irgendwie versetzt oder ähnliches.

Wir haben zuerst lokal im **working area**  die Dateien foo und bar erstellt. ( Hier weiß unser Repository noch nichts davon, diese Dateien gibt es nur in unserem working area!) 
jetzt geben wir mit `git add foo.txt` an, dass wir diese Datei der Staging-Area hinzufügen wollen, also wir übergeben die Änderungen, die da vorgenommen wurden so weiter, dass wir mit einem Commit dann anschließend diese Änderung ( Datei in dem Falle) im Repository haben werden. 

Es wird hier also eine Änderung der Datei in die **Staging Area** aufgenommen.

**konzeptuelle Repräsentation eines Commits**:
Commits sind mit einer **eindeutigen** ID versehen ( dem Hash). 
Weiterhin repräsentieren sie einen Snapshot des Repositories und hat als Inhalt die Änderungen, die von dem vorherigen Commit ( von dem dieser neue Commit jetzt quasi erstellt wurde) vorgenommen wurden. 
( Das heißt Datei X wurde verändert, Datei Y kam hinzu etcetc).
Wichtig ist auch, dass ein Commit immer ein ( oder mehrere) Parents hat. Damit beschreiben wir die Commits, auf dessen Grundlage wir diesen neuen Commit erstellt haben.

**Zustand Staging Area und Working Area (Aufgabe1)**:
foo.txt ist in der Staging-Area, ja, **aber weiterhin** auch noch in der Working area. 
Wir haben der Staging Area ja nur die Information gegeben, dass wir ihre Änderung ( dazu zählt auch das Erstellen ) übernehmen möchten.

**git rm**:
Dieses Kommando löscht die ausgewählte Datei **aus dem Working-Area** und wird diese **Änderung** anschließend in die **Staging-Area** übernehmen.
Das heißt also, dass die Datei nach dem Ausführen bereits aus der _Working-Area_ entfernt wurde, aber im Repository noch vorhanden ist. Weil sie es da noch ist, wir sie bald aber löschen möchten, wird diese Änderung in die staging area verschoben und damit angegeben, dass wir die Datei entfernen möchten.

**git graph nach Änderungen**:
Nach den Änderungen von D haben wir insgesamt **3 Commits** getätigt. Dabei bauen diese immer aufeinander auf, also A<- B <- D.
Da wir uns auf "main" befinden, ist dieser Zeiger in seiner Repräsentation auch mit auf den neusten Commit gerutscht und zeigt auf D.
Weiterhin zeigt "HEAD" auf main, denn wir befinden uns in unserem Arbeitsbereich soeben auf diesem commit.

## Aufgabe 2:

**git init**:
mit `git init .` erstellst du die Struktur im derzeitigen Ordner  
mit `git init namedesProjektes` machst du es in einen neuen Ordner, der den Namen übernimmt.

**git add && git commit**:
mit `git add` werden Änderungen aus der Working area in die **Staging Area** übernommen. Jetzt müssen diese Stages aber noch in das Repository übernommen werden --> wir müssen noch `git commit` anbringen und sie so aus der **staging area** in das **repository** übernehmen.

**git show commit**:
Mit `git show aaaa` können wir uns anschauen, welche Änderungen bei diesem commit vorgenommen wurden. 

**Zustand aus Staging Area wiederherstellen**:
Wenn wir in der Staging Area eine Änderung haben und aus Versehen noch in der Working area was verändern, dann haben wir quasi **3 Version der gleichen Datei**: 
1. die neuste Änderung ( working area) 
2. die zweitneuste Änderung ( staging area) 
3. der Grundzustand ( Repository) 
Was wir hier nutzen können: `git restore Student.scala` --> dafür kannst du dir mal die Doku `git restore --help` anschauen ^^


**Zustand von Student.scala auf Zustand des letzten Commits zurücksetzen.:**
Mit `git reset` setzen wir folglich den Zustand aus der Staging area zurück und **behalten dabei die Änderung dieses Stages** im working area. Also wir setzen den Zustand passend zurück, aber die Änderungen, die wir vorgenommen haben, sind immernoch gleich ( nur nicht mehr gestaged).

Was wir jetzt stattdessen nutzen können: `git checkout HEAD Student.scala`
Denn damit wird die Version von **Student.scala** aus dem HEAD ( also dem ausgewählten Commit, den wir gerade betrachten) übernommen und überschreibt somit die Änderungen der Staging und Working area.


**git restore Student.Scala**:
--staged würde hier die Änderung aus der Staging area zurücksetzen und auf den Stand von HEAD ( also dem aktuellen commit) zurücksetzen. 

Was wir hier also brauchen: `git restore Student.scala`, denn damit wird die Änderung, die im working area stattfand, zurück auf den Zustand der staging area gesetzt.

**spezifische Änderung in Datei modifizieren**:
Wir können hier nicht einfach `git add`, denn dann würden **alle Änderungen in der Datei** übernommen werden. Wir wollen ja aber nur einen Teil einer Datei übernehmen :).

Wir können mit `git add -p` Schritt für Schritt "veränderte Bereiche" innerhalb einer Datei betrachten und sagen, ob wir sie stagen wollen oder nicht.

Hab ich beispielsweise eine Datei, die ganz am Anfang, irgendwo in der Mitte und am Ende eine Änderung hat, können wir jetzt mit `git add -p` sagen, welche von diesen Änderungen wir stagen möchten.
Also wenn ich jetzt etwa nur die Änderung am Ende und am Anfang stagen möchte, kann ich dann mit diesem Kommando genau das bewirken!

**git blame**:
`git blame` gibt die Metadaten, die Git sammelt, wieder und kann somit angeben, wann welche Zeile von wem in welchem Commit geändert wurde.
Dabei wird nichts verändert, weil diese Informationen im Repository vorhanden sind.

### Änderung finden: ( Aufgabe 4 ): 

In der Aufgabe zuvor haben wir uns `git blame` angeschaut, was dabei helfen kann zu gucken, wann eine Zeile innerhalb einer Datei verändert wurde. Zusätzlich steht da dann noch **bei welchem Commit** das Geschehen ist. Damit können wir also in diesem Repository schauen, wann welche Zeile in welchem Commit verändert wurde. Vielleicht finden sich da dann Informationen dazu, wann Polnisch hinzugefügt wurde. 

Sofern du möchtest, kannst du diese Aufgabe im Nachhinein nochmal unter Anwendung von `git blame` verwenden. Dafür empfehle ich dir mal die "README.md" durchzulesen :) 
Wenn du magst, kannst du mich anschließend hier nochmal taggen und ich dir bei Fragen oder Problemen helfen.
Die Verwendung von git log -S ... wäre ein Ansatz, setzt aber voraus, dass wir wissen, wonach wir suchen!

**commit nachricht**:
Der Commit lies sich so schlecht finden, weil in dessen Nachricht nicht beschrieben wird, was sich verändert hat. Das heißt der Commit ist in seiner Beschreibung ziemlich ungenau, weil wir nicht wissen, was er macht.
Man könnte etwa "add polish translatio to README.md" oder "Link polish translation to README" nehmen, um es so klar zu definieren, was er verändert ^^
