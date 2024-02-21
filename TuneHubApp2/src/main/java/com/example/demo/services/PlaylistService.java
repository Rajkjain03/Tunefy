package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;

public interface PlaylistService {
	public void addtoPlaylist(Playlist pl);
	public List<Playlist> fetchPlaylist();
	public Playlist findPlaylist(String name);
	public String deletePlaylist(Playlist pl);
	public void deleteById(int id);
}
