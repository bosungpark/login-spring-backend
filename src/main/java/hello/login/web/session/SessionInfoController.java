package hello.login.web.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class SessionInfoController {

    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session==null) {
            return "session does not exist";
        }

        session.getAttributeNames().asIterator()
                .forEachRemaining(name-> log.info(name, session.getAttribute(name)));

        log.info(session.getId());

        return "session print";
    }
}
