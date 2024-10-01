package io.github.michael_bailey.Blog.database.post

class PostRepository {
	fun create(title: String, content: String): Post {
		return Post.new {
			this.title = title
			this.content = content
		}
	}
}