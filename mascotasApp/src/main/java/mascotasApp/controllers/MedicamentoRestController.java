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
import mascotasApp.models.entity.Usuario;
import mascotasApp.models.services.IMedicamentoService;
import mascotasApp.models.services.IUsuarioService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MedicamentoRestController {
	
	@Autowired
	private IMedicamentoService medicamentoService;
	
	@PostMapping("/medicamento")
	@ResponseStatus(HttpStatus.CREATED)
	public Medicamento create(@RequestBody Medicamento medicamento){			
		return medicamentoService.save(medicamento);		
	}
}
