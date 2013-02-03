package ${classPackage};

import com.example.myapp.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/users")
public class ${className} {

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return new ArrayList<User>();
    }
}
