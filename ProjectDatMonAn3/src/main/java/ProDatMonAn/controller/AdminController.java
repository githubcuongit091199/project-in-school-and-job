package ProDatMonAn.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ProDatMonAn.model.DanhMucSanPhamModel;

import ProDatMonAn.model.MaGiamGiaModel;
import ProDatMonAn.model.MonAnModel;
import ProDatMonAn.model.NhaHangChuQuanModel;
import ProDatMonAn.model.TaiKhoanModel;
import ProDatMonAn.model.ThucDonModel;
import ProDatMonAn.repository.ChiTietDonHangRepository;
import ProDatMonAn.repository.DanhMucSanPhamRepository;
import ProDatMonAn.repository.DonDatHangRepository;
import ProDatMonAn.repository.MaGiamGiaRepository;
import ProDatMonAn.repository.MonAnReponsitory;
import ProDatMonAn.repository.NhaHangChuQuanRepository;
import ProDatMonAn.repository.TaiKhoanRepository;
import ProDatMonAn.repository.ThucDonRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	NhaHangChuQuanRepository nhcqr;
	@Autowired
	ChiTietDonHangRepository ctdhr;
	@Autowired
	DonDatHangRepository ddhr;
	@Autowired
	DanhMucSanPhamRepository dmspr;
	@Autowired
	MaGiamGiaRepository mggr;
	@Autowired 
	TaiKhoanRepository tkr;
	@Autowired
	MonAnReponsitory mar;
	@Autowired
	ThucDonRepository tdr;
	HibernateTemplate template;  
	@GetMapping("index")
	public ModelAndView admin(){
		System.out.println("da vo day khong??");
		ModelAndView mv = new ModelAndView("admin/AdminIndex");
		
		return mv;
	}
	//chỉnh sửa danh mục món ăn
	@GetMapping("quanlidanhmucmonan")
	public ModelAndView bang(){

		ModelAndView mv = new ModelAndView("admin/DanhMucMonAn" );
		ModelMap map=new ModelMap();		
		Iterable<DanhMucSanPhamModel> dsdanhmuc=dmspr.findAll();
		map.addAttribute("dsdanhmuc", dsdanhmuc);			
		mv.addAllObjects(map);
		return mv;
	}


			//thêm loại món ăn
	@GetMapping("themmoidanhmucmonan")
	public ModelAndView themdanhmucmonan(){
		ModelAndView mv = new ModelAndView("admin/themdanhmucmonan");
		DanhMucSanPhamModel danhmuc = new DanhMucSanPhamModel();
		mv.addObject("danhmucmonan",danhmuc);
		return mv;
	}
	@PostMapping("themmoidanhmucmonan")
	public ModelAndView themdanhmucmonanpost(@ModelAttribute DanhMucSanPhamModel danhmucmonan){
		System.out.println(danhmucmonan.getLoaimonan()+"hhhhhhhh");
		dmspr.save(danhmucmonan);
		ModelAndView mv = new ModelAndView("redirect:/admin/quanlidanhmucmonan");
		return mv;
	}
			//xóa loại món ăn
	@GetMapping("xoadanhmucmonan/{iddanhmuc}")
	public ModelAndView xoadanhmucmonan(@PathVariable int iddanhmuc){
		DanhMucSanPhamModel danhmuc=dmspr.findById(iddanhmuc).get();
		danhmuc.setTrangthai("xoa");
		
		if(danhmuc!=null)
		dmspr.save(danhmuc);
		ModelAndView mv = new ModelAndView("redirect:/admin/quanlidanhmucmonan");
		return mv;
	}
			//chỉnh sửa loại món ăn
	@GetMapping("chinhsuadanhmucmonan/{iddanhmuc}")
	public ModelAndView chinhsuadanhmucmonan(@PathVariable int iddanhmuc,@ModelAttribute DanhMucSanPhamModel danhmucmonan){
		DanhMucSanPhamModel danhmuc=dmspr.findById(iddanhmuc).get();
		System.out.println("danh muc cua ádasdasdasdsa"+ danhmuc.getLoaimonan());
		ModelAndView mv = new ModelAndView("/admin/ChinhSuaDanhMucMonAn");
		System.out.println("danh muc cua ádasdasdasdsa"+ danhmuc.getLoaimonan());
		mv.addObject("danhmucmonan",danhmuc);
		return mv;
	}
	@PostMapping("chinhsuadanhmucmonan/{iddanhmuc}")
	public ModelAndView chinhsuadanhmucmonanpost(@PathVariable int iddanhmuc,@ModelAttribute DanhMucSanPhamModel danhmucmonan){
		
		System.out.println(danhmucmonan.getIddanhmuc()+"hhhhhhhh");
		
		DanhMucSanPhamModel danhmuccu=dmspr.findById(iddanhmuc).get();
		danhmuccu.setLoaimonan(danhmucmonan.getLoaimonan());
		
		danhmuccu.setTrangthai(danhmucmonan.getTrangthai());
		

		dmspr.save(danhmuccu);
		
		
		
		ModelAndView mv = new ModelAndView("redirect:/admin/quanlidanhmucmonan");
		return mv;
	}
