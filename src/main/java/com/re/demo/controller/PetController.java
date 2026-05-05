package com.re.demo.controller;

import com.re.demo.dto.PetDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PetController {

    @GetMapping("/pet/add")
    public String showAddPetForm(Model model) {
        model.addAttribute("pet", new PetDto());
        return "add-pet-form";
    }

    @PostMapping("/pet/add")
    public String submitPetForm(@Valid @ModelAttribute("pet") PetDto pet,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "add-pet-form";
        }

        // Giả sử bạn lưu vào database ở đây
        System.out.println("Lưu thành công: " + pet.getPetName());

        // Dùng FlashAttribute để truyền object sang trang success mà không bị lộ trên URL
        redirectAttributes.addFlashAttribute("savedPet", pet);

        return "redirect:/pet/success";
    }

    @GetMapping("/pet/success")
    public String showSuccess(Model model) {
        // Nếu không có dữ liệu (người dùng tự gõ URL /pet/success), có thể điều hướng về trang chủ
        if (!model.containsAttribute("savedPet")) {
            return "redirect:/pet/add";
        }

        return "success";
    }
}
