package ProDatMonAn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProDatMonAn.model.NhaHangChuQuanModel;

import ProDatMonAn.repository.NhaHangChuQuanRepository;

@RestController
@RequestMapping("/api/nhahang")
@CrossOrigin("http://10.0.2.2:*")
public class NhaHangChuQuanAPI {
	@Autowired 
	NhaHangChuQuanRepository nhcq;
	@GetMapping("/danhsachnhahang")
	public List<NhaHangChuQuanModel> monan(){
		return (List<NhaHangChuQuanModel>)nhcq.findAll();
	}
	
}