//chỉnh sửa quyền nhà hàng chủ quán
	
	@GetMapping("nhahangchuquan")
	public ModelAndView QuyenNhaHangChuQuan()
	{
		Iterable<NhaHangChuQuanModel> dsKhachHang=nhcqr.findAll();
		ModelAndView mv = new ModelAndView("/admin/NhaHangChuQuan");	
		mv.addObject("dskhachhang", dsKhachHang);
		return mv;
	}
				//chỉnh sửa nhà hàng chủ quán
	@GetMapping("chinhsuanhahangchuquan/{idkhachhang}")
	public ModelAndView ChinhSuaQuyenNhaHangChuQuan(@PathVariable int idkhachhang){
	
		NhaHangChuQuanModel nhahang= nhcqr.findById(idkhachhang).get();
	
		
		
		ModelAndView mv = new ModelAndView("/admin/ChinhSuaNhaHangChuQuan","nhahangchuquan",nhahang);
		
		
		return mv;
	}  
	@PostMapping("chinhsuanhahangchuquan/{idkhachhang}")// sửa dữ liệu trong data
	public ModelAndView ChinhSuaQuyenNhaHangChuQuangpost(@PathVariable int idkhachhang,@ModelAttribute NhaHangChuQuanModel nhahangchuquan){
		System.out.println("??????");
		NhaHangChuQuanModel NhaHangCu = nhcqr.findById(idkhachhang).get();		
		NhaHangCu.setDiachi(nhahangchuquan.getDiachi());
		NhaHangCu.setSdt(nhahangchuquan.getSdt());
		NhaHangCu.setTennhahang(nhahangchuquan.getTennhahang());
		NhaHangCu.setTrangthai(nhahangchuquan.getTrangthai());
		nhcqr.save(NhaHangCu);
		if(nhahangchuquan.getTrangthai().compareTo("an")==0)
		{
			List<ThucDonModel> dsthucdon=tdr.findbyIdThucDon(idkhachhang);
			List<MonAnModel> dsmonan=new ArrayList<MonAnModel>();
			for(ThucDonModel th:dsthucdon) {
				dsmonan.addAll(mar.findbyIdThucDon(th.getMathucdon()));
				
			} 
			for(MonAnModel ma:dsmonan) {
				ma.setTrangthai("an");
				mar.save(ma);
			}
			
		} 
		
		
	
		
		
		ModelAndView mv = new ModelAndView("redirect:/admin/nhahangchuquan");
		return mv;
	}
			//xóa nhà hàng chủ quán
	@GetMapping("xoanhahangchuquan/{idkhachhang}")
	public ModelAndView XoaNhaHangChuQuan(@PathVariable int idkhachhang){
		
		NhaHangChuQuanModel nhahang=nhcqr.findById(idkhachhang).get();
		nhahang.setTrangthai("xóa");
		nhcqr.save(nhahang);
		
		
			List<ThucDonModel> dsthucdon=tdr.findbyIdThucDon(idkhachhang);
			List<MonAnModel> dsmonan=new ArrayList<MonAnModel>();
			for(ThucDonModel th:dsthucdon) {
				dsmonan.addAll(mar.findbyIdThucDon(th.getMathucdon()));
				
			} 
			for(MonAnModel ma:dsmonan) {
				ma.setTrangthai("xoa");
				mar.save(ma);
			}
			
		
		
		ModelAndView mv = new ModelAndView("redirect:/admin/nhahangchuquan");
		return mv;
	}
