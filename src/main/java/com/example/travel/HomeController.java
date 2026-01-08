package com.example.travel;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	
	

@RequestMapping("/")
public String home(Model model) {
model.addAttribute("title","Home - Smart Contact Manager");
return "home";

}

@RequestMapping("/about")
public String about(Model model) {
model.addAttribute("title","About - Smart Contact Manager");
return "about";
}


@RequestMapping("/review")
public String review(Model model) {
model.addAttribute("title","Review - Smart Contact Manager");
return "review";
}


@RequestMapping("/discover")
public String discover(Model model) {
model.addAttribute("title","Discover - Smart Contact Manager");
return "discover";
}





@RequestMapping("/signup")
public String signup(Model model) {
model.addAttribute("title","Register - Smart Contact Manager");
model.addAttribute("user",new User());
return "signup";
}



@RequestMapping("/details")
public String details(Model model) {
model.addAttribute("title","Register - Smart Contact Manager");
model.addAttribute("contact",new Contact());
return "details";
}

@RequestMapping("/success")
public String success(Model model) {
model.addAttribute("title","Success - Smart Contact Manager");
return "success";

}


@RequestMapping("/included")
public String included(Model model) {
model.addAttribute("title","Included - Smart Contact Manager");
return "included";
}


@Autowired(required=true)
private UserRepository userRepository;



// handler user
@RequestMapping(value="/do_register",method=RequestMethod.POST)
public String registerUser(@ModelAttribute("user") User user, @RequestParam(value="agreement",defaultValue="false") boolean agreement,Model model) {


if(!agreement) {
System.out.println("you have not agreed the terms and condition");

}

user.setEnabled(true);
user.setImageUrl("default.png");


System.out.println("Agreement "+agreement);
System.out.println("USER "+user);



User result=this.userRepository.save(user);
//
//
model.addAttribute("user",new User());

//System.out.println("success");




return "success";


}


@Autowired
private ContactRepository contactRepository;



@RequestMapping(value="/do_to_register",method=RequestMethod.POST)
public String registerContact(@ModelAttribute("contact") Contact contact, @RequestParam(value="agreement",defaultValue="false") boolean agreement,Model model) {

	if(!agreement) {
		System.out.println("you have not agreed the terms and condition");

		}


contact.setWork("ROLE_USER");
contact.setImage("default.png");


System.out.println("Agreement "+agreement);
System.out.println("CONTACT "+contact);



Contact result=this.contactRepository.save(contact);
//
//
model.addAttribute("contact",new Contact());

//System.out.println("success");




return "success1";


}





}






