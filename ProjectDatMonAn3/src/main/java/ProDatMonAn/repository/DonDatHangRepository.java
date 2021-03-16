package ProDatMonAn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProDatMonAn.model.DonDatHangModel;

@Repository
public interface DonDatHangRepository extends CrudRepository<DonDatHangModel,Integer>{

}
