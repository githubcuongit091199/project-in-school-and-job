package ProDatMonAn.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class Register {
	
	@NotEmpty(message = "Vui lòng nhập tên của bạn. Không được bỏ trống.")
	public String tenkhachhang;
	@NotEmpty(message = "Vui lòng nhập mật khẩu. Không được bỏ trống.")	
	public String password;
	@Email(message = "Sai cấu trúc mail! vui lọng nhập lại.")
	@NotEmpty(message = "Vui lòng nhập mail. Không được bỏ trống.")
	public String email;
	//@NotEmpty(message = "Vui lòng chọn loại tài khoản bạn muốn đăng ký.")
	
	public String loaitaikhoan;
	@NotEmpty(message = "Vui lòng nhập địa chỉ. Không được bỏ trống")
	public String diachi;
	@NotEmpty(message = "Vui lòng nhập lại mật khẩu")
	public String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String sdt;
	public String getTenkhachhang() {
		return tenkhachhang;
	}
	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoaitaikhoan() {
		return loaitaikhoan;
	}
	public void setLoaitaikhoan(String loaitaikhoan) {
		this.loaitaikhoan = loaitaikhoan;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public Register(String tenkhachhang, String password, String email, String diachi,String sdt, String loaitaikhoan) {
		super();

		this.tenkhachhang = tenkhachhang;
		this.password = password;
		this.email = email;
		this.loaitaikhoan = loaitaikhoan;
		this.diachi = diachi;
		this.sdt = sdt;
	}
	public Register() {
		super();
	}
	

	
	
	
	
	
}
