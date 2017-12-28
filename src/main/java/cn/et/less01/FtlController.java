package cn.et.less01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FtlController {
	
	@RequestMapping("/index")
	public String index(Model model){
		return "inds";
	}
}
