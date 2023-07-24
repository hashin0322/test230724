package com.korea.basic1.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/")
    public String home(){
        return "redirect:post/list";
    }

    @GetMapping("/post/list")
    public String list(Model model) {
        List<Post> postList = this.postRepository.findAll();
        model.addAttribute("postList", postList);

        return "list";
    }


    @GetMapping("/post/create")
    public String questionCreate() {
        return "postForm";
    }

    @PostMapping("/post/create")
    public String postCreate(@RequestParam String subject, @RequestParam String content) {
        this.postService.create(subject, content);
        return "redirect:/post/list";
    }



    @GetMapping(value = "/post/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Post post = this.postService.getPost(id);
        model.addAttribute("post", post);

        return "detail";
    }



    @GetMapping("/post/modify/{id}")
    public String modify(@PathVariable Integer id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "postForm";
    }

    @PostMapping("/post/modify")
    public String modify(@ModelAttribute Post post) {
        postService.updatePost(post);
        return "redirect:/list";
    }






    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/list";
    }

}
