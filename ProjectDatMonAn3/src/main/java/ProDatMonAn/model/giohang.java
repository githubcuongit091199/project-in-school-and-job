package ProDatMonAn.model;

import java.util.List;



public class giohang {
	private List<MatHang> item;
	public int getGia() {
		int tonggia=0;
		for(MatHang gia:item)
		{
			tonggia=(int) (gia.getThanhTien()+tonggia);
		}
		tonggia= tonggia-magiamgia;
		return (tonggia);
	}
	private int magiamgia;
	public int getMagiamgia() {
		return magiamgia;
	}
	public void setMagiamgia(int magiamgia) {
		this.magiamgia = magiamgia;
	}
	public int getSoLuong() {
		int tongSoLuong=0;
		for(MatHang sl:item)
		{
			tongSoLuong=(int) (sl.getSoluong()+tongSoLuong);
		}
			
		return tongSoLuong;
	}
	public List<MatHang> getItem() {
		return item;
	}
	public void setItem(List<MatHang> item) {
		this.item = item;
	}
	public float TongGiaGiam()
	{
		float GiaGiam=0;
		for(MatHang mathang:item)
		{
			GiaGiam=mathang.tongTienGiam()+GiaGiam;
		}
		GiaGiam=GiaGiam+magiamgia;
		return GiaGiam ;
	}
}
