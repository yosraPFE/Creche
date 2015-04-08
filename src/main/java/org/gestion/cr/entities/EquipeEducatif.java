package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("Equipe_Educatif")
public class EquipeEducatif extends Equipe implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@ManyToOne
	@JoinColumn(name="idFonction")
	private Fonction fonction;
	
	
	
	@ManyToMany
	@JoinTable(name="EQEDU_CLASS",joinColumns=@JoinColumn(name="ID_EQ_EDU"),
	inverseJoinColumns=@JoinColumn(name="idClass"))
	private Collection<Classe> classes;
	
	
    //generation des guetteurs et des setteurs
	public Fonction getFonction() 
	{
		return fonction;
	}

	public void setFonction(Fonction fonction)
	{
		this.fonction = fonction;	
	}
	public Collection<Classe> getClasses() 
	{
		return classes;
	}

	public void setClasses(Collection<Classe> classes) 
	{
		this.classes = classes;
	}
	
	

	

	//generation du constructeur sans parametres
	public EquipeEducatif() 
	{
		super();
		
	}
	  //generation du constructeur avec parametres

	public EquipeEducatif(String nom, String prenom, byte[] photo,
			String nomPhoto, String dateNaissance, String lieuNaissance,
			String sexe, String adresseDomicile, String nomUtilisateur,
			String motPasse) {
		super(nom, prenom, photo, nomPhoto, dateNaissance, lieuNaissance, sexe,
				adresseDomicile, nomUtilisateur, motPasse);
	}

	@Override
	public String toString() {
		
		return "Equipe Educatif";
	}
	
	
}
