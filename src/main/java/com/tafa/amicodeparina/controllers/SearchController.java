package com.tafa.amicodeparina.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tafa.amicodeparina.controllers.dto.SearchDto;
import com.tafa.amicodeparina.models.Search;
import com.tafa.amicodeparina.models.User;
import com.tafa.amicodeparina.service.SearchServiceImpl;
import com.tafa.amicodeparina.service.UserService;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    @Autowired
    private SearchServiceImpl searchServiceImpl;

    public SearchController(SearchServiceImpl searchServiceImpl) {
        super();
        this.searchServiceImpl = searchServiceImpl;
    }

    @ModelAttribute("search")
    public SearchDto searchDto() {
        return new SearchDto();
    }

    @GetMapping("/")
    public String showSearch() {
        return "KhojTheSearch";
    }

    @PostMapping("/")
    public ModelAndView registerSearch(@ModelAttribute("search") SearchDto searchDto, RedirectAttributes attributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        User user = userService.getUserByEmail(username);
        searchDto.setDate(LocalDateTime.now());
        searchDto.setUser(user);

        String[] strSplit = searchDto.getInput().split(", ");
        ArrayList<String> inputs = new ArrayList<String>(
                Arrays.asList(strSplit));
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (String stringValue : inputs) {
            try {
                result.add(Integer.parseInt(stringValue.trim()));
            } catch (NumberFormatException nfe) {
                System.out.printf("NumberFormat", "Parsing failed! " + stringValue + " can not be an integer");
            }
        }
        Collections.sort(result, Collections.reverseOrder());
        searchDto.setResult(result.contains(Integer.parseInt(searchDto.getSearch().trim())));
        inputs.clear();
        for (Integer intValue : result) {
            try {
                inputs.add(String.valueOf(intValue));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        searchDto.setInput(String.join(", ", inputs));
        Search s = searchServiceImpl.save(searchDto);
        attributes.addFlashAttribute("search", s);
        return new ModelAndView("redirect:/");
    }

}