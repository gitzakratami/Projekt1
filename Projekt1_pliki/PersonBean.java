package com.mycompany.projekt1.beans; // Pakiet dla klasy PersonBean

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named // Rejestruje tę klasę jako zarządzaną przez JSF, można się do niej odwołać jako "#{personBean}"
@ApplicationScoped // Dane w tym beanie są współdzielone przez całą aplikację
public class PersonBean {
    private List<Person> people; // Lista przechowująca obiekty Person
    private Person newPerson; // Obiekt reprezentujący nową osobę do dodania

    @PostConstruct // Metoda wywoływana automatycznie po utworzeniu beana
    public void init() {
        people = new ArrayList<>(); // Inicjalizujemy pustą listę osób
        newPerson = new Person(); // Tworzymy pusty obiekt Person, który będzie wypełniany przez formularz
    }

    // Getter dla listy osób – JSF używa go do pobierania danych
    public List<Person> getPeople() {
        return people;
    }

    // Getter dla obiektu newPerson – formularz JSF mapuje do tego obiektu
    public Person getNewPerson() {
        return newPerson;
    }

    // Metoda dodająca nową osobę do listy
    public void addPerson() {
        // Tworzymy nowy obiekt Person na podstawie danych wpisanych w formularzu i dodajemy go do listy
        people.add(new Person(newPerson.getName(), newPerson.getAddress(), newPerson.getPhoneNumber()));
        
        // Resetujemy formularz, przypisując nowy pusty obiekt Person
        newPerson = new Person();
    }
}
