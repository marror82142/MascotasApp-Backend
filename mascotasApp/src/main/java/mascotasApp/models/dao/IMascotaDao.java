package mascotasApp.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mascotasApp.models.entity.Mascota;
import mascotasApp.models.entity.Usuario;

public interface IMascotaDao extends CrudRepository<Mascota, Long>{

}
