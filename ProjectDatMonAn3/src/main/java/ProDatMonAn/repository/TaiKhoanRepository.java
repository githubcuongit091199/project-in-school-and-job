package ProDatMonAn.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import ProDatMonAn.model.TaiKhoanModel;

@Repository
public interface TaiKhoanRepository extends CrudRepository<TaiKhoanModel,Integer>{
	@Query("from TaiKhoanModel tk where tk.email =:email")
	public TaiKhoanModel findbyIdEmail (String email);
	
	
}