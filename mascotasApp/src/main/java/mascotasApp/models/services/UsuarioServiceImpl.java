package mascotasApp.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mascotasApp.models.dao.IMascotaDao;
import mascotasApp.models.dao.IUsuarioDao;
import mascotasApp.models.entity.Medicamento;
import mascotasApp.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long cedula) {
		return usuarioDao.findById(cedula).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long cedula) {
		usuarioDao.deleteById(cedula);
	}
	
	@Transactional
	public Usuario findByNombre(String nombre, String apellidos) {
		List<Usuario> listaUsuarios = (List<Usuario>) usuarioDao.findAll();
		for(int i = 0; i < listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i).getNombres().equals(nombre)
					&& listaUsuarios.get(i).getApellidos().equals(apellidos)){
				return listaUsuarios.get(i);
			}
		}
		return null;
	}
	
}
