package ProDatMonAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProDatMonAn.model.ThucDonModel;

@Repository
public interface ThucDonRepository extends CrudRepository<ThucDonModel,Integer>{
	@Query("from ThucDonModel td where  td.manhahang =:idkhachhang")
	public List<ThucDonModel> findbyIdThucDon (int idkhachhang);
}