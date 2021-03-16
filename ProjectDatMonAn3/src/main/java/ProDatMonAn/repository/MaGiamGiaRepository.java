package ProDatMonAn.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProDatMonAn.model.MaGiamGiaModel;

@Repository
public interface  MaGiamGiaRepository extends CrudRepository<MaGiamGiaModel,Integer>{
	@Query("from MaGiamGiaModel gg where gg.tenma=:tenma ")
	public MaGiamGiaModel findbytenma (String tenma);
	
}
