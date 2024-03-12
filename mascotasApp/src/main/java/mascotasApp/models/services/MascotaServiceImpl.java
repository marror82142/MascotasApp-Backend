package mascotasApp.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mascotasApp.models.dao.IMascotaDao;
import mascotasApp.models.dao.IMascotaDao;
import mascotasApp.models.entity.Medicamento;
import mascotasApp.models.entity.Mascota;

@Service
public class MascotaServiceImpl implements IMascotaService {

	@Autowired
	private IMascotaDao mascotaDao;
	
	@Override
	@Transactional
	public List<Mascota> findAll() {
		return (List<Mascota>) mascotaDao.findAll();
	}

	@Override
	@Transactional
	public Mascota save(Mascota mascota) {
		return mascotaDao.save(mascota);
	}

	@Override
	@Transactional(readOnly = true)
	public Mascota findById(Long id) {
		return mascotaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		mascotaDao.deleteById(id);
	}
	
	@Transactional
	public Mascota findByNombre(String nombre) {
		List<Mascota> listaMascotas = (List<Mascota>) mascotaDao.findAll();
		for(int i = 0; i < listaMascotas.size(); i++) {
			if(listaMascotas.get(i).getNombre().equals(nombre)){
				return listaMascotas.get(i);
			}
		}
		return null;
	}
	
}
