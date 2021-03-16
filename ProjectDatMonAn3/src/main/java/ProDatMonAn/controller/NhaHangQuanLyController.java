package ProDatMonAn.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ProDatMonAn.model.DanhMucSanPhamModel;
import ProDatMonAn.model.MonAnModel;
import ProDatMonAn.model.NhaHangChuQuanModel;
import ProDatMonAn.model.TaiKhoanModel;
import ProDatMonAn.model.ThucDon;
import ProDatMonAn.model.ThucDonModel;
import ProDatMonAn.repository.DanhMucSanPhamRepository;
import ProDatMonAn.repository.MonAnReponsitory;
import ProDatMonAn.repository.NhaHangChuQuanRepository;
import ProDatMonAn.repository.ThucDonRepository;

@Controller
@RequestMapping("/nhahangquanly")
public class NhaHangQuanLyController {

	@Autowired
	MonAnReponsitory mar;
	@Autowired
	NhaHangChuQuanRepository nhcqr;
	@Autowired
	ThucDonRepository tdr;
	@Autowired
	DanhMucSanPhamRepository dmspr;
	 
	
	
	@GetMapping("index")	
	public ModelAndView Index(HttpSession session){
		
		ModelAndView mv=new ModelAndView("quanli");
		ModelMap map=new ModelMap();
		TaiKhoanModel taikhoan=	(TaiKhoanModel) session.getAttribute("user");
		System.out.println(taikhoan.getMataikhoan());
		Iterable<NhaHangChuQuanModel> dsNhaHang= nhcqr.findAll();
		
		
		
		
		
		
		
		
		
		
		
		int idNhaHangChuQuan=0;
		for(NhaHangChuQuanModel nh:dsNhaHang)
		{
			if(nh.getMataikhoan()==taikhoan.getMataikhoan())
				idNhaHangChuQuan=nh.getManhahang();
		}
		
		
		List<ThucDonModel> ThucDonCanTim= new ArrayList<ThucDonModel>();
		Iterable<ThucDonModel>dsthucdon=tdr.findAll();
		ArrayList<MonAnModel> monAnNhahang=new ArrayList<MonAnModel>();
		
		Iterable<MonAnModel> dsMonAn=mar.findAll();
		for(ThucDonModel id:dsthucdon)
		{
		
			if(id.getManhahang()==idNhaHangChuQuan)
			{	
				ThucDonCanTim.add(id);		
				for(MonAnModel monan:dsMonAn)
					if(monan.getMathucdon()==id.getMathucdon())
					{	monAnNhahang.add(monan);
				
					}
			}	
		}
		
		
		map.addAttribute("danhsachmonannhahang", monAnNhahang);
		
		map.addAttribute("danhsachthucdon", ThucDonCanTim);
		mv.addAllObjects(map);
		
		
		
		return mv;
	}
	
	@GetMapping("menu")
	public ModelAndView DanhSachThucDon() {
		ThucDon menu=new ThucDon();
		ModelAndView mv=new ModelAndView("taoMenu","thucdon",menu);
		

		return mv;
	}
	@GetMapping("chinhsua/{idmonan}")
	public ModelAndView getchinhsua(@PathVariable int idmonan) {
		
		ThucDon td=new ThucDon();
		ModelAndView mv=new ModelAndView("chinhsuamonan","monancantim",td);
		ModelMap map=new ModelMap();
		
		MonAnModel monan=mar.findById(idmonan).get();
		Iterable<DanhMucSanPhamModel>dsdanhmuc= dmspr.findAll();
		
		
		ThucDonModel thucdon=tdr.findById(monan.getIddanhmuc()).get();
		
		Iterable<ThucDonModel> dsThucdon= tdr.findAll();
		
		DanhMucSanPhamModel danhmuc=dmspr.findById(monan.getIddanhmuc()).get();
		
		map.addAttribute("thucdon",thucdon);
		map.addAttribute("monan", monan);
		map.addAttribute("danhmuc", danhmuc);
		map.addAttribute("danhsachloaimonan", dsdanhmuc);
		map.addAttribute("dsthucdon", dsThucdon);
		mv.addAllObjects(map);
		return mv;
	}
	@PostMapping("chinhsua")
	public ModelAndView postchinhsua(@ModelAttribute ThucDon monancantim) {
		
		ModelAndView mv=new ModelAndView("quanli");
		
//		Iterable<NhaHangChuQuanModel> nhahang= nhcqr.findAll();
//		MonAnModel monan=new MonAnModel();
		return mv;
	}
	
}
