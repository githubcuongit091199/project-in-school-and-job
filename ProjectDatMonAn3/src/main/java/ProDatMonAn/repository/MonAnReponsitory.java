package ProDatMonAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProDatMonAn.model.MonAnModel;


@Repository
public interface MonAnReponsitory extends CrudRepository<MonAnModel,Integer>{
	@Query("from MonAnModel ma where  ma.mathucdon =:idthucdon")
	public List<MonAnModel> findbyIdThucDon (int idthucdon);
	@Query("from MonAnModel ma where  ma.trangthai =:trangthai")
	public List<MonAnModel> findbyIdtrangthai (String trangthai);
}
