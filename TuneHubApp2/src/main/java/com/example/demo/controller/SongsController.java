package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

@Controller
public class SongsController {

	@Autowired
	SongService sr;

	@PostMapping("/songs")
	public String addSongs(@ModelAttribute Song song) {

		if (sr.songExist(song.getName()) == false) {
			sr.addSongs(song);
			return "songsuccess";
		} else {
			return "songfail";
		}
	}
	
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model) {
		List<Song> ls = sr.viewSong();
		model.addAttribute("songlist", ls);
		return "viewSongs";
	}
	
	@GetMapping("/map-viewCustomerSongs")
	public String viewCustomerSongs(Model model) {
		List<Song> ls = sr.viewSong();
		model.addAttribute("songlist", ls);
		return "customerSongs";
	}
	
	@RequestMapping("/deleteSong/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		sr.deleteById(id);
		return "redirect:/map-viewsongs";
	}
	
	
}
