import model.Carte;
import service.CarteService;

import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            CarteService carteService = new CarteService();

            // 1. Afișarea colecției
            carteService.afiseazaCarti();

            // 2. Ștergerea unei cărți
            carteService.stergeCarte(2);

            // 3. Adăugarea unei cărți
            Carte carteNoua = new Carte("Sapiens", "Yuval Noah Harari", 2011);
            carteService.adaugaCarte(5, carteNoua);

            // 4. Salvarea modificărilor
            carteService.salveazaModificari();

            // 5. Filtrarea cărților autorului "Yuval Noah Harari"
            Set<Carte> cartiYuval = carteService.filtreazaCartiAutor("Yuval Noah Harari");
            System.out.println("\nCărțile autorului Yuval Noah Harari:");
            cartiYuval.forEach(System.out::println);

            // 6. Afișarea cărților ordonate după titlu
            System.out.println("\nCărțile ordonate după titlu:");
            carteService.afiseazaCartiOrdonate(cartiYuval);
        } catch (IOException e) {
            System.err.println("A apărut o eroare: " + e.getMessage());
        }
    }
}