package com.company.subscriptionandaccountlist.controller;

import com.company.subscriptionandaccountlist.models.ContactUser;
import com.company.subscriptionandaccountlist.models.User;
import com.company.subscriptionandaccountlist.repositories.ContactUserRepository;
import com.company.subscriptionandaccountlist.repositories.EmailSender;
import com.company.subscriptionandaccountlist.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;



@Controller
public class MainController {

    public final UserRepository userRepository;
    public final ContactUserRepository contactUserRepository;
    public final EmailSender emailSender;
    public MainController(UserRepository userRepository, ContactUserRepository contactUserRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.contactUserRepository = contactUserRepository;
        this.emailSender = emailSender;
    }


    @GetMapping("/")
    public String startPage(User account, Model model){

        /* Start page would realistically only be seen upon initial opening of the website.
        It needs "account" in the case the user wants to login at that point but it doesn't need to know if they were previously logged in*/

        model.addAttribute("account", account);
        if(account.getFirstname() != null){
            model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
        }
        return "startPage";
    }

    @GetMapping({"/homepage/{accountId}", "/homepage"})
    public String homepage(@PathVariable(value = "accountId", required = false) String accountId, Model model){

        // Both conditions need this, good for reducing code
        User account = new User();

        if(accountId != null){
            // See Duplicated code fragment (11 lines long)  and resolution Extract Method from Duplicate Code
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }

        // Account is needed to format the form and accountID is needed for PathVariable
        model.addAttribute("account", account);
        model.addAttribute("accountId", accountId);

        return "homePage";
    }

    @GetMapping({"/shopping/{accountId}", "/shopping"})
    public String shoppingpage(@PathVariable(value = "accountId", required = false) String accountId, Model model){

        User account = new User();

        if(accountId != null){
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }

        model.addAttribute("account", account);
        model.addAttribute("accountId", accountId);
        return "shoppingPage";
    }

    @GetMapping({"/basket/{accountId}", "/basket"})
    public String basketpage(@PathVariable(value = "accountId", required = false) String accountId, Model model){

        User account = new User();

        if(accountId != null){
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }

        model.addAttribute("account", account);
        model.addAttribute("accountId", accountId);

        return "basketPage";
    }

    @GetMapping({"/mens/{accountId}", "/mens"})
    public String menspage(@PathVariable(value = "accountId", required = false) String accountId,  Model model){

        //from main page
        if(accountId == null){
            User account = new User();
            model.addAttribute("account", account);
        } else { //from mens page when logged in

            //Learning

            //Business logic
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            User account = new User();
            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            model.addAttribute("account", account);
            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }

            model.addAttribute("accountId", accountId);

        }
        return "mensPage";
    }

    @GetMapping({"/womens/{accountId}", "/womens"})
    public String womenspage(@PathVariable(value = "accountId", required = false) String accountId, Model model){

        User account = new User();

        if(accountId != null){
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }

        model.addAttribute("account", account);
        model.addAttribute("accountId", accountId);
        return "womensPage";
    }

    @GetMapping({"/kids/{accountId}", "/kids"})
    public String kidspage(@PathVariable(value = "accountId", required = false) String accountId, Model model){

        User account = new User();

        if(accountId != null){
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }

        model.addAttribute("account", account);
        model.addAttribute("accountId", accountId);

        return "kidsPage";
    }

    @GetMapping({"/about/{accountId}", "/about"})
    public String aboutpage(@PathVariable(value = "accountId", required = false) String accountId, Model model){

        User account = new User();

        if(accountId != null){
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }

        model.addAttribute("account", account);
        model.addAttribute("accountId", accountId);

        return "aboutPage";
    }

    @GetMapping({"/wishlist/{accountId}", "/wishlist"})
    public String wishlistpage(@PathVariable(value = "accountId", required = false) String accountId, Model model){

        User account = new User();

        if(accountId != null){
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }

        model.addAttribute("account", account);
        model.addAttribute("accountId", accountId);
        return "wishlistPage";
    }

    @GetMapping({"/account/{accountId}", "/account"})
    public String accountpage(@PathVariable(value = "accountId", required = false) String accountId, Model model){

        User account = new User();

        if(accountId != null){
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }

        model.addAttribute("account", account);
        model.addAttribute("accountId", accountId);

        return "accountPage";
    }

    @GetMapping({"/accountsettings/{accountId}","/accountsettings"})
    public String accountsettingspage(@PathVariable(value = "accountId", required = false) String accountId, Model model){

        User account = new User();

        if(accountId != null){
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }

        model.addAttribute("account", account);
        model.addAttribute("accountId", accountId);

        return "accountSettings";
    }

    //Post mapping for the subscription form
    @PostMapping("/accountsettings/{accountId}")
    public String accountsettingspageform(@PathVariable(value = "accountId", required = false) String accountId, Model model, @RequestParam(value = "form", required = false) String form){

        User account = new User();

        if(accountId != null){
            Optional<User> OptionalAccount = userRepository.findById(Long.valueOf(accountId));

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
            }

            if (account.getFirstname() != null) {
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }

        if(form.equals("contactForm")){
            account.setVerified(true);
            emailSender.send(account.getEmail(), "You are subscribed " + account.getFirstname() + "!", "Account and subscription list - Subscribe");
            model.addAttribute("submissionMessage", "You are subscribed!");
        }

        model.addAttribute("account", account);
        model.addAttribute("accountId", accountId);

        return "accountSettings";
    }

    @GetMapping("/contact")
    public String contactpage(@ModelAttribute(value = "account") User account, Model model){

        ContactUser contactUser = new ContactUser();

        model.addAttribute("user", contactUser);

        return "contactPage";
    }

    @PostMapping("/formsuccess")
    public String fakeContact(@ModelAttribute(value = "user") ContactUser user, Model model) {

        ContactUser toSaveUser = new ContactUser(user.getFirstname(), user.getEmail(), user.getConcern());

        contactUserRepository.save(toSaveUser);

        model.addAttribute("user", user);
        model.addAttribute("submissionMessage", "Thank you for the message " + user.getFirstname() + ". We will get to it as soon as possible!");
        return "contactPage";
    }

    @GetMapping("/check")
    public String form(@ModelAttribute(value = "account") User account, Model model){

        model.addAttribute("account", account);
        return "fragments/popUpForm";
    }

    @PostMapping("/login")
    public String accountsubmission(@ModelAttribute(value = "account") User account, Model model, @RequestParam String action)  {

        if (action.equals("signup")){
            User toSaveAccount = new User(account.getFirstname(), account.getEmail(), account.getPassword());

            User save = userRepository.save(toSaveAccount);

            emailSender.send(account.getEmail(), "Hello " + account.getFirstname(), "Account made");

            model.addAttribute("accountId", save.getId());
            model.addAttribute("account", account);
            if(account.getFirstname() != null){
                model.addAttribute("loginMessage", "You are now logged in " + account.getFirstname() + "!");
            }
        }
        else if(action.equals("signin")){

            Optional<User> OptionalAccount = userRepository.findByPasswordAndEmail(account.getPassword(),account.getEmail());

            if (OptionalAccount.isPresent()) {
                account = OptionalAccount.get();
                model.addAttribute("loginMessage", "You are logged in " + account.getFirstname() + "!");
                model.addAttribute("accountId", account.getId());
            }
            else{
                model.addAttribute("loginMessage", "It appears you don't have an account. Try again!");
                return "accountPage";
            }
        }

        return "accountPage";
        //return "redirect:/";
    }

}
