package org.gestion.cr.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EquipeTechniques")
@DiscriminatorValue("EQ_TEC")

public class EquipeTechnique extends Equipe implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	
	@ManyToOne
	@JoinColumn(name="ID_FONCTION")
	private Fonction fonction;
	
	@ManyToOne
	@JoinColumn(name="ID_CRECHE")
	private Creche creche;
	
	//generateur du guetteurs et du setteurs
	public Fonction getFonction() 
	{
		return fonction;
	}
	public void setFonction(Fonction fonction) 
	{
		this.fonction = fonction;
	}
	public Creche getCreche() 
	{
		return creche;
	}
	public void setCreche(Creche creche) 
	{
		this.creche = creche;
	}
	
	
	//generateur du constructeur sans parametres
	public EquipeTechnique() 
	{
		super();
		
	}
	
	//generateur du constructeur avec parametres
	public EquipeTechnique(String nom, String prenom, byte[] photo,
			Date dateNaissance, String lieuNaissance, String sexe,
			String adresseDomicile, String nomUtilisateur, String motPasse) {
		super(nom, prenom, photo, dateNaissance, lieuNaissance, sexe,
				adresseDomicile, nomUtilisateur, motPasse);
	}
	
	
	
	
	
	

}
