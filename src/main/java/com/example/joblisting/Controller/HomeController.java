package com.example.joblisting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.joblisting.MongoEntity.mongoEntity;
import com.example.joblisting.MongoRepository.MongoRepo;
import com.example.joblisting.MongoRepository.MongoSearchRepo;

@RestController
@RequestMapping(value="job")
public class HomeController 
{
	@Autowired
    private MongoRepo repo;
	
	@Autowired
	private MongoSearchRepo searchRepo;
	
	@PostMapping("/addemp")
	public ResponseEntity<?> addemp(@RequestBody mongoEntity mongo)
	{
	    mongoEntity save=this.repo.save(mongo);	
		return ResponseEntity.ok(save);
	}
	
	
	@GetMapping("/posts")
  public List<mongoEntity> getAll()	
  {
	  return repo.findAll();
  }
  
  @GetMapping("/posts/{text}")
  public List<mongoEntity> searchByText(@PathVariable String text)
  {
	return  searchRepo.searchByText(text); 
	  
  }
  
	
}
