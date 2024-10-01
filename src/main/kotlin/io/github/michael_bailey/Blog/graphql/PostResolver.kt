package io.github.michael_bailey.Blog.graphql

import io.github.michael_bailey.Blog.database.post.Post
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Transactional

@Controller
class PostResolver {
	@QueryMapping
	@Transactional
	fun allPosts(): List<Post> {
		return Post.all().toList()
	}

	@MutationMapping
	@Transactional
	fun createPost(
		@Argument title: String,
		@Argument content: String,
	): Post {
		return Post.new {
			this.title = title
			this.content =  content
		}
	}
}