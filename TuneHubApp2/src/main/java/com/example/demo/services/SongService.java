package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Song;

public interface SongService {

	public String addSongs(Song song);

	public boolean songExist(String name);
	
	public List<Song> viewSong();

	public void updateSong(Song song);

	public void deleteById(int id);
}
