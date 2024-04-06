package Pharmacy.controleur;


import java.util.List;

import Pharmacy.modele.produit;

public interface Cproduit {
	public produit save(produit p);
	public List<produit> prduitsparmc(String mc);
	public produit getproduit(int id);
	public produit update(produit p);
	public void delete(int id);

}
