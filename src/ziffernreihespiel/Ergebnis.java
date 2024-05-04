package ziffernreihespiel;

/**
 * Schnittstellendefinition für ein Ergebnis eines Spieldurchgangs.
 */
public interface Ergebnis {

    /**
     * Gibt den gespeicherten Namen des Spielers zurück.
     * 
     * @return Gespeicherter Name des Spielers.
     */
    String getNamedesSpielers();

    /**
     * Speichert den Namen des Spielers.
     * 
     * @param name Name des Spielers.
     */
    void setNamedesSpielers(String name);

    /**
     * Gibt die Spielzeit zurück.
     * 
     * @return Die Spielzeit in Millisekunden.
     */
    long getSpielzeit();

    /**
     * Speichert die Startzeit.
     * 
     * @param startzeit Die Startzeit in Millisekunden.
     */
    void setStartzeit(long startzeit);

    /**
     * Gibt die Länge der Ziffernreihe zurück.
     * 
     * @return Die Länge der Ziffernreihe.
     */
    int getLaengeDerReihe();

    /**
     * Setzt die Länge der Ziffernreihe.
     * 
     * @param index Die Länge der Ziffernreihe.
     */
    void setLaengeDerReihe(int index);

    Ergebnis getNext();

    void setNext(Ergebnis neuesErgebnis);

}
