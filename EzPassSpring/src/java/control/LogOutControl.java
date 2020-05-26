package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LogOutControl {

    @RequestMapping(value = "/LogOutControl", method = RequestMethod.GET)
    public ModelAndView LogOut(HttpServletRequest request, RedirectAttributes redirectAttributes, ModelAndView mv) {
        HttpSession session = request.getSession();
        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "Account signed off successfully!");
        mv.setViewName("redirect:/index");
        return mv;
    }

}
