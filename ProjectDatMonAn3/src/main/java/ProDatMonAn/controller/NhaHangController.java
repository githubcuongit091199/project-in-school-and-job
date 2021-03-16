package ProDatMonAn.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ProDatMonAn.model.DanhMucSanPhamModel;
import ProDatMonAn.model.MonAnModel;
import ProDatMonAn.model.NhaHangChuQuanModel;
import ProDatMonAn.model.ThucDonModel;
import ProDatMonAn.repository.DanhMucSanPhamRepository;
import ProDatMonAn.repository.MonAnReponsitory;
import ProDatMonAn.repository.NhaHangChuQuanRepository;
import ProDatMonAn.repository.ThucDonRepository;


@Controller
@RequestMapping("/nhahang")
public class NhaHangController {
	@Autowired
	ThucDonRepository tdr;
	
	@Autowired
	MonAnReponsitory mar;
	@Autowired
	NhaHangChuQuanRepository nhcqr;
	@Autowired
	DanhMucSanPhamRepository dmspr;
	
	
	@GetMapping("trangnhahang/{manhahang}")
	public ModelAndView Index(@PathVariable int manhahang ){
		ModelMap map=new ModelMap();
		
		Iterable<DanhMucSanPhamModel> lst2 = dmspr.findAll();		
		map.addAttribute("danhsachloaimonan",lst2);
		ModelAndView mv = new ModelAndView("NhaHang");
		Iterable<NhaHangChuQuanModel> lst3 = nhcqr.findAll();
		NhaHangChuQuanModel m=new NhaHangChuQuanModel();
	
		Iterable<ThucDonModel> lst = tdr.findAll();
		   ArrayList<ThucDonModel> listThucDon = new ArrayList<ThucDonModel>();// khởi tạo danh sách thực đơn có trong nhà hàng
		   
		   ArrayList<MonAnModel> listMonAn = new ArrayList<MonAnModel>();// khởi tạo danh sách món ăn có trong nhà hàng
		   

		for(NhaHangChuQuanModel nh:lst3) {// lấy thông tin nhà hàng
			
			if(manhahang==nh.getManhahang()) {
				m=nh;
				
			break;
				
			}
		}
		for(ThucDonModel td:lst) {//lấy danh sách mon ăn có trong nhà hàng
			if(manhahang	== td.getManhahang()) {
				listThucDon.add(td);
				
		
			}
		}
		
		map.addAttribute("thongtinnhahang", m);
		
		map.addAttribute("thongtinthucdon",listThucDon);
		
		Iterable<MonAnModel> lst1 = mar.findAll();
		
		for(MonAnModel ma:lst1) {
			for(ThucDonModel td:listThucDon)
			{
				if(ma.getMathucdon()==td.getMathucdon())
				{
					listMonAn.add(ma);
					
				}
				
				
			}
		}
		

		map.addAttribute("monannhahang",listMonAn);
		
		mv.addAllObjects(map);
		return mv;
	}
	@GetMapping("trangnhahang1/{mathucdon}")
	public ModelAndView Index1(@PathVariable int mathucdon ){
		ModelMap map=new ModelMap();
		ModelAndView mv = new ModelAndView("NhaHang");
		Iterable<ThucDonModel> lst = tdr.findAll();	 
	
		   Iterable<NhaHangChuQuanModel> lst3 = nhcqr.findAll();
		   NhaHangChuQuanModel m=new NhaHangChuQuanModel();
		   ArrayList<MonAnModel> listMonAn1 = new ArrayList<MonAnModel>();
			ArrayList<ThucDonModel> listThucDon = new ArrayList<ThucDonModel>();// khởi tạo danh sách thực đơn có trong nhà hàng
			int manhahang = 0;
		Iterable<MonAnModel> lst1 = mar.findAll();

		for(ThucDonModel td:lst) {//lấy danh sách mon ăn có trong nhà hàng
			if(mathucdon	== td.getMathucdon()) {
				manhahang=td.getManhahang();
				
				
		
			}
		}
		for(MonAnModel ma1:lst1) {
			if(mathucdon	== ma1.getMathucdon()) {
				listMonAn1.add(ma1);
				
		
			}
		}
		for(ThucDonModel td:lst) {//lấy danh sách mon ăn có trong nhà hàng
			if(manhahang== td.getManhahang()) {
				
				listThucDon.add(td);
				
		
			}
		}

		for(NhaHangChuQuanModel nh:lst3) {// lấy thông tin nhà hàng
			
			if(manhahang==nh.getManhahang()) {
				m=nh;
				
			break;
				
			}
		}
		

		
		map.addAttribute("thongtinthucdon",listThucDon);
		
		map.addAttribute("thongtinnhahang", m);

		map.addAttribute("monannhahang",listMonAn1);
		mv.addAllObjects(map);
		return mv;
	}


}
