package org.gestion.cr.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Personnages")

/*une annotation specifier pour l'heritage
 *SINGLE_TABLE :c a d que tous les type de la Classe mere "Personnage" sont stock� dans le mem tableau(un seul tableau))
 *JOINED:ser a enregistrer les champs de chaque entit� dans sa propre table
 *TABLE_PER_CLASS:inverse de SINGLE_TABLE :c a d envoyer tous les champs de toutes les entit�s vers table de juin unique
 */

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

/*les classes heritantes de la classe mere sont stock�s dans  la meme table qui contient une colone 
 * qui a le nom "TYPE_PERSONNAGE"
 * qui va faire la differences entre les differetes type de la table Personnage
 * et cette colonne a un type Stringe  qui est  le nombre de caractere de nom du type du maximum longueur 22 */

@DiscriminatorColumn(name="TYPE_PERSONNAGE",discriminatorType=DiscriminatorType.STRING,length=22)

public class Personnage implements Serializable
{
	/**
	 * 
	 * @author YOSRA
	 *
	 */
	/*
	 * GenerationType.IDENTITY:c a d attribuer  les cl�s primaires pour l'entit� en utilisant une colonne d'identit� de base de donn�es.
	 * GenerationType.AUTO :c a d choisir une strat�gie appropri�e pour la base de donn�es particuli�re.
	 * GenerationType.SEQUENCE:attribuer les cl�s primaires pour l'entit� en utilisant une colonne de s�quence de base de donn�es.
	 * GenerationType.TABLE :attribuer les cl�s primaires pour l'entit� en utilisant une table de base de donn�es sous-jacente pour garantir l'unicit�
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERSONNAGE")
	private long idPerson;
	
	private String nom;
	private String prenom;
	//byte[]:entier compri entre -128 jusqua 127
	private byte[] photo;
	
	//generateur du guetteurs et du setteurs
	public String getNom() 
	{
		return nom;
	}
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	public String getPrenom() 
	{
		return prenom;
	}
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	
	public byte[] getPhoto()
	{
		return photo;
	}
	public void setPhoto(byte[] photo)
	{
		this.photo = photo;
	}
	//generateur du constructeur sans parametres
	public Personnage() 
	{
		super();
		
	}
	//generateur du constructeur avec parametres
	public Personnage(String nom, String prenom, byte[] photo) 
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
	}
	
	
	

}
