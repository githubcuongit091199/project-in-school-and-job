package ProDatMonAn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ProDatMonAn.model.DanhMucSanPhamModel;
import ProDatMonAn.model.MonAnModel;
import ProDatMonAn.repository.DanhMucSanPhamRepository;
import ProDatMonAn.repository.MonAnReponsitory;
import ProDatMonAn.repository.NhaHangChuQuanRepository;

@Controller
@RequestMapping("/chitietmonan")
public class MonAnController {
	 @Autowired
	 MonAnReponsitory mar; 
	 @Autowired
	 NhaHangChuQuanRepository nhcqr; 
	 @Autowired
	 DanhMucSanPhamRepository dmspr;
	 
	 public  void danhmuc(ModelMap map)
		{
			List<DanhMucSanPhamModel> dsdanhmuc= dmspr.findbytrangthai("hien");
			
			map.addAttribute("danhsachloaimonan",dsdanhmuc);
			for(DanhMucSanPhamModel dm:dsdanhmuc)
			System.out.println("danh muc"+ dm.getLoaimonan()+dm.getTrangthai());
		}
	 
	 @GetMapping("chitiet/{idmonan}")
	  public ModelAndView Details(@PathVariable int idmonan) {
		
		 ModelAndView mv1 = new ModelAndView("ChiTietMonAn");
		  
		  
		  ModelMap map=new ModelMap();
		  danhmuc(map);
		  Iterable<MonAnModel> lst = mar.findAll();
		  MonAnModel m=new MonAnModel();
			for(MonAnModel nh:lst) {
			if(idmonan==nh.getMamonan()) {
				m=nh;
			break;
				
			}
			}
			
			 
				
			
		  map.addAttribute("monan",m);
		  
		  mv1.addAllObjects(map);
		  
		  return mv1;
	  }
	 
	  
}
