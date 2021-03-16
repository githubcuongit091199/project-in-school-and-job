package ProDatMonAn.controller;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ProDatMonAn.model.ChiTietDonHangModel;
import ProDatMonAn.model.DanhMucSanPhamModel;
import ProDatMonAn.model.DonDatHangModel;
import ProDatMonAn.model.KhachHangModel;
import ProDatMonAn.model.MaGiamGiaModel;
import ProDatMonAn.model.MatHang;
import ProDatMonAn.model.MonAnModel;
import ProDatMonAn.model.TaiKhoanModel;
import ProDatMonAn.model.giohang;
import ProDatMonAn.repository.ChiTietDonHangRepository;
import ProDatMonAn.repository.DanhMucSanPhamRepository;
import ProDatMonAn.repository.DonDatHangRepository;
import ProDatMonAn.repository.KhachHangRepository;
import ProDatMonAn.repository.MaGiamGiaRepository;
import ProDatMonAn.repository.MonAnReponsitory;

@Controller
@RequestMapping("/giohang")
public class GioHangController {
	
	@Autowired
	MonAnReponsitory mar;
	@Autowired
	DonDatHangRepository ddhr;
	@Autowired
	ChiTietDonHangRepository ctdhr;
	@Autowired
	KhachHangRepository khr;
	@Autowired
	MaGiamGiaRepository mggr;
	@Autowired
	DanhMucSanPhamRepository dmspr;

	
	
			@GetMapping("index")		
		public ModelAndView Index(){
				ModelMap map=new ModelMap();
				ModelAndView mv = new ModelAndView("GioHang");
				danhmuc(map);
				mv.addAllObjects(map);
			return mv;
		}
		
		@GetMapping("thanhtoan")
		public String ThanhToan(HttpSession session) {
			giohang gio = (giohang) session.getAttribute("cart");
			if(gio==null) {
				return  ("redirect:/giohang/index");
			}
			return "ThanhToan";
		}
		public  void danhmuc(ModelMap map)
		{
			List<DanhMucSanPhamModel> dsdanhmuc= dmspr.findbytrangthai("hien");
			
			map.addAttribute("danhsachloaimonan",dsdanhmuc);
			for(DanhMucSanPhamModel dm:dsdanhmuc)
			System.out.println("danh muc"+ dm.getLoaimonan()+dm.getTrangthai());
		}
		@GetMapping("themvaodb")
		public String XacNhanThanhToan(HttpSession session) {
			giohang gio=(giohang) session.getAttribute("cart");
			TaiKhoanModel taikhoan=(TaiKhoanModel) session.getAttribute("user");
		
			if(taikhoan==null)
			{
				return ("redirect:/taikhoan/dangnhap");
			}			
			else
			{
				System.out.println(taikhoan.getMataikhoan());
				System.out.println("ffffff44444445555555555555666666666");
				
				KhachHangModel khachhang=khr.findbyidkhachhang(taikhoan.getMataikhoan());
			
					System.out.println(khachhang);
				ThemHangVaoDB(gio,khachhang.getMakhachhang());
				session.removeAttribute("cart");
				return ("redirect:/home/index");
			}
		}
		
