package io.github.michael_bailey.Blog.controller

import io.github.michael_bailey.Blog.database.post.Post
import io.github.michael_bailey.Blog.database.post.PostRepository
import io.github.michael_bailey.Blog.database.post.PostTable.title
import kotlinx.serialization.Serializable
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*


import java.util.*

@RestController
class PostController {

	@Serializable
	data class PostOutput(
		val id: String,
		val title: String,
		val content: String,
		val time: String
	)

	@GetMapping("/api/posts")
	@CrossOrigin(origins = ["*"])
	@Transactional
	fun getAllPosts(): List<PostOutput> {
		return Post.all()
			.map {
				PostOutput(
					id = it.id.value.toString(),
					title = it.title,
					content = it.content,
					time = it.time.toString()
				)
			}
	}

	@GetMapping("/api/posts/{uuid}")
	@CrossOrigin(origins = ["*"])
	@ResponseBody
	@Transactional
	fun getPost(
		@PathVariable uuid: UUID
	): PostOutput? {
		return PostOutput(
			id = uuid.toString(),
			title = "Test Post 2",
			content = "This is some content for a post",
			time = toString()
		)
	}

	@PostMapping("/api/posts")
	@CrossOrigin(origins = ["*"])
	@Transactional
	fun createPost(
		@RequestParam title: String,
		@RequestParam content: String,
	): PostOutput? {
		val postRepository = PostRepository()
		val post = postRepository.create(
			title = title,
			content = content
		)

		return PostOutput(
			id = post.id.value.toString(),
			title = post.title,
			content = post.content,
			time = post.time.toString(),
		)
	}
}