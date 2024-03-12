package mascotasApp.models.services;

import java.util.List;

import mascotasApp.models.entity.Mascota;

public interface IMascotaService {
	public List<Mascota> findAll();
	
	public Mascota save(Mascota mascota);
	
	public Mascota findById(Long id);
	
	public void delete(Long id);

}
