package ProDatMonAn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProDatMonAn.model.ChiTietDonHangModel;

@Repository
public interface ChiTietDonHangRepository extends CrudRepository<ChiTietDonHangModel,Integer>{

}
