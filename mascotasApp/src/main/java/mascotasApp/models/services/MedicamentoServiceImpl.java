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

@Service
public class MedicamentoServiceImpl implements IMedicamentoService {

	@Autowired
	private IMedicamentoDao medicamentoDao;
	
	@Override
	@Transactional
	public Medicamento save(Medicamento medicamento) {		
		return medicamentoDao.save(medicamento);
	}
	
}
