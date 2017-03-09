package co.bbenson.grades;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Arrays.asList;

@RestController
public class GradesController {
    @RequestMapping(value = "/grades.xlsx", method = RequestMethod.GET, produces = "application/xlsx")
    public ModelAndView listGrades() {
        return new ModelAndView(
                new GradesView(),
                "grades",
                asList(
                        new Grade("Jimmy", "B+"),
                        new Grade("Kelly", "A-")
                )
        );
    }
}
