package mascotasApp.models.services;

import java.util.List;

import mascotasApp.models.entity.Mascota;
import mascotasApp.models.entity.Medicamento;

public interface IMascotaService {
	public List<Mascota> findAll();
	
	public Mascota save(Mascota mascota);
	
	public Mascota findById(Long id);
	
	public void delete(Long id);
	
	public Mascota findByNombre(String nombre);

}
