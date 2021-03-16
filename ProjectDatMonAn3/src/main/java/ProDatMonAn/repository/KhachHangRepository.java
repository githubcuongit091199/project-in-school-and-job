package ProDatMonAn.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProDatMonAn.model.KhachHangModel;

@Repository
public interface KhachHangRepository extends CrudRepository<KhachHangModel,Integer>{

	@Query("from KhachHangModel kh where kh.mataikhoan=:idkhachhang")
	public KhachHangModel findbyidkhachhang (int idkhachhang);

}