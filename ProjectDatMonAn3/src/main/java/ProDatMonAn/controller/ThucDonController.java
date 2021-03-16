package ProDatMonAn.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ProDatMonAn.model.ThucDonModel;
import ProDatMonAn.repository.ThucDonRepository;

@Controller
@RequestMapping("/thucdon")
public class ThucDonController {
	@Autowired
	ThucDonRepository tdr;
	@GetMapping("thucdon")
		public ModelAndView DanhSachThucDon() {
			Iterable<ThucDonModel> lst = tdr.findAll();
			ModelAndView mv=new ModelAndView("NhaHang");
			mv.addObject("danhsachthucdon",lst);
	
			return mv;
		}
}
