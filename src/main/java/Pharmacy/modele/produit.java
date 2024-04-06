package Pharmacy.modele;

public class produit{

		private int id;
		private String name;
		private int quantite;
		private float prix;
		private String description;
		
		
		public produit(int id, String name, String description, int quantite, float prix) {
			super();
			this.id = id;
			this.name = name;
			this.quantite = quantite;
			this.prix = prix;
			this.description = description;
		}
		@Override
		public String toString() {
			return "produit [id=" + id + ", name=" + name + ", quantite=" + quantite + ", prix=" + prix
					+ ", description=" + description + "]";
		}
		public produit(String name, int quantite, float prix, String description) {
			super();
			this.name = name;
			this.quantite = quantite;
			this.prix = prix;
			this.description = description;
		}
		public produit() {
 
		}

		public int getid() {
			return id;
		}
		public void setid(int id) {
			this.id = id;
		}
		
		public String getname() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
		}
		
		public int getquantite() {
			return quantite;
		}
		public void setquantite(int quantite) {
			this.quantite = quantite;
		}
		
		public float getprix() {
			return prix;
		}
		public void setprix(float prix) {
			this.prix = prix;
		}
		
		public String getdescription() {
			return description;
		}
		public void setdescription(String description) {
			this.description = description;
		}
	}

