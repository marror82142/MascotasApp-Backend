package mascotasApp.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mascotasApp.models.dao.IMascotaDao;
import mascotasApp.models.dao.IMedicamentoDao;
import mascotasApp.models.dao.IUsuarioDao;
import mascotasApp.models.entity.Medicamento;
import mascotasApp.models.entity.Usuario;
import mascotasApp.models.entity.Medicamento;

@Service
public class MedicamentoServiceImpl implements IMedicamentoService {

	@Autowired
	private IMedicamentoDao medicamentoDao;
	
	@Override
	@Transactional
	public Medicamento save(Medicamento medicamento) {		
		return medicamentoDao.save(medicamento);
	}
	
	@Override
	@Transactional
	public List<Medicamento> findAll() {
		return (List<Medicamento>) medicamentoDao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Medicamento findById(Long id) {
		return medicamentoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		medicamentoDao.deleteById(id);
	}

	@Override
	@Transactional
	public Medicamento findByNombre(String nombre) {
		List<Medicamento> listaUsuarios = (List<Medicamento>) medicamentoDao.findAll();
		for(int i = 0; i < listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i).getNombre().equals(nombre)){
				return listaUsuarios.get(i);
			}
		}
		return null;
	}
	
}
