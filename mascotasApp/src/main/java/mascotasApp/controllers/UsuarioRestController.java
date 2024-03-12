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

import mascotasApp.models.entity.Usuario;
import mascotasApp.models.services.IUsuarioService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuarios/{cedula}")
	public Usuario show(@PathVariable Long cedula){
		return usuarioService.findById(cedula);
	}
	
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario){			
		return usuarioService.save(usuario);		
	}
		
	@PutMapping("/usuarios/{cedula}")
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long cedula){
		Usuario current = usuarioService.findById(cedula);
		
		current.setCedula(usuario.getCedula());
		current.setNombres(usuario.getNombres());
		current.setApellidos(usuario.getApellidos());
		current.setDireccion(usuario.getDireccion());
		current.setTelefono(usuario.getTelefono());
		return usuarioService.save(current);
	}
	
	@DeleteMapping("/usuarios/{cedula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long cedula){
		usuarioService.delete(cedula);
	}
}
