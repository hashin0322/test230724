package com.korea.basic1;

import com.korea.basic1.post.Post;
import com.korea.basic1.post.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Basic1ApplicationTests {


	@Autowired
	private PostRepository postRepository;

	@Test
	void testJpa() {
		Post p = new Post();
		p.setSubject("제목1");
		p.setContent("내용1");

		p.setAuthor("홍길동");
		p.setHit(0);
		p.setView(0);


		p.setDate(LocalDateTime.now());
		this.postRepository.save(p);  // 첫번째 질문 저장
	}

}
