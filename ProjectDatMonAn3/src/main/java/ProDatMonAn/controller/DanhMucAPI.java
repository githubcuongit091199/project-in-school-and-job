package ProDatMonAn.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import ProDatMonAn.model.ChiTietDonHangModel;
import ProDatMonAn.model.DanhMucSanPhamModel;
import ProDatMonAn.model.DonDatHangModel;
import ProDatMonAn.model.MatHang;
import ProDatMonAn.model.MonAnModel;
import ProDatMonAn.model.TaiKhoanModel;
import ProDatMonAn.model.giohang;
import ProDatMonAn.repository.ChiTietDonHangRepository;
import ProDatMonAn.repository.DanhMucSanPhamRepository;
import ProDatMonAn.repository.DonDatHangRepository;
import ProDatMonAn.repository.KhachHangRepository;
import ProDatMonAn.repository.MonAnReponsitory;
import ProDatMonAn.repository.TaiKhoanRepository;



 


@RestController
@RequestMapping("/api/monan")
@CrossOrigin("http://10.0.2.2:*")
public class DanhMucAPI {
	@Autowired 
	DanhMucSanPhamRepository tdr;
	@Autowired 
	TaiKhoanRepository tkr;
	@Autowired 
	ChiTietDonHangRepository ctr;
	@Autowired 
	MonAnReponsitory mar;
	@Autowired 
	DonDatHangRepository ddhr;
	@Autowired 
	KhachHangRepository khr;
	
	
	@GetMapping("/danhmuc")
	public List<DanhMucSanPhamModel> thucdon(){
		System.out.println("danh sach danh muc");
		return (List<DanhMucSanPhamModel>)tdr.findAll();
	}

	
	
	@GetMapping("/taikhoan")
	public List<TaiKhoanModel> taikhoan(){
	
		return (List<TaiKhoanModel>)tkr.findAll();
	}
	
	@PostMapping("/dulieugiohang")
    public void create(@RequestBody List<apidonhang> v) {
		System.out.println("api" +v.get(0).soLuong);
		TaiKhoanModel tk=tkr.findbyIdEmail(v.get(0).email);
		giohang gio = new giohang();
		List<MatHang> dshang=new ArrayList<>();
		
	
		for(apidonhang donhangAndroid: v) {
			
			MonAnModel monan=mar.findById(donhangAndroid.idmonan).get();
			MatHang hang =new MatHang();
				hang.setIdmonan(donhangAndroid.idmonan);
				hang.setMonan(monan);
				hang.setSoluong(donhangAndroid.soLuong);
			dshang.add(hang);
		
		}
		gio.setItem(dshang);
		System.out.println("mail"+v.get(0).email +tk.getMataikhoan());
		
		
		ThemHangVaoDB1(gio, khr.findbyidkhachhang(tk.getMataikhoan()).makhachhang);
		
	

	}
	public void ThemHangVaoDB1(giohang cart, int idkhachhang)
	{
			System.out.println("ffffff4444444");
			List<MatHang> mathang=new ArrayList<MatHang>();
				mathang=	cart.getItem();

			System.out.println("xuat gio hang" + cart.getSoLuong()+ " asdasdasdas "+cart.getGia());
			DonDatHangModel donhang=new DonDatHangModel(1,cart.getSoLuong(),cart.getGia(),"26/5/2020",idkhachhang);
			
			ddhr.save(donhang);
			
			Iterable<DonDatHangModel> iterDonHang=ddhr.findAll();
		
			ArrayList<DonDatHangModel> arrdonhang=(ArrayList<DonDatHangModel>) iterDonHang;
		
			System.out.println(idkhachhang);
			for(MatHang hang:mathang)
				{
				ChiTietDonHangModel chitiet=new ChiTietDonHangModel(hang.getIdmonan(),hang.getThanhTien(),hang.getSoluong(),arrdonhang.size(),hang.getMonan().getKhuyenmai());
				
				ctr.save(chitiet);
		
				}
			
	}
	

}
