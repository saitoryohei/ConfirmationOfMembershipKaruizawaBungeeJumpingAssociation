package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {

    // 最初に画面を表示する（入力フォーム）
    @GetMapping("/main")
    public String showMain() {
        return "main";
    }

    // 送信ボタンが押された後の処理
    @PostMapping("/confirm")
    public String confirm(
            @RequestParam("userName") String name, 
            @RequestParam("userLevel") int level, 
            Model model) {
        
        model.addAttribute("name", name);
        model.addAttribute("level", level);
        // レベルに応じてランクを判定（ロジック）
        model.addAttribute("rank", level > 50 ? "シニア" : "現役世代");
        
        return "confirm"; // 確認画面（confirm.html）へ
    }
}