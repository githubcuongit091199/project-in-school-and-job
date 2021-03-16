package ProDatMonAn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {

		@GetMapping("danhsachkhachhang")
		
		public String Index(){
			return "Index";
		}
		@GetMapping("gioithieu")
		
		public String GioiThieu(){
			return "GioiThieu";
		}
}
