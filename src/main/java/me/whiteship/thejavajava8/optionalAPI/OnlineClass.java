package me.whiteship.thejavajava8.optionalAPI;

import java.util.Optional;

public class OnlineClass {

	int id;
	String title;
	boolean closed;

	Progress progress;

	public OnlineClass() {

	}

	public OnlineClass(int id, String title, boolean closed) {
		this.id = id;
		this.title = title;
		this.closed = closed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public Optional<Progress> getProgress() {
		return Optional.ofNullable(progress);
	}

	public void setProgress(Progress progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return "OnlineClass{" +
				"id=" + id +
				", title='" + title + '\'' +
				", closed=" + closed +
				'}';
	}
}
