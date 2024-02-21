package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String artist;
	String genere;
	String link;
	@ManyToMany
	List<Playlist> pl;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(int id, String name, String artist, String genere, String link, List<Playlist> pl) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genere = genere;
		this.link = link;
		this.pl = pl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Playlist> getPl() {
		return pl;
	}

	public void setPl(List<Playlist> pl) {
		this.pl = pl;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", genere=" + genere + ", link=" + link
				;
	}

}
