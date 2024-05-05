package ziffernreihespiel;

/**
 * Diese Klasse enthält eine main-Methode zum Testen der Ziffernreihe-Klasse.
 * 
 * Sie erstellt eine Ziffernreihe und fügt Ziffern hinzu, um sicherzustellen,
 * dass die Funktionalität der Ziffernreihe-Klasse ordnungsgemäß funktioniert.
 * 
 * @author Mohamed Bebba
 * @see https://github.com/bebba01/java-p1
 */
public class ZiffernreiheTest {
    public static void main(String[] args) {
        // Erstellen einer Ziffernreihe und Hinzufügen von Ziffern
        Ziffernreihe ziffernreihe = new Ziffernreihe();
        ziffernreihe.append(1);
        ziffernreihe.append(2);
        ziffernreihe.append(3);
        ziffernreihe.append(4);
        ziffernreihe.append(5);

        // Ausgabe der Ziffernreihe
        System.out.println("Ziffernreihe:");
        ziffernreihe.printZiffernreihe();
    }
}
