package ProDatMonAn.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import ProDatMonAn.model.DonDatHangModel;
import ProDatMonAn.model.MatHang;
import ProDatMonAn.model.giohang;
import ProDatMonAn.repository.DonDatHangRepository;

public class TrangThaiGioHang {
	@Autowired
	DonDatHangRepository ddhr;
	public boolean KiemTra(List<MatHang> cart,int idMonAn) {//kiểm tra xem món ăn đó đã có trong giỏ hàng chưa
		for(MatHang kiemtra:cart)
		{
			if(kiemtra.getIdmonan()==idMonAn)// đã có trong gio h
				return true;
		}
		return false;
	}
	public boolean ThemHangVaoDB(giohang cart, int idkhachhang)
	{
		if(idkhachhang ==0)// kiểm tra đã đăng nhập chưa
		{
			System.out.println("idkhachhagn =0");
			return true;// giả sử có khách rồi
		}
		else{// đã đăng nhập
			System.out.println("idkhach=1");
			System.out.println("idkhach=2");
			
				DonDatHangModel donhang=new DonDatHangModel(1,cart.getSoLuong(),cart.getGia(),"26/5/2020",idkhachhang);
				System.out.println(cart.getGia());
				Iterable<DonDatHangModel> g=ddhr.findAll();
				if(g!=null)
				{
					System.out.println("123456ccccccccc");
				}
					
				
				ddhr.save(donhang);
				System.out.println("du lieu");
				
			}
			return true;
	}
}