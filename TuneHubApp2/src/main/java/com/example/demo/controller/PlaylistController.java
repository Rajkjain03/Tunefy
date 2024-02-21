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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	PlaylistService pserv;
	
	@Autowired
	SongService sserv;
	
	@GetMapping("/map-createplaylist")
	public String createPlaylist(Model model) {
		
		List<Song> songlist = sserv.viewSong();
		model.addAttribute("songlist", songlist);
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addtoPlaylist(@ModelAttribute Playlist pl) {
		
		pserv.addtoPlaylist(pl);
		List<Song> songlist = pl.getSong();
		for(Song song : songlist) {
			song.getPl().add(pl);
			sserv.updateSong(song);
		}
		return "playlistSuccess";
	}
	
	@GetMapping("/viewPlaylist")
	public String viewPlaylist(Model model) {
		System.out.println("hi");
		List<Playlist> plist = pserv.fetchPlaylist();
		model.addAttribute("plist", plist);
		return "viewPlaylists";
	}
	
	@RequestMapping("deleteplist/{id}")
	public String deleteplaylist(@PathVariable("id") int id) {
		pserv.deleteById(id);
		return "redirect:/viewPlaylist";
	}
}
