package com.example.jsbae.controller;

import com.example.jsbae.domain.Board;
import com.example.jsbae.domain.Post;
import com.example.jsbae.domain.Reply;
import com.example.jsbae.domain.User;
import com.example.jsbae.repository.BoardRepository;
import com.example.jsbae.repository.PostRepository;
import com.example.jsbae.repository.ReplyRepository;
import com.example.jsbae.repository.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin("*")
@RestController()
@RequestMapping("/v3")
public class BoardController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ReplyRepository replyRepository;

    @PostMapping("/user")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        try {
            userRepository.createUser(new User(user.getEmail(), user.getName()));
            return new ResponseEntity<>("", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/board")
    public ResponseEntity<String> createBoard(@RequestBody Board board) {
        boardRepository.createBoard(new Board(board.getTitle(), board.getType()));
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        postRepository.createPost(new Post(post.getUserIdx(), post.getBoardIdx(), post.getTitle(), post.getDescription()));
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/reply")
    public ResponseEntity<String> createReply(@RequestBody Reply reply) {
        replyRepository.createReply(new Reply(reply.getUserIdx(), reply.getPostIdx(), reply.getDescription()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = userRepository.findDetail(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/boards")
    public List<Board> getBoardList() {
        return boardRepository.boardList();
    }

    @GetMapping("/board/{id}")
    public Board getBoardDetail(@PathVariable("id") long id) {
        return boardRepository.boardInfo(id);
    }

    @GetMapping("/posts")
    public List<Post> getPostList() {
        return postRepository.postList();
    }

    @GetMapping("/post/{id}")
    public Post getPostDetail(@PathVariable("id") long id) {
        Post post = postRepository.postInfo(id);
        post.setReplyList(replyRepository.replyListByPostId(id));

        return post;
    }

    @GetMapping("/replys/{id}")
    public List<Reply> getReplyList(@PathVariable("id") long id) {
        return replyRepository.replyList(id);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        User user1 = userRepository.findDetail(id);
        if (user1 != null) {
            user1.setEmail(user.getEmail());
            user1.setUpdated(user.getUpdated());
            userRepository.userUpdate(user1);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/board/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable("id") long id, @RequestBody Board board) {
        Board board1 = boardRepository.boardInfo(id);
        if (board1 != null) {
            board1.setTitle(board.getTitle());
            board1.setType(board.getType());
            board1.setUpdated(board.getUpdated());
            boardRepository.boardUpdate(board1);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<String> updatePost(@PathVariable("id") long id, @RequestBody Post post) {
        Post post1 = postRepository.postInfo(id);
        if (post1 != null) {
            post1.setTitle(post.getTitle());
            post1.setDescription(post.getDescription());
            postRepository.postUpdate(post1);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/reply/{id}")
    public ResponseEntity<String> updateReply(@PathVariable("id") long id, @RequestBody Reply reply) {
        Reply r1 = replyRepository.replySearch(id);
        if (r1 != null) {
            r1.setIdx(r1.getIdx());
            r1.setDescription(reply.getDescription());
            replyRepository.updateReply(r1);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        try {
            if (userRepository.userDelete(id) == 0) {
                return new ResponseEntity<>("삭제 안되영" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("삭제 왜안됭?", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable("id") long id) {
        try {
            if (boardRepository.boardDelete(id) == 0) {
                return new ResponseEntity<>("", HttpStatus.OK);
            }
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") long id) {

        postRepository.postDelete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/reply/{id}")
    public ResponseEntity<String> deleteReply(@PathVariable("id") long id) {
        replyRepository.deleteReply(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}