package com.banque;

import com.banque.model.*;
import com.banque.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(BanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner testerBackend(
            TypeProduitRepository typeProduitRepository,
            PersonneMoraleRepository personneMoraleRepository,
            PersonnePhysiqueRepository personnePhysiqueRepository,
            ProduitBancaireRepository produitBancaireRepository,
            TypePersonneMoraleRepository typePersonneMoraleRepository,
            ClientBancaireRepository clientBancaireRepository) {

        return args -> {

            typeProduitRepository.deleteAll();

            ArrayList<TypeProduit> listeTP = new ArrayList<>();
            listeTP.add(new TypeProduit(0f, "Mastercard", 20));
            listeTP.add(new TypeProduit(0.3f, "Livret épargne", 0));
            listeTP.add(new TypeProduit(0.1f, "Compte rémunéré", 0));
            listeTP.add(new TypeProduit(0.5f, "Prêt consommation", 0));
            listeTP.add(new TypeProduit(0.3f, "Prêt immobilier", 0));
            typeProduitRepository.saveAll(listeTP);

            System.out.println("\n***************** Test count *****************");
            long nbTypeProduits = typeProduitRepository.count();
            System.out.println("Il y a " + nbTypeProduits + " types de produits dans la base");

            System.out.println("\n***************** Test findById *****************");
            long id = 100;
            Optional<TypeProduit> typeProduit = typeProduitRepository.findById(id);
            if (typeProduit.isPresent()) {
                System.out.println("Type de produit avec l'id " + id + " : " + typeProduit.get());
            } else {
                System.out.println("Pas de type de produit avec la clé : " + id);
            }

            System.out.println("\n***************** Tous les types de produits non triés *****************");
            System.out.println(typeProduitRepository.findAll());

            System.out.println("\n***************** Tous les types de produits triés par ordre alphabétique *****************");
            System.out.println(typeProduitRepository.findAll(Sort.by(Sort.Direction.ASC, "intitule")));

            System.out.println("\n***************** Test pagination *****************");
            Page<TypeProduit> page = typeProduitRepository.findAll(PageRequest.of(3, 1, Sort.by(Sort.Direction.ASC, "intitule")));
            System.out.println(page + "\nContenu de la page : " + page.getContent());

            System.out.println("\n***************** Recherche par intitulé exact *****************");
            System.out.println(typeProduitRepository.findByIntitule("Prêt consommation"));

            System.out.println("\n***************** Recherche par intitulé contenant 'compte' *****************");
            System.out.println(typeProduitRepository.findByIntituleContains("compte"));

            System.out.println("\n***************** Recherche par LIKE *****************");
            System.out.println(typeProduitRepository.findByIntituleLike("%compte%"));

            System.out.println("\n***************** 3 derniers types de produits saisis *****************");
            System.out.println(typeProduitRepository.findFirst3ByOrderByIdDesc());

            System.out.println("\n***************** Produits dont la rentabilité >= 0.3 *****************");
            System.out.println(typeProduitRepository.findByTauxInteretAgiosGreaterThanEqualOrderByTauxInteretAgiosAsc(0.3f));

            TypePersonneMorale tpmEntreprise = new TypePersonneMorale("Entreprise");
            TypePersonneMorale tpmAssociation = new TypePersonneMorale("Association");
            typePersonneMoraleRepository.save(tpmEntreprise);
            typePersonneMoraleRepository.save(tpmAssociation);

            tpmEntreprise = typePersonneMoraleRepository.findById(tpmEntreprise.getId()).orElseThrow();
            tpmAssociation = typePersonneMoraleRepository.findById(tpmAssociation.getId()).orElseThrow();

            PersonneMorale pm1 = new PersonneMorale("102bis rue du Vesuve", "SIRET1", "Pizza Tonio", tpmEntreprise);
            PersonneMorale pm2 = new PersonneMorale("45 Boulevard du fleuve", "SIRET2", "Meubles cosy", tpmAssociation);
            PersonneMorale pm3 = new PersonneMorale("14 allée des platanes", "SIRET3", "Espaces très verts", tpmEntreprise);

            personneMoraleRepository.save(pm1);
            personneMoraleRepository.save(pm2);
            personneMoraleRepository.save(pm3);


            PersonnePhysique pp1 = new PersonnePhysique("19 rue des fleurs, 80000 Amiens", "Dupont", "Jean");
            PersonnePhysique pp2 = new PersonnePhysique("143 boulevard des Landes, 64200 Anglet", "Eche", "Piou");
            PersonnePhysique pp3 = new PersonnePhysique("56 avenue de Paris, 60000 Beauvais", "Tristan", "Jacques");
            personnePhysiqueRepository.save(pp1);
            personnePhysiqueRepository.save(pp2);
            personnePhysiqueRepository.save(pp3);

            System.out.println("\n***************** Personnes physiques *****************");
            System.out.println(personnePhysiqueRepository.findAll());

            TypeProduit tp1 = new TypeProduit(0.2f, "tp1", 0);
            TypeProduit tp2 = new TypeProduit(3f, "tp2", 0);
            TypeProduit tp3 = new TypeProduit(0f, "tp3", 15);
            typeProduitRepository.save(tp1);
            typeProduitRepository.save(tp2);
            typeProduitRepository.save(tp3);

            ProduitBancaire pb1 = new ProduitBancaire(1, "num1", tp3);
            ProduitBancaire pb2 = new ProduitBancaire(2, "num2", tp2);
            ProduitBancaire pb3 = new ProduitBancaire(3, "num3", tp3);
            produitBancaireRepository.save(pb1);
            produitBancaireRepository.save(pb2);
            produitBancaireRepository.save(pb3);

            System.out.println("\n***************** Produits bancaires *****************");
            System.out.println(produitBancaireRepository.findAll());

            TypePersonneMorale tpm1 = new TypePersonneMorale("Entreprise");
            TypePersonneMorale tpm2 = new TypePersonneMorale("Association");
            typePersonneMoraleRepository.save(tpm1);
            typePersonneMoraleRepository.save(tpm2);

            pm1 = new PersonneMorale("102bis rue du Vesuve", "SIRET1", "Pizza Tonio", tpm1);
            personneMoraleRepository.save(pm1);

            pm2 = new PersonneMorale("45 Boulevard du fleuve", "SIRET2", "Meubles cosy", tpm2);
            personneMoraleRepository.save(pm2);

            System.out.println("\n=== Personnes Morales et leurs Types ===");
            List<TypePersonneMorale> typesPM = typePersonneMoraleRepository.findAll();
            for (TypePersonneMorale tpm : typesPM) {
                System.out.println(tpm);
                tpm.getPersonnesMorales().forEach(pm -> System.out.println("  - " + pm));
            }

            ClientBancaire cb1 = new ClientBancaire();
            ClientBancaire cb2 = new ClientBancaire();
            ClientBancaire cb3 = new ClientBancaire();
            clientBancaireRepository.save(cb1);
            clientBancaireRepository.save(cb2);
            clientBancaireRepository.save(cb3);

            cb1.addProduitBancaire(pb1);
            cb2.addProduitBancaire(pb2);
            cb3.addProduitBancaire(pb3);

            clientBancaireRepository.save(cb1);
            clientBancaireRepository.save(cb2);
            clientBancaireRepository.save(cb3);

            pm1 = personneMoraleRepository.findById(pm1.getId()).orElseThrow();
            cb1.addPersonne(pm1);
            clientBancaireRepository.save(cb1);

            pp2 = personnePhysiqueRepository.findById(pp2.getId()).orElseThrow();
            cb1 = clientBancaireRepository.findById(cb1.getId()).orElseThrow();
            cb1.addPersonne(pp2);
            clientBancaireRepository.save(cb1);

            pp1 = personnePhysiqueRepository.findById(pp1.getId()).orElseThrow();
            cb2 = clientBancaireRepository.findById(cb2.getId()).orElseThrow();
            pp1.addClientBancaire(cb2);
            personnePhysiqueRepository.save(pp1);

            cb3 = clientBancaireRepository.findById(cb3.getId()).orElseThrow();
            pp3 = personnePhysiqueRepository.findById(pp3.getId()).orElseThrow();
            cb3.addPersonne(pp3);
            clientBancaireRepository.save(cb3);

            System.out.println("\n***************************************************");
            System.out.println("Les personnes physiques");
            System.out.println("***************************************************");
            System.out.println(personnePhysiqueRepository.findAll());

            System.out.println("\n***************************************************");
            System.out.println("Les personnes morales");
            System.out.println("***************************************************");
            System.out.println(personneMoraleRepository.findAll());

            System.out.println("\n***************** Opérations bancaires *****************");

            Operation op1 = new Operation(new java.sql.Date(System.currentTimeMillis()), 150.0f, pb1);
            Operation op2 = new Operation(new java.sql.Date(System.currentTimeMillis()), -50.0f, pb1);
            pb1.addOperation(op1);
            pb1.addOperation(op2);

            Operation op3 = new Operation(new java.sql.Date(System.currentTimeMillis()), 300.0f, pb2);
            pb2.addOperation(op3);

            Operation op4 = new Operation(new java.sql.Date(System.currentTimeMillis()), -75.0f, pb3);
            Operation op5 = new Operation(new java.sql.Date(System.currentTimeMillis()), 200.0f, pb3);
            pb3.addOperation(op4);
            pb3.addOperation(op5);

            produitBancaireRepository.save(pb1);
            produitBancaireRepository.save(pb2);
            produitBancaireRepository.save(pb3);

            produitBancaireRepository.findAll().forEach(pb -> {
                System.out.println(pb);
                pb.getOperations().forEach(op -> System.out.println("  - " + op));
            });
        };
    }
}
