package ProDatMonAn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taikhoan")
public class TaiKhoanModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int mataikhoan;
	@Column
	public String email;
	@Column
	public String password;
	@Column
	public String loaitaikhoan;
	public TaiKhoanModel() {
		super();
	}
	public TaiKhoanModel(String email, String password, String loaitaikhoan) {
		super();
		
	
		this.email = email;
		this.password = password;
		this.loaitaikhoan = loaitaikhoan;
	}
	public int getMataikhoan() {
		return mataikhoan;
	}
	public void setMataikhoan(int mataikhoan) {
		this.mataikhoan = mataikhoan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoaitaikhoan() {
		return loaitaikhoan;
	}
	public void setLoaitaikhoan(String loaitaikhoan) {
		this.loaitaikhoan = loaitaikhoan;
	}

}
