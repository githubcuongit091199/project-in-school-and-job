package ProDatMonAn.model;

public class MatHang {
	private int idmonan;
	private MonAnModel monan;
	private int soluong;
	public MonAnModel getMonan() {
		return monan;
	}
	public void setMonan(MonAnModel monan) {
		this.monan = monan;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}	
	public int getThanhTien() {
		
		return (int) (soluong*(monan.getGia()-monan.getGia()*monan.getKhuyenmai()/100));
	}
	public int getIdmonan() {
		return idmonan;
	}
	public void setIdmonan(int idmonan) {
		this.idmonan = idmonan;
	}
	public float tongTienGiam()
	{
		float tongtiengiam=0;
		tongtiengiam=monan.getGia()*monan.getKhuyenmai()/100;
		return tongtiengiam;
	}
	

}
