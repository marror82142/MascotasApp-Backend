package mascotasApp.models.services;

import java.util.List;

import mascotasApp.models.entity.Medicamento;
import mascotasApp.models.entity.Usuario;

public interface IMedicamentoService {
	public Medicamento save(Medicamento medicamento);
	
	public List<Medicamento> findAll();
	
	public Medicamento findById(Long id);
	

	public Medicamento findByNombre(String nombre);
	
	public void delete(Long id);
}
