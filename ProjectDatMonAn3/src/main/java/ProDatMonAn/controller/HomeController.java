package ProDatMonAn.controller;


import java.util.ArrayList;
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
import ProDatMonAn.model.NhaHangChuQuanModel;
import ProDatMonAn.repository.DanhMucSanPhamRepository;
import ProDatMonAn.repository.MonAnReponsitory;
import ProDatMonAn.repository.NhaHangChuQuanRepository;


@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	NhaHangChuQuanRepository nhcqr;
	@Autowired
	DanhMucSanPhamRepository dmspr; 
	@Autowired
	MonAnReponsitory mar;
	
	
	public  void danhmuc(ModelMap map)
	{
		List<DanhMucSanPhamModel> dsdanhmuc= dmspr.findbytrangthai("hien");
		
		map.addAttribute("danhsachloaimonan",dsdanhmuc);
		for(DanhMucSanPhamModel dm:dsdanhmuc)
		System.out.println("danh muc"+ dm.getLoaimonan()+dm.getTrangthai());
	}
	@GetMapping("index")
	public ModelAndView Index(){
		ModelMap map=new ModelMap();
		ModelAndView mv = new ModelAndView("Index");
		Iterable<NhaHangChuQuanModel> lst1 = nhcqr.findbytrangthai("hien");	
		map.addAttribute("danhsach",lst1);
		danhmuc(map);
		khuyenmai(map);
		mv.addAllObjects(map);
		return mv;
	}
	@GetMapping("nhomhang/{iddanhmuc}")
	public ModelAndView NhomMonAn(@PathVariable int iddanhmuc)
	{
		ModelAndView mv =new ModelAndView("NhomMonAn");
		ModelMap map=new ModelMap();
		System.out.println("da vo day khong??");
		Iterable<MonAnModel> listMonAn= mar.findbyIdtrangthai("hien");
		 
		   ArrayList<MonAnModel> listMonAnTrongDanhMuc = new ArrayList<MonAnModel>();// khởi tạo danh sách món ăn có trong nhà hàng
		   Iterable<DanhMucSanPhamModel> lst2 = dmspr.findbytrangthai("hien");		
			map.addAttribute("danhsachloaimonan",lst2);
		  
		 for(MonAnModel ma:listMonAn)
		  {
			  if(ma.getIddanhmuc()== iddanhmuc)
			  {
					
				  listMonAnTrongDanhMuc.add(ma);
			  }
		  }
		
		
		map.addAttribute("monan",listMonAnTrongDanhMuc);
		mv.addAllObjects(map);
		
		return mv ; 
	}

	public void khuyenmai(ModelMap map)
	{
		Iterable< MonAnModel> dsmonan= mar.findAll();
		List<MonAnModel> khuyenmai=new ArrayList<MonAnModel>();
		for(MonAnModel monan:dsmonan)
		{
			if(monan.getKhuyenmai()>1)
			{
				khuyenmai.add(monan);
			}
		}
		map.addAttribute("khuyenmai",khuyenmai);
		
		
	}
	@GetMapping("shopping")
	public ModelAndView shopping()
	{
		ModelAndView mv =new ModelAndView("NhomMonAn");
		ModelMap map=new ModelMap();		
		Iterable<MonAnModel> listMonAn= mar.findAll();
		danhmuc(map);
		khuyenmai(map);
		map.addAttribute("monan",listMonAn);
		mv.addAllObjects(map);
		
		return mv ; 
	}
	
	


	 

}
