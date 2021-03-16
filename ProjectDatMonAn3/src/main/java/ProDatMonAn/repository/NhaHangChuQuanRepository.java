package ProDatMonAn.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProDatMonAn.model.DanhMucSanPhamModel;
import ProDatMonAn.model.NhaHangChuQuanModel;

@Repository
public interface NhaHangChuQuanRepository extends CrudRepository<NhaHangChuQuanModel,Integer>{

	@Query("from NhaHangChuQuanModel nh where nh.mataikhoan=:idnhahang")
	public  NhaHangChuQuanModel findbyidnhaHang (int idnhahang);
	@Query("from NhaHangChuQuanModel dm where dm.trangthai=:trangthai")
	public List<NhaHangChuQuanModel> findbytrangthai (String trangthai);
	
	
	
}

