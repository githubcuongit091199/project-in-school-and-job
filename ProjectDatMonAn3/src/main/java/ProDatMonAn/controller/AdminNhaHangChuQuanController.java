package ProDatMonAn.controller;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ProDatMonAn.model.MonAnModel;
import ProDatMonAn.model.NhaHangChuQuanModel;
import ProDatMonAn.model.TaiKhoanModel;
import ProDatMonAn.model.ThucDonModel;
import ProDatMonAn.repository.MonAnReponsitory;
import ProDatMonAn.repository.NhaHangChuQuanRepository;
import ProDatMonAn.repository.TaiKhoanRepository;
import ProDatMonAn.repository.ThucDonRepository;

@Controller
@RequestMapping("/adminnhahangchuquan")
public class AdminNhaHangChuQuanController {
	
	@Autowired
	MonAnReponsitory mar;
	@Autowired
	ThucDonRepository tdr;
	@Autowired
	NhaHangChuQuanRepository nhcqr;
	@Autowired
	TaiKhoanRepository tkr;

	@GetMapping("quanlimonan")
	public ModelAndView MonAn(HttpSession session)
	{
//		TaiKhoanModel taikhoan= (TaiKhoanModel) session.getAttribute("user");//xử lý lấy id nhà hằng chủ quán
		
		
		ModelAndView mv=new ModelAndView("admin/nhahangchuquan/MonAnNhaHang");
		
		//NhaHangChuQuanModel nhahang= nhcqr.findbyidnhaHang(taikhoan.getMataikhoan());
		NhaHangChuQuanModel nhahang= nhcqr.findbyidnhaHang(1);
		//System.out.print(nhahang.getManhahang());
		
		List<ThucDonModel>dsthucdon=tdr.findbyIdThucDon(nhahang.getManhahang());
		System.out.print("mmmmm"+dsthucdon.get(0).getMathucdon()+"hhhhhhhhh");
		ArrayList<MonAnModel> dsMonAn=new ArrayList<MonAnModel>();
		for(ThucDonModel thucdon:dsthucdon)
		{
			List<MonAnModel> MonAn=mar.findbyIdThucDon(thucdon.getMathucdon());
			//System.out.println(MonAn.get(0).getTenmonan() +"ffffffff");
			dsMonAn.addAll(MonAn);
		//System.out.println(MonAn.get(0).getTenmonan() +"ffffffff");
		 //System.out.print(dsthucdon.get(1).getManhahang());
			
	}
	//	System.out.println(dsMonAn.get(0).getTenmonan() +"ffffffff");
		//System.out.print("yy"+dsthucdon.get(0).getMathucdon()+"    ");
		//List<MonAnModel> MonAn=mar.findbyIdThucDon(dsthucdon.get(0).getMathucdon());

		//System.out.print("aaaaa" + MonAn.get(0).getTenmonan());
		//System.out.println("kkk"+mar.findbyIdThucDon(0).get(0).getMamonan());
		//dsMonAn.addAll(mar.findbyIdThucDon(dsthucdon.get(1).getMathucdon()));

		//System.out.print(dsMonAn.get(1));
		
		mv.addObject("dsmonan", dsMonAn);
		
		
		
		
		return mv;
	}
	@GetMapping("chinhsuaquanlimonannhahang/{idmonan}")
	public ModelAndView ChinhSuaMonAn(@PathVariable int idmonan)
	{
		
		MonAnModel ma=mar.findById(idmonan).get();
		//MonAnModel ma=new MonAnModel();
		
		ModelAndView mv= new ModelAndView("admin/nhahangchuquan/ChinhSuaMonAn","monan",ma);
		

		
		
		
		return mv;
	}
	@PostMapping("chinhsuaquanlimonannhahang/{mamonan}")
	public ModelAndView ChinhSuaMonAnpost(@PathVariable int mamonan,@ModelAttribute MonAnModel monan)
	{
		ModelAndView mv= new ModelAndView("redirect:/adminnhahangchuquan/quanlimonan");
		MonAnModel ma=mar.findById(mamonan).get();
		ma.setGia(monan.getGia());
		ma.setKhuyenmai(monan.getKhuyenmai());
		ma.setThongtin(monan.getThongtin());
		mar.save(ma);
		return mv;
		
		
	}
	//thêm món ăn
	@GetMapping("themmonannhahang")
	public ModelAndView ThemMonAn()
	{
		MonAnModel ma=new MonAnModel();
		ModelAndView mv= new ModelAndView("admin/nhahangchuquan/ThemMonAn","monan",ma);
		mv.addObject("monan",ma);
		return mv;
	}
	@PostMapping("themmonannhahang")
	public ModelAndView ThemMonAnpost(@ModelAttribute MonAnModel monan)
	{
		mar.save(monan);
		
		
		ModelAndView mv= new ModelAndView("redirect:/adminnhahangchuquan/quanlimonan");
		
		
		return mv;
		
		
	}
	@RequestMapping(value = "/uploadFile/{idmonan}", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@PathVariable int idmonan,@RequestParam("name") String name,
	@RequestParam("file") MultipartFile file,HttpSession session)
	{
//		String name=null;
//		TaiKhoanModel taiKhoan=(TaiKhoanModel) session.getAttribute("user");
//		name= String.valueOf(idmonan)+taiKhoan.getMataikhoan();
//		
		
		
		
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("user.dir");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();
				
		
				System.out.println(rootPath+"      444444444444");
				// Create the file on server
//				File serverFile = new File(dir.getAbsolutePath()
//						+ File.separator + name);
				File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + name);
				System.out.println(rootPath+"      444444444444");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				System.out.println(serverFile.getAbsolutePath()+"      5555555555555555");
				stream.write(bytes);
				stream.close();
//
//				logger.info("Server File Location="
//						+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
	
	
//---------------------------------------------đăng nhập tài khoải admin-----------------------------------------------------------
		@GetMapping("dangnhap")
		public ModelAndView dangnhap(){
		

			
			ModelAndView mv = new ModelAndView("/admin/nhahangchuquan/login","user",new TaiKhoanModel());
			
			

			return mv;
		}
		@PostMapping("dangnhap")
		public String dangnhappost(@ModelAttribute("cq") TaiKhoanModel taikhoan,HttpSession session) throws NoSuchAlgorithmException{
			//System.out.println(danhmucmonan.getLoaimonan()+"hhhhhhhh");
			TaiKhoanModel user = tkr.findbyIdEmail(taikhoan.getEmail());
			 /*for(KhachHangModel kh:lst)
			 {
				 System.out.println(kh.getPassword()+ user.getPassword());
			 }*/
			System.out.println("tai khoan"+user.getEmail()+" "+user.getLoaitaikhoan());
			if(user.getLoaitaikhoan().compareTo("nhà hàng/ chủ quán")==0)
				{
				System.out.println("vo day ko");
				if(kiemtraEmail(user.getEmail(), taikhoan.getEmail())==true && kiemtraPassword(taikhoan.getPassword(), user.getPassword())==true)
				{ 
					session.setAttribute("cq", user);
				
						return "redirect:/adminnhahangchuquan/quanlimonan";				
				 
				
				}
				}
	
		
			
			
		
			
			return "redirect:/adminnhahangchuquan/dangnhap";
		}
		@GetMapping("dangxuat")
		public String dangxuat(HttpSession session){
			
			session.invalidate();
			
			
			return "redirect:/adminnhahangchuquan/dangnhap";
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
			
			if(mail1.toLowerCase().equals(mail2.toLowerCase()))
				return true;
			return false;
		}
	
	
}
