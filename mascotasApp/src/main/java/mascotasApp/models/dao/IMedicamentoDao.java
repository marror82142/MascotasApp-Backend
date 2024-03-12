package mascotasApp.models.dao;

import org.springframework.data.repository.CrudRepository;

import mascotasApp.models.entity.Medicamento;

public interface IMedicamentoDao extends CrudRepository<Medicamento, Long>{

}
