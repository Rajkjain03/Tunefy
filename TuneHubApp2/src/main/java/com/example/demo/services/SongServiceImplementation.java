package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService {
	@Autowired
	SongRepository sr;

	@Override
	public String addSongs(Song song) {
		sr.save(song);
		return "song is created and saved";
	}

	@Override
	public boolean songExist(String name) {
		if (sr.findByName(name) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Song> viewSong() {
		List<Song> ls = sr.findAll();
		return ls;
	}

	@Override
	public void updateSong(Song song) {
		sr.save(song);
	}

	@Override
	public void deleteById(int id) {
		sr.deleteById(id);
	}

}
