package com.mehdi.socialmedia.controller;

import com.mehdi.socialmedia.models.Post;
import com.mehdi.socialmedia.models.User;
import com.mehdi.socialmedia.response.ApiResponse;
import com.mehdi.socialmedia.service.PostService;
import com.mehdi.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @PostMapping("/api/posts")
    public ResponseEntity<Post> createPost(@RequestHeader("Authorization") String jwt,
                                           @RequestBody Post post) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);
        Post createdPost = postService.createNewPost(post,reqUser.getId());
        return  new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@RequestHeader("Authorization") String jwt,
                                                  @PathVariable Integer postId) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);
        String message = postService.deletePost(postId,reqUser.getId());
        ApiResponse res = new ApiResponse(message,true);
        return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
    }

    @GetMapping("/api/posts/{postId}")
    public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws Exception {

        Post post = postService.findPostById(postId);

        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);

    }

    @GetMapping("/api/posts/user/{userId}")
    public ResponseEntity<List<Post>> findUsersPost(@PathVariable Integer userId) throws Exception {
        List<Post> posts = postService.findPostByUserId(userId);

        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }


    @GetMapping("/api/posts")
    public ResponseEntity<List<Post>> findAllPost() throws Exception {
        List<Post> posts = postService.findAllPost();

        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }

    @PutMapping("/api/posts/save/{postId}")
    public ResponseEntity<Post> savedPostHandler(@RequestHeader("Authorization") String jwt,
                                                 @PathVariable Integer postId) throws Exception {

        User reqUser = userService.findUserByJwt(jwt);
        Post post = postService.savedPost(postId,reqUser.getId());

        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);

    }

    @PutMapping("/api/posts/like/{postId}")
    public ResponseEntity<Post> likePostHandler(@RequestHeader("Authorization") String jwt,
                                                @PathVariable Integer postId) throws Exception {
        User reqUser= userService.findUserByJwt(jwt);

        Post post = postService.likePost(postId,reqUser.getId());

        return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);

    }
}
