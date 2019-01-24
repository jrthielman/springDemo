package com.example.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.items.Mens;
import com.example.email.MailClient;
import com.example.persistence.RepositoryMens;

@RestController
public class MensEndpoint {
	
	@Autowired
	private RepositoryMens repositoryMens;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	MailClient mailClient;
		
	@GetMapping("/mail")
	public void sendMail() {
		mailClient.prepareAndSend("javiel_55@hotmail.com", "Javiel", "dit is het onderwerp");
	}
	
	@GetMapping("testresponse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testResponse() {
		return Response.ok().build();
	}
	
	@GetMapping("/boot/{bootId}/mensen")
	public Iterable<Mens> getAlleMensenByBoot(@PathVariable(value = "bootId") Long id){
		List<Mens> toonAlleMensen = new ArrayList<>();
		for(Mens mens : repositoryMens.findAll()) {
			if(mens.getBoot().getId() == id) {
				toonAlleMensen.add(mens);
			}
		}
		return toonAlleMensen;
	}
	
	@GetMapping("api/mens")
	public ResponseEntity<Mens> getMens(Long id, String name){
		Optional<Mens> result = repositoryMens.findById(id);
		return result.isPresent() && result.get().getName().equals(name) ? ResponseEntity.ok(result.get()) : 
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
	
	@GetMapping("api/getmens")
	public ResponseEntity<Mens> getMens(){
		return ResponseEntity.ok().body(new Mens());	
		}
	
	@PostMapping("api/mens")
	public ResponseEntity<?> makeMens(@RequestBody @Valid Mens mens){
		return ResponseEntity.ok().body(repositoryMens.save(mens));	
		}
	
//	@PostMapping("/boot/{bootId}/mensen")
//	public Mens voegMensAanBoot(@PathVariable(value = "bootId") Long id,
//			@Valid @RequestBody Mens mens) {
//		return repositoryBoot.findById(id).map(boot -> {
//			mens.setBoot(boot);
//			return repositoryMens.save(mens);
//		}).orElseThrow(() -> new IllegalArgumentException());
//	}

}
