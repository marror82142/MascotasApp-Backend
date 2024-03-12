package mascotasApp.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import mascotasApp.models.entity.Mascota;
import mascotasApp.models.services.IMascotaService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MascotaRestController {
	
	@Autowired
	private IMascotaService mascotaService;
	
	@GetMapping("/mascotas")
	public List<Mascota> index(){
		return mascotaService.findAll();
	}
	
	@GetMapping("/mascotas/{id}")
	public Mascota show(@PathVariable Long id){
		return mascotaService.findById(id);
	}
	
	
	@PostMapping("/mascotas")
	@ResponseStatus(HttpStatus.CREATED)
	public Mascota create(@RequestBody Mascota mascota){			
		return mascotaService.save(mascota);		
	}
		
	@PutMapping("/mascotas/{id}")
	public Mascota update(@RequestBody Mascota mascota, @PathVariable Long id){
		Mascota current = mascotaService.findById(id);
		
		current.setNombre(mascota.getNombre());
		current.setRaza(mascota.getRaza());
		current.setEdad(mascota.getEdad());
		current.setPeso(mascota.getPeso());
		return mascotaService.save(current);
	}
	
	@DeleteMapping("/mascotas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		mascotaService.delete(id);
	}
}
