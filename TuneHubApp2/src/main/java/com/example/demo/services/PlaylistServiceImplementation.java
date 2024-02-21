package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService{
	
	@Autowired
	PlaylistRepository pr;
	

	@Override
	public void addtoPlaylist(Playlist pl) {
		pr.save(pl);
	}


	@Override
	public List<Playlist> fetchPlaylist() {
		return pr.findAll();
	}


	@Override
	public String deletePlaylist(Playlist pl) {
		int id = pl.getId();
		pr.deleteById(id);
		return null;
	}
	
	@Override
	public Playlist findPlaylist(String name) {
		Playlist pl = pr.findByName(name);
		return pl;
	}


	@Override
	public void deleteById(int id) {
		pr.deleteById(id);
	}
}
