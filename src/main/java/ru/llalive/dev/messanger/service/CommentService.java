package ru.llalive.dev.messanger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.llalive.dev.messanger.database.DatabaseClass;
import ru.llalive.dev.messanger.model.Comment;
import ru.llalive.dev.messanger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public CommentService() {
		Map<Long, Comment> comments = new HashMap<>();
		comments.put(1L, new Comment(1L, "New comment", "Pavel"));
		comments.put(2L, new Comment(2L, "Nice!", "Valentina"));
		messages.get(1L).setComments(comments);
	}

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}

	public Comment getComment(long messageId, long commentId) {
		return messages.get(messageId).getComments().get(commentId);
	}

	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		messages.get(messageId).setComments(comments);
		return comment;
	}

	public Comment updateComment(long messageId, Comment comment) {
		if (comment.getId() <= 0) {
			return null;
		}
		messages.get(messageId).getComments().put(comment.getId(), comment);
		return comment;
	}

	public Comment removeComment(long messageId, long commentId) {
		return messages.get(messageId).getComments().remove(commentId);
	}
}
