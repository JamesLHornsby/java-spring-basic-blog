package com.pluralsight.blog;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;


@Controller
public class BlogController {
	
	private PostRepository postRepository;
	
	public BlogController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@RequestMapping("/")
	public String listPosts(ModelMap mp) {
		mp.put("title", "Blog Post 1");
		List<Post> pR = postRepository.getAllPosts();
		mp.put("posts", pR);
		return "home";
	}
	
	@RequestMapping("/post/{id}")
	public String postDetails(@PathVariable Long id, ModelMap modelMap) {
		Post p = postRepository.findById(id);
		modelMap.put("post", p);
		return "post-details";
	}
	
}
