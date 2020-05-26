package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TransactionControl {
    
    @RequestMapping(value = "/TransactionControl", method = RequestMethod.POST)
    public ModelAndView ViewTransactionDate(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, RedirectAttributes redirectAttributes) {
     HttpSession session = request.getSession(false);
        String before = request.getParameter("before");
        String after = request.getParameter("after");
        redirectAttributes.addFlashAttribute("before", before);
        redirectAttributes.addFlashAttribute("after", after);
        mv.setViewName("redirect:/ViewDateTransactions");
        return mv;
    }
    
}
