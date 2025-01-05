package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Carte;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CarteService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File fisierCarti = new File("src/main/resources/carti.json");
    private Map<Integer, Carte> carti;

    public CarteService() throws IOException {
        // Citire din fișier
        this.carti = objectMapper.readValue(fisierCarti, new TypeReference<>() {});
    }

    public void afiseazaCarti() {
        System.out.println("Colecția de cărți:");
        for (var entry : carti.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", model.Carte: " + entry.getValue());
        }
    }

    public void stergeCarte(int id) {
        carti.remove(id);
        System.out.println("Cartea cu ID " + id + " a fost ștearsă.");
    }

    public void adaugaCarte(int id, Carte carte) {
        carti.putIfAbsent(id, carte);
        System.out.println("Cartea a fost adăugată: " + carte);
    }

    public void salveazaModificari() throws IOException {
        objectMapper.writeValue(fisierCarti, carti);
        System.out.println("Modificările au fost salvate în fișierul JSON.");
    }

    public Set<Carte> filtreazaCartiAutor(String autor) {
        return carti.values().stream()
                .filter(carte -> carte.getAutor().equals(autor))
                .collect(Collectors.toSet());
    }

    public void afiseazaCartiOrdonate(Set<Carte> cartiFiltrate) {
        cartiFiltrate.stream()
                .sorted(Comparator.comparing(Carte::getTitlu))
                .forEach(System.out::println);
    }
}