//khuyễn mãi
	@GetMapping("khuyenmai")
	public ModelAndView KhuyenMai(){
		
	
		ModelAndView mv = new ModelAndView("/admin/KhuyenMai");	
		mv.addObject("dskhuyenmai", mggr.findAll() );
		return mv;
	}
			//chỉnh sửa khuyễn mãi
	@GetMapping("chinhsuakhuyenmai/{idkhuyenmai}")
	public ModelAndView ChinhSuaKhuyenMai(@PathVariable int idkhuyenmai){
	
		
		MaGiamGiaModel khuyenmai =mggr.findById(idkhuyenmai).get();
		
		ModelAndView mv = new ModelAndView("/admin/ChinhSuaKhuyenMai","GiamGia",khuyenmai);
		
		
		return mv;
	}  
	@PostMapping("chinhsuakhuyenmai/{idkhuyenmai}")// sửa dữ liệu trong data
	public ModelAndView ChinhSuaKhuyenMaipost(@PathVariable int idkhuyenmai,@ModelAttribute("GiamGia") MaGiamGiaModel khuyenmai){
		
		
	System.out.println("fffff"+khuyenmai.getMoney());
		MaGiamGiaModel giagiamcu=mggr.findById(idkhuyenmai).get();
		
		giagiamcu.setMoney(khuyenmai.getMoney());
		giagiamcu.setTenma(khuyenmai.getTenma());
		giagiamcu.setTrangthai(khuyenmai.getTrangthai());
		giagiamcu.setStartdate(khuyenmai.getStartdate());
		giagiamcu.setFinishdate(khuyenmai.getFinishdate());
		mggr.save(giagiamcu);
		ModelAndView mv = new ModelAndView("redirect:/admin/khuyenmai");
		return mv;
	}
			//thêm khuyễn mãi
	@GetMapping("themmoikhuyenmai")
	public ModelAndView themKhuyenMai(){
	
		MaGiamGiaModel GiamGia=new MaGiamGiaModel();
		
		ModelAndView mv = new ModelAndView("admin/ThemKhuyenMai","khuyenmai",GiamGia);
		
		

		return mv;
	}
	@PostMapping("themmoikhuyenmai")
	public ModelAndView themKhuyenMaipost(@ModelAttribute MaGiamGiaModel khuyenmai){
		//System.out.println(danhmucmonan.getLoaimonan()+"hhhhhhhh");
		khuyenmai.setTrangthai("hiện");
		
		mggr.save(khuyenmai);
		
		ModelAndView mv = new ModelAndView("redirect:/admin/khuyenmai");
		return mv;
	}
			//xóa khuyễn mãi
	@GetMapping("xoakhuyenmai/{idkhuyenmai}")
	public ModelAndView xoakhuyenmai(@PathVariable int idkhuyenmai){
		MaGiamGiaModel GiamGia=mggr.findById(idkhuyenmai).get();
		GiamGia.setTrangthai("xoa");
		mggr.save(GiamGia);
		ModelAndView mv = new ModelAndView("redirect:/admin/khuyenmai");
		return mv;
	}
	//đăng nhập tài khoải admin
	@GetMapping("dangnhap")
	public ModelAndView dangnhap(){
	
		ModelAndView mv = new ModelAndView("admin/login","user",new TaiKhoanModel());
		return mv;
	}
	@PostMapping("dangnhap")
	public String dangnhappost(@ModelAttribute("admin") TaiKhoanModel taikhoan,HttpSession session) throws NoSuchAlgorithmException{
		//System.out.println(danhmucmonan.getLoaimonan()+"hhhhhhhh");
		TaiKhoanModel user = tkr.findbyIdEmail(taikhoan.getEmail());
		 /*for(KhachHangModel kh:lst)
		 {
			 System.out.println(kh.getPassword()+ user.getPassword());
		 }*/
//		System.out.println("tai khoan"+user.getEmail()+" "+user.getLoaitaikhoan());
		if(user.getLoaitaikhoan().compareTo("quanly")==0)
			{
			System.out.println("vo day ko");
			if(kiemtraEmail(user.getEmail(), taikhoan.getEmail())==true && kiemtraPassword(taikhoan.getPassword(), user.getPassword())==true)
			{ 
				session.setAttribute("admin", user);
			
					return "redirect:/admin/index";				
			 
			
			}
			}else {
				
						return "redirect:/admin/danghap";				
			}
				
		System.out.println("vo xuong day ko");
		
	
		
		
	
		
		return "redirect:/admin/dangnhap";
	}
	@GetMapping("dangxuat")
	public String dangxuat(HttpSession session){
		
		session.invalidate();
		
		
		return "redirect:/admin/dangnhap";
	}
	private String getMD5(String input) throws NoSuchAlgorithmException {
		  
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    byte[] messageDigest = md.digest(input.getBytes());
	    return convertByteToHex1(messageDigest);
	  
	}
	private String convertByteToHex1(byte[] data) {
	  BigInteger number = new BigInteger(1, data);
	  String hashtext = number.toString(16);
	  // Now we need to zero pad it if you actually want the full 32 chars.
	  while (hashtext.length() < 32) {
	    hashtext = "0" + hashtext;
	  }
	  return hashtext;
	}
	private boolean kiemtraPassword(String pass,String pass2) throws NoSuchAlgorithmException
	{
		String pass1=getMD5(pass);
		if(pass1.equals(pass2))
			return true;
		return false;
	}
	private boolean kiemtraEmail(String mail1,String mail2)
	{
		
		if(mail1.equals(mail2))
			return true;
		return false;
	}
	
}
