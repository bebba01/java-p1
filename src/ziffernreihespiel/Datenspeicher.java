package ziffernreihespiel;

import java.util.List;

/**
 * Schnittstellendefinition für den Datenspeicher.
 */
public interface Datenspeicher {

    /**
     * 
     * Speichert eine Ergebnisliste in einer Datei.
     * 
     * 
     * @param ergebnisliste Die Liste der Ergebnisse.
     * @param dateiname     Der Dateiname.
     */

    void speichereErgebnisliste(List<Ergebnis> ergebnisliste, String dateiname);

    /**
     * Lädt eine Ergebnisliste aus einer Datei.
     * 
     * @param dateiname Der Dateiname.
     * @return Die geladene Ergebnisliste.
     */
    List<Ergebnis> ladeErgebnisliste(String dateiname);

}