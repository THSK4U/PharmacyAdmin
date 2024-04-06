package Pharmacy.controleur;

import java.util.List;

import Pharmacy.modele.produit;

public class test {

    public static void main(String[] args) {
        produitImplimen imp = new produitImplimen();

        List<produit> pro = imp.getAllProducts();

        for (produit p : pro) {
            System.out.println(p.toString());
        }

    }

}
