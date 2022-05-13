package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.impl.GestionMaterielServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("controllerPricipal")
public class GestionMaterielController {

	@Autowired
    private GestionMaterielServiceImpl gestionLivreService;

    @Autowired
    @Qualifier("materielService")
    private GestionMaterielServiceImpl gestionMaterielService;

    public void listerMateriel() {
        gestionMaterielService.listerMateriel();
    }

    public GestionMaterielController() {
    }

    public GestionMaterielController(GestionMaterielService livreService) {
        this.gestionLivreService = (GestionMaterielServiceImpl) livreService;
    }

    public void afficherMenu() {
        System.out.println("1- pour lister le matériel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour supprimer un matériel, entrer 2");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            // ajouter nouveau matériel
        	Livre l = new Livre();
            System.out.println("id du materiel à ajouter");
        	l.setCode(scanner.next());
            System.out.println("nom du materiel à ajouter");
        	l.setName(scanner.next());
        	gestionLivreService.ajouterNouveauMateriel(l);
        }else if("3".equals(next)) {
            System.out.println("id du materiel à supprimer");
            String asupp = scanner.next();
        	gestionMaterielService.suppMateriel(Long.getLong(asupp));
        }
        else {
            System.out.println("choix invalide");
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }

}
