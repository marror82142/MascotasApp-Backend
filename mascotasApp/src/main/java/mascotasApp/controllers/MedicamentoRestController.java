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

import mascotasApp.models.entity.Medicamento;
import mascotasApp.models.services.IMedicamentoService;
import mascotasApp.models.services.IMedicamentoService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MedicamentoRestController {
	
	@Autowired
	private IMedicamentoService medicamentoService;
	
	@PostMapping("/medicamentos")
	@ResponseStatus(HttpStatus.CREATED)
	public Medicamento create(@RequestBody Medicamento medicamento){			
		return medicamentoService.save(medicamento);		
	}
	
	@GetMapping("/medicamentos")
	public List<Medicamento> index(){
		return medicamentoService.findAll();
	}
	
	@GetMapping("/medicamentos/{id}")
	public Medicamento show(@PathVariable String id){
		return medicamentoService.findByNombre(id);
	}
	
		
	@PutMapping("/medicamentos/{id}")
	public Medicamento update(@RequestBody Medicamento medicamento, @PathVariable Long id){
		Medicamento current = medicamentoService.findById(id);
		
		current.setNombre(medicamento.getNombre());
		current.setDescripcion(medicamento.getDescripcion());
		current.setDosis(medicamento.getDosis());
		return medicamentoService.save(current);
	}
	
	@DeleteMapping("/medicamentos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		medicamentoService.delete(id);
	}
}
