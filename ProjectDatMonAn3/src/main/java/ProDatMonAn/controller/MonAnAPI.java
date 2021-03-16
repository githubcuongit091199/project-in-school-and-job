package ProDatMonAn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProDatMonAn.model.MonAnModel;
import ProDatMonAn.repository.MonAnReponsitory;

@RestController
@RequestMapping("/api/monan")
@CrossOrigin("http://10.0.2.2:*")
public class MonAnAPI {
	@Autowired 
	MonAnReponsitory ma;
	@GetMapping("/danhsachmonan")
	public List<MonAnModel> monan(){
		return (List<MonAnModel>)ma.findAll();
	}
	
}
