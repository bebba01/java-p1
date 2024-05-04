package ziffernreihespiel;

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
