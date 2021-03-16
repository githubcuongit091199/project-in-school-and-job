package ProDatMonAn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProDatMonAn.model.DanhMucSanPhamModel;
import ProDatMonAn.model.MaGiamGiaModel;

@Repository
public interface DanhMucSanPhamRepository extends CrudRepository<DanhMucSanPhamModel,Integer>{
	@Query("from DanhMucSanPhamModel dm where dm.trangthai=:trangthai")
	public List<DanhMucSanPhamModel> findbytrangthai (String trangthai);
}
