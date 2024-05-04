package ziffernreihespiel;

/**
 * Diese Klasse repräsentiert eine Sequenz von Ziffern.
 * Sie stellt Methoden zum Hinzufügen von Ziffern zur Sequenz und zum Ausgeben
 * der Sequenz bereit.
 */
public class Ziffernreihe {
    private Node kopf; // Der Anfang der Sequenz

    /**
     * Konstruiert eine leere Sequenz von Ziffern.
     */
    public Ziffernreihe() {
        this.kopf = null;
    }

    /**
     * Gibt den Anfang der Sequenz zurück.
     *
     * @return Der Anfang der Sequenz.
     */
    public Node getKopf() {
        return kopf;
    }

    /**
     * Fügt eine Ziffer am Ende der Sequenz hinzu.
     *
     * @param data Die Ziffer, die hinzugefügt werden soll.
     */
    public void append(int data) {
        if (kopf == null) {
            kopf = new Node(data);
        } else {
            Node aktuelles = kopf;
            while (aktuelles.getNext() != null) {
                aktuelles = aktuelles.getNext();
            }
            aktuelles.setNext(new Node(data));
        }
    }

    /**
     * Gibt die Sequenz von Ziffern aus.
     */
    public void printZiffernreihe() {
        Node aktuelles = kopf;
        while (aktuelles != null) {
            System.out.print(aktuelles.getData() + " ");
            aktuelles = aktuelles.getNext();
        }
        System.out.println();
    }

    // Innere Klasse Node mit öffentlicher Sichtbarkeit
    public class Node {
        private int data; // Die Ziffer
        private Node next; // Verweis auf den nächsten Knoten

        /**
         * Konstruiert einen Knoten mit der gegebenen Ziffer.
         *
         * @param data Die Ziffer, die im Knoten gespeichert werden soll.
         */
        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        /**
         * Gibt die im Knoten gespeicherte Ziffer zurück.
         *
         * @return Die im Knoten gespeicherte Ziffer.
         */
        public int getData() {
            return data;
        }

        /**
         * Gibt den Verweis auf den nächsten Knoten zurück.
         *
         * @return Der Verweis auf den nächsten Knoten.
         */
        public Node getNext() {
            return next;
        }

        /**
         * Setzt den Verweis auf den nächsten Knoten.
         *
         * @param next Der Verweis auf den nächsten Knoten.
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }
}
