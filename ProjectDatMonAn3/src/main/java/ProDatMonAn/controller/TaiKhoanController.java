package ProDatMonAn.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import ProDatMonAn.model.KhachHangModel;
import ProDatMonAn.model.NhaHangChuQuanModel;
import ProDatMonAn.model.Register;
import ProDatMonAn.model.RegisterFormValidator;
import ProDatMonAn.model.TaiKhoanModel;
import ProDatMonAn.repository.KhachHangRepository;
import ProDatMonAn.repository.NhaHangChuQuanRepository;
import ProDatMonAn.repository.TaiKhoanRepository;


@Controller
@RequestMapping("/taikhoan")
public class TaiKhoanController {
	@Autowired
	KhachHangRepository rep;
	@Autowired
	TaiKhoanRepository tkr;
	@Autowired
	NhaHangChuQuanRepository nhcqr;
	
	
	@GetMapping("dangki")
	public ModelAndView Index(){
		Register Kh = new Register();
		ModelAndView mv = new ModelAndView("DangKi","user", Kh);
		//mv.addObject("KH", Kh);
		return mv;
	}
	@PostMapping("dangki")
	public String dangkypost(ModelMap m,@Valid @ModelAttribute("user") Register user,BindingResult result, RegisterFormValidator registerFormValidator) throws NoSuchAlgorithmException  
	{
		System.out.println("dang");
		
		//registerFormValidator.validate(user, result);// Thực hiện validate dữ liệu
//		if(user.getPassword()!=user.getConfirmPassword())
//		{
//			
//			m.addAttribute("loiPassword", "false");
//			System.out.println("confirm pass");
//			return "DangKi";
//		}
//		m.addAttribute("loiPassword", "true");
////		 
		if(result.hasErrors()) {
			System.out.println("dangki "+user.getEmail());
			return "DangKi";
		}
		Iterable<TaiKhoanModel> dsTaiKhoan=tkr.findAll();
		for(TaiKhoanModel taikhoan:dsTaiKhoan)
		{
			if(taikhoan.getEmail().equals(user.getEmail())== true)
			{
				
				return ("redirect:/taikhoan/dangki");
			}
		}

		System.out.println("loz que t tuc rui ak"+user.loaitaikhoan);
			String password = getMD5(user.getPassword());
		if(user.getLoaitaikhoan()==null)
		{
			System.out.println("loz que");
		user.setLoaitaikhoan("khachhang");
		}
		
		System.out.println(""+user.getTenkhachhang()+user.getDiachi()+user.getSdt()+user.getEmail()+user.password+ "  "+user.loaitaikhoan);
		
		TaiKhoanModel t=new TaiKhoanModel(user.getEmail(),password,user.loaitaikhoan);
		
		
		tkr.save(t);
		
		TaiKhoanModel iterTaiKhoan=tkr.findbyIdEmail(user.getEmail());
		
	
		
		if(user.getLoaitaikhoan().compareTo("khachhang")==0)
		{
			System.out.println("loại tài khoan");
			
			KhachHangModel K = new KhachHangModel(user.getTenkhachhang(),user.getDiachi(),user.getSdt(),iterTaiKhoan.getMataikhoan());
		
			rep.save(K);
			
			
		}
		else
		{
			
			NhaHangChuQuanModel nhaHang=new NhaHangChuQuanModel(user.getTenkhachhang(),user.getDiachi(),user.getSdt(),iterTaiKhoan.getMataikhoan());
			nhcqr.save(nhaHang);
		}
		
		
		
//		return "DangKi";
		
		return ("redirect:/taikhoan/dangnhap");
	}
//-----------------------------------------------------------------------------------------------------------------
//-------------------------------------Đăng nhập-------------------------------------------------------------------
	@GetMapping("dangnhap")
	public ModelAndView dangnhap(){
		TaiKhoanModel Kh = new TaiKhoanModel();
		ModelAndView mv = new ModelAndView("DangNhap","user", Kh);
		//mv.addObject("KH", Kh);
		return mv;
	}
	@PostMapping("dangnhap")
	public String trangChu(@ModelAttribute TaiKhoanModel user, HttpSession session) throws NoSuchAlgorithmException {
		Iterable<TaiKhoanModel> lst = tkr.findAll();
		 /*for(KhachHangModel kh:lst)
		 {
			 System.out.println(kh.getPassword()+ user.getPassword());
		 }*/
		for(TaiKhoanModel kh:lst) {
			if(kiemtraEmail(kh.getEmail(), user.getEmail())==true && kiemtraPassword(user.getPassword(), kh.getPassword())==true)
			{ 
				session.setAttribute("user", kh);
				
				if(kh.getLoaitaikhoan().equals("khachhang"))
					return "redirect:/home/index";
			
			}
			 
		} 
	
			return "redirect:/taikhoan/dangnhap";

		
	}
//--------------------------------------------------------------------------------------------------------------------------------------
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
		
		if(mail1.toLowerCase().equals(mail2.toLowerCase()))
			return true;
		return false;
	}
	@GetMapping("dangxuat")
	public String dangxuat(HttpSession session){
		
		session.invalidate();
		
		
		return "redirect:/home/index";
	}
}