		@GetMapping("index1/{idmonan}")		///////////
		public ModelAndView themhangvaogio(HttpSession session,@PathVariable int idmonan,@RequestParam ("soluong") int soluong){
		
			ModelAndView mv = new ModelAndView("GioHang");
			MonAnModel monan= mar.findById(idmonan).get();
			MatHang mathang=new MatHang();

			List<MatHang> dshang=new ArrayList<>();
			giohang gio=new giohang();
			
				if(session.getAttribute("cart")==null)//chưa có món an nào trong giỏ
				{					
					mathang.setMonan(monan);
					mathang.setIdmonan(idmonan);
					mathang.setSoluong(soluong);					
					dshang.add(mathang);					
					gio.setItem(dshang);
					session.setAttribute("cart", gio);
				}else 
				{
					gio=(giohang) session.getAttribute("cart");
					dshang=gio.getItem();	
					
					if(new TrangThaiGioHang().KiemTra(dshang, idmonan)==true)//món ăn đã có trong giỏ hàng
					{
					for(MatHang mh:dshang)						
						{
						if(mh.getIdmonan()==idmonan)
							{
							mh.setSoluong(mh.getSoluong()+ soluong);
							}
						
						}
							
					}
					else {
						mathang.setMonan(monan);
						mathang.setIdmonan(idmonan);
						mathang.setSoluong(soluong);					
						dshang.add(mathang);					
						gio.setItem(dshang);
						session.setAttribute("cart", gio);
											
						}
				}
				
				gio=(giohang) session.getAttribute("cart");
				dshang=gio.getItem();	
				
				for(MatHang j:dshang)
				System.out.println(j.getIdmonan());
				return mv;
		}
		
		
	
		
		@GetMapping("xoa/{idmonan}")		
		public ModelAndView Index1(HttpSession session,@PathVariable int idmonan){
			ModelAndView mv=new ModelAndView("GioHang");
			
			
			
			
			List<MatHang> dshang=new ArrayList<>();
			giohang gio=new giohang();
			gio=(giohang) session.getAttribute("cart");
			dshang=gio.getItem();
			
			
			
			for(int i=0;i<dshang.size();i++)
			{
				if(dshang.get(i).getIdmonan()==idmonan)
				{
					dshang.remove(i);
				}
			}
			gio.setItem(dshang);
			session.setAttribute("cart", gio);
			
		
			
			
			
			
			return mv;
		}
		public void ThemHangVaoDB(giohang cart, int idkhachhang)
		{
				System.out.println("ffffff4444444");
				List<MatHang> mathang=cart.getItem();
	
				
				DonDatHangModel donhang=new DonDatHangModel(1,cart.getSoLuong(),cart.getGia(),"26/5/2020",idkhachhang);
				
				ddhr.save(donhang);
				
				Iterable<DonDatHangModel> iterDonHang=ddhr.findAll();
			
				ArrayList<DonDatHangModel> arrdonhang=(ArrayList<DonDatHangModel>) iterDonHang;
			
				System.out.println(idkhachhang);
				for(MatHang hang:mathang)
					{
					ChiTietDonHangModel chitiet=new ChiTietDonHangModel(hang.getIdmonan(),hang.getThanhTien(),hang.getSoluong(),arrdonhang.size(),hang.getMonan().getKhuyenmai());
					
					ctdhr.save(chitiet);
			
					
					}
				   
		}
		@GetMapping("giamgia")
		public ModelAndView KhuyenMai(@RequestParam ("magiamgia") String MaGiam,HttpSession session)
		{
			ModelAndView mv =new ModelAndView("GioHang");
			MaGiamGiaModel giamgia= mggr.findbytenma(MaGiam);
			
			giohang gio= (giohang) session.getAttribute("cart");
			if(session.getAttribute("cart")!= null)
			{
			if(gio.getMagiamgia()==0)
			gio.setMagiamgia(giamgia.getMoney());
			else {
				mv.addObject("thongbao", "bạn đã sử dụng khuyến mãi");
			}
			}
			return mv;
			
				
				
	
			
		}
		
		
		
		
				
	













































			@PostMapping("chinhsua")
			public ModelAndView chinhsua(@RequestParam ("soluong") int soluong,HttpSession session,@RequestParam ("id") int id)
			{
				ModelAndView mv=new ModelAndView("GioHang");
				System.out.println("hhhhhhhhhhhhhhhhhhhhhh");
				giohang gio=  (giohang) session.getAttribute("cart");
				System.out.println(gio.getGia());
				for(MatHang hang:gio.getItem())
				{
					System.out.println(hang.getIdmonan());
					System.out.println("so luong mmmmmm   "+soluong);
					//int soluong=(int) request.getAttribute(String.valueOf(hang.getIdmonan()));
					//System.out.println(hang.getIdmonan());
					if(hang.getIdmonan()==id)
					{
						hang.setSoluong(soluong);
						break;
					}
				}
				
				return mv;
			}
		
			
		
}
