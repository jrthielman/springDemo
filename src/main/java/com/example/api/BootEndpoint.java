package com.example.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.items.Boot;
import com.example.demo.items.TestingBeans;
import com.example.persistence.BService;

@RestController
public class BootEndpoint {
	
	@Autowired
	private BService service;
	
	@Autowired
	private TestingBeans testingBeans;
	
	@Autowired
	private int giveMe4;
	
	@GetMapping("/boot")
	public Iterable <Boot>  listGroep(){
		Iterable <Boot> boten = service.findAll();
		return boten;
	}
	
	@GetMapping("/beantest")
	public Set<String> beanTest(){
		return testingBeans.getCategories();
	}
	
	@GetMapping("/giveme4")
	public int giveMe4(){
		return giveMe4;
	}
	
//	@GetMapping("/boot")
//	public Boot  findBoot(long id, String name){
//		Optional <Boot> boten = service.findById(id);
//		if(boten.get().getName().equals(name)) {
//			return boten.get();
//		}
//		return null;
//	}
	
	/*
	 * pageable werkt nog niet.
	 */
	
//	@GetMapping("/boot/{name}")
//	public Page<Boot> findByName(Pageable pageable, @PathVariable(name="name")String name){
//		Page<Boot> boten = service.findByName(name, pageable);
//		return boten;
//	}
	
	@GetMapping("/boot/{id}/name/{name}")
	public Boot getBoot(@PathVariable(name ="id") Long id, @PathVariable(name ="waarde") String name){
		service.findById(id).get().setName(name);
		return service.findById(id).get();
	}
	
	/*@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response addItem(Boot boot) {
		
		Boot result = service.save(boot);
		return Response.accepted(result).build();
	}*/
	
	/*@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") long id) {
		Optional<Boot> optionalBoot = this.service.findById(id);
		if(optionalBoot.isPresent()) {
			// do succes // geef je hem terug met Optional.get()
			return Response.ok(optionalBoot.get().getName()).build();
		}
		else {
			return Response.status(404).build();
		}
	}*/
	
	@PostMapping("/boot")
	public Boot postBoot(@RequestBody Boot boot){
		return service.save(boot);
	}

